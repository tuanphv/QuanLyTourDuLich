package business.service;

import business.model.NhanVienDTO;
import persistence.dao.NhanVienDAO;
import java.util.ArrayList;

public class NhanVienBUS {
    private NhanVienDAO dao;
    private ArrayList<NhanVienDTO> dsNhanVien;

    public NhanVienBUS() {
        dao = new NhanVienDAO();
        dsNhanVien = dao.getAll();
    }

    public int insert(NhanVienDTO nv) {
        int id = dao.insert(nv);
        if (id != -1) {
            nv.setMaNV(id);
            dsNhanVien.add(nv);
        }
        return id;
    }

    public boolean update(NhanVienDTO nv) {
        boolean success = dao.update(nv);
        if (success) {
            int index = getIndexById(nv.getMaNV());
            if (index != -1) dsNhanVien.set(index, nv);
        }
        return success;
    }

    public boolean delete(int maNV) {
        boolean success = dao.delete(maNV);
        if (success) {
            int index = getIndexById(maNV);
            if (index != -1) dsNhanVien.remove(index);
        }
        return success;
    }

    public ArrayList<NhanVienDTO> getList() {
        return dsNhanVien;
    }
    public NhanVienDTO getById(int id) {
        return dsNhanVien.stream().filter(kh -> kh.getMaNV() == id).findFirst().orElse(null);
    }
    private int getIndexById(int maNV) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getMaNV() == maNV) return i;
        }
        return -1;
    }
}