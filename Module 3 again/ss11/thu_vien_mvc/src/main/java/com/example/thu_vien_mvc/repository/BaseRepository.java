package com.example.thu_vien_mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static String Url = "jdbc:mysql://localhost:3306/library?useSSL=false";
    private static String Username = "root";
    private static String Password = "Kietanh2301@";
    private static Connection connection = null;
    private BaseRepository(){
    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver" );
            connection = DriverManager.getConnection(Url,Username,Password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
