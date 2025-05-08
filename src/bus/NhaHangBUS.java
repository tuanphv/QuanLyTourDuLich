package bus;

import dao.NhaHangDAO;
import dto.NhaHangDTO;
import java.util.ArrayList;

public class NhaHangBUS {
    NhaHangDAO nhaHangDAO;
    ArrayList<NhaHangDTO> listRestaurant;

    public NhaHangBUS() {
        nhaHangDAO = new NhaHangDAO();
        listRestaurant = nhaHangDAO.getAllRestaurant();
    }

    public int insert(NhaHangDTO nhaHang) {
        int index = nhaHangDAO.insert(nhaHang);
        if (index != -1) listRestaurant.add(nhaHang);
        return index;
    }

    public boolean update(NhaHangDTO nhaHang) {
        boolean check = nhaHangDAO.update(nhaHang);
        if (check) listRestaurant.set(getIndexById(nhaHang.getMaNhaHang()), nhaHang);
        return check;
    }

    public boolean delete(int maNhaHang) {
        boolean check = nhaHangDAO.delete(maNhaHang);
        if (check) listRestaurant.remove(getIndexById(maNhaHang));
        return check;
    }

    public ArrayList<NhaHangDTO> getListRestaurant() {
        return listRestaurant;
    }

    public int getIndexById(int maNhaHang) {
        for (int i = 0; i < listRestaurant.size(); i++) {
            if (listRestaurant.get(i).getMaNhaHang() == maNhaHang) {
                return i;
            }
        }
        return -1;
    }

    public NhaHangDTO getRestaurantById(int maNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getMaNhaHang() == maNhaHang) {
                return nhaHang;
            }
        }
        return null;
    }

    public int getIdByName(String tenNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getTenNhaHang().equals(tenNhaHang)) {
                return nhaHang.getMaNhaHang();
            }
        }
        return -1;
    }

    public String getNameById(int maNhaHang) {
        for (NhaHangDTO nhaHang : listRestaurant) {
            if (nhaHang.getMaNhaHang() == maNhaHang) {
                return nhaHang.getTenNhaHang();
            }
        }
        return null;
    }
    
}
