package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Nn15071992$";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Sử dụng driver mới hơn
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
