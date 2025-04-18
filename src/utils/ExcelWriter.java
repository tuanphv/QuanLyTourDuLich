package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    /**
     * 
     * @param filePath
     * @param data 
     * @param types types of every row in data 
     */
    public void write(String filePath, ArrayList<Object[]> data, Class<?>[] types) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
            Row row = sheet.createRow(rowIndex);
            Object[] rowData = data.get(rowIndex);

            for (int colIndex = 0; colIndex < rowData.length; colIndex++) {
                Cell cell = row.createCell(colIndex);
                Object value = rowData[colIndex];
                Class<?> type = (types != null && colIndex < types.length) ? types[colIndex] : null;

                if (value == null || type == null) {
                    cell.setBlank();
                    continue;
                }

                castValue(value, type);

            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            System.out.println("✅ Ghi file thành công: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Lỗi ghi file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Object castValue(Object value, Class<?> type) {
        if (value == null || type == null) {
            return null;
        }

        try {
            if (type == String.class) {
                return value.toString();
            } else if (type == Integer.class) {
                if (value instanceof Number number) {
                    return number.intValue();
                }
                return Integer.valueOf(value.toString());
            } else if (type == Double.class) {
                if (value instanceof Number number) {
                    return number.doubleValue();
                }
                return Double.valueOf(value.toString());
            } else if (type == Boolean.class) {
                if (value instanceof Boolean) {
                    return value;
                }
                return Boolean.valueOf(value.toString());
            } else if (type == Date.class) {
                if (value instanceof Date) {
                    return value;
                }
                // parse từ chuỗi ngày (nếu cần)
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.parse(value.toString());
            }
        } catch (Exception e) {
            System.out.println("⚠️ Không ép được: " + value + " → " + type.getSimpleName());
        }

        return null; // fallback
    }

}
