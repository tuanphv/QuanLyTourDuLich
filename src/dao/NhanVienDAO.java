/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.NhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DatabaseConnection;

public class NhanVienDAO {

    public ArrayList<NhanVienDTO> getAllNhanVien() {
        ArrayList<NhanVienDTO> employees = new ArrayList<>();
        String query = "SELECT * FROM nhanvien";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                employees.add(new NhanVienDTO(
                    rs.getInt("maNV"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("ho"),
                    rs.getString("ten"),
                    rs.getString("ngaySinh"),
                    rs.getString("gioiTinh"),
                    rs.getString("soDT"),
                    rs.getString("email"),
                    rs.getString("CC_HC"),
                    rs.getString("ngayVaoLam"),
                    rs.getString("chucVu"),
                    rs.getString("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void addNhanVien(NhanVienDTO nv) {
        String query = "INSERT INTO nhanvien (maNV, username, password, ho, ten, ngaySinh, gioiTinh, soDT, email, CC_HC, ngayVaoLam, chucVu, trangThai) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, nv.getMaNV());
            pstmt.setString(2, nv.getUsername());
            pstmt.setString(3, nv.getPassword());
            pstmt.setString(4, nv.getHo());
            pstmt.setString(5, nv.getTen());
            pstmt.setString(6, nv.getNgaySinh());
            pstmt.setString(7, nv.getGioiTinh());
            pstmt.setString(8, nv.getSoDT());
            pstmt.setString(9, nv.getEmail());
            pstmt.setString(10, nv.getCC_HC());
            pstmt.setString(11, nv.getNgayVaoLam());
            pstmt.setString(12, nv.getChucVu());
            pstmt.setString(13, nv.getTrangThai());

            pstmt.executeUpdate();
            System.out.println("Thêm nhân viên thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNhanVien(NhanVienDTO nv) {
        String query = "UPDATE nhanvien SET username = ?, password = ?, ho = ?, ten = ?, ngaySinh = ?, "
                     + "gioiTinh = ?, soDT = ?, email = ?, CC_HC = ?, ngayVaoLam = ?, chucVu = ?, trangThai = ? "
                     + "WHERE maNV = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nv.getUsername());
            pstmt.setString(2, nv.getPassword());
            pstmt.setString(3, nv.getHo());
            pstmt.setString(4, nv.getTen());
            pstmt.setString(5, nv.getNgaySinh());
            pstmt.setString(6, nv.getGioiTinh());
            pstmt.setString(7, nv.getSoDT());
            pstmt.setString(8, nv.getEmail());
            pstmt.setString(9, nv.getCC_HC());
            pstmt.setString(10, nv.getNgayVaoLam());
            pstmt.setString(11, nv.getChucVu());
            pstmt.setString(12, nv.getTrangThai());
            pstmt.setInt(13, nv.getMaNV());

            int rowUpdated = pstmt.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Cập nhật nhân viên thành công!");
            } else {
                System.out.println("Không tìm thấy nhân viên!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNhanVien(int maNV) {
        String query = "DELETE FROM nhanvien WHERE maNV = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, maNV);
            int rowDeleted = pstmt.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Xoá nhân viên thành công!");
            } else {
                System.out.println("Không tìm thấy nhân viên!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}