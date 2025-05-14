package bus;

import dao.KhachSanNghiNgoiDAO;
import dto.KhachSanNghiNgoiDTO;
import java.util.ArrayList;

public class KhachSanNghiNgoiBUS {
    KhachSanNghiNgoiDAO khachSanNghiNgoiDAO;
    ArrayList<KhachSanNghiNgoiDTO> dsKhachSanNghiNgoi;

    public KhachSanNghiNgoiBUS() {
        khachSanNghiNgoiDAO = new KhachSanNghiNgoiDAO();
        loadData(); // Tải dữ liệu ban đầu
    }

    public void loadData() {
        dsKhachSanNghiNgoi = khachSanNghiNgoiDAO.getAllKhachSanNghiNgoi();
    }

    public int insert(KhachSanNghiNgoiDTO khachSanNghiNgoi) {
        int id = khachSanNghiNgoiDAO.insert(khachSanNghiNgoi);
        if (id != -1) dsKhachSanNghiNgoi.add(khachSanNghiNgoi);
        return id;
    }

    public boolean update(KhachSanNghiNgoiDTO khachSanNghiNgoi) {
        boolean check = khachSanNghiNgoiDAO.update(khachSanNghiNgoi);
        if (check) dsKhachSanNghiNgoi.set(getIndexByMaKhachSanNghiNgoi(khachSanNghiNgoi.getMaKhachSanNghiNgoi()), khachSanNghiNgoi);
        return check;
    }

    public boolean delete(int maKhachSanNghiNgoi) {
        boolean check = khachSanNghiNgoiDAO.delete(maKhachSanNghiNgoi);
        if (check) dsKhachSanNghiNgoi.remove(getIndexByMaKhachSanNghiNgoi(maKhachSanNghiNgoi));
        return check;
    }

    public ArrayList<KhachSanNghiNgoiDTO> getAllKhachSanNghiNgoi() {
        return dsKhachSanNghiNgoi;
    }

    public int getIndexByMaKhachSanNghiNgoi(int maKhachSanNghiNgoi) {
        for (int i = 0; i < dsKhachSanNghiNgoi.size(); i++) {
            if (dsKhachSanNghiNgoi.get(i).getMaKhachSanNghiNgoi() == maKhachSanNghiNgoi) {
                return i;
            }
        }
        return -1;
    }

    public KhachSanNghiNgoiDTO getKhachSanNghiNgoiByMaKhachSanNghiNgoi(int maKhachSanNghiNgoi) {
        for (KhachSanNghiNgoiDTO khachSanNghiNgoi : dsKhachSanNghiNgoi) {
            if (khachSanNghiNgoi.getMaKhachSanNghiNgoi() == maKhachSanNghiNgoi) {
                return khachSanNghiNgoi;
            }
        }
        return null;
    }
    
    public ArrayList<KhachSanNghiNgoiDTO> getKhachSanNghiNgoiByMaChiTietKeHoachTour(int maChiTietKeHoachTour) {
        loadData();
        ArrayList<KhachSanNghiNgoiDTO> result = new ArrayList<>();
        for (KhachSanNghiNgoiDTO khachSanNghiNgoi : dsKhachSanNghiNgoi) {
            if (khachSanNghiNgoi.getMaChiTietKeHoachTour() == maChiTietKeHoachTour) {
                result.add(khachSanNghiNgoi);
            }
        }
        return result;
    }

    public KhachSanNghiNgoiDTO getKhachSanNghiNgoiByMaChiTietKeHoachAndMaKhachSanNghiNgoi(int maChiTietKeHoachTour, int maKhachSan) {
        for (KhachSanNghiNgoiDTO khachSanNghiNgoi : dsKhachSanNghiNgoi) {
            if (khachSanNghiNgoi.getMaChiTietKeHoachTour() == maChiTietKeHoachTour && khachSanNghiNgoi.getMaKhachSan() == maKhachSan) {
                return khachSanNghiNgoi;
            }
        }
        return null;
    }


}
