package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.model.NhaHangDTO;
import persistence.database.DatabaseConnection;

public class NhaHangDAO {
    public boolean insert(NhaHangDTO nhaHang) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO nhahang (tenNhaHang, diaChi, sdt, gia) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nhaHang.getTenNhaHang());
            pstm.setString(2, nhaHang.getDiaChi());
            pstm.setString(3, nhaHang.getSdt());
            pstm.setInt(4, nhaHang.getGia());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(NhaHangDTO nhaHang) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE nhahang SET tenNhaHang = ?, diaChi = ?, sdt = ?, gia = ? WHERE maNhaHang = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nhaHang.getTenNhaHang());
            pstm.setString(2, nhaHang.getDiaChi());
            pstm.setString(3, nhaHang.getSdt());
            pstm.setInt(4, nhaHang.getGia());
            pstm.setInt(5, nhaHang.getMaNhaHang());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(int maNhaHang) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE nhahang SET trangThai = ? WHERE maNhaHang = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maNhaHang);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    public ArrayList<NhaHangDTO> getAllRestaurant() {
        ArrayList<NhaHangDTO> listRestaurant = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM nhahang";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listRestaurant.add(new NhaHangDTO(
                    rs.getInt("maNhaHang"),
                    rs.getString("tenNhaHang"),
                    rs.getString("diaChi"),
                    rs.getString("sdt"),
                    rs.getInt("gia"),
                    rs.getInt("trangThai")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listRestaurant;
    }
}
