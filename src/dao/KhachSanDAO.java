package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.KhachSanDTO;
import database.DatabaseConnection;

public class KhachSanDAO {
    public int insert(KhachSanDTO hotel) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO khachsan (tenKhachSan, diaChi, sdt, gia, trangThai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm;
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, hotel.getTenKhachSan());
            pstm.setString(2, hotel.getDiaChi());
            pstm.setString(3, hotel.getSoDienThoai());
            pstm.setInt(4, hotel.getGia());
            pstm.setInt(5, hotel.getTrangThai());

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public boolean update(KhachSanDTO hotel) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE khachsan SET tenKhachSan = ?, diaChi = ?, sdt = ?, gia = ?, trangThai = ? WHERE maKhachSan = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, hotel.getTenKhachSan());
            pstm.setString(2, hotel.getDiaChi());
            pstm.setString(3, hotel.getSoDienThoai());
            pstm.setInt(4, hotel.getGia());
            pstm.setInt(5, hotel.getTrangThai());
            pstm.setInt(6, hotel.getMaKhachSan());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maKhachSan) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE khachsan SET trangThai = 0 WHERE maKhachSan = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maKhachSan);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<KhachSanDTO> getAllHotel() {
        ArrayList<KhachSanDTO> listHotel = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM khachsan";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listHotel.add(new KhachSanDTO(
                    rs.getInt("maKhachSan"),
                    rs.getString("tenKhachSan"),
                    rs.getString("diaChi"),
                    rs.getInt("gia"),
                    rs.getString("sdt"),
                    rs.getInt("trangThai")
                ));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listHotel;
    }
}
