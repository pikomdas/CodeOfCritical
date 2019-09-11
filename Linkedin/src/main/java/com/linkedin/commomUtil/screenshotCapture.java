package com.linkedin.commomUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.linkedin.Browser.browser;
import com.linkedin.interfaces.screenShotInterface;

public class screenshotCapture extends browser implements screenShotInterface {

	public void takeScreenShotofCurrentpage() throws IOException {

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(
					"/home/amit/git/CodeOfCritical/Linkedin/screenShots/" + System.currentTimeMillis() + ".png"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("ScreenShot is Captured");

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

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
