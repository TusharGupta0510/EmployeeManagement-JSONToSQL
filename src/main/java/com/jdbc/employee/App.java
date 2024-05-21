package com.jdbc.employee;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("unchecked")
	public void run() {
        try {
            // Get user input for JSON file path
            System.out.println("Enter the JSON File path: ");
            String myFile = scanner.nextLine();

            // Establish database connection
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = dbConnection.getConnection();

            // Read JSON file
            JsonParser jsonParser = new JsonParser();
            JSONArray employeeList = jsonParser.parseJsonFile(myFile);
            System.out.println(employeeList);

            // Iterate over employee array
            EmployeeData employeeData = new EmployeeData();
            DatabaseOperations dbOperations = new DatabaseOperations();

            employeeList.forEach(emp -> {
                JSONObject employeeObject = employeeData.parseEmployeeObject((JSONObject) emp);
                try {
                    dbOperations.insertIntoDatabase(connection, employeeObject);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

        } catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new App().run();
    }
}
