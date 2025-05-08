package bus;

import dao.DiaDanhDAO;
import dto.DiaDanhDTO;
import java.util.ArrayList;
import java.util.Iterator;

public class DiaDanhBUS {

    private static ArrayList<DiaDanhDTO> dsDiaDanh;

    public DiaDanhBUS() {
        dsDiaDanh = new ArrayList<>();
        loadData(); // Tải dữ liệu ban đầu
    }

    // Hàm loadData: lấy danh sách từ DAO
    private void loadData() {
        DiaDanhDAO dao = new DiaDanhDAO();
        dsDiaDanh = dao.getAllDiaDanh();
    }

    // Thêm địa danh
    public int addDiaDanh(DiaDanhDTO diaDanh) {
        if ("".equals(diaDanh.getTenDD()) || "".equals(diaDanh.getTinhThanh()) || "".equals(diaDanh.getDiemNoiBat()))
            return -1;
        DiaDanhDAO dao = new DiaDanhDAO();
        int index = dao.addDiaDanh(diaDanh);
        if (index != -1) {
            dsDiaDanh.add(diaDanh);
        }
        return index;
    }

    // Sửa địa danh
    public int updateDiaDanh(DiaDanhDTO diaDanh) {
        DiaDanhDAO dao = new DiaDanhDAO();
        boolean success = dao.updateDiaDanh(diaDanh);
        if (success) {
            for (int i = 0; i < dsDiaDanh.size(); i++) {
                if (dsDiaDanh.get(i).getMaDD() == diaDanh.getMaDD()) {
                    dsDiaDanh.set(i, diaDanh);
                    return i;
                }
            }
        }
        return -1;
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

    public int findIndexByMa(int maDD) {
        for (int i = 0; i < dsDiaDanh.size(); i++) {
            if (dsDiaDanh.get(i).getMaDD() == maDD) {
                return i;
            }
        }
        return -1;
    }
    
    public DiaDanhDTO getDiaDanhByMa(int maDD) {
        for (DiaDanhDTO dd : dsDiaDanh) {
            if (dd.getMaDD() == maDD) {
                return dd;
            }
        }
        return null;
    }
    // Getter danh sách địa danh
    public ArrayList<DiaDanhDTO> getDsDiaDanh() {
        return dsDiaDanh;
    }

    public int getIdByName(String name) {
        for (DiaDanhDTO diaDanh : dsDiaDanh) {
            if (diaDanh.getTenDD().equals(name)) {
                return diaDanh.getMaDD();
            }
        }
        return -1;
    }
    
    public String getNameById(int id) {
        for (DiaDanhDTO diaDanh : dsDiaDanh) {
            if (diaDanh.getMaDD() == id) {
                return diaDanh.getTenDD();
            }
        }
        return null;
    }

}
