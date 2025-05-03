package dao;

import dto.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;
import database.DatabaseConnection;

public class NhanVienDAO {

    public ArrayList<NhanVienDTO> getAll() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM nhanvien WHERE trangThai = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new NhanVienDTO(
                        rs.getInt("maNV"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("ho"),
                        rs.getString("ten"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("soDT"),
                        rs.getString("email"),
                        rs.getString("cc_hc"),
                        rs.getString("ngayVaoLam"),
                        rs.getString("chucVu"),
                        rs.getInt("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insert(NhanVienDTO nv) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO nhanvien (username, password, ho, ten, ngaySinh, gioiTinh, soDT, email, cc_hc, ngayVaoLam, chucVu, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Điền các tham số vào câu lệnh SQL
            stmt.setString(1, nv.getUsername());
            stmt.setString(2, nv.getPassword());
            stmt.setString(3, nv.getHo());
            stmt.setString(4, nv.getTen());
            stmt.setString(5, nv.getNgaySinh());
            stmt.setString(6, nv.getGioiTinh());
            stmt.setString(7, nv.getSoDT());
            stmt.setString(8, nv.getEmail());
            stmt.setString(9, nv.getCC_HC());
            stmt.setString(10, nv.getNgayVaoLam());
            stmt.setString(11, nv.getChucVu());
            stmt.setInt(12, nv.getTrangThai());

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean update(NhanVienDTO nv) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE nhanvien SET username=?, password=?, ho=?, ten=?, ngaySinh=?, gioiTinh=?, soDT=?, email=?, cc_hc=?, ngayVaoLam=?, chucVu=?, trangThai=? WHERE maNV=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nv.getUsername());
            stmt.setString(2, nv.getPassword());
            stmt.setString(3, nv.getHo());
            stmt.setString(4, nv.getTen());
            stmt.setString(5, nv.getNgaySinh());
            stmt.setString(6, nv.getGioiTinh());
            stmt.setString(7, nv.getSoDT());
            stmt.setString(8, nv.getEmail());
            stmt.setString(9, nv.getCC_HC());
            stmt.setString(10, nv.getNgayVaoLam());
            stmt.setString(11, nv.getChucVu());
            stmt.setInt(12, nv.getTrangThai());
            stmt.setInt(13, nv.getMaNV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int maNV) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE nhanvien SET trangThai=0 WHERE maNV=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maNV);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public NhanVienDTO getNhanVienByMa(int ma) {
        String sql = "SELECT * FROM nhanvien WHERE ma = " + ma;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            return new NhanVienDTO(
                    rs.getInt("maNV"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("ho"),
                    rs.getString("ten"),
                    rs.getString("ngaySinh"),
                    rs.getString("gioiTinh"),
                    rs.getString("soDT"),
                    rs.getString("email"),
                    rs.getString("cc_hc"),
                    rs.getString("ngayVaoLam"),
                    rs.getString("chucVu"),
                    rs.getInt("trangThai")
            );
        } catch (SQLException e) {
            return null;
        }
    }
}
