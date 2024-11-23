package com.codeOfCritical;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DeleteCustomer {
	@Test
	public void DeleteSingleCustomer() {

		given()
				.relaxedHTTPSValidation()
				.when()
				.get("/api/users/2")
				.then()
				.statusCode(204)
				//.statusLine("HTTP/1.1 200 OK")
				//.assertThat().body("data.first_name",equalTo(CustomerName))
				.log().status()
				.log().headers()
				.log().body()
				.header("Content-Type", "application/json; charset=utf-8");
	}

//	public void CreateCustomer(){
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("name","ABC");
//		map.put("job","Manager");
//		RestAssured.baseURI="https://reqres.in";
//		RestAssured.basePath="/api/users";
//		
//		given()
//			.relaxedHTTPSValidation()
//			.contentType("application/json")
//			.body(map)
//		.when()
//			.post()
//		.then()
//			.statusCode(201)
//			.statusLine("HTTP/1.1 201 Created")
//			//.body("Message",equalTo("Operation Completed Successfully"));
//			.log().body()
//			.log().status()
//			.log().all();
//	}
}
