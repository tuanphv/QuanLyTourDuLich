package dao;

import dto.TourDTO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DatabaseConnection;
import enums.TinhTrangTour;

public class TourDAO {

    public ArrayList<TourDTO> getAllTours() {
        ArrayList<TourDTO> tours = new ArrayList<>();
        String query = "SELECT * FROM tour";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                tours.add(new TourDTO(
                        rs.getInt("maTour"),
                        rs.getString("tenTour"),
                        rs.getFloat("gia"),
                        TinhTrangTour.valueOf(rs.getString("tinhTrang")),
                        rs.getString("moTa"),
                        rs.getString("diemKhoiHanh"),
                        rs.getString("diemDen"),
                        rs.getString("loaiTour"),
                        rs.getInt("soNgay"),
                        rs.getInt("soDem")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    public int addTour(TourDTO tour) {
        String query = "INSERT INTO tour (tenTour, gia, tinhTrang, moTa, diemKhoiHanh, diemDen, loaiTour, soNgay, soDem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, tour.getTenTour());
            pstmt.setFloat(2, tour.getGia());
            pstmt.setString(3, tour.getTinhTrang().name());
            pstmt.setString(4, tour.getMoTa());
            pstmt.setString(5, tour.getDiemKhoiHanh());
            pstmt.setString(6, tour.getDiemDen());
            pstmt.setString(7, tour.getLoaiTour());
            pstmt.setInt(8, tour.getSoNgay());
            pstmt.setInt(9, tour.getSoDem());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Trả về ID vừa được sinh ra
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean deleteTour(int maTour) {
        String query = "DELETE FROM tour WHERE maTour = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maTour);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTour(TourDTO tour) {
        String query = "UPDATE tour SET tenTour = ?, gia = ?, tinhTrang = ?, moTa = ?, diemKhoiHanh = ?, diemDen = ?, loaiTour = ?, soNgay = ?, soDem = ? WHERE maTour = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tour.getTenTour());
            pstmt.setFloat(2, tour.getGia());
            pstmt.setString(3, tour.getTinhTrang().name());
            pstmt.setString(4, tour.getMoTa());
            pstmt.setString(5, tour.getDiemKhoiHanh());
            pstmt.setString(6, tour.getDiemDen());
            pstmt.setString(7, tour.getLoaiTour());
            pstmt.setInt(8, tour.getSoNgay());
            pstmt.setInt(9, tour.getSoDem());
            pstmt.setInt(10, tour.getMaTour());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        new TourDAO().getAllTours();
    }

}
