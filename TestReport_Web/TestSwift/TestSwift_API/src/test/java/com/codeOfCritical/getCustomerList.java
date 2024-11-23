package com.codeOfCritical;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getCustomerList {
	@Test
	public void GetCustomerList() {
		given()
				.relaxedHTTPSValidation()
				.when()
				.get("https://reqres.in/api/users")
				//.get("https://reqres.in/api/unknown")
				.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.log().status()
				.log().body();
	}
}
