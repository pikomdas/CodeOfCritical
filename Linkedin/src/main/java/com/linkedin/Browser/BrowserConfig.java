package com.linkedin.Browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.File;
import java.util.*;
import java.util.logging.Level;

public abstract class BrowserConfig {
	private static Logger log = LogManager.getLogger(BrowserConfig.class.getName());
	public static WebDriver driver;
	private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
	@SuppressWarnings("unused")
	private static ThreadLocal<WebDriver> driverThread;
	public static SessionId session;

	private static String OS = System.getProperty("os.name").toLowerCase();

	private static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	private static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	private static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

	private static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

	public static String getBrowserName() {
		Scanner browserName = new Scanner(System.in);
		log.info("Select Browser : ");
		String br = browserName.nextLine();
		browserName.close();
		return br;
	}

	public static void selectBrowserToExecute(String browserName) {

		log.info("Current OS has been detected as : " + OS);

		if (isWindows())
		{
			if (driver == null && session == null)
			{
				if (browserName.equalsIgnoreCase("chrome"))
				{
					String exePath = "./src/main/java/com/linkedin/BrowserDriver/chromedriver.exe";
					System.setProperty("webdriver.chrome.driver", exePath);
					ChromeOptions caps = new ChromeOptions();
					caps.addArguments("--disable-web-security");
					caps.addArguments("--no-proxy-server");

					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					// Use File.separator as it will work on any OS
					prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator
							+ "externalFiles" + File.separator + "downloadFiles");
					caps.setExperimentalOption("prefs", prefs);
					LoggingPreferences logPrefs = new LoggingPreferences();
					logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
					caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
					driver = new ChromeDriver(caps);
					session = ((RemoteWebDriver) driver).getSessionId();
					log.info("Session ID is -----> " + session.toString());
					webDriverPool.add(driver);
				}
				else if (browserName.equalsIgnoreCase("firefox"))
				{
					String exePath = "./src/main/java/com/linkedin/BrowserDriver/geckodriver.exe";
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
					log.info("Session ID is -----> " + session.toString());
					webDriverPool.add(driver);
				}
				else if (browserName.equalsIgnoreCase("IE"))
				{
					String exePath = "./src/main/java/com/linkedin/BrowserDriver/MicrosoftWebDriver.exe";
					System.setProperty("webdriver.edge.driver", exePath);
					EdgeOptions cap = new EdgeOptions();
					cap.setPageLoadStrategy("--disable-web-security");
					cap.setPageLoadStrategy("--no-proxy-server");
					driver = new EdgeDriver(cap);
					session = ((RemoteWebDriver) driver).getSessionId();
					log.info("Session ID is -----> " + session.toString());
					webDriverPool.add(driver);
				}
				else if (browserName.equalsIgnoreCase("opera"))
				{
					String exePath = "./src/main/java/com/linkedin/BrowserDriver/operadriver.exe";
					System.setProperty("webdriver.opera.driver", exePath);
					OperaOptions caps = new OperaOptions();
					driver = new OperaDriver(caps);
					session = ((RemoteWebDriver) driver).getSessionId();
					log.info("Session ID is -----> " + session.toString());
					webDriverPool.add(driver);
				}
			}
		}
		else if (isMac())
		{
			log.info("This is Mac");
		}
		else if (isUnix())
		{
			if (driver == null && session == null)
			{
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
					prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator
							+ "externalFiles" + File.separator + "downloadFiles");
					caps.setExperimentalOption("prefs", prefs);
					LoggingPreferences logPrefs = new LoggingPreferences();
					logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
					caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
					driver = new ChromeDriver(caps);
					session = ((RemoteWebDriver) driver).getSessionId();
					log.info("Session ID is -----> " + session.toString());
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
		}
		else if (isSolaris())
		{
			log.info("This is Solaris");
		}
		else
		{
			log.info("Your OS is not support!!");
		}

	}

	/**
	 * @param element
	 */
	public abstract <T> void ClickOnElement(T element);

	/**
	 * @param element
	 * @param text
	 * @return 
	 */
	public abstract <T, T1> void SendKeysTo(T element, T1 text);

	public abstract <T, T1> void DropdownSelect(T element, T1 text);

	public abstract <T, T1> void ExactDropdownSelect(T element, T1 text);
}// End of Class
