package dao;

import dto.KhachHangDTO;
import java.sql.*;
import java.util.ArrayList;
import config.DatabaseConnection;

public class KhachHangDAO {

    public int insert(KhachHangDTO kh) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO khachhang (username, password, ho, ten, ngaySinh, gioiTinh, soDT, email, cc_hc, ngayDK, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, kh.getUsername());
            stmt.setString(2, kh.getPassword());
            stmt.setString(3, kh.getHo());
            stmt.setString(4, kh.getTen());
            stmt.setString(5, kh.getNgaySinh());
            stmt.setString(6, kh.getGioiTinh());
            stmt.setString(7, kh.getSoDT());
            stmt.setString(8, kh.getEmail());
            stmt.setString(9, kh.getCC_HC());
            stmt.setString(10, kh.getNgayDK());
            stmt.setInt(11, kh.getTrangThai());

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

    public boolean update(KhachHangDTO kh) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE khachhang SET username = ?, password = ?, ho = ?, ten = ?, ngaySinh = ?, gioiTinh = ?, soDT = ?, email = ?, cc_hc = ?, ngayDK = ?, trangThai = ? WHERE maKH = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kh.getUsername());
            stmt.setString(2, kh.getPassword());
            stmt.setString(3, kh.getHo());
            stmt.setString(4, kh.getTen());
            stmt.setString(5, kh.getNgaySinh());
            stmt.setString(6, kh.getGioiTinh());
            stmt.setString(7, kh.getSoDT());
            stmt.setString(8, kh.getEmail());
            stmt.setString(9, kh.getCC_HC());
            stmt.setString(10, kh.getNgayDK());
            stmt.setInt(11, kh.getTrangThai());
            stmt.setInt(12, kh.getMaKH());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int maKH) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE khachhang SET trangThai = 0 WHERE maKH = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maKH);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHangDTO> getAll() {
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM khachhang WHERE trangThai = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new KhachHangDTO(
                        rs.getInt("maKH"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("ho"),
                        rs.getString("ten"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("soDT"),
                        rs.getString("email"),
                        rs.getString("cc_hc"),
                        rs.getString("ngayDK"),
                        rs.getInt("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHangDTO getKhachHangByMa(int ma) {
        String sql = "SELECT * FROM khachhang WHERE maKH = " + ma;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new KhachHangDTO(
                        rs.getInt("maKH"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("ho"),
                        rs.getString("ten"),
                        rs.getString("ngaySinh"),
                        rs.getString("gioiTinh"),
                        rs.getString("soDT"),
                        rs.getString("email"),
                        rs.getString("cc_hc"),
                        rs.getString("ngayDK"),
                        rs.getInt("trangThai")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return null;
    }
}
