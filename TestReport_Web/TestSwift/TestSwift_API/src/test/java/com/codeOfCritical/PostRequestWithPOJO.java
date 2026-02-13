package com.codeOfCritical;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Define POJO
class User {
    private String name;
    private String job;

    // Constructors, getters, setters
    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
    // getters and setters omitted for brevity
}

public class PostRequestWithPOJO {
    public static void main(String[] args) {
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();

        // Dynamic payload using POJO
        User user = new User("Partha", "QA Engineer");

        Response response = RestAssured.given()
                .spec(reqSpec)
                .body(user) // Rest Assured auto-serializes POJO to JSON
                .post("/api/users");

        response.then().statusCode(201);

        // Extract response values
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        String id = response.jsonPath().getString("id");

        System.out.println("Name: " + name);
        System.out.println("Job: " + job);
        System.out.println("ID: " + id);
    }
}
