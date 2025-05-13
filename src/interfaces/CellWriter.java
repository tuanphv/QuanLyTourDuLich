package interfaces;

import org.apache.poi.ss.usermodel.Cell;

@FunctionalInterface
public interface CellWriter {
    /**
     * Ghi dữ liệu vào cell theo cài đặt trong hàm
     * @param cell
     * @param value
     * @param rowIndex
     * @param columnIndex 
     */
    void write(Cell cell, Object value, int rowIndex, int columnIndex);
}
