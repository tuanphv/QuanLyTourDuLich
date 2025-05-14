package bus;

import dto.NhanVienDTO;
import dao.NhanVienDAO;
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
        NhanVienDTO nv = dsNhanVien.stream().filter(kh -> kh.getMaNV() == id).findFirst().orElse(null);
        if (nv == null)
            return dao.getNhanVienByMa(id);
        return nv;
    }
    private int getIndexById(int maNV) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getMaNV() == maNV) return i;
        }
        return -1;
    }
     public ArrayList<NhanVienDTO> timTheoMa(String ma) {
            ArrayList<NhanVienDTO> result = new ArrayList<>();
            for (NhanVienDTO nv : dsNhanVien) {
                if (String.valueOf(nv.getMaNV()).contains(ma)) {
                    result.add(nv);
                }
            }
            return result;
        }

    public ArrayList<NhanVienDTO> timTheoTen(String ten) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        for (NhanVienDTO nv : dsNhanVien) {
            if (nv.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> timTheoChucVu(String chucVu) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        for (NhanVienDTO nv : dsNhanVien) {
            if (nv.getChucVu().toLowerCase().contains(chucVu.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }
    public NhanVienDTO login(String username, String password) {
        for (NhanVienDTO nv : dsNhanVien) {
            if (nv.getUsername().equals(username) && nv.getPassword().equals(password)) {
                return nv;
            }
        }
        return null;
    }
}