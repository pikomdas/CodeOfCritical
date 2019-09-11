package com.linkedin.Browser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class BrowserConfig
{
	public static WebDriver driver;
	private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
	@SuppressWarnings("unused")
	private static ThreadLocal<WebDriver> driverThread;
	public static SessionId session;

	public static String getBrowserName() {
		Scanner browserName = new Scanner(System.in);
		System.out.println("Select Browser : ");
		String br = browserName.nextLine();
		browserName.close();
		return br;
	}

	public static void selectBrowserToExecute(String browserName) {
		if (browserName.equalsIgnoreCase("chrome"))
		{
			String exePath = "/opt/selenium/Chrome_Linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			ChromeOptions caps = new ChromeOptions();
			caps.addArguments("--disable-web-security");
			caps.addArguments("--no-proxy-server");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			// Use File.separator as it will work on any OS
			prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles"
					+ File.separator + "downloadFiles");
			caps.setExperimentalOption("prefs", prefs);
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
			caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			driver = new ChromeDriver(caps);
			session = ((RemoteWebDriver) driver).getSessionId();
			System.out.println("Session ID is -----> " + session.toString());
			webDriverPool.add(driver);

		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			String exePath = "/opt/selenium/firefoxDriver/geckodriver";
			System.setProperty("webdriver.firefox.marionette", exePath);
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			String exePath = "/opt/selenium/IE_driver/MicrosoftWebDriver.exe";
			System.setProperty("webdriver.edge.driver", exePath);
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("opera"))
		{
			String exePath = "/opt/selenium/opera_Linux/operadriver";
			System.setProperty("webdriver.opera.driver", exePath);
			driver = new ChromeDriver();

		}
	}
}// End of Class
