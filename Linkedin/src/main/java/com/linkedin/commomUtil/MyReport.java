package com.linkedin.commomUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.linkedin.interfaces.reportInterface;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyReport implements ITestListener, reportInterface {
	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	protected static ITestResult result;

	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));
			String file = test.addScreenCapture("C:\\images\\" + result.getMethod().getMethodName() + ".png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
					result.getThrowable().getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}

	public void onStart(ITestResult result) {
		System.out.println("on start");
		// driver = new ChromeDriver(); // Set the drivers path in environment variables
		// to avoid code(System.setProperty())
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	}

	public void onFinish(ITestResult result) {
		System.out.println("on finish");
		// driver.close();
		reports.endTest(test);
		reports.flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void takeScreenShotofCurrentpage() throws IOException {
		// TODO Auto-generated method stub

	}

	public void startTestCase(String sTestCaseName) {
		// TODO Auto-generated method stub

	}

	public void endTestCase(String sTestCaseName) {
		// TODO Auto-generated method stub

	}

	public void info(String message) {
		// TODO Auto-generated method stub

	}

	public void warn(String message) {
		// TODO Auto-generated method stub

	}

	public void error(String message) {
		// TODO Auto-generated method stub

	}

	public void fatal(String message) {
		// TODO Auto-generated method stub

	}

	public void debug(String message) {
		// TODO Auto-generated method stub

	}

}
