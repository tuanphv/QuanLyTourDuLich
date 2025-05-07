package bus;

import dao.DiaDiemThamQuanDAO;
import dto.DiaDiemThamQuanDTO;
import java.util.ArrayList;

public class DiaDiemThamQuanBUS {
    DiaDiemThamQuanDAO diaDiemThamQuanDAO;
    ArrayList<DiaDiemThamQuanDTO> listDiaDiemThamQuan;

    public DiaDiemThamQuanBUS() {
        diaDiemThamQuanDAO = new DiaDiemThamQuanDAO();
        listDiaDiemThamQuan = diaDiemThamQuanDAO.getAllDiaDiemThamQuan();
    }

    public int insert(DiaDiemThamQuanDTO diaDiemThamQuan) {
        int id = diaDiemThamQuanDAO.insert(diaDiemThamQuan);
        if (id != -1) listDiaDiemThamQuan.add(diaDiemThamQuan);
        return id;
    }

    public boolean update(DiaDiemThamQuanDTO diaDiemThamQuan) {
        boolean check = diaDiemThamQuanDAO.update(diaDiemThamQuan);
        if (check) listDiaDiemThamQuan.set(getIndexById(diaDiemThamQuan.getMaDiaDiemThamQuan()), diaDiemThamQuan);
        return check;
    }

    public boolean  delete(int maDiaDiemThamQuan) {
        boolean check = diaDiemThamQuanDAO.delete(maDiaDiemThamQuan);
        if (check) listDiaDiemThamQuan.remove(getIndexById(maDiaDiemThamQuan));
        return check;
    }

    public ArrayList<DiaDiemThamQuanDTO> getAllDiaDiemThamQuan() {
        return listDiaDiemThamQuan;
    }

    public int getIndexById(int maDiaDiemThamQuan) {
        for (int i = 0; i < listDiaDiemThamQuan.size(); i++) {
            if (listDiaDiemThamQuan.get(i).getMaDiaDiemThamQuan() == maDiaDiemThamQuan) {
                return i;
            }
        }
        return -1;
    }

    public DiaDiemThamQuanDTO getDiaDiemThamQuanById(int maDiaDiemThamQuan) {
        for (DiaDiemThamQuanDTO diaDiemThamQuan : listDiaDiemThamQuan) {
            if (diaDiemThamQuan.getMaDiaDiemThamQuan() == maDiaDiemThamQuan) {
                return diaDiemThamQuan;
            }
        }
        return null;
    }
    
}
