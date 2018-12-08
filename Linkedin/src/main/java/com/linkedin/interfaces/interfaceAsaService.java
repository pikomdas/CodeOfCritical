/**
 * 
 */
package com.linkedin.interfaces;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author Critical 
 * Main Interface to be called
 */
public interface interfaceAsaService {

	void takeScreenShotofCurrentpage() throws IOException;

	void startTestCase(String sTestCaseName);

	void endTestCase(String sTestCaseName);

	public void info(String message);

	void warn(String message);

	void error(String message);

	void fatal(String message);

	void debug(String message);

	public void onTestStart(ITestResult result);

	public void onTestSuccess(ITestResult result);

	public void onTestFailure(ITestResult result);

	public void onTestSkipped(ITestResult result);

	public void onStart(ITestContext context);

	public void onFinish(ITestContext context);

}
