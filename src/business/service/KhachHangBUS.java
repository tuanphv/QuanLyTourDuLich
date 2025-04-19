package business.service;

import business.model.KhachHangDTO;
import persistence.dao.KhachHangDAO;
import java.util.ArrayList;

public class KhachHangBUS {
    private KhachHangDAO dao;
    private ArrayList<KhachHangDTO> dsKhachHang;

    public KhachHangBUS() {
        dao = new KhachHangDAO();
        dsKhachHang = dao.getAll();
    }

    public int insert(KhachHangDTO kh) {
        int id = dao.insert(kh);
        if (id != -1) {
            kh.setMaKH(id);
            dsKhachHang.add(kh);
        }
        return id;
    }

    public boolean update(KhachHangDTO kh) {
        boolean success = dao.update(kh);
        if (success) {
            int index = getIndexById(kh.getMaKH());
            if (index != -1) dsKhachHang.set(index, kh);
        }
        return success;
    }

    public boolean delete(int maKH) {
        boolean success = dao.delete(maKH);
        if (success) {
            int index = getIndexById(maKH);
            if (index != -1) dsKhachHang.remove(index);
        }
        return success;
    }

    public ArrayList<KhachHangDTO> getList() {
        return dsKhachHang;
    }

    public KhachHangDTO getById(int id) {
        return dsKhachHang.stream().filter(kh -> kh.getMaKH() == id).findFirst().orElse(null);
    }

    private int getIndexById(int id) {
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if (dsKhachHang.get(i).getMaKH() == id) return i;
        }
        return -1;
    }
}