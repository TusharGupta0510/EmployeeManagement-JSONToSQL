package com.jdbc.employee;

import org.json.simple.JSONObject;

public class EmployeeData {
    public JSONObject parseEmployeeObject(JSONObject employee) {
        // Get employee object within list
        return (JSONObject) employee.get("employee");
    }
}
