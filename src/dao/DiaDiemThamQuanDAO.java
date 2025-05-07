package dao;

import config.DatabaseConnection;
import dto.DiaDiemThamQuanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiaDiemThamQuanDAO {
    public int insert(DiaDiemThamQuanDTO diaDiemThamQuan) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO DiaDiemThamQuan (maChiTietKeHoachTour, maDiaDanh, moTa, maPhuongTien, chiPhiThamQuan, chiPhiDiChuyen) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, diaDiemThamQuan.getMaChiTietKeHoachTour());
            pstm.setInt(2, diaDiemThamQuan.getMaDiaDanh());
            pstm.setString(3, diaDiemThamQuan.getMoTaHoatDong());
            pstm.setInt(4, diaDiemThamQuan.getMaPhuongTienDiChuyen());
            pstm.setLong(5, diaDiemThamQuan.getChiPhiThamQuan());
            pstm.setLong(6, diaDiemThamQuan.getChiPhiDiChuyen());

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

    public boolean update(DiaDiemThamQuanDTO diaDiemThamQuan) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE DiaDiemThamQuan SET maChiTietKeHoachTour = ?, maDiaDanh = ?, moTa = ?, maPhuongTien = ?, chiPhiThamQuan = ?, chiPhiDiChuyen = ? WHERE maDiaDiemThamQuan = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, diaDiemThamQuan.getMaChiTietKeHoachTour());
            pstm.setInt(2, diaDiemThamQuan.getMaDiaDanh());
            pstm.setString(3, diaDiemThamQuan.getMoTaHoatDong());
            pstm.setInt(4, diaDiemThamQuan.getMaPhuongTienDiChuyen());
            pstm.setLong(5, diaDiemThamQuan.getChiPhiThamQuan());
            pstm.setLong(6, diaDiemThamQuan.getChiPhiDiChuyen());
            pstm.setInt(7, diaDiemThamQuan.getMaDiaDiemThamQuan());
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int maDiaDiemThamQuan) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE DiaDiemThamQuan SET trangThai = 0 WHERE maDiaDiemThamQuan = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, maDiaDiemThamQuan);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }   
    }

    public ArrayList<DiaDiemThamQuanDTO> getAllDiaDiemThamQuan() {
        ArrayList<DiaDiemThamQuanDTO> listDiaDiemThamQuan = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM DiaDiemThamQuan";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DiaDiemThamQuanDTO diaDiemThamQuan = new DiaDiemThamQuanDTO();
                diaDiemThamQuan.setMaDiaDiemThamQuan(rs.getInt("maDiaDiemThamQuan"));
                diaDiemThamQuan.setMaChiTietKeHoachTour(rs.getInt("maChiTietKeHoachTour"));
                diaDiemThamQuan.setMaDiaDanh(rs.getInt("maDiaDanh"));
                diaDiemThamQuan.setMoTaHoatDong(rs.getString("moTa"));
                diaDiemThamQuan.setMaPhuongTienDiChuyen(rs.getInt("maPhuongTien"));
                diaDiemThamQuan.setChiPhiThamQuan(rs.getLong("chiPhiThamQuan"));
                diaDiemThamQuan.setChiPhiDiChuyen(rs.getLong("chiPhiDiChuyen"));
                
                listDiaDiemThamQuan.add(diaDiemThamQuan);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDiaDiemThamQuan;
    }
    
}
