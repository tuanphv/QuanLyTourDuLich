package business.service;

import java.util.ArrayList;

import business.model.PhuongTienDTO;
import persistence.dao.PhuongTienDAO;

public class PhuongTienBUS {
    PhuongTienDAO phuongTienDAO;
    ArrayList<PhuongTienDTO> listVehicle;

    public PhuongTienBUS() {
        phuongTienDAO = new PhuongTienDAO();
        listVehicle = phuongTienDAO.getAllVehicle();
    }

    public boolean insert(PhuongTienDTO phuongTien) {
        boolean check = phuongTienDAO.insert(phuongTien);
        if (check) listVehicle.add(phuongTien);
        return check;
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
