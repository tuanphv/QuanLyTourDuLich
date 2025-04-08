package business.service;

import business.model.DiaDanhDTO;
import persistence.dao.DiaDanhDAO;
import java.util.ArrayList;
import java.util.Iterator;

public class DiaDanhBUS {

    private static ArrayList<DiaDanhDTO> dsDiaDanh;

    public DiaDanhBUS() {
        dsDiaDanh = new ArrayList<>();
        loadData(); // Tải dữ liệu ban đầu
    }

    // Hàm loadData: lấy danh sách từ DAO
    public void loadData() {
        DiaDanhDAO dao = new DiaDanhDAO();
        dsDiaDanh = dao.getAllDiaDanh();
    }

    // Thêm địa danh
    public boolean addDiaDanh(DiaDanhDTO diaDanh) {
        DiaDanhDAO dao = new DiaDanhDAO();
        boolean success = dao.addDiaDanh(diaDanh);
        if (success) {
            dsDiaDanh.add(diaDanh);
        }
        return success;
    }

    // Sửa địa danh
    public boolean updateDiaDanh(DiaDanhDTO diaDanh) {
        DiaDanhDAO dao = new DiaDanhDAO();
        boolean success = dao.updateDiaDanh(diaDanh);
        if (success) {
            for (int i = 0; i < dsDiaDanh.size(); i++) {
                if (dsDiaDanh.get(i).getMaDD() == diaDanh.getMaDD()) {
                    dsDiaDanh.set(i, diaDanh);
                    break;
                }
            }
        }
        return success;
    }

    // Xóa địa danh theo mã
    public boolean deleteDiaDanh(int maDD) {
        DiaDanhDAO dao = new DiaDanhDAO();
        boolean success = dao.deleteDiaDanh(maDD);
        if (success) {
            Iterator<DiaDanhDTO> iterator = dsDiaDanh.iterator();
            while (iterator.hasNext()) {
                DiaDanhDTO d = iterator.next();
                if (d.getMaDD() == maDD) {
                    iterator.remove();
                    break;
                }
            }
        }
        return success;
    }

    // Getter danh sách địa danh
    public ArrayList<DiaDanhDTO> getDsDiaDanh() {
        return dsDiaDanh;
    }
}
