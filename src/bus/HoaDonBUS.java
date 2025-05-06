package bus;

import java.util.ArrayList;

import dao.HoaDonDAO;
import dto.HoaDonDTO;
import enums.TrangThaiHoaDon;

public class HoaDonBUS {
    private static ArrayList<HoaDonDTO> dsHoaDon;
    private HoaDonDAO dao;

    public HoaDonBUS() {
        dsHoaDon = new ArrayList<>();
        dao = new HoaDonDAO();
        loadData();
    }

    private void loadData() {
        dsHoaDon = dao.getAllHoaDon();
    }

    public ArrayList<HoaDonDTO> getDSHoaDon() {
        return dsHoaDon;
    }

    public int addHoaDon(HoaDonDTO hoaDon) {
        int index = dao.addHoaDon(hoaDon);
        if (index != -1) {
            dsHoaDon.add(hoaDon);
        }
        return index;
    }

    public int updateHoaDon(HoaDonDTO hoaDon) {
        boolean success = dao.updateHoaDon(hoaDon);
        if (success) {
            for (int i = 0; i < dsHoaDon.size(); i++) {
                if (dsHoaDon.get(i).getMaHoaDon() == hoaDon.getMaHoaDon()) {
                    dsHoaDon.set(i, hoaDon);
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean deleteHoaDon(int maHoaDon) {
        boolean success = dao.deleteHoaDon(maHoaDon);
        if (success) {
            for (int i = 0; i < dsHoaDon.size(); i++) {
                if (dsHoaDon.get(i).getMaHoaDon() == maHoaDon) {
                    dsHoaDon.remove(i);
                    break;
                }
            }
        }
        return success;
    }

    public HoaDonDTO getHoaDonById(int maHoaDon) {
        for (HoaDonDTO hoaDon : dsHoaDon) {
            if (hoaDon.getMaHoaDon() == maHoaDon) {
                return hoaDon;
            }
        }
        return null;
    }

    public ArrayList<HoaDonDTO> getHoaDonByMaNV(int maNV) {
        ArrayList<HoaDonDTO> result = new ArrayList<>();
        for (HoaDonDTO hoaDon : dsHoaDon) {
            if (hoaDon.getMaNV() == maNV) {
                result.add(hoaDon);
            }
        }
        return result;
    }
    
    public HoaDonDTO getHoaDonByMaDat(int maDat) {
        for (HoaDonDTO hoaDon : dsHoaDon) {
            if (hoaDon.getMaDat() == maDat) {
                return hoaDon;
            }
        }
        return null;
    }
}
