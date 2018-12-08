 package com.linkedin.commomUtil;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.linkedin.interfaces.logInterface;

 public class Log implements logInterface{

// Initialize Log4j logs

	 private static Logger Log = Logger.getLogger(Log.class.getName());//

 // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

 public void startTestCase(String sTestCaseName){
	 
	Log.info("****************************************************************************************");

	Log.info("****************************************************************************************");

	Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

	Log.info("****************************************************************************************");

	Log.info("****************************************************************************************");

	}

	//This is to print log for the ending of the test case

 public void endTestCase(String sTestCaseName){

	Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

	Log.info("X");

	Log.info("X");

	Log.info("X");

	Log.info("X");

	}

	// Need to create these methods, so that they can be called  

 public void info(String message) {
	
		Log.info(message);

		}

 public void warn(String message) {

    Log.warn(message);

	}

 public void error(String message) {

    Log.error(message);

	}

 public void fatal(String message) {

    Log.fatal(message);

	}

 public void debug(String message) {

    Log.debug(message);

	}

public void takeScreenShotofCurrentpage() throws IOException {
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