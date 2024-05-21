package com.jdbc.employee;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class DatabaseOperationsTest {
    private DatabaseOperations databaseOperations;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    public void setUp() throws SQLException {
        databaseOperations = new DatabaseOperations();
        mockConnection = Mockito.mock(Connection.class);
        mockPreparedStatement = Mockito.mock(PreparedStatement.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testInsertIntoDatabase() throws SQLException {
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("firstName", "John");
        employeeObject.put("lastName", "Doe");
        employeeObject.put("website", "example.com");

        databaseOperations.insertIntoDatabase(mockConnection, employeeObject);

        verify(mockPreparedStatement).setString(1, "John");
        verify(mockPreparedStatement).setString(2, "Doe");
        verify(mockPreparedStatement).setString(3, "example.com");
        verify(mockPreparedStatement).executeUpdate();
    }
}
