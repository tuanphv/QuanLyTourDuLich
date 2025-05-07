package dao;

import config.DatabaseConnection;
import dto.BuoiAnDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuoiAnDAO {
    public int insert(BuoiAnDTO buoiAn) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO BuoiAn (maChiTietKeHoachTour, loaiBuoiAn, maNhaHang, chiPhi, moTa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, buoiAn.getMaChiTietKeHoachTour());
            pstm.setString(2, buoiAn.getLoaiBuoiAn());
            pstm.setInt(3, buoiAn.getMaNhaHang());
            pstm.setDouble(4, buoiAn.getChiPhi());
            pstm.setString(5, buoiAn.getMoTa());

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

    public boolean update(BuoiAnDTO buoiAn) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE BuoiAn SET maChiTietKeHoachTour = ?, loaiBuoiAn = ?, maNhaHang = ?, chiPhi = ?, moTa = ? WHERE maBuoiAn = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buoiAn.getMaChiTietKeHoachTour());
            pstm.setString(2, buoiAn.getLoaiBuoiAn());
            pstm.setInt(3, buoiAn.getMaNhaHang());
            pstm.setDouble(4, buoiAn.getChiPhi());
            pstm.setString(5, buoiAn.getMoTa());
            pstm.setInt(6, buoiAn.getMaBuoiAn());

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maBuoiAn) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE BuoiAn SET trangThai = 0 WHERE maBuoiAn = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maBuoiAn);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<BuoiAnDTO> getAllBuoiAn() {
        ArrayList<BuoiAnDTO> listBuoiAn = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM BuoiAn";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listBuoiAn.add(new BuoiAnDTO(
                    rs.getInt("maBuoiAn"),
                    rs.getInt("maChiTietKeHoachTour"),
                    rs.getString("loaiBuoiAn"),
                    rs.getInt("maNhaHang"),
                    rs.getDouble("chiPhi"),
                    rs.getString("moTa")
            ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listBuoiAn;
    }

}
