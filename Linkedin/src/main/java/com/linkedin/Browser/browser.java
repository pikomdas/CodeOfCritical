package com.linkedin.Browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.linkedin.commomUtil.Log;
import com.linkedin.commomUtil.getMyProperty;
import com.linkedin.interfaces.interfaceAsaService;

public class browser extends BrowserConfig {

	public static Properties prop;
	File file;
	FileInputStream fileInput;
	interfaceAsaService log = new Log();

	// TEST PASSED
	public void openBrowserandNavigate() throws Exception {
		try {

			BrowserConfig.selectBrowserToExecute("chrome");
			driver.get(getMyProperty.readmyFile("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			log.info("URL is Presented");

			// driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			log.info("Browser is MAXIMIZED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void teardown() {
		if (driver != null) {
			driver.quit();
			log.info("Browser Closed");
		}

	}
}
