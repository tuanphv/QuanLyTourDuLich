package bus;

import dao.KeHoachTourDAO;
import dto.KeHoachTourDTO;
import java.util.ArrayList;

public class KeHoachTourBUS {

    private static ArrayList<KeHoachTourDTO> dsKHTour;

    public KeHoachTourBUS() {
        dsKHTour = new ArrayList<>();
        loadData(); // Tải dữ liệu ban đầu
    }

    public void loadData() {
        KeHoachTourDAO dao = new KeHoachTourDAO();
        dsKHTour = dao.getAllKeHoachTour();
    }

    public ArrayList<KeHoachTourDTO> getDSKHTour() {
        return dsKHTour;
    }

    public int addKeHoachTour(KeHoachTourDTO khTour) {
        KeHoachTourDAO dao = new KeHoachTourDAO();
        int id = dao.addKeHoachTour(khTour);
        if (id != -1) {
            khTour.setMaKHTour(id);
            dsKHTour.add(khTour);
        }
        return id;
    }

    public int updateKeHoachTour(KeHoachTourDTO khTour) {
        KeHoachTourDAO dao = new KeHoachTourDAO();
        boolean success = dao.updateKeHoachTour(khTour);
        if (success) {
            for (int i = 0; i < dsKHTour.size(); i++) {
                if (dsKHTour.get(i).getMaKHTour() == khTour.getMaKHTour()) {
                    dsKHTour.set(i, khTour);
                    return i;
                }
            }
        }
        return -1; // Không tìm thấy
    }

    public boolean deleteKeHoachTour(int maKHTour) {
        KeHoachTourDAO dao = new KeHoachTourDAO();
        boolean success = dao.deleteKeHoachTour(maKHTour);
        if (success) {
            for (int i = 0; i < dsKHTour.size(); i++) {
                if (dsKHTour.get(i).getMaKHTour() == maKHTour) {
                    dsKHTour.remove(i);
                    break;
                }
            }
        }
        return success;
    }

    public KeHoachTourDTO getKeHoachTourById(int maKHTour) {
        for (KeHoachTourDTO khTour : dsKHTour) {
            if (khTour.getMaKHTour() == maKHTour) {
                return khTour;
            }
        }
        return null; // Không tìm thấy
    }

    public ArrayList<KeHoachTourDTO> getKeHoachTourByMaTour(int maTour) {
        ArrayList<KeHoachTourDTO> result = new ArrayList<>();
        for (KeHoachTourDTO khTour : dsKHTour) {
            if (khTour.getMaTour() == maTour) {
                result.add(khTour);
            }
        }
        return result;
    }
    
    public ArrayList<KeHoachTourDTO> getKeHoachTourBySLToiDa(int sl) {
        ArrayList<KeHoachTourDTO> result = new ArrayList<>();
        for (KeHoachTourDTO khTour : dsKHTour) {
            if (khTour.getSlToiDa() == sl) {
                result.add(khTour);
            }
        }
        return result;
    }
    
    public ArrayList<KeHoachTourDTO> getKeHoachTourByMaTour(String maTour) {
        try {
            int ma = Integer.parseInt(maTour.trim());
            return getKeHoachTourByMaTour(ma);
        } catch (NumberFormatException e) {
            return null;
        }  
    }
    
    public ArrayList<KeHoachTourDTO> getKeHoachTourBySLToiDa(String soLuong) {
        try {
            int sl = Integer.parseInt(soLuong.trim());
            return getKeHoachTourBySLToiDa(sl);
        } catch (NumberFormatException e) {
            return null;
        }  
    }

    public ArrayList<KeHoachTourDTO> getKeHoachTourByNameTour(String nameTour) {
        ArrayList<KeHoachTourDTO> listKeHoachTour = new ArrayList<>();
        TourBUS tourBus = new TourBUS();
        for (KeHoachTourDTO keHoachTour : dsKHTour) {
            if (tourBus.getTourById(keHoachTour.getMaTour()).getTenTour().toLowerCase().contains(nameTour.toLowerCase())) {
                listKeHoachTour.add(keHoachTour);
            }
        }
        return listKeHoachTour;
    }

    public int getMaTourByMaKHTour(int maKHTour) {
        for (KeHoachTourDTO khTour : dsKHTour) {
            if (khTour.getMaKHTour() == maKHTour) {
                return khTour.getMaTour();
            }
        }
        return -1; // Không tìm thấy
    }
    
    public KeHoachTourDTO getKeHoachTourByID(int maKHTour) {
        for (KeHoachTourDTO khTourDTO: dsKHTour) {
            if (khTourDTO.getMaKHTour() == maKHTour) 
                return khTourDTO;
        }
        return null;
    }

    
}

