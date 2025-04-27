package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DatabaseConnection;
import dto.HoaDonDTO;

public class HoaDonDAO {
    public ArrayList<HoaDonDTO> getAllHoaDon() {
        ArrayList<HoaDonDTO> dsHoaDon = new ArrayList<>();
        String query = "SELECT * FROM hoadon";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                dsHoaDon.add(new HoaDonDTO(
                        rs.getInt("maHoaDon"),
                        rs.getInt("maKH"),
                        rs.getInt("maKHTour"),
                        rs.getInt("soVe"),
                        rs.getInt("maNV"),
                        rs.getFloat("tongTien"),
                        rs.getString("ghiChu"),
                        rs.getInt("maKhuyenMai"),
                        rs.getTimestamp("ngayLapPhieu").toLocalDateTime(),
                        rs.getInt("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public int addHoaDon(HoaDonDTO hoaDon) {
        String query = "INSERT INTO hoadon (maKH, maKHTour, soVe, maNV, tongTien, ghiChu, maKhuyenMai, ngayLapPhieu, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, hoaDon.getMaKH());
            pstmt.setInt(2, hoaDon.getMaKHTour());
            pstmt.setInt(3, hoaDon.getSoVe());
            pstmt.setInt(4, hoaDon.getMaNV());
            pstmt.setFloat(5, hoaDon.getTongTien());
            pstmt.setString(6, hoaDon.getGhiChu());
            pstmt.setInt(7, hoaDon.getMaKhuyenMai());
            pstmt.setTimestamp(8, java.sql.Timestamp.valueOf(hoaDon.getNgayLapPhieu()));
            pstmt.setInt(9, hoaDon.getTrangThai());

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
    public boolean updateHoaDon(HoaDonDTO hoaDon) {
        String query = "UPDATE hoadon SET maKH = ?, maKHTour = ?, soVe = ?, maNV = ?, tongTien = ?, ghiChu = ?, maKhuyenMai = ?, ngayLapPhieu = ?, trangThai = ? WHERE maHoaDon = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, hoaDon.getMaKH());
            pstmt.setInt(2, hoaDon.getMaKHTour());
            pstmt.setInt(3, hoaDon.getSoVe());
            pstmt.setInt(4, hoaDon.getMaNV());
            pstmt.setFloat(5, hoaDon.getTongTien());
            pstmt.setString(6, hoaDon.getGhiChu());
            pstmt.setInt(7, hoaDon.getMaKhuyenMai());
            pstmt.setTimestamp(8, java.sql.Timestamp.valueOf(hoaDon.getNgayLapPhieu()));
            pstmt.setInt(9, hoaDon.getTrangThai());
            pstmt.setInt(10, hoaDon.getMaHoaDon());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteHoaDon(int maHoaDon) {
        String query = "UPDATE hoadon SET trangThai = 0 WHERE maHoaDon = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maHoaDon);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
