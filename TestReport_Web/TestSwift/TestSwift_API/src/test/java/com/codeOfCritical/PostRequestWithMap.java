package com.codeOfCritical;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class PostRequestWithMap {
    public static void main(String[] args) {
        // Build reusable RequestSpecification
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .addHeader("Content-Type", "application/json")
                .build();

        // Dynamic payload using Map
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "dynamicTitle");
        requestBody.put("body", "dynamicBody");
        requestBody.put("userId", 101);

        // Perform POST request
        Response response = RestAssured.given()
                .spec(reqSpec)
                .body(requestBody)
                .post("/posts");

        // Validate status code
        response.then().statusCode(201);

        // Extract values using JsonPath
        String id = response.jsonPath().getString("id");
        String title = response.jsonPath().getString("title");

        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
    }
}
