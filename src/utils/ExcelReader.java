package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Function;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Lớp đọc dữ liệu từ file Excel
 */
public class ExcelReader<T> {

    /**
     * Đọc dữ liệu từ file Excel
     *
     * @param filePath đường dẫn tới file Excel
     * @param rowMapper hàm ánh xạ từ Row -> T
     * @return ArrayList chứa các dòng dữ liệu
     */
    public ArrayList<T> read(String filePath, Function<Row, T> rowMapper) {
        ArrayList<T> result = new ArrayList<>();

        if (filePath == null || filePath.isBlank()) {
            System.out.println("❌ Đường dẫn file không hợp lệ");
            return result;
        }

        try (FileInputStream fis = new FileInputStream(new File(filePath)); Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            // bỏ qua header
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                T rowData = rowMapper.apply(row); // ánh xạ dòng sang DTO
                if (rowData != null) {
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
     * @param rowMapper hàm ánh xạ từ Row -> T
     * @return ArrayList chứa các dòng dữ liệu
     */
    public ArrayList<T> readWithDialog(Function<Row, T> rowMapper) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        fileChooser.setDialogTitle("Chọn file Excel để nhập dữ liệu");

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return read(fileChooser.getSelectedFile().getAbsolutePath(), rowMapper);
        }

        return new ArrayList<>();
    }

    /**
     * Lấy giá trị từ cell theo kiểu dữ liệu mong muốn
     */
    private Object getCellValue(Cell cell, Class<?> type) {
        if (cell == null) {
            return null;
        }

        try {
            switch (cell.getCellType()) {
                case STRING:
                    String str = cell.getStringCellValue();
                    if (str.isBlank()) {
                        return null;
                    }

                    if (type == Integer.class || type == int.class) {
                        return Integer.valueOf(str.trim());
                    }
                    if (type == Double.class || type == double.class) {
                        return Double.valueOf(str.trim());
                    }
                    if (type == Boolean.class || type == boolean.class) {
                        return Boolean.valueOf(str.trim());
                    }

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
                    if (type == Integer.class || type == int.class) {
                        return (int) num;
                    }
                    if (type == Double.class || type == double.class) {
                        return (double) num;
                    }
                    if (type == Boolean.class || type == boolean.class) {
                        return num != 0.0;
                    }
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
