package com.linkedin.interfaces;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author Critical 
 * Main Interface to be called
 */
public interface interfaceAsaService
{

	void takeScreenShotofCurrentpage() throws IOException;

	void startTestCase(String sTestCaseName);

	void endTestCase(String sTestCaseName);

	public void info(String message);

	void warn(String message);

	void error(String message);

	void fatal(String message);

	void debug(String message);

	void onTestStart(ITestResult result);

	void onTestSuccess(ITestResult result);

	void onTestFailure(ITestResult result);

	void onTestSkipped(ITestResult result);

	void onStart(ITestContext context);

	void onFinish(ITestContext context);

}
