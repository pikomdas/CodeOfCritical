package Browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.linkedin.interfaces.interfaceAsaService;

import commomUtil.getMyProperty;

import commomUtil.Log;

public class browser extends BrowserConfig {

	public static Properties prop;
	File file;
	FileInputStream fileInput;
	interfaceAsaService log = new Log();

	// TEST PASSED
	public void openBrowserandNavigate() throws Exception {
		try {

			BrowserConfig.selectBrowserToExecute(getBrowserName());
			driver.get(getMyProperty.readmyFile("url"));

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
