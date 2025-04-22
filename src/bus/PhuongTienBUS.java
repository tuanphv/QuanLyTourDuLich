package bus;

import java.util.ArrayList;

import dto.PhuongTienDTO;
import dao.PhuongTienDAO;

public class PhuongTienBUS {
    PhuongTienDAO phuongTienDAO;
    ArrayList<PhuongTienDTO> listVehicle;

    public PhuongTienBUS() {
        phuongTienDAO = new PhuongTienDAO();
        listVehicle = phuongTienDAO.getAllVehicle();
    }

    public int insert(PhuongTienDTO phuongTien) {
        int index = phuongTienDAO.insert(phuongTien);
        if (index != -1) listVehicle.add(phuongTien);
        return index;
    }

    public boolean update(PhuongTienDTO phuongTien) {
        boolean check = phuongTienDAO.update(phuongTien);
        if (check) listVehicle.set(getIndexById(phuongTien.getMaPhuongTien()), phuongTien);
        return check;
    }

    public boolean delete(int maPhuongTien) {
        boolean check = phuongTienDAO.delete(maPhuongTien);
        if (check) listVehicle.remove(getIndexById(maPhuongTien));
        return check;
    }

    public ArrayList<PhuongTienDTO> getListVehicle() {
        return listVehicle;
    }

    public int getIndexById(int maPhuongTien) {
        for (int i = 0; i < listVehicle.size(); i++) {
            if (listVehicle.get(i).getMaPhuongTien() == maPhuongTien) {
                return i;
            }
        }
        return -1;
    }

    public PhuongTienDTO getVehicleById(int maPhuongTien) {
        for (PhuongTienDTO phuongTien : listVehicle) {
            if (phuongTien.getMaPhuongTien() == maPhuongTien) {
                return phuongTien;
            }
        }
        return null;
    }
}
