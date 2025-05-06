package bus;

import dao.DatTourDAO;
import dto.DatTourDTO;
import enums.TrangThaiDatTour;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Business Logic class for managing Tour Booking operations
 */
public class DatTourBUS {
    
    private ArrayList<DatTourDTO> dsDatTour;
    private DatTourDAO dao;
    
    /**
     * Constructor initializes the data access object and loads data
     */
    public DatTourBUS() {
        dao = new DatTourDAO();
        dsDatTour = new ArrayList<>();
        loadData();
    }
    
    /**
     * Load all booking data from database
     */
    private void loadData() {
        dsDatTour = dao.getAllDatTour();
    }
    
    /**
     * Get all tour bookings
     * @return ArrayList of all tour bookings
     */
    public ArrayList<DatTourDTO> getAllDatTour() {
        return dsDatTour;
    }
    
    /**
     * Add a new tour booking
     * @param datTour The booking to add
     * @return ID of the newly created booking or -1 if failed
     */
    public int addDatTour(DatTourDTO datTour) {
        int id = dao.addDatTour(datTour);
        if (id != -1) {
            datTour.setMaDat(id);
            dsDatTour.add(datTour);
        }
        return id;
    }
    
    /**
     * Update an existing tour booking
     * @param datTour The booking with updated information
     * @return Index of the updated booking in the list or -1 if failed
     */
    public int updateDatTour(DatTourDTO datTour) {
        boolean success = dao.updateDatTour(datTour);
        if (success) {
            for (int i = 0; i < dsDatTour.size(); i++) {
                if (dsDatTour.get(i).getMaDat() == datTour.getMaDat()) {
                    dsDatTour.set(i, datTour);
                    return i;
                }
            }
        }
        return -1;
    }
    
    public boolean updateTrangThaiDatTour(DatTourDTO datTourDTO, TrangThaiDatTour trangThaiMoi) {
        return dao.updateTrangThaiDatTour(datTourDTO, trangThaiMoi);
    }
    
    /**
     * Delete a tour booking
     * @param maDat ID of the booking to delete
     * @return true if successful, false otherwise
     */
    public boolean deleteDatTour(int maDat) {
        boolean success = dao.deleteDatTour(maDat);
        if (success) {
            for (int i = 0; i < dsDatTour.size(); i++) {
                if (dsDatTour.get(i).getMaDat() == maDat) {
                    dsDatTour.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Get a tour booking by its ID
     * @param maDat ID of the booking to retrieve
     * @return DatTourDTO object or null if not found
     */
    public DatTourDTO getDatTourById(int maDat) {
        for (DatTourDTO datTour : dsDatTour) {
            if (datTour.getMaDat() == maDat) {
                return datTour;
            }
        }
        // If not found in memory, try to get from database
        return dao.getDatTourById(maDat);
    }
    
    /**
     * Get all tour bookings for a specific customer
     * @param maKH Customer ID
     * @return ArrayList of bookings made by the customer
     */
    public ArrayList<DatTourDTO> getDatTourByKhachHang(int maKH) {
        ArrayList<DatTourDTO> result = new ArrayList<>();
        for (DatTourDTO datTour : dsDatTour) {
            if (datTour.getMaKH() == maKH) {
                result.add(datTour);
            }
        }
        return result;
    }
    
    /**
     * Get all tour bookings for a specific tour plan
     * @param maKHTour Tour plan ID
     * @return ArrayList of bookings for the tour plan
     */
    public ArrayList<DatTourDTO> getDatTourByKeHoachTour(int maKHTour) {
        ArrayList<DatTourDTO> result = new ArrayList<>();
        for (DatTourDTO datTour : dsDatTour) {
            if (datTour.getMaKHTour() == maKHTour) {
                result.add(datTour);
            }
        }
        return result;
    }
    
    /**
     * Get all tour bookings by status
     * @param trangThai Status to search for
     * @return ArrayList of bookings with the specified status
     */
    public ArrayList<DatTourDTO> getDatTourByTrangThai(TrangThaiDatTour trangThai) {
        ArrayList<DatTourDTO> result = new ArrayList<>();
        for (DatTourDTO datTour : dsDatTour) {
            if (datTour.getTrangThai() == trangThai) {
                result.add(datTour);
            }
        }
        return result;
    }
    
    /**
     * Get all tour bookings for a specific date
     * @param ngayDat Booking date to search for
     * @return ArrayList of bookings made on the specified date
     */
    public ArrayList<DatTourDTO> getDatTourByNgayDat(LocalDate ngayDat) {
        ArrayList<DatTourDTO> result = new ArrayList<>();
        for (DatTourDTO datTour : dsDatTour) {
            if (datTour.getNgayDat() != null && datTour.getNgayDat().equals(ngayDat)) {
                result.add(datTour);
            }
        }
        return result;
    }
    
    /**
     * Get tour bookings within a date range
     * @param tuNgay Start date (inclusive)
     * @param denNgay End date (inclusive)
     * @return ArrayList of bookings within the date range
     */
    public ArrayList<DatTourDTO> getDatTourByDateRange(LocalDate tuNgay, LocalDate denNgay) {
        ArrayList<DatTourDTO> result = new ArrayList<>();
        for (DatTourDTO datTour : dsDatTour) {
            LocalDate ngayDat = datTour.getNgayDat();
            if (ngayDat != null && 
                (ngayDat.isEqual(tuNgay) || ngayDat.isAfter(tuNgay)) && 
                (ngayDat.isEqual(denNgay) || ngayDat.isBefore(denNgay))) {
                result.add(datTour);
            }
        }
        return result;
    }
    
    /**
     * Get all bookings with a minimum quantity of tickets
     * @param soLuongMin Minimum number of tickets
     * @return ArrayList of bookings with at least the specified number of tickets
     */
    public ArrayList<DatTourDTO> getDatTourBySoLuong(int soLuongMin) {
        ArrayList<DatTourDTO> result = new ArrayList<>();
        for (DatTourDTO datTour : dsDatTour) {
            if (datTour.getSoLuong() >= soLuongMin) {
                result.add(datTour);
            }
        }
        return result;
    }
    
    /**
     * Refresh data from the database
     */
    public void refreshData() {
        dsDatTour = dao.getAllDatTour();
    }
}
