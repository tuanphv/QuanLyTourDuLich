package bus;

import dao.VeDAO;
import dto.VeDTO;
import java.util.ArrayList;

/**
 * Business Logic class for managing Ve (Ticket) operations
 */
public class VeBUS {
    
    private VeDAO veDAO;
    private ArrayList<VeDTO> dsVe;
    
    /**
     * Constructor initializes VeDAO and loads data
     */
    public VeBUS() {
        veDAO = new VeDAO();
        dsVe = veDAO.getAllVe();
    }
    
    /**
     * Get all Ve records
     * @return ArrayList of all Ve records
     */
    public ArrayList<VeDTO> getAllVe() {
        return dsVe;
    }
    
    /**
     * Add a new Ve record
     * @param ve The Ve to add
     * @return The ID of the new Ve or -1 if failed
     */
    public int addVe(VeDTO ve) {
        int id = veDAO.addVe(ve);
        if (id != -1) {
            ve.setMaVe(id);
            dsVe.add(ve);
        }
        return id;
    }
    
    /**
     * Update a Ve record
     * @param ve The Ve with updated information
     * @return Index of the updated Ve in the list or -1 if failed
     */
    public int updateVe(VeDTO ve) {
        if (veDAO.updateVe(ve)) {
            for (int i = 0; i < dsVe.size(); i++) {
                if (dsVe.get(i).getMaVe() == ve.getMaVe()) {
                    dsVe.set(i, ve);
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * Delete a Ve record
     * @param maVe ID of the Ve to delete
     * @return true if successful, false otherwise
     */
    public boolean deleteVe(int maVe) {
        if (veDAO.deleteVe(maVe)) {
            for (int i = 0; i < dsVe.size(); i++) {
                if (dsVe.get(i).getMaVe() == maVe) {
                    dsVe.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Get a Ve by its ID
     * @param maVe ID of the Ve to retrieve
     * @return VeDTO object or null if not found
     */
    public VeDTO getVeById(int maVe) {
        for (VeDTO ve : dsVe) {
            if (ve.getMaVe() == maVe) {
                return ve;
            }
        }
        return veDAO.getVeByMa(maVe);
    }
    
    /**
     * Get list of Ve by MaKHTour
     * @param maKHTour ID of the KeHoachTour
     * @return ArrayList of Ve related to the specified KeHoachTour
     */
    public ArrayList<VeDTO> getVeByMaKHTour(int maKHTour) {
        ArrayList<VeDTO> result = new ArrayList<>();
        for (VeDTO ve : dsVe) {
            if (ve.getMaKHTour() == maKHTour) {
                result.add(ve);
            }
        }
        return result;
    }
    
    /**
     * Get list of Ve by MaHoaDon
     * @param maHoaDon ID of the HoaDon
     * @return ArrayList of Ve related to the specified HoaDon
     */
    public ArrayList<VeDTO> getVeByMaHoaDon(int maHoaDon) {
        return veDAO.getVeByMaHoaDon(maHoaDon);
    }
    
    /**
     * Search for Ve by price range
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @return ArrayList of Ve within the specified price range
     */
    public ArrayList<VeDTO> searchVeByPriceRange(float minPrice, float maxPrice) {
        ArrayList<VeDTO> result = new ArrayList<>();
        for (VeDTO ve : dsVe) {
            if (ve.getGiaVe() >= minPrice && ve.getGiaVe() <= maxPrice) {
                result.add(ve);
            }
        }
        return result;
    }
    
    /**
     * Search for Ve by type
     * @param loaiVe Type of Ve to search for
     * @return ArrayList of Ve with the specified type
     */
    public ArrayList<VeDTO> searchVeByType(int loaiVe) {
        ArrayList<VeDTO> result = new ArrayList<>();
        for (VeDTO ve : dsVe) {
            if (ve.getLoaiVe() == loaiVe) {
                result.add(ve);
            }
        }
        return result;
    }
    
    /**
     * Reload data from database
     */
    public void refreshData() {
        dsVe = veDAO.getAllVe();
    }
}
