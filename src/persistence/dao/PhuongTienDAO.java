package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.model.PhuongTienDTO;
import persistence.database.DatabaseConnection;

public class PhuongTienDAO {
    public boolean insert(PhuongTienDTO phuongTien) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO phuongtien (tenPhuongTien, loaiPhuongTien, soChoNgoi, sdt, gia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, phuongTien.getTenPhuongTien());
            pstm.setString(2, phuongTien.getLoaiPhuongTien());
            pstm.setInt(3, phuongTien.getSoChoNgoi());
            pstm.setString(4, phuongTien.getSdt());
            pstm.setInt(5, phuongTien.getGia());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(PhuongTienDTO phuongTien) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE phuongtien SET tenPhuongTien = ?, loaiPhuongTien = ?, soChoNgoi = ?, sdt = ?, gia = ? WHERE maPhuongTien = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, phuongTien.getTenPhuongTien());
            pstm.setString(2, phuongTien.getLoaiPhuongTien());
            pstm.setInt(3, phuongTien.getSoChoNgoi());
            pstm.setString(4, phuongTien.getSdt());
            pstm.setInt(5, phuongTien.getGia());
            pstm.setInt(6, phuongTien.getMaPhuongTien());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maPhuongTien) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE phuongtien SET trangThai = ? WHERE maPhuongTien = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maPhuongTien);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<PhuongTienDTO> getAllVehicle() {
        ArrayList<PhuongTienDTO> dsPhuongTien = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM phuongtien";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                dsPhuongTien.add(new PhuongTienDTO(
                    rs.getInt("maPhuongTien"),
                    rs.getString("tenPhuongTien"),
                    rs.getString("loaiPhuongTien"),
                    rs.getInt("soChoNgoi"),
                    rs.getString("sdt"),
                    rs.getInt("gia"),
                    rs.getInt("trangThai")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsPhuongTien;
    }
}
