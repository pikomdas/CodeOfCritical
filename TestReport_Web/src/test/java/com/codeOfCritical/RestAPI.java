package com.codeOfCritical;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI {
    public static void getRequest() {

        // Define reusable RequestSpecification
        RequestSpecification requestSpec = RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/users")
                .header("Content-Type", "application/json");

        // Perform GET request
        Response response = requestSpec
                .when()
                .get("/1")   // Fetch user with ID = 1
                .then()
                .statusCode(200)
                .extract().response();

        // Extract values using JsonPath
        String name = response.jsonPath().getString("name");
        String email = response.jsonPath().getString("email");
        String city = response.jsonPath().getString("address.city");

        // Print extracted values
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("City: " + city);
    }

    public static void postRequest() {

        // Define reusable RequestSpecification
        RequestSpecification requestSpec = RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/posts")
                .header("Content-Type", "application/json");

        // Define request body
        String requestBody = "{ \"title\": \"Interview Prep\", \"body\": \"Rest Assured Example\", \"userId\": 101 }";

        // Perform POST request
        Response response = requestSpec
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(201)   // Validate response code
                .extract().response();

        // Extract values using JsonPath
        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");

        // Print extracted values
        System.out.println("Created Post ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Body: " + body);
    }




public static void main(String[] args) {
    getRequest();
}
}
