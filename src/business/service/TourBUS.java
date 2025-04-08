package business.service;

import business.model.TourDTO;
import persistence.dao.TourDAO;
import java.util.ArrayList;
import java.util.Iterator;

public class TourBUS {

    private static ArrayList<TourDTO> dsTour;

    public TourBUS() {
        dsTour = new ArrayList<>();
        loadData(); // tải dữ liệu ban đầu khi khởi tạo BUS
    }

    // Hàm loadData: lấy danh sách tour từ cơ sở dữ liệu thông qua DAO
    public void loadData() {
        TourDAO dao = new TourDAO();
        dsTour = dao.getAllTours();
    }

    // Hàm thêm Tour
    public boolean addTour(TourDTO tour) {
        TourDAO dao = new TourDAO();
        boolean success = dao.addTour(tour);
        if (success) {
            // Thêm vào dsTour nếu thao tác INSERT thành công.
            dsTour.add(tour);
        }
        return success;
    }

    // Hàm sửa Tour
    public boolean updateTour(TourDTO tour) {
        TourDAO dao = new TourDAO();
        boolean success = dao.updateTour(tour);
        if (success) {
            // Cập nhật trong dsTour
            for (int i = 0; i < dsTour.size(); i++) {
                if (dsTour.get(i).getMaTour() == tour.getMaTour()) {
                    dsTour.set(i, tour);
                    break;
                }
            }
        }
        return success;
    }

    // Hàm xóa Tour theo mã tour
    public boolean deleteTour(int maTour) {
        TourDAO dao = new TourDAO();
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

    // Getter cho danh sách tours (nếu cần truy cập từ bên ngoài)
    public ArrayList<TourDTO> getDsTour() {
        return dsTour;
    }
}
