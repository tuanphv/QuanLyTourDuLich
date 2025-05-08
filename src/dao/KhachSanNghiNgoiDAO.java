package dao;

import config.DatabaseConnection;
import dto.KhachSanNghiNgoiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachSanNghiNgoiDAO {
    public int insert(KhachSanNghiNgoiDTO khachSanNghiNgoi) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO KhachSanNghiNgoi (maChiTietKeHoachTour, maKhachSan, chiPhiKhachSan) VALUES (?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, khachSanNghiNgoi.getMaChiTietKeHoachTour());
            pstm.setInt(2, khachSanNghiNgoi.getMaKhachSan());
            pstm.setLong(3, khachSanNghiNgoi.getChiPhiKhachSan());
            
            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public boolean update(KhachSanNghiNgoiDTO khachSanNghiNgoi) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE KhachSanNghiNgoi SET maChiTietKeHoachTour = ?, maKhachSan = ?, chiPhiKhachSan = ? WHERE maKhachSanNghiNgoi = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, khachSanNghiNgoi.getMaChiTietKeHoachTour());
            pstm.setInt(2, khachSanNghiNgoi.getMaKhachSan());
            pstm.setLong(3, khachSanNghiNgoi.getChiPhiKhachSan());
            pstm.setInt(4, khachSanNghiNgoi.getMaKhachSanNghiNgoi());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maKhachSanNghiNgoi) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM KhachSanNghiNgoi WHERE maKhachSanNghiNgoi = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maKhachSanNghiNgoi);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<KhachSanNghiNgoiDTO> getAllKhachSanNghiNgoi() {
        ArrayList<KhachSanNghiNgoiDTO> listKhachSan = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM KhachSanNghiNgoi";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listKhachSan.add(new KhachSanNghiNgoiDTO(
                    rs.getInt("maKhachSanNghiNgoi"),
                    rs.getInt("maChiTietKeHoachTour"),
                    rs.getInt("maKhachSan"),
                    rs.getLong("chiPhiKhachSan")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachSan;
    }

}
