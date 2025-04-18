package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ExcelReader {

    public ExcelReader() {
    }

    public ArrayList<Object[]> read(String filePath, Class<?>[] types) {
        ArrayList<Object[]> result = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            fis = new FileInputStream(new File(filePath));

            if (filePath.toLowerCase().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (filePath.toLowerCase().endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis);
            } else {
                System.out.println("File không hợp lệ!");
                return result;
            }

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Object[] rowData = new Object[types.length];

                for (int i = 0; i < types.length; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Class<?> expectedType = types[i];

                    rowData[i] = parseCell(cell, expectedType);
                    System.out.print(rowData[i]);
                }
                result.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private Object parseCell(Cell cell, Class<?> type) {
        try {
            if (type == String.class) {
                return cell.getStringCellValue();
            } else if (type == int.class) {
                return (int) cell.getNumericCellValue();
            } else if (type == Double.class) {
                return cell.getNumericCellValue();
            } else if (type == Boolean.class) {
                return cell.getBooleanCellValue();
            } else if (type == Date.class) {
                return cell.getDateCellValue();
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Lỗi ép kiểu tại ô: " + cell + " → " + type.getSimpleName());
            return null;
        }
    }
}
