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

    public static void main(String[] args) {
        getRequest();
    }
}
