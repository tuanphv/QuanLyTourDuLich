package persistence.dao;

import business.model.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistence.database.DatabaseConnection;

public class KhachHangDAO {

    public ArrayList<KhachHangDTO> getAllKhachHang() {
        ArrayList<KhachHangDTO> customers = new ArrayList<>();
        String query = "SELECT * FROM khachhang";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                customers.add(new KhachHangDTO(
                        rs.getInt("maKH"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("ho"),
                        rs.getString("ten"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("soDT"),
                        rs.getString("email"),
                        rs.getString("ngayDK"),
                        rs.getString("CC_HC"),
                        rs.getString("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return customers;
    }



    public void addKhachHang(KhachHangDTO c) {
        StringBuilder query = new StringBuilder(
                "INSERT INTO khachhang (maKH, username, password, ho, ten, ngaySinh, gioiTinh, soDT, email, ngayDK, CC_HC,trangThai");
        query.append("\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            pstmt.setInt(1, c.getMaKH());
            pstmt.setString(2, c.getUsername());
            pstmt.setString(3, c.getPassword());
            pstmt.setString(4, c.getHo());
            pstmt.setString(5, c.getTen());
            pstmt.setString(6, c.getNgaySinh());
            pstmt.setString(7, c.getGioiTinh());
            pstmt.setString(8, c.getSoDT());
            pstmt.setString(9, c.getEmail());
            pstmt.setString(10, c.getCC_HC());
            pstmt.setString(11, c.getNgayDK());
            pstmt.setString(12, c.getTrangThai());
            pstmt.executeUpdate();
            System.out.println("Thêm dữ liệu người dùng thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateKhachHang(KhachHangDTO c) {
        StringBuilder query = new StringBuilder(
                "UPDATE customer SET username = ?, password = ?, ho = ?, ten = ?, ngaySinh = ?, gioiTinh = ?, soDT = ?, email = ?, ngayDK = ?, CC_HC = ?, ngayDK = ?, trangThai = ? WHERE maKH = ?)");
        query.append("\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            pstmt.setString(3, c.getHo());
            pstmt.setString(4, c.getTen());
            pstmt.setString(5, c.getNgaySinh());
            pstmt.setString(6, c.getGioiTinh());
            pstmt.setString(7, c.getSoDT());
            pstmt.setString(8, c.getEmail());
            pstmt.setString(8, c.getCC_HC());
            pstmt.setString(9, c.getNgayDK());
            pstmt.setString(10, c.getTrangThai());
            pstmt.setInt(11, c.getMaKH());

            int rowUpdated = pstmt.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Cập nhật dữ liệu người dùng thành công!");
            } else {
                System.out.println("Cập nhật dữ liệu người dùng thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public void deleteKhachHang(int maKH) {
        String query = "DELETE FROM customer WHERE maKH = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maKH);
            int rowDeleted = pstmt.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Xoá khách hàng thành công!");
            } else {
                System.out.println("Không tìm thấy khách hàng!");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        new KhachHangDAO().getAllKhachHang();
    }
}
