package persistence.dao;

import business.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import persistence.database.DatabaseConnection;

public class CustomerDAO {

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getString("registrationDate"),
                        rs.getString("identityNumber"),
                        rs.getString("customerType"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("dateOfBirth"),
                        rs.getString("gender"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return customers;
    }

    public void deleteCustomer(String id) {
        String query = "DELETE FROM customer WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            int rowDeleted = pstmt.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Xoá khách hàng thành công!");
            } else {
                System.out.println("Không tìm thấy khách hàng!");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addCustomer(Customer c) {
        StringBuilder query = new StringBuilder(
                "INSERT INTO customer (id, username, password, role, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, registrationDate, identityNumber, customerType)");
        query.append("\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            pstmt.setString(1, c.getId());
            pstmt.setString(2, c.getUsername());
            pstmt.setString(3, c.getPassword());
            pstmt.setString(4, c.getRole());
            pstmt.setString(5, c.getFirstName());
            pstmt.setString(6, c.getLastName());
            pstmt.setString(7, c.getDateOfBirth());
            pstmt.setString(8, c.getGender());
            pstmt.setString(9, c.getPhoneNumber());
            pstmt.setString(10, c.getEmail());
            pstmt.setString(11, c.getAddress());
            pstmt.setString(12, c.getRegistrationDate());
            pstmt.setString(13, c.getIdentityNumber());
            pstmt.setString(14, c.getCustomerType());
            pstmt.executeUpdate();
            System.out.println("Thêm dữ liệu người dùng thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCustomer(Customer c) {
        StringBuilder query = new StringBuilder(
                "UPDATE customer SET username = ?, password = ?, role = ?, firstName = ?, lastName = ?, dateOfBirth = ?, gender = ?, phoneNumber = ?, email = ?, address = ?, registrationDate = ?, identityNumber = ?, customerType = ? WHERE id = ?)");
        query.append("\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            pstmt.setString(1, c.getUsername());
            pstmt.setString(2, c.getPassword());
            pstmt.setString(3, c.getRole());
            pstmt.setString(4, c.getFirstName());
            pstmt.setString(5, c.getLastName());
            pstmt.setString(6, c.getDateOfBirth());
            pstmt.setString(7, c.getGender());
            pstmt.setString(8, c.getPhoneNumber());
            pstmt.setString(9, c.getEmail());
            pstmt.setString(10, c.getAddress());
            pstmt.setString(11, c.getRegistrationDate());
            pstmt.setString(12, c.getIdentityNumber());
            pstmt.setString(13, c.getCustomerType());
            pstmt.setString(14, c.getId());
            int rowUpdated = pstmt.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Cập nhật dữ liệu người dùng thành công!");
            } else {
                System.out.println("Cập nhật dữ liệu người dùng thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
