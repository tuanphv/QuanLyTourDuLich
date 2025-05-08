package dao;

import config.DatabaseConnection;
import dto.KeHoachTourDTO;
import enums.TrangThaiKeHoachTour;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.FormatDate;

public class KeHoachTourDAO {

    public ArrayList<KeHoachTourDTO> getAllKeHoachTour() {
        ArrayList<KeHoachTourDTO> dsKeHoachTour = new ArrayList<>();
        String query = "SELECT * FROM KeHoachTour";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                dsKeHoachTour.add(new KeHoachTourDTO(
                        rs.getInt("maKeHoachTour"),
                        rs.getInt("maTour"),
                        FormatDate.dateToLocalDate(new java.util.Date(rs.getDate("thoigianBD").getTime())),
                        FormatDate.dateToLocalDate(new java.util.Date(rs.getDate("thoigianKT").getTime())),
                        rs.getInt("slDaDat"),
                        rs.getInt("slToiDa"),
                        rs.getFloat("tongChiPhi"),
                        TrangThaiKeHoachTour.valueOf(rs.getString("trangThai"))
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKeHoachTour;
    }

    public int addKeHoachTour(KeHoachTourDTO khTour) {
        String query = "INSERT INTO KeHoachTour (maTour, thoiGianBD, thoiGianKT, slDaDat, slToiDa, trangThai, tongChiPhi) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, khTour.getMaTour());
            pstmt.setDate(2, Date.valueOf(khTour.getThoiGianBD()));
            pstmt.setInt(3, khTour.getSlDaDat());
            pstmt.setInt(4, khTour.getSlToiDa());
            pstmt.setString(5, khTour.getTrangThai().name());
            pstmt.setFloat(6, khTour.getTongChiPhi());

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

    public boolean deleteKeHoachTour(int maKeHoachTour) {
        String query = "DELETE FROM KeHoachTour WHERE maKeHoachTour = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, maKeHoachTour);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateKeHoachTour(KeHoachTourDTO khTour) {
        String query = "UPDATE KeHoachTour SET maTour = ?, thoiGianBD = ?, thoiGianKT = ?, slDaDat = ?, slToiDa = ?, trangThai = ?, tongChiPhi = ? WHERE maKeHoachTour = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, khTour.getMaTour());
            pstmt.setDate(2, Date.valueOf(khTour.getThoiGianBD()));
            pstmt.setDate(3, Date.valueOf(khTour.getThoiGianKT()));
            pstmt.setInt(4, khTour.getSlDaDat());
            pstmt.setInt(5, khTour.getSlToiDa());
            pstmt.setString(6, khTour.getTrangThai().name());
            pstmt.setFloat(7, khTour.getTongChiPhi());
            pstmt.setInt(8, khTour.getMaKHTour());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public KeHoachTourDTO getKeHoachTourByMa(int ma) {
        String query = "SELECT * FROM KeHoachTour WHERE ma = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, ma);
            ResultSet rs = pstmt.executeQuery();
            return new KeHoachTourDTO(
                    rs.getInt("maKHTour"),
                    rs.getInt("maTour"),
                    FormatDate.dateToLocalDate(new java.util.Date(rs.getDate("thoigianBD").getTime())),
                    FormatDate.dateToLocalDate(new java.util.Date(rs.getDate("thoigianKT").getTime())),
                    rs.getInt("slDaDat"),
                    rs.getInt("slToiDa"),
                    rs.getFloat("tongChiPhi"),
                    TrangThaiKeHoachTour.valueOf(rs.getString("trangThai"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new KeHoachTourDAO().getAllKeHoachTour();
    }
}
