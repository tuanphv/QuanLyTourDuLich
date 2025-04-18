package dao;

import model.DiaDanhDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DatabaseConnection;

public class DiaDanhDAO {

    public ArrayList<DiaDanhDTO> getAllDiaDanh() {
        ArrayList<DiaDanhDTO> dsdiadanh = new ArrayList<>();
        String query = "SELECT * FROM diadanh";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                dsdiadanh.add(new DiaDanhDTO(
                        rs.getInt("maDD"),
                        rs.getString("tenDD"),
                        rs.getString("tinhThanh"),
                        rs.getString("diemNoiBat")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsdiadanh;
    }

    public int addDiaDanh(DiaDanhDTO diadanh) {
        String query = "INSERT INTO diadanh (tenDD, tinhThanh, diemNoiBat) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, diadanh.getTenDD());
            pstmt.setString(2, diadanh.getTinhThanh());
            pstmt.setString(3, diadanh.getDiemNoiBat());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Trả về ID vừa được sinh ra
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Trả về -1 nếu thất bại
    }

    public boolean deleteDiaDanh(int maDD) {
        String query = "DELETE FROM diadanh WHERE maDD = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maDD);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDiaDanh(DiaDanhDTO diadanh) {
        String query = "UPDATE diadanh SET tenDD = ?, tinhThanh = ?, diemNoiBat = ? WHERE maDD = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, diadanh.getTenDD());
            pstmt.setString(2, diadanh.getTinhThanh());
            pstmt.setString(3, diadanh.getDiemNoiBat());
            pstmt.setInt(4, diadanh.getMaDD());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
