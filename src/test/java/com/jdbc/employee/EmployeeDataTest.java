package com.jdbc.employee;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeDataTest {
    @SuppressWarnings("unchecked")
	@Test
    public void testParseEmployeeObject() {
        EmployeeData employeeData = new EmployeeData();

        JSONObject employee = new JSONObject();
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "John");
        employeeDetails.put("lastName", "Doe");
        employeeDetails.put("website", "example.com");

        employee.put("employee", employeeDetails);

        JSONObject result = employeeData.parseEmployeeObject(employee);
        assertEquals("John", result.get("firstName"));
        assertEquals("Doe", result.get("lastName"));
        assertEquals("example.com", result.get("website"));
    }
}
