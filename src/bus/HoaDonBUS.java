package bus;

import java.util.ArrayList;

import dao.HoaDonDAO;
import dto.HoaDonDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import utils.CellUtils;
import utils.DateUtils;
import utils.ExcelWriter;

public class HoaDonBUS {

    private static ArrayList<HoaDonDTO> dsHoaDon;
    private HoaDonDAO dao;

    public HoaDonBUS() {
        dsHoaDon = new ArrayList<>();
        dao = new HoaDonDAO();
        loadData();
    }

    private void loadData() {
        dsHoaDon = dao.getAllHoaDon();
    }

    public ArrayList<HoaDonDTO> getDSHoaDon() {
        return dsHoaDon;
    }

    public int addHoaDon(HoaDonDTO hoaDon) {
        int index = dao.addHoaDon(hoaDon);
        if (index != -1) {
            dsHoaDon.add(hoaDon);
        }
        return index;
    }

    public int updateHoaDon(HoaDonDTO hoaDon) {
        boolean success = dao.updateHoaDon(hoaDon);
        if (success) {
            for (int i = 0; i < dsHoaDon.size(); i++) {
                if (dsHoaDon.get(i).getMaHoaDon() == hoaDon.getMaHoaDon()) {
                    dsHoaDon.set(i, hoaDon);
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean deleteHoaDon(int maHoaDon) {
        boolean success = dao.deleteHoaDon(maHoaDon);
        if (success) {
            for (int i = 0; i < dsHoaDon.size(); i++) {
                if (dsHoaDon.get(i).getMaHoaDon() == maHoaDon) {
                    dsHoaDon.remove(i);
                    break;
                }
            }
        }
        return success;
    }

    public HoaDonDTO getHoaDonById(int maHoaDon) {
        for (HoaDonDTO hoaDon : dsHoaDon) {
            if (hoaDon.getMaHoaDon() == maHoaDon) {
                return hoaDon;
            }
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getHoaDonByMaNV(int maNV) {
        ArrayList<HoaDonDTO> result = new ArrayList<>();
        for (HoaDonDTO hoaDon : dsHoaDon) {
            if (hoaDon.getMaNV() == maNV) {
                result.add(hoaDon);
            }
        }
        return result;
    }

    public HoaDonDTO getHoaDonByMaDat(int maDat) {
        for (HoaDonDTO hoaDon : dsHoaDon) {
            if (hoaDon.getMaDat() == maDat) {
                return hoaDon;
            }
        }
        return null;
    }

    public float[] thongKeDoanhThuTheoNam(int year) {
        LocalDate start = DateUtils.getStartOfYear(year);
        LocalDate end = DateUtils.getEndOfYear(year);
        float[] data = new float[12];
        for (HoaDonDTO hoaDon : dsHoaDon) {
            LocalDate date = hoaDon.getNgayLap().toLocalDate();
            if (date.isAfter(start) && date.isBefore(end)) {
                data[date.getMonthValue() - 1] += hoaDon.getTongTien();
            }
        }
        return data;
    }

    public String exportExcel() {
        ArrayList<Object[]> data = new ArrayList<>();
        // tạo headers
        Object[] headers = HoaDonDTO.COLUMN_NAMES;
        data.add(headers);
        // add từng dòng
        for (HoaDonDTO hoaDon : dsHoaDon) {
            data.add(hoaDon.toExcelRow());
        }

        ExcelWriter excelWriter = new ExcelWriter(((cell, value, rowIndex, columnIndex) -> {
            if (rowIndex == 0) {
                CellStyle style = cell.getSheet().getWorkbook().createCellStyle();
                Font font = cell.getSheet().getWorkbook().createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
                cell.setCellValue((String) value);
            } else {
                switch (columnIndex) {
                    case 0, 1, 2 ->
                        cell.setCellValue((Integer) value);
                    case 3 -> {
                        cell.setCellStyle(CellUtils.getDateTimeStyle(cell.getSheet().getWorkbook()));
                        cell.setCellValue(DateUtils.localDateTimeToDate((LocalDateTime) value));
                    }
                    case 4 -> {
                        cell.setCellStyle(CellUtils.getCurrencyStyle(cell.getSheet().getWorkbook()));
                        cell.setCellValue((Float) value);
                    }
                    case 5, 6 ->
                        cell.setCellValue((String) value);
                }
            }
        }));
        return excelWriter.writeWithDialog("DanhSachHoaDon.xlsx", data);
    }
}
