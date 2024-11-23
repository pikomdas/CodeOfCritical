package com.codeOfCritical;

import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateCustomer {
	@DataProvider
	public Object[][] dataProvider_ImportCustomerData() throws IOException {
		File file = new File(".\\CustomerData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook Workbook1 = new XSSFWorkbook(inputStream);
		XSSFSheet Sheet = Workbook1.getSheet("Sheet2");
		int rowCount = Sheet.getLastRowNum();
		int colCount = Sheet.getRow(0).getLastCellNum();
		Object[][] Object1 = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++)
			for (int j = 0; j < Sheet.getRow(i).getLastCellNum(); j++) {
				Cell cell = Sheet.getRow(i).getCell(j);
				if (cell.getCellType() == CellType.STRING)
					Object1[i - 1][j] = cell.getStringCellValue();
				else if (cell.getCellType() == CellType.NUMERIC) {
					String s = String.valueOf(cell.getNumericCellValue());
					Double d = Double.parseDouble(s);
					Object1[i - 1][j] = d.intValue();
				}
			}
		Workbook1.close();
		return Object1;
	}

	@Test(dataProvider = "dataProvider_ImportCustomerData")
	public void getCustomerDeatils(int TCID, String TCDescription, String CustomerName, int StatusCode, String job) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", CustomerName);
		map.put("job", job);
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users";

		given()
				.relaxedHTTPSValidation()
				.contentType("application/json")
				.body(map)
				.when()
				.post()
				.then()
				.statusCode(201)
				.statusLine("HTTP/1.1 201 Created")
				//.body("Message",equalTo("Operation Completed Successfully"));
				.log().body()
				.log().status()
				.log().all();

	}
}
