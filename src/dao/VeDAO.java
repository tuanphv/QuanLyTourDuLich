package dao;

import database.DatabaseConnection;
import dto.VeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class VeDAO {

    public ArrayList<VeDTO> getAllVe() {
        ArrayList<VeDTO> dsVe = new ArrayList<>();
        String query = "SELECT * FROM Ve";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                dsVe.add(new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("loaiVe"),
                        rs.getInt("maKHTour"),
                        rs.getFloat("giaVe")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }

    public int addVe(VeDTO ve) {
        String query = "INSERT INTO Ve (loaiVe, maKHTour, giaVe) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, ve.getLoaiVe());
            pstmt.setInt(2, ve.getMaKHTour());
            pstmt.setFloat(3, ve.getGiaVe());

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
        return -1; // Trả về -1 nếu thất bại
    }

    public boolean deleteVe(int maVe) {
        String query = "DELETE FROM Ve WHERE maVe = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, maVe);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateVe(VeDTO ve) {
        String query = "UPDATE Ve SET maHoaDon = ?, maKHTour = ?, ghiChu = ?, giaTien = ? WHERE maVe = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ve.getLoaiVe());
            pstmt.setInt(2, ve.getMaKHTour());
            pstmt.setFloat(3, ve.getGiaVe());
            pstmt.setInt(4, ve.getMaVe());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public VeDTO getVeByMa(int ma) {
        String query = "SELECT * FROM Ve WHERE maVe = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ma);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("loaiVe"),
                        rs.getInt("maKHTour"),
                        rs.getFloat("giaVe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<VeDTO> getVeByMaHoaDon(int maHoaDon) {
        ArrayList<VeDTO> dsVe = new ArrayList<>();
        String query = "SELECT * FROM Ve WHERE maHoaDon = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, maHoaDon);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dsVe.add(new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("loaiVe"),
                        rs.getInt("maKHTour"),
                        rs.getFloat("giaVe")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }

    public ArrayList<VeDTO> getVeByMaKHTour(int maKHTour) {
        ArrayList<VeDTO> dsVe = new ArrayList<>();
        String query = "SELECT * FROM Ve WHERE maKHTour = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, maKHTour);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dsVe.add(new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("loaiVe"),
                        rs.getInt("maKHTour"),
                        rs.getFloat("giaVe")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }
}
