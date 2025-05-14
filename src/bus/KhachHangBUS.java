package bus;

import dto.KhachHangDTO;
import dao.KhachHangDAO;
import java.util.ArrayList;
import utils.TextUtils;

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
            if (index != -1) {
                dsKhachHang.set(index, kh);
            }
        }
        return success;
    }

    public boolean delete(int maKH) {
        boolean success = dao.delete(maKH);
        if (success) {
            int index = getIndexById(maKH);
            if (index != -1) {
                dsKhachHang.remove(index);
            }
        }
        return success;
    }

    public ArrayList<KhachHangDTO> getList() {
        return dsKhachHang;
    }

    public KhachHangDTO getById(int id) {
        KhachHangDTO khachHang = dsKhachHang.stream().filter(kh -> kh.getMaKH() == id).findFirst().orElse(null);
        if (khachHang == null) {
            return dao.getKhachHangByMa(id);
        }
        return khachHang;
    }

    private int getIndexById(int id) {
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if (dsKhachHang.get(i).getMaKH() == id) {
                return i;
            }
        }
        return -1;
    }
    public ArrayList<KhachHangDTO> timTheoTen(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        for (KhachHangDTO kh : dsKhachHang) {
            if (TextUtils.removeDiacritics(kh.getHoTen()).toLowerCase()
                    .contains(TextUtils.removeDiacritics(text).toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHangDTO> timTheoMaKH(int maKH) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        for (KhachHangDTO kh : dsKhachHang) {
            if (kh.getMaKH() == maKH) {
                result.add(kh);
                break; // Mã KH là duy nhất
            }
        }
        return result;
    }

    public ArrayList<KhachHangDTO> timTheoCC(String cc) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        for (KhachHangDTO kh : dsKhachHang) {
            if (TextUtils.removeDiacritics(kh.getCC_HC()).toLowerCase()
                    .contains(TextUtils.removeDiacritics(cc).toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
}
