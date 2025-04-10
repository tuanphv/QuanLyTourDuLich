package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.model.KhachSanDTO;
import persistence.database.DatabaseConnection;

public class KhachSanDAO {
    public boolean insert(KhachSanDTO hotel) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO khachsan (tenKhachSan, diaChi, sdt, gia) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, hotel.getTenKhachSan());
            pstm.setString(2, hotel.getDiaChi());
            pstm.setString(3, hotel.getSdt());
            pstm.setInt(4, hotel.getGia());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(KhachSanDTO hotel) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE khachsan SET tenKhachSan = ?, diaChi = ?, sdt = ?, gia = ? WHERE maKhachSan = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, hotel.getTenKhachSan());
            pstm.setString(2, hotel.getDiaChi());
            pstm.setString(3, hotel.getSdt());
            pstm.setInt(4, hotel.getGia());
            pstm.setInt(5, hotel.getMaKhachSan());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maKhachSan) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE khachsan SET trangThai = ? WHERE maKhachSan = ?";
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
                    rs.getString("sdt"),
                    rs.getInt("gia"),
                    rs.getInt("trangThai")
                ));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listHotel;
    }
}
