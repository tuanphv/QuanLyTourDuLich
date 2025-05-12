package bus;

import dao.TourDAO;
import dto.TourDTO;
import java.util.ArrayList;
import java.util.Iterator;

public class TourBUS {

    private static ArrayList<TourDTO> dsTour;

    public TourBUS() {
        dsTour = new ArrayList<>();
        loadData(); // tải dữ liệu ban đầu khi khởi tạo BUS
    }

    // Hàm loadData: lấy danh sách tour từ cơ sở dữ liệu thông qua DAO
    private void loadData() {
        TourDAO dao = new TourDAO();
        dsTour = dao.getAllTours();
    }

    // Hàm thêm Tour
    public int addTour(TourDTO tour) {
        TourDAO dao = new TourDAO();
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
        TourDAO dao = new TourDAO();
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
            if (tour.getTenTour().toLowerCase().contains(text.toLowerCase()))
                result.add(tour);
        }
        return result;
    }
    
    public ArrayList<TourDTO> timTheoDiemDen(String text) {
        ArrayList<TourDTO> result = new ArrayList<>();
        for (TourDTO tour : dsTour) {
            if (tour.getDiemDen().toLowerCase().contains(text.toLowerCase()))
                result.add(tour);
        }
        return result;
    }
    
    public ArrayList<TourDTO> timTheoDiemKhoiHanh(String text) {
        ArrayList<TourDTO> result = new ArrayList<>();
        for (TourDTO tour : dsTour) {
            if (tour.getDiemKhoiHanh().toLowerCase().contains(text.toLowerCase()))
                result.add(tour);
        }
        return result;
    }
    
    // Getter cho danh sách tours (nếu cần truy cập từ bên ngoài)
    public ArrayList<TourDTO> getDsTour() {
        return dsTour;
    }

}

