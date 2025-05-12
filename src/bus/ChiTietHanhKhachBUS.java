package bus;

import dao.ChiTietHanhKhachDAO;
import dto.ChiTietHanhKhachDTO;
import java.util.ArrayList;

public class ChiTietHanhKhachBUS {

    private ArrayList<ChiTietHanhKhachDTO> dsCTietHKhach;
    private ChiTietHanhKhachDAO dao;

    public ChiTietHanhKhachBUS() {
        dao = new ChiTietHanhKhachDAO();
        dsCTietHKhach = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        dsCTietHKhach = dao.getAllCTietHKhach();
    }

    public boolean addCTietHKhach(ChiTietHanhKhachDTO chiTiet) {
        boolean success = dao.addCTietHKhach(chiTiet);
        if (success) {
            dsCTietHKhach.add(chiTiet);
        }
        return success;
    }
    
    public ArrayList<Object[]> thongKeLoaiHanhKhach() {
        return dao.thongKeLoaiHanhKhach();
    }
}
