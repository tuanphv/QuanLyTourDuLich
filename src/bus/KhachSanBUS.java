package bus;

import java.util.ArrayList;

import model.KhachSanDTO;
import dao.KhachSanDAO;

public class KhachSanBUS {
    KhachSanDAO khachSanDAO;
    ArrayList<KhachSanDTO> listHotel;

    public KhachSanBUS() {
        khachSanDAO = new KhachSanDAO();
        listHotel = khachSanDAO.getAllHotel();
    }

    public int insert(KhachSanDTO khachSan) {
        int index = khachSanDAO.insert(khachSan);
        if (index != -1) listHotel.add(khachSan);
        return index;
    }

    public boolean update(KhachSanDTO khachSan) {
        boolean check = khachSanDAO.update(khachSan);
        if (check) listHotel.set(getIndexById(khachSan.getMaKhachSan()), khachSan);
        return check;
    }

    public boolean delete(int maKhachSan) {
        boolean check = khachSanDAO.delete(maKhachSan);
        if (check) listHotel.remove(getIndexById(maKhachSan));
        return check;
    }

    public ArrayList<KhachSanDTO> getListHotel() {
        return listHotel;
    }

    public int getIndexById(int maKhachSan) {
        for (int i = 0; i < listHotel.size(); i++) {
            if (listHotel.get(i).getMaKhachSan() == maKhachSan) {
                return i;
            }
        }
        return -1;
    }

    public KhachSanDTO getHotelById(int maKhachSan) {
        for (KhachSanDTO hotel : listHotel) {
            if (hotel.getMaKhachSan() == maKhachSan) {
                return hotel;
            }
        }
        return null;
    }
}
