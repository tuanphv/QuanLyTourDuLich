package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Lớp hỗ trợ xuất dữ liệu ra file Excel
 */
public class ExcelWriter {

    /**
     * Xuất dữ liệu từ TableModel ra file Excel
     * 
     * @param defaultFileName tên file mặc định
     * @param model           TableModel chứa dữ liệu
     * @return đường dẫn file đã lưu hoặc null nếu hủy
     */
    public String exportFromTable(String defaultFileName, TableModel model) {
        if (model == null || model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Không có dữ liệu để xuất",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        // Chuyển dữ liệu từ TableModel sang ArrayList
        ArrayList<Object[]> data = new ArrayList<>();

        // Thêm header
        Object[] header = new Object[model.getColumnCount()];
        for (int col = 0; col < model.getColumnCount(); col++) {
            header[col] = model.getColumnName(col);
        }
        data.add(header);

        // Thêm dữ liệu
        for (int row = 0; row < model.getRowCount(); row++) {
            Object[] rowData = new Object[model.getColumnCount()];
            for (int col = 0; col < model.getColumnCount(); col++) {
                rowData[col] = model.getValueAt(row, col);
            }
            data.add(rowData);
        }

        return writeWithDialog(defaultFileName, data);
    }

    /**
     * Xuất dữ liệu ra file Excel và cho phép người dùng chọn vị trí lưu
     * 
     * @param defaultFileName tên file mặc định
     * @param data            dữ liệu cần xuất
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
     * @param data     dữ liệu cần xuất
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

                    if (value == null) {
                        cell.setBlank();
                        continue;
                    }

                    // Xử lý dựa trên kiểu dữ liệu thực tế
                    if (value instanceof String) {
                        String strValue = (String) value;

                        // Kiểm tra xem chuỗi có phải là định dạng ngày tháng "yyyy-MM-dd" không
                        if (strValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            try {
                                // Chuyển đổi chuỗi sang Date
                                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strValue);
                                cell.setCellValue(date);

                                // Sử dụng định dạng ngày tháng chuẩn của Excel
                                CellStyle dateStyle = workbook.createCellStyle();
                                CreationHelper helper = workbook.getCreationHelper();

                                // Sử dụng định dạng mặc định của Excel
                                short dateFormat = helper.createDataFormat().getFormat("m/d/yy");
                                dateStyle.setDataFormat(dateFormat);
                                cell.setCellStyle(dateStyle);
                            } catch (Exception e) {
                                // Nếu không thể chuyển đổi, xử lý như chuỗi bình thường
                                cell.setCellValue(strValue);
                            }
                        } else {
                            cell.setCellValue(strValue);
                        }
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else if (value instanceof Date) {
                        cell.setCellValue((Date) value);

                        // Định dạng ngày tháng theo tiêu chuẩn Excel
                        CellStyle dateStyle = workbook.createCellStyle();
                        CreationHelper helper = workbook.getCreationHelper();

                        // Sử dụng định dạng mặc định của Excel
                        short dateFormat = helper.createDataFormat().getFormat("m/d/yy");
                        dateStyle.setDataFormat(dateFormat);
                        cell.setCellStyle(dateStyle);
                    }
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