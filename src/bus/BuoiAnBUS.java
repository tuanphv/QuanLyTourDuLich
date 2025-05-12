package bus;

import dao.BuoiAnDAO;
import dto.BuoiAnDTO;
import java.util.ArrayList;

public class BuoiAnBUS {
    BuoiAnDAO buoiAnDAO;
    ArrayList<BuoiAnDTO> listBuoiAn;

    public BuoiAnBUS() {
        buoiAnDAO = new BuoiAnDAO();
        listBuoiAn = buoiAnDAO.getAllBuoiAn();
    }

    public int insert(BuoiAnDTO buoiAn) {
        int id = buoiAnDAO.insert(buoiAn);
        if (id != -1) listBuoiAn.add(buoiAn);
        return id;
    }  

    public boolean update(BuoiAnDTO buoiAn) {
        boolean check = buoiAnDAO.update(buoiAn);
        if (check) listBuoiAn.set(getIndexById(buoiAn.getMaBuoiAn()), buoiAn);
        return check;
    }

    public boolean delete(int maBuoiAn) {
        boolean check = buoiAnDAO.delete(maBuoiAn);
        if (check) listBuoiAn.remove(getIndexById(maBuoiAn));
        return check;
    }

    public ArrayList<BuoiAnDTO> getAllBuoiAn() {
        return listBuoiAn;
    }

    public int getIndexById(int maBuoiAn) {
        for (int i = 0; i < listBuoiAn.size(); i++) {
            if (listBuoiAn.get(i).getMaBuoiAn() == maBuoiAn) {
                return i;
            }
        }
        return -1;
    }

    public BuoiAnDTO getBuoiAnById(int maBuoiAn) {
        for (BuoiAnDTO buoiAn : listBuoiAn) {
            if (buoiAn.getMaBuoiAn() == maBuoiAn) {
                return buoiAn;
            }
        }
        return null;
    }
    
    public ArrayList<BuoiAnDTO> getBuoiAnByMaChiTietKeHoachTour(int maChiTietKeHoachTour) {
        ArrayList<BuoiAnDTO> result = new ArrayList<>();
        for (BuoiAnDTO buoiAn : listBuoiAn) {
            if (buoiAn.getMaChiTietKeHoachTour() == maChiTietKeHoachTour) {
                result.add(buoiAn);
            }
        }
        return result;
    }

    public BuoiAnDTO getBuoiAnByMaChiTietKeHoachTourAndMaNhaHang(int maChiTietKeHoachTour, int maNhaHang) {
        for (BuoiAnDTO buoiAn : listBuoiAn) {
            if (buoiAn.getMaChiTietKeHoachTour() == maChiTietKeHoachTour && buoiAn.getMaNhaHang() == maNhaHang) {
                return buoiAn;
            }
        }
        return null;
    }

    public String getLoaiBuaAn(int number) {
        return switch (number) {
            case 1 -> "Sáng";
            case 2 -> "Trưa";
            case 3 -> "Tối";
            default -> null;
        };
    }
}
