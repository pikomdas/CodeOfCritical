package com.codeOfCritical.BDD;

import com.codeOfCritical.test.Managers.FileUtility;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getCustomerList {
	@Test
	public void getAllCustomerList() {
		String Res = given()
				.relaxedHTTPSValidation()
				.when()
				.get("https://reqres.in/api/users")
				//.get("https://reqres.in/api/unknown")
				.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.log().status()
				.log().body().extract().asPrettyString();
		FileUtility.WriteResponseToFile(Res, "Reponse_getCustomerList");
	}
}
