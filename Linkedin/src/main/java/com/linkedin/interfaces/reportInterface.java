package com.linkedin.interfaces;

import org.testng.ITestContext;
import org.testng.ITestResult;

public interface reportInterface extends interfaceAsaService{

	public void onTestStart(ITestResult result);

	public void onTestSuccess(ITestResult result);

	public void onTestFailure(ITestResult result);

	public void onTestSkipped(ITestResult result);

	public void onStart(ITestContext context);

	public void onFinish(ITestContext context);

}
