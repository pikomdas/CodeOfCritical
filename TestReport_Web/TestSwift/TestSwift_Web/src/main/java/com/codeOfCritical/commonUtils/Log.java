package com.codeOfCritical.commonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log
{
    private static final Logger Log = LogManager.getLogger(Log.class.getName());

    // This is to print log for the beginning of the test case, as we usually run so
    // many test cases as a test suite

    public void startTestCase(String sTestCaseName)
    {

        Log.info("****************************************************************************************");

        Log.info("****************************************************************************************");

        Log.info("$$$$$$$$$$$$$$$$$$$$$  " + sTestCaseName + "  $$$$$$$$$$$$$$$$$$$$$$$$$");

        Log.info("****************************************************************************************");

        Log.info("****************************************************************************************");

    }

    // This is to print log for the ending of the test case
    public void endTestCase(String sTestCaseName)
    {

        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

    }

	/*@Override
	public void info(String message) {

		Log.info(message);

	}

	@Override
	public void warn(String message) {

		Log.warn(message);

	}

	@Override
	public void error(String message) {

		Log.error(message);

	}

	@Override
	public void fatal(String message) {

		Log.fatal(message);

	}

	@Override
	public void debug(String message) {

		// Log.debug(message);

	}

	@Override
	public void takeScreenShotofCurrentpage() throws IOException {
		// TODO Auto-generated method stub

	}
*/
}
