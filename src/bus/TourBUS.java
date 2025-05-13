package bus;

import dto.TourDTO;
import dao.TourDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import utils.CellUtils;
import utils.ExcelWriter;
import utils.TextUtils;

public class TourBUS {

    private static ArrayList<TourDTO> dsTour;
    private TourDAO dao;

    public TourBUS() {
        dao = new TourDAO();
        dsTour = new ArrayList<>();
        loadData(); // tải dữ liệu ban đầu khi khởi tạo BUS
    }

    // Hàm loadData: lấy danh sách tour từ cơ sở dữ liệu thông qua DAO
    private void loadData() {
        dsTour = dao.getAllTours();
    }

    // Hàm thêm Tour
    public int addTour(TourDTO tour) {
        int index = dao.addTour(tour);
        if (index != -1) {
            // Thêm vào dsTour nếu thao tác INSERT thành công.
            dsTour.add(tour);
        }
        return index;
    }

    /**
     *
     * @param tour Tour to be updated
     * @return index of element to be updated
     */
    public int updateTour(TourDTO tour) {
        boolean success = dao.updateTour(tour);
        if (success) {
            // Cập nhật trong dsTour
            for (int i = 0; i < dsTour.size(); i++) {
                if (dsTour.get(i).getMaTour() == tour.getMaTour()) {
                    dsTour.set(i, tour);
                    return i;
                }
            }
        }
        return -1;
    }

    // Hàm xóa Tour theo mã tour
    public boolean deleteTour(int maTour) {
        boolean success = dao.deleteTour(maTour);
        if (success) {
            // Xóa khỏi dsTour bằng cách sử dụng Iterator
            Iterator<TourDTO> iterator = dsTour.iterator();
            while (iterator.hasNext()) {
                TourDTO t = iterator.next();
                if (t.getMaTour() == maTour) {
                    iterator.remove();
                    break;
                }
            }
        }
        return success;
    }

    public TourDTO getTourById(int maTour) {
        for (TourDTO tour : dsTour) {
            if (tour.getMaTour() == maTour) {
                return tour;
            }
        }
        return null; // Nếu không tìm thấy
    }

    public ArrayList<TourDTO> timTheoTen(String text) {
        ArrayList<TourDTO> result = new ArrayList<>();
        for (TourDTO tour : dsTour) {
            if (TextUtils.removeDiacritics(tour.getTenTour()).toLowerCase().contains(TextUtils.removeDiacritics(text).toLowerCase())) {
                result.add(tour);
            }
        }
        return result;
    }

    public ArrayList<TourDTO> timTheoDiemDen(String text) {
        ArrayList<TourDTO> result = new ArrayList<>();
        for (TourDTO tour : dsTour) {
            if (TextUtils.removeDiacritics(tour.getDiemDen()).toLowerCase().contains(TextUtils.removeDiacritics(text).toLowerCase())) {
                result.add(tour);
            }
        }
        return result;
    }

    public ArrayList<TourDTO> timTheoDiemKhoiHanh(String text) {
        ArrayList<TourDTO> result = new ArrayList<>();
        for (TourDTO tour : dsTour) {
            if (TextUtils.removeDiacritics(tour.getDiemKhoiHanh()).toLowerCase().contains(TextUtils.removeDiacritics(text).toLowerCase())) {
                result.add(tour);
            }
        }
        return result;
    }

    public ArrayList<Object[]> thongKeTour(LocalDate startDate, LocalDate endDate) {
        return dao.thongKeTour(startDate, endDate);
    }

    // Getter cho danh sách tours (nếu cần truy cập từ bên ngoài)
    public ArrayList<TourDTO> getDsTour() {
        return dsTour;
    }

    public String exportExcel() {
        ArrayList<Object[]> data = new ArrayList<>();
        // tạo headers
        Object[] headers = new Object[]{
            "Mã Tour",
            "Tên Tour",
            "Giá",
            "Tình Trạng",
            "Mô Tả",
            "Điểm Khởi Hành",
            "Điểm Đến",
            "Loại Tour",
            "Số Ngày",
            "Số Đêm"};
        data.add(headers);
        // add từng dòng
        for (TourDTO tour : dsTour) {
            data.add(tour.toExcelRow());
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
                    case 0, 8, 9 ->
                        cell.setCellValue((Integer) value);
                    case 1, 3, 4, 5, 6, 7 ->
                        cell.setCellValue((String) value);
                    case 2 -> {    
                        cell.setCellStyle(CellUtils.getCurrencyStyle(cell.getSheet().getWorkbook()));
                        cell.setCellValue((Float) value);
                    }
                }
            }
        }));
        return excelWriter.writeWithDialog("DanhSachTour.xlsx", data);
    }
}
