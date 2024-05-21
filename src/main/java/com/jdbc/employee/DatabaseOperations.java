package com.jdbc.employee;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations {
    public void insertIntoDatabase(Connection connection, JSONObject employeeObject) throws SQLException {
        String sql = "insert into employee(firstName, lastName, website) values(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, (String) employeeObject.get("firstName"));
            preparedStatement.setString(2, (String) employeeObject.get("lastName"));
            preparedStatement.setString(3, (String) employeeObject.get("website"));
            preparedStatement.executeUpdate();
        }
    }
}
