package com.jdbc.employee;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParserTest {
    @SuppressWarnings("unchecked")
	@Test
    public void testParseJsonFile() throws IOException, ParseException {
        String testFilePath = "test.json";

        // Create a test JSON file
        JSONArray jsonArray = new JSONArray();
        JSONObject employee = new JSONObject();
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "John");
        employeeDetails.put("lastName", "Doe");
        employeeDetails.put("website", "example.com");
        employee.put("employee", employeeDetails);
        jsonArray.add(employee);

        try (FileWriter file = new FileWriter(testFilePath)) {
            file.write(jsonArray.toJSONString());
        }

        JsonParser jsonParser = new JsonParser();
        JSONArray result = jsonParser.parseJsonFile(testFilePath);

        assertEquals(jsonArray.size(), result.size());
        assertEquals(jsonArray.toJSONString(), result.toJSONString());

        // Clean up test file
        Files.delete(Path.of(testFilePath));
    }
}
