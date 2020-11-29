package src.main.java.com.linkedin.commomUtil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CustomLog
{

	public CustomLog()
	{

	}
	// Initialize Log4j logs

	private static Logger Log = LogManager.getLogger(CustomLog.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	public void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

	}

	//This is to print log for the ending of the test case

	public void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		Log.info("X");

	}

}
