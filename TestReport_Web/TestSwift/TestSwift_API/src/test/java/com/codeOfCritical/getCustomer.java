package com.codeOfCritical;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getCustomer {
	@DataProvider
	public Object[][] dataProvider_getCustomer() throws IOException {
		File file = new File(".\\CustomerData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook Workbook1 = new XSSFWorkbook(inputStream);
		XSSFSheet Sheet = Workbook1.getSheet("Sheet1");
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

	@Test(dataProvider = "dataProvider_getCustomer")
	public void getCustomerDeatils(int TCID, String TCDescription, String CustomerName, int CustomerID, int StatusCode) {

		given()
				.relaxedHTTPSValidation()
				.when()
				.get("https://reqres.in/api/users/" + CustomerID)
				.then()
				.statusCode(StatusCode)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("data.first_name", equalTo(CustomerName))
				.assertThat().body("data.id", equalTo(CustomerID))
				.log().status()
				.log().headers()
				.log().body()
				.header("Content-Type", "application/json; charset=utf-8");
	}
}
