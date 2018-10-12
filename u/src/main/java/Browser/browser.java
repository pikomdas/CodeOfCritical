package Browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commomUtil.getMyProperty;

import commomUtil.Log;

public class browser {

	public static WebDriver driver;
	public static Properties prop;
	File file;
	FileInputStream fileInput;

	// TEST PASSED
	public void openBrowserandNavigate() throws Exception {
		try {

			String exePath = "/opt/selenium/Chrome_Linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.get(getMyProperty.readmyFile("url"));
			
			Log.info("URL is Presented");
			
		//	driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
			Log.info("Browser is MAXIMIZED");
		} catch (Exception e) {
			e.printStackTrace();}
		}
		

	public void teardown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
