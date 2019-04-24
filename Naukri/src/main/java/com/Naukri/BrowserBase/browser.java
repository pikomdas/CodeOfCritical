package com.Naukri.BrowserBase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.Naukri.utility.configFiles.getProperty;

public class browser {

	public static WebDriver driver;
	private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
	@SuppressWarnings("unused")
	private static ThreadLocal<WebDriver> driverThread;
	public static SessionId session;

	public void selectBrowser(String browserName) {
		if (driver == null && session == null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				String exePath = "/opt/selenium/Chrome_Linux/chromedriver";
				System.setProperty("webdriver.chrome.driver", exePath);
				ChromeOptions caps = new ChromeOptions();
				caps.addArguments("--disable-web-security");
				caps.addArguments("--no-proxy-server");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				caps.setExperimentalOption("prefs", prefs);
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
				caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				driver = new ChromeDriver(caps);
				session = ((RemoteWebDriver) driver).getSessionId();
				System.out.println("Session ID is -----> " + session.toString());
				webDriverPool.add(driver);
				
			} else if (browserName.equalsIgnoreCase("firefox")) {
				String exePath = "../src/main/java/com/assetvantage/browserDriver/geckodriver.exe";
				// System.setProperty("webdriver.firefox.marionette", exePath);
				System.setProperty("webdriver.gecko.driver", exePath);
				FirefoxOptions caps = new FirefoxOptions();
				caps.addArguments("--disable-web-security");
				caps.addArguments("--no-proxy-server");
				caps.setCapability("marionette", true);
				caps.setCapability("takesScreenshot", true);
				caps.setCapability("acceptInsecureCerts", true);
				driver = new FirefoxDriver(caps);
				session = ((RemoteWebDriver) driver).getSessionId();
				System.out.println("Session ID is -----> " + session.toString());
				webDriverPool.add(driver);
				
			} else if (browserName.equalsIgnoreCase("IE")) {
				String exePath = "../src/main/java/com/assetvantage/browserDriver/MicrosoftWebDriver.exe";
				System.setProperty("webdriver.edge.driver", exePath);
				EdgeOptions cap = new EdgeOptions();
				cap.setPageLoadStrategy("--disable-web-security");
				cap.setPageLoadStrategy("--no-proxy-server");
				driver = new EdgeDriver(cap);
				session = ((RemoteWebDriver) driver).getSessionId();
				System.out.println("Session ID is -----> " + session.toString());
				webDriverPool.add(driver);
				
			} else if (browserName.equalsIgnoreCase("opera")) {
				String exePath = "./src/main/java/com/assetvantage/browserDriver/operadriver.exe";
				System.setProperty("webdriver.opera.driver", exePath);
				OperaOptions caps = new OperaOptions();
				driver = new OperaDriver(caps);
				session = ((RemoteWebDriver) driver).getSessionId();
				System.out.println("Session ID is -----> " + session.toString());
				webDriverPool.add(driver);
				
			} else if (browserName.equalsIgnoreCase("cloud")) {
				try {
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability("os", getProperty.readBrowserName("OS"));
					caps.setCapability("os_version", getProperty.readBrowserName("OS_VERSION"));
					caps.setCapability("browser", getProperty.readBrowserName("BROWSER"));
					caps.setCapability("browser_version", getProperty.readBrowserName("BROWSER_VERSION"));
					caps.setCapability("resolution", getProperty.readBrowserName("RESOLUTION"));
					caps.setCapability("browserstack.local", getProperty.readBrowserName("browserstack_local"));
					caps.setCapability("browserstack.selenium_version",
							getProperty.readBrowserName("browserstack_selenium_version"));

					// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
					driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("BROWSERSTACK_URL"))), caps);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			driver = null;
			session = null;
			selectBrowser(browserName);
		}
	}

	public static void quitDriver() {
		webDriverPool.stream().filter(driver -> driver != null).forEach(driver -> {
			if (((RemoteWebDriver) driver).getSessionId() != null) {
				driver.quit();
				session = null;
			} else if (((RemoteWebDriver) driver).getSessionId() == null) {
				driver.quit();
			}
		});
		driverThread = null;
	}
}