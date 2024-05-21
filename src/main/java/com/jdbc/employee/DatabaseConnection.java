package com.jdbc.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String DbURL = "jdbc:mysql://localhost:3306/parquet";
            String uname = "root";
            String pass = "051002";
            connection = DriverManager.getConnection(DbURL, uname, pass);
        }
        return connection;
    }
}
