package utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

public class CellUtils {

    public static CellStyle getCurrencyStyle(Workbook wb) {
        CellStyle currencyStyle = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();
        currencyStyle.setDataFormat(format.getFormat("#,##0 \"VNĐ\""));
        return currencyStyle;
    }

    public static CellStyle getDateTimeStyle(Workbook workbook) {
        CellStyle dateTimeStyle = workbook.createCellStyle();
        short format = workbook.createDataFormat().getFormat("dd/MM/yyyy HH:mm:ss");
        dateTimeStyle.setDataFormat(format);
        return dateTimeStyle;
    }
}
