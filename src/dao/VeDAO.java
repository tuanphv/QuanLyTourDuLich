package dao;

import config.DatabaseConnection;
import dto.VeDTO;
import enums.TrangThaiVe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VeDAO {

    public ArrayList<VeDTO> getAllVe() {
        ArrayList<VeDTO> dsVe = new ArrayList<>();
        String query = "SELECT * FROM Ve";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                dsVe.add(new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("maDat"),
                        rs.getInt("soThuTu"),
                        rs.getInt("maKHTour"),
                        rs.getString("hoTen"),
                        rs.getDate("ngayKhoiHanh").toLocalDate(),
                        rs.getDate("ngayCap").toLocalDate(),
                        rs.getFloat("giaVe"),
                        TrangThaiVe.fromValue(rs.getString("trangThai"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }

    public int addVe(VeDTO ve) {
        String query = "INSERT INTO Ve (maDat, soThuTu, maKHTour, hoTen, ngayKhoiHanh, ngayCap, giaVe, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, ve.getMaDat());
            pstmt.setInt(2, ve.getSoThuTu());
            pstmt.setInt(3, ve.getMaKHTour());
            pstmt.setString(4, ve.getHoTen());
            pstmt.setDate(5, Date.valueOf(ve.getNgayKhoiHanh()));
            pstmt.setDate(6, Date.valueOf(ve.getNgayCap()));
            pstmt.setFloat(7, ve.getGiaVe());
            pstmt.setString(8, ve.getTrangThai().getValue());

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
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maVe);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateVe(VeDTO ve) {
        String query = "UPDATE Ve SET maDat = ?, soThuTu = ?, maKHTour = ?, hoTen = ?, ngayKhoiHanh = ?, ngayCap = ?, giaVe = ?, trangThai = ? WHERE maVe = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ve.getMaDat());
            pstmt.setInt(2, ve.getSoThuTu());
            pstmt.setInt(3, ve.getMaKHTour());
            pstmt.setString(4, ve.getHoTen());
            pstmt.setDate(5, Date.valueOf(ve.getNgayKhoiHanh()));
            pstmt.setDate(6, Date.valueOf(ve.getNgayCap()));
            pstmt.setFloat(7, ve.getGiaVe());
            pstmt.setString(8, ve.getTrangThai().getValue());
            pstmt.setInt(9, ve.getMaVe());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public VeDTO getVeByMa(int ma) {
        String query = "SELECT * FROM Ve WHERE maVe = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ma);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("maDat"),
                        rs.getInt("soThuTu"),
                        rs.getInt("maKHTour"),
                        rs.getString("hoTen"),
                        rs.getDate("ngayKhoiHanh").toLocalDate(),
                        rs.getDate("ngayCap").toLocalDate(),
                        rs.getFloat("giaVe"),
                        TrangThaiVe.fromValue(rs.getString("trangThai")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<VeDTO> getVeByMaDat(int maDat) {
        ArrayList<VeDTO> dsVe = new ArrayList<>();
        String query = "SELECT * FROM Ve WHERE maDat = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, maDat);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dsVe.add(new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("maDat"),
                        rs.getInt("soThuTu"),
                        rs.getInt("maKHTour"),
                        rs.getString("hoTen"),
                        rs.getDate("ngayKhoiHanh").toLocalDate(),
                        rs.getDate("ngayCap").toLocalDate(),
                        rs.getFloat("giaVe"),
                        TrangThaiVe.fromValue(rs.getString("trangThai"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }

    public ArrayList<VeDTO> getVeByMaKHTour(int maKHTour) {
        ArrayList<VeDTO> dsVe = new ArrayList<>();
        String query = "SELECT * FROM Ve WHERE maKHTour = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, maKHTour);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dsVe.add(new VeDTO(
                        rs.getInt("maVe"),
                        rs.getInt("maDat"),
                        rs.getInt("soThuTu"),
                        rs.getInt("maKHTour"),
                        rs.getString("hoTen"),
                        rs.getDate("ngayKhoiHanh").toLocalDate(),
                        rs.getDate("ngayCap").toLocalDate(),
                        rs.getFloat("giaVe"),
                        TrangThaiVe.fromValue(rs.getString("trangThai"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }
}
