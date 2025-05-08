package dao;

import config.DatabaseConnection;
import dto.HoaDonDTO;
import enums.TrangThaiHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class HoaDonDAO {

    public ArrayList<HoaDonDTO> getAllHoaDon() {
        ArrayList<HoaDonDTO> dsHoaDon = new ArrayList<>();
        String query = "SELECT * FROM hoadon WHERE trangThai != 'Huy'";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                dsHoaDon.add(new HoaDonDTO(
                        rs.getInt("maHD"),
                        rs.getInt("maDat"),
                        rs.getInt("maNV"),
                        rs.getTimestamp("ngayLap").toLocalDateTime(),
                        rs.getFloat("tongTien"),
                        rs.getString("hinhThucThanhToan"),
                        TrangThaiHoaDon.fromValue(rs.getString("trangThai"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public int addHoaDon(HoaDonDTO hoaDon) {
        String query = "INSERT INTO hoadon (maDat, maNV, ngayLap, tongTien, hinhThucThanhToan, trangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, hoaDon.getMaDat());
            pstmt.setInt(2, hoaDon.getMaNV());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(hoaDon.getNgayLap()));
            pstmt.setFloat(4, hoaDon.getTongTien());
            pstmt.setString(5, hoaDon.getHinhThucThanhToan());
            pstmt.setString(6, hoaDon.getTrangThai().getValue());

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
            pstmt.setInt(1, hoaDon.getMaDat());
            pstmt.setInt(2, hoaDon.getMaNV());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(hoaDon.getNgayLap()));
            pstmt.setFloat(4, hoaDon.getTongTien());
            pstmt.setString(5, hoaDon.getHinhThucThanhToan());
            pstmt.setString(6, hoaDon.getTrangThai().getValue());
            pstmt.setInt(7, hoaDon.getMaHoaDon());
            System.out.println(hoaDon);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteHoaDon(int maHoaDon) {
        String query = "UPDATE hoadon SET trangThai = 'Huy' WHERE maHD = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maHoaDon);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
