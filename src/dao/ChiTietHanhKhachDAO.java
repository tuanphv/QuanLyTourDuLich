package dao;

import database.DatabaseConnection;
import dto.ChiTietHanhKhachDTO;
import enums.LoaiHanhKhach;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChiTietHanhKhachDAO {

    public ArrayList<ChiTietHanhKhachDTO> getAllCTietHKhach() {
        ArrayList<ChiTietHanhKhachDTO> ds = new ArrayList<>();
        String query = "SELECT * FROM ChiTietHanhKhach";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ds.add(new ChiTietHanhKhachDTO(
                        rs.getInt("maDat"),
                        rs.getInt("soThuTu"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh").toLocalDate(),
                        LoaiHanhKhach.fromValue(rs.getString("loaiHanhKhach")),
                        rs.getString("soGiayTo"),
                        rs.getBoolean("laNguoiDat")
                ));
            }
        } catch (SQLException e) {
        }
        return ds;
    }

    public boolean addCTietHKhach(ChiTietHanhKhachDTO chiTiet) {
        String query = "INSERT INTO ChiTietHanhKhach (maDat, soThuTu, hoTen, ngaySinh, loaiHanhKhach, soGiayTo, laNguoiDat) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, chiTiet.getMaDat());
            pstmt.setInt(2, chiTiet.getSoThuTu());
            pstmt.setString(3, chiTiet.getHoTen());
            pstmt.setDate(4, Date.valueOf(chiTiet.getNgaySinh()));
            pstmt.setString(5, chiTiet.getLoaiHanhKhach().getValue());
            pstmt.setString(6, chiTiet.getSoGiayTo());
            pstmt.setBoolean(7, chiTiet.isLaNguoiDat());

            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        new ChiTietHanhKhachDAO().getAllCTietHKhach().forEach(e -> System.out.println(e));
    }
}
