package com.linkedin.commomUtil;

import com.linkedin.Browser.browser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReport extends browser implements ITestListener
{

	protected static ExtentReports reports;
	protected static ExtentTest test;
	protected static ITestResult result;

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Case Execution starts here");
		if(!(result == null))
		{
			test = reports.startTest(result.getMethod().getMethodName());
			test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
		}
		else
		{
			throw new TestException("TestNG configuration problem");
		}

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("TestCase passed and report is being generated");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("TestCase failed and refer to screenShot");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("/home/amit/git/CodeOfCritical/Linkedin/screenShots"
					+ result.getMethod().getMethodName() + ".png"));
			String file = test.addScreenCapture(
					"/home/amit/git/CodeOfCritical/Linkedin/screenShots" + result.getMethod().getMethodName() + ".png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
					result.getThrowable().getMessage());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("on test skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("on test sucess within percentage");
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("Listening TestNG steps to genarate report");

		reports = new ExtentReports("test-output/extent-report/"
				+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "report.html");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println("on finish");
		reports.endTest(test);
		reports.flush();
	}

}
