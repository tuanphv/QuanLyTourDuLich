package database;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.EnvLoader;

public class DatabaseConnection {
    private static final EnvLoader env = EnvLoader.load();
    private static final String URL = "jdbc:mysql://"+env.get("DB_HOST")+":"+env.get("DB_PORT")+"/quanlytourdulich_test";
    private static final String USER = env.get("DB_USER");
    private static final String PASSWORD = env.get("DB_PASSWORD");

    public static Connection getConnection() {
        if (Beans.isDesignTime()) {
            System.out.println("Running in design mode - mock connection used");
            return null;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }

}