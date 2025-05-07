package bus;

import dao.ChiTietKeHoachTourDAO;
import dto.ChiTietKeHoachTourDTO;
import java.util.ArrayList;

public class ChiTietKeHoachTourBUS {
    ChiTietKeHoachTourDAO chiTietKeHoachTourDAO;
    ArrayList<ChiTietKeHoachTourDTO> listChiTietKeHoachTour;

    public ChiTietKeHoachTourBUS() {
        chiTietKeHoachTourDAO = new ChiTietKeHoachTourDAO();
        listChiTietKeHoachTour = chiTietKeHoachTourDAO.getAllChiTietKeHoachTour();
    }

    public int insert(ChiTietKeHoachTourDTO chiTietKeHoachTour) {
        int id = chiTietKeHoachTourDAO.insert(chiTietKeHoachTour);
        if (id != -1) listChiTietKeHoachTour.add(chiTietKeHoachTour);
        return id;
    }

    public boolean update(ChiTietKeHoachTourDTO chiTietKeHoachTour) {
        boolean check = chiTietKeHoachTourDAO.update(chiTietKeHoachTour);
        if (check) listChiTietKeHoachTour.set(getIndexById(chiTietKeHoachTour.getMaChiTietKeHoachTour()), chiTietKeHoachTour);
        return check;
    }

    public boolean delete(int maChiTietKeHoachTour) {
        boolean check = chiTietKeHoachTourDAO.delete(maChiTietKeHoachTour);
        if (check) listChiTietKeHoachTour.remove(getIndexById(maChiTietKeHoachTour));
        return check;
    }

    public ArrayList<ChiTietKeHoachTourDTO> getAllChiTietKeHoachTour() {
        return listChiTietKeHoachTour;
    }

    public int getIndexById(int maChiTietKeHoachTour) {
        for (int i = 0; i < listChiTietKeHoachTour.size(); i++) {
            if (listChiTietKeHoachTour.get(i).getMaChiTietKeHoachTour() == maChiTietKeHoachTour) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietKeHoachTourDTO getChiTietKeHoachTourById(int maChiTietKeHoachTour) {
        for (ChiTietKeHoachTourDTO chiTietKeHoachTour : listChiTietKeHoachTour) {
            if (chiTietKeHoachTour.getMaChiTietKeHoachTour() == maChiTietKeHoachTour) {
                return chiTietKeHoachTour;
            }
        }
        return null;
    }
    
    public ArrayList<ChiTietKeHoachTourDTO> getChiTietKeHoachTourByMaKeHoachTour(int maKeHoachTour) {
        ArrayList<ChiTietKeHoachTourDTO> result = new ArrayList<>();
        for (ChiTietKeHoachTourDTO chiTietKeHoachTour : listChiTietKeHoachTour) {
            if (chiTietKeHoachTour.getMaKeHoachTour() == maKeHoachTour) {
                result.add(chiTietKeHoachTour);
            }
        }
        return result;
    }
}
