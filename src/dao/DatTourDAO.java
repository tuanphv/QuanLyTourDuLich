package dao;

import database.DatabaseConnection;
import dto.DatTourDTO;
import enums.TrangThaiDatTour;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatTourDAO {
    
    /**
     * Retrieves all booking records from the database
     * @return ArrayList of all DatTour records
     */
    public ArrayList<DatTourDTO> getAllDatTour() {
        ArrayList<DatTourDTO> dsDatTour = new ArrayList<>();
        String query = "SELECT * FROM DatTour";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query); 
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Date ngayDat = rs.getDate("ngayDat");
                LocalDate ngayDatLocal = ngayDat != null ? ngayDat.toLocalDate() : null;
                
                dsDatTour.add(new DatTourDTO(
                    rs.getInt("maDat"),
                    rs.getInt("maKHTour"),
                    rs.getInt("maKH"),
                    ngayDatLocal,
                    rs.getInt("soLuong"),
                    rs.getFloat("tongTien"),
                    TrangThaiDatTour.fromValue(rs.getString("trangThai"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDatTour;
    }
    
    /**
     * Adds a new DatTour record to the database
     * @param datTour DatTour object to add
     * @return ID of the newly created record, or -1 if failed
     */
    public int addDatTour(DatTourDTO datTour) {
        String query = "INSERT INTO DatTour (maKHTour, maKH, ngayDat, soLuong, tongTien, trangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, datTour.getMaKHTour());
            pstmt.setInt(2, datTour.getMaKH());
            
            if (datTour.getNgayDat() != null) {
                pstmt.setDate(3, Date.valueOf(datTour.getNgayDat()));
            } else {
                pstmt.setNull(3, java.sql.Types.DATE);
            }
            
            pstmt.setInt(4, datTour.getSoLuong());
            pstmt.setFloat(5, datTour.getTongTien());
            pstmt.setString(6, datTour.getTrangThai().name());
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Return the auto-generated ID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if insertion fails
    }
    
    /**
     * Updates an existing DatTour record
     * @param datTour DatTour object with updated information
     * @return true if successful, false otherwise
     */
    public boolean updateDatTour(DatTourDTO datTour) {
        String query = "UPDATE DatTour SET maKHTour = ?, maKH = ?, ngayDat = ?, soLuong = ?, tongTien = ?, trangThai = ? WHERE maDat = ?";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, datTour.getMaKHTour());
            pstmt.setInt(2, datTour.getMaKH());
            
            if (datTour.getNgayDat() != null) {
                pstmt.setDate(3, Date.valueOf(datTour.getNgayDat()));
            } else {
                pstmt.setNull(3, java.sql.Types.DATE);
            }
            
            pstmt.setInt(4, datTour.getSoLuong());
            pstmt.setFloat(5, datTour.getTongTien());
            pstmt.setString(6, datTour.getTrangThai().name());
            pstmt.setInt(7, datTour.getMaDat());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Deletes a DatTour record by its ID
     * @param maDat ID of the record to delete
     * @return true if successful, false otherwise
     */
    public boolean deleteDatTour(int maDat) {
        String query = "DELETE FROM DatTour WHERE maDat = ?";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, maDat);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Gets a DatTour record by its ID
     * @param maDat ID of the record to retrieve
     * @return DatTourDTO object if found, null otherwise
     */
    public DatTourDTO getDatTourById(int maDat) {
        String query = "SELECT * FROM DatTour WHERE maDat = ?";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, maDat);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Date ngayDat = rs.getDate("ngayDat");
                    LocalDate ngayDatLocal = ngayDat != null ? ngayDat.toLocalDate() : null;
                    
                    return new DatTourDTO(
                        rs.getInt("maDat"),
                        rs.getInt("maKHTour"),
                        rs.getInt("maKH"),
                        ngayDatLocal,
                        rs.getInt("soLuong"),
                        rs.getFloat("tongTien"),
                        TrangThaiDatTour.valueOf(rs.getString("trangThai"))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Gets all DatTour records for a specific customer
     * @param maKH Customer ID
     * @return ArrayList of DatTourDTO objects for the customer
     */
    public ArrayList<DatTourDTO> getDatTourByKhachHang(int maKH) {
        ArrayList<DatTourDTO> dsDatTour = new ArrayList<>();
        String query = "SELECT * FROM DatTour WHERE maKH = ?";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, maKH);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Date ngayDat = rs.getDate("ngayDat");
                    LocalDate ngayDatLocal = ngayDat != null ? ngayDat.toLocalDate() : null;
                    
                    dsDatTour.add(new DatTourDTO(
                        rs.getInt("maDat"),
                        rs.getInt("maKHTour"),
                        rs.getInt("maKH"),
                        ngayDatLocal,
                        rs.getInt("soLuong"),
                        rs.getFloat("tongTien"),
                        TrangThaiDatTour.valueOf(rs.getString("trangThai"))
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDatTour;
    }
    
    /**
     * Gets all DatTour records for a specific tour plan
     * @param maKHTour Tour plan ID
     * @return ArrayList of DatTourDTO objects for the tour plan
     */
    public ArrayList<DatTourDTO> getDatTourByKeHoachTour(int maKHTour) {
        ArrayList<DatTourDTO> dsDatTour = new ArrayList<>();
        String query = "SELECT * FROM DatTour WHERE maKHTour = ?";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, maKHTour);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Date ngayDat = rs.getDate("ngayDat");
                    LocalDate ngayDatLocal = ngayDat != null ? ngayDat.toLocalDate() : null;
                    
                    dsDatTour.add(new DatTourDTO(
                        rs.getInt("maDat"),
                        rs.getInt("maKHTour"),
                        rs.getInt("maKH"),
                        ngayDatLocal,
                        rs.getInt("soLuong"),
                        rs.getFloat("tongTien"),
                        TrangThaiDatTour.valueOf(rs.getString("trangThai"))
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDatTour;
    }
}
