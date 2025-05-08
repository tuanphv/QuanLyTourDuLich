package dao;

import config.DatabaseConnection;
import dto.ChiTietKeHoachTourDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietKeHoachTourDAO {
    public int insert(ChiTietKeHoachTourDTO chiTietKeHoachTour) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO chitietkehoachtour(maKeHoachTour, ngay, chiPhiNgay) VALUES (?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, chiTietKeHoachTour.getMaKeHoachTour());
            pstm.setDate(2, java.sql.Date.valueOf(chiTietKeHoachTour.getNgay()));
            pstm.setLong(3, chiTietKeHoachTour.getChiPhiNgay());

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

    public boolean update(ChiTietKeHoachTourDTO chiTietKeHoachTour) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE chitietkehoachtour SET maKeHoachTour = ?, ngay = ?, chiPhiNgay = ? WHERE maChiTietKeHoachTour = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, chiTietKeHoachTour.getMaKeHoachTour());
            pstm.setDate(2, java.sql.Date.valueOf(chiTietKeHoachTour.getNgay()));
            pstm.setLong(3, chiTietKeHoachTour.getChiPhiNgay());
            pstm.setInt(4, chiTietKeHoachTour.getMaChiTietKeHoachTour());

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maChiTietKeHoachTour) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE chitietkehoachtour SET trangThai = 0 WHERE maChiTietKeHoachTour = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maChiTietKeHoachTour);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<ChiTietKeHoachTourDTO> getAllChiTietKeHoachTour() {
        ArrayList<ChiTietKeHoachTourDTO> list = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM chitietkehoachtour";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietKeHoachTourDTO(
                        rs.getInt("maChiTietKeHoachTour"),
                        rs.getInt("maKeHoachTour"),
                        rs.getDate("ngay").toLocalDate(),
                        rs.getLong("chiPhiNgay")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
