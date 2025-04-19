package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Lớp đọc dữ liệu từ file Excel
 */
public class ExcelReader {

    /**
     * Đọc dữ liệu từ file Excel
     * 
     * @param filePath đường dẫn tới file Excel
     * @param types    mảng các kiểu dữ liệu cho mỗi cột
     * @return ArrayList chứa các dòng dữ liệu
     */
    public ArrayList<Object[]> read(String filePath, Class<?>[] types) {
        ArrayList<Object[]> result = new ArrayList<>();

        if (filePath == null || filePath.isBlank()) {
            System.out.println("❌ Đường dẫn file không hợp lệ");
            return result;
        }

        try (FileInputStream fis = new FileInputStream(new File(filePath));
                Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int maxColumns = getColumnCount(sheet, types);

            // Xử lý tất cả các dòng trong sheet
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null)
                    continue;

                Object[] rowData = new Object[maxColumns];
                boolean hasData = false;

                for (int j = 0; j < maxColumns; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null)
                        continue;

                    Object value = getCellValue(cell, types != null && j < types.length ? types[j] : String.class);
                    rowData[j] = value;

                    if (value != null) {
                        hasData = true;
                    }
                }

                if (hasData) {
                    result.add(rowData);
                }
            }

            System.out.println("✅ Đọc thành công " + result.size() + " dòng từ file: " + filePath);

        } catch (IOException e) {
            System.out.println("❌ Lỗi đọc file: " + e.getMessage());
        }

        return result;
    }

    /**
     * Cho phép người dùng chọn file Excel và đọc dữ liệu
     * 
     * @param types mảng các kiểu dữ liệu cho mỗi cột
     * @return ArrayList chứa các dòng dữ liệu
     */
    public ArrayList<Object[]> readWithDialog(Class<?>[] types) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        fileChooser.setDialogTitle("Chọn file Excel để nhập dữ liệu");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return read(fileChooser.getSelectedFile().getAbsolutePath(), types);
        }

        return new ArrayList<>();
    }

    /**
     * Xác định số cột cần đọc
     */
    private int getColumnCount(Sheet sheet, Class<?>[] types) {
        // Nếu có types, dùng độ dài của types
        if (types != null && types.length > 0) {
            return types.length;
        }

        // Kiểm tra số cột từ dòng đầu tiên
        Row firstRow = sheet.getRow(0);
        return firstRow != null ? firstRow.getLastCellNum() : 0;
    }

    /**
     * Lấy giá trị từ cell theo kiểu dữ liệu mong muốn
     */
    private Object getCellValue(Cell cell, Class<?> type) {
        if (cell == null)
            return null;

        try {
            switch (cell.getCellType()) {
                case STRING:
                    String str = cell.getStringCellValue();
                    if (str.isBlank())
                        return null;

                    if (type == Integer.class || type == int.class)
                        return Integer.valueOf(str.trim());
                    if (type == Double.class || type == double.class)
                        return Double.valueOf(str.trim());
                    if (type == Boolean.class || type == boolean.class)
                        return Boolean.valueOf(str.trim());

                    // Xử lý ngày tháng với nhiều định dạng
                    if (type == Date.class) {
                        String trimmed = str.trim();

                        // Thử các định dạng phổ biến
                        String[] dateFormats = {
                                "yyyy-MM-dd", // 2023-04-25
                                "dd/MM/yyyy", // 25/04/2023
                                "dd-MM-yyyy", // 25-04-2023
                                "MM/dd/yyyy", // 04/25/2023
                                "yyyy/MM/dd", // 2023/04/25
                                "m/d/yyyy", // 4/25/2023
                        };

                        for (String format : dateFormats) {
                            try {
                                return new SimpleDateFormat(format).parse(trimmed);
                            } catch (Exception e) {
                                // Thử định dạng tiếp theo
                            }
                        }

                        // Nếu tất cả định dạng đều thất bại
                        System.out.println("⚠️ Không thể chuyển đổi chuỗi sang Date: " + str);
                        return null;
                    }
                    return str;

                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        return type == String.class ? new SimpleDateFormat("dd/MM/yyyy").format(date) : date;
                    }

                    double num = cell.getNumericCellValue();
                    if (type == Integer.class || type == int.class)
                        return (int) num;
                    if (type == Double.class || type == double.class)
                        return (double) num;
                    if (type == Boolean.class || type == boolean.class)
                        return num != 0.0;
                    if (type == String.class) {
                        return num == Math.floor(num) ? Long.toString((long) num) : Double.toString(num);
                    }
                    return num;

                case BOOLEAN:
                    boolean bool = cell.getBooleanCellValue();
                    return type == String.class ? Boolean.toString(bool) : bool;

                case FORMULA:
                    return cell.getStringCellValue();

                case BLANK:
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}