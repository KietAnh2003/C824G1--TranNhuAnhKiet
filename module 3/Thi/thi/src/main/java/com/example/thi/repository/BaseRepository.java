package com.example.thi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    static final String Url = "jdbc:mysql://localhost:3306/thu_vien";
    static final String User= "root";
    static final String Password = "Kietanh2301@";
    private static Connection connection = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Url,User,Password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private BaseRepository() {
    }
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(Url, User, Password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Không thể tạo kết nối cơ sở dữ liệu.", e);
        }
        return connection;
    }
}