package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import interfaces.CellWriter;

/**
 * Lớp hỗ trợ xuất dữ liệu ra file Excel
 */
public class ExcelWriter {

    private final CellWriter cellWriter;

    public ExcelWriter(CellWriter cellWriter) {
        this.cellWriter = cellWriter;
    }

    /**
     * Xuất dữ liệu ra file Excel và cho phép người dùng chọn vị trí lưu
     *
     * @param defaultFileName tên file mặc định
     * @param data dữ liệu cần xuất
     * @return đường dẫn file đã lưu hoặc null nếu người dùng hủy
     */
    public String writeWithDialog(String defaultFileName, ArrayList<Object[]> data) {
        // Hiển thị hộp thoại chọn vị trí lưu
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        fileChooser.setDialogTitle("Chọn vị trí lưu file Excel");
        fileChooser.setSelectedFile(new File(defaultFileName));

        if (fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        // Xử lý đường dẫn file
        File fileToSave = fileChooser.getSelectedFile();
        String filePath = fileToSave.getAbsolutePath();

        if (!filePath.toLowerCase().endsWith(".xlsx")) {
            filePath += ".xlsx";
        }

        // Kiểm tra file tồn tại
        File file = new File(filePath);
        if (file.exists()) {
            int result = JOptionPane.showConfirmDialog(null,
                    "File đã tồn tại, bạn có muốn ghi đè không?",
                    "Xác nhận ghi đè", JOptionPane.YES_NO_OPTION);

            if (result != JOptionPane.YES_OPTION) {
                return null;
            }
        }

        // Xuất file Excel
        if (write(filePath, data)) {
            return filePath;
        }

        return null;
    }

    /**
     * Xuất dữ liệu ra file Excel với đường dẫn cụ thể
     *
     * @param filePath đường dẫn file cần xuất
     * @param data dữ liệu cần xuất
     * @return true nếu xuất file thành công, false nếu thất bại
     */
    private boolean write(String filePath, ArrayList<Object[]> data) {
        if (data == null || data.isEmpty()) {
            return false;
        }

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Tạo các dòng và ô
            for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
                Row row = sheet.createRow(rowIndex);
                Object[] rowData = data.get(rowIndex);

                for (int colIndex = 0; colIndex < rowData.length; colIndex++) {
                    Cell cell = row.createCell(colIndex);
                    Object value = rowData[colIndex];
                    cellWriter.write(cell, value, rowIndex, colIndex);
                }
            }

            // Tự động điều chỉnh độ rộng cột
            if (!data.isEmpty() && data.get(0) != null) {
                for (int i = 0; i < data.get(0).length; i++) {
                    sheet.autoSizeColumn(i);
                }
            }

            // Ghi file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
                System.out.println("✅ Ghi file thành công: " + filePath);
                return true;
            }
        } catch (IOException e) {
            System.out.println("❌ Lỗi ghi file: " + e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Không thể ghi file: " + e.getMessage(),
                    "Lỗi ghi file", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
