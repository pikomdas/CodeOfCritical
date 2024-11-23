package com.codeOfCritical.BaseClass;

import com.codeOfCritical.commonUtils.getProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;

/**
 * <h1>This is the base class but no class will extend it directly</h1>
 * <h2>This Class contains about the information to get started with browser instance creation</h2>
 * <h2>First it will look for current OS and Version, then it will take the input
 * from hooks for browser selection</h2>
 *
 * @author partha.das browserConfig
 * Creation date-time : 06-Dec-2018 11:24:16 PM
 */
public abstract class BrowserConfig
{
    /*
        RIP static instance of WebDriver
        //public static WebDriver driver = null;
     */
    /*
     * @param driver The driver that will be used to look up the elements
     * @param webDriverPool browser which will be initialized.
     * @param <T> Class of the PageObject
     */
    private static final Logger log = LogManager.getLogger(BrowserConfig.class.getName());
    private static final List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    /*
     * Checking OS
     */
    private static final String OS = System.getProperty("os.name").toLowerCase();
    public static ThreadLocal<WebDriver> driverThread = new InheritableThreadLocal<WebDriver>();
    public static ThreadLocal<SessionId> session = new InheritableThreadLocal<SessionId>();

    private static boolean isWindows()
    {

        return (OS.indexOf("win") >= 0);

    }

    private static boolean isMac()
    {

        return (OS.indexOf("mac") >= 0);

    }

    private static boolean isUnix()
    {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

    private static boolean isSolaris()
    {

        return (OS.indexOf("sunos") >= 0);

    }

    /**
     * <h2>Definition that uses WebDriver to drive the browser. For multiple scenario
     * execution, to maintain the driver instance unique always keep driver and
     * session ID null by default</h2>
     *
     * @param browserName which is received from @Before hooks
     */
    public synchronized WebDriver startBrowser(String browserName)
    {
        WebDriver driver = null;
        if (isWindows()) {
            if (browserName.equalsIgnoreCase("chrome")) {
                String exePath = "./src/main/java/com/codeOfCritical/BrowserDriver/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", exePath);
                ChromeOptions caps = new ChromeOptions();
                caps.addArguments("--disable-web-security");
                caps.addArguments("--no-proxy-server");
                caps.addArguments("--ignore-certificate-errors");
                caps.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                caps.setExperimentalOption("useAutomationExtension", false);

                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                // Use File.separator as it will work on any OS
                prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator
                        + "externalFiles" + File.separator + "downloadFiles");
                caps.setExperimentalOption("prefs", prefs);
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
//                caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                driver = new ChromeDriver(caps);
                session.set(((RemoteWebDriver) driver).getSessionId());
                log.info("Session ID is -----> " + session.get().toString());
                webDriverPool.add(driver);
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
                String exePath = "./src/main/java/com/codeOfCritical/browserDriver/geckodriver.exe";
                // System.setProperty("webdriver.firefox.marionette", exePath);
                System.setProperty("webdriver.gecko.driver", exePath);
                FirefoxOptions caps = new FirefoxOptions();
                caps.addArguments("--disable-web-security");
                caps.addArguments("--no-proxy-server");
                caps.setCapability("marionette", true);
                caps.setCapability("takesScreenshot", true);
                caps.setCapability("acceptInsecureCerts", true);
                driver = new FirefoxDriver(caps);
                session.set(((RemoteWebDriver) driver).getSessionId());
                log.info("Session ID is -----> " + session.get().toString());
                webDriverPool.add(driver);
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("IE")) {
                String exePath = "./src/main/java/com/codeOfCritical/browserDriver/MicrosoftWebDriver.exe";
                System.setProperty("webdriver.edge.driver", exePath);
                EdgeOptions cap = new EdgeOptions();
                cap.setPageLoadStrategy(PageLoadStrategy.valueOf("--disable-web-security"));
                cap.setPageLoadStrategy(PageLoadStrategy.valueOf("--no-proxy-server"));
                driver = new EdgeDriver(cap);
                session.set(((RemoteWebDriver) driver).getSessionId());
                log.info("Session ID is -----> " + session.get().toString());
                webDriverPool.add(driver);
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("opera")) {
                /*String exePath = "./src/main/java/com/codeOfCritical/browserDriver/operadriver.exe";
                System.setProperty("webdriver.opera.driver", exePath);
                OperaOptions caps = new OperaOptions();
                driver = new OperaDriver(caps);
                session.set(((RemoteWebDriver) driver).getSessionId());
                log.info("Session ID is -----> " + session.get().toString());
                webDriverPool.add(driver);
                driverThread.set(driver);*/
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("cloud")) {
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
                    caps.setCapability("project", "Asset Vantage Quality Controll");
                    caps.setCapability("build", getProperty.readBrowserName("BUILD"));
                    caps.setCapability("browserstack.idleTimeout", getProperty.readBrowserName("BROWSER_TIMEOUT"));

                    driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("BROWSERSTACK_URL"))), caps);
                    session.set(((RemoteWebDriver) driver).getSessionId());
                    log.info("Session ID is -----> " + session.get().toString());
                    webDriverPool.add(driver);
                    driverThread.set(driver);
                    return driverThread.get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (browserName.equalsIgnoreCase("docker")) {
                try {
                    ChromeOptions options = new ChromeOptions();
                        /*options.addArguments("window-size=" + getProperty.readBrowserName("Hub_screen_width") + ","
                                + getProperty.readBrowserName("Hub_screen_height"));*/
                    options.addArguments("--disable-web-security");
                    options.addArguments("--no-proxy-server");
                    options.addArguments("enable-features=NetworkServiceInProcess");

                    //options.addArguments("--headless");

                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setBrowserName("chrome");
                    dc.setCapability(ChromeOptions.CAPABILITY, options);
                    dc.setPlatform(Platform.LINUX);
                    dc.setJavascriptEnabled(true);

                    driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("Hub_Url"))), dc);
                    session.set(((RemoteWebDriver) driver).getSessionId());
                    log.info("Session ID is -----> " + session.get().toString());
                    webDriverPool.add(driver);
                    driverThread.set(driver);
                    return driverThread.get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (browserName.equalsIgnoreCase("docker1")) {
                try {
                    ChromeOptions options = new ChromeOptions();
                        /*options.addArguments("window-size=" + getProperty.readBrowserName("Hub_screen_width") + ","
                                + getProperty.readBrowserName("Hub_screen_height"));*/
                    options.addArguments("--disable-web-security");
                    options.addArguments("--no-proxy-server");
                    options.addArguments("enable-features=NetworkServiceInProcess");

                    //options.addArguments("--headless");

                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setBrowserName("chrome");
                    dc.setCapability(ChromeOptions.CAPABILITY, options);
                    dc.setPlatform(Platform.LINUX);
//                    dc.setJavascriptEnabled(true);

                    driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("Hub_Url1"))), dc);
                    session.set(((RemoteWebDriver) driver).getSessionId());
                    log.info("Session ID is -----> " + session.get().toString());
                    webDriverPool.add(driver);
                    driverThread.set(driver);
                    return driverThread.get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (isMac()) {
            log.info("This is Mac");
            driverThread.set(driver);
            return driverThread.get();
        }
        else if (isUnix()) {
            if (browserName.equalsIgnoreCase("chrome")) {
                String exePath = "./src/main/java/com/codeOfCritical/browserDriver/chromedriver_linux64/chromedriver";
                System.setProperty("webdriver.chrome.driver", exePath);
                ChromeOptions caps = new ChromeOptions();
                caps.addArguments("--disable-web-security");
                caps.addArguments("--no-proxy-server");
                caps.addArguments("--headless");
                caps.addArguments("--no-sandbox");

                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                // Use File.separator as it will work on any OS
                prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator
                        + "externalFiles" + File.separator + "downloadFiles");
                caps.setExperimentalOption("prefs", prefs);
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
//                caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                driver = new ChromeDriver(caps);
                session.set(((RemoteWebDriver) driver).getSessionId());
                log.info("Session ID is -----> " + session.get().toString());
                webDriverPool.add(driver);
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("firefox")) {
                String exePath = "/opt/selenium/firefoxDriver/geckodriver";
                System.setProperty("webdriver.firefox.marionette", exePath);
                driver = new FirefoxDriver();
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("IE")) {
                String exePath = "/opt/selenium/IE_driver/MicrosoftWebDriver.exe";
                System.setProperty("webdriver.edge.driver", exePath);
                driver = new EdgeDriver();
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("opera")) {
                String exePath = "/opt/selenium/opera_Linux/operadriver";
                System.setProperty("webdriver.opera.driver", exePath);
                driver = new ChromeDriver();
                driverThread.set(driver);
                return driverThread.get();
            }
            else if (browserName.equalsIgnoreCase("cloud")) {
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
                    caps.setCapability("project", "Asset Vantage Quality Controll");
                    caps.setCapability("build", getProperty.readBrowserName("BUILD"));
                    caps.setCapability("browserstack.idleTimeout", getProperty.readBrowserName("BROWSER_TIMEOUT"));

                    driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("BROWSERSTACK_URL"))), caps);
                    session.set(((RemoteWebDriver) driver).getSessionId());
                    log.info("Session ID is -----> " + session.get().toString());
                    webDriverPool.add(driver);
                    driverThread.set(driver);
                    return driverThread.get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (browserName.equalsIgnoreCase("docker")) {
                try {
                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setBrowserName("chrome");
                    dc.setPlatform(Platform.LINUX);
                    dc.setJavascriptEnabled(true);

                    driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("Hub_Url"))), dc);
                    session.set(((RemoteWebDriver) driver).getSessionId());
                    log.info("Session ID is -----> " + session.get().toString());
                    webDriverPool.add(driver);
                    driverThread.set(driver);
                    return driverThread.get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (browserName.equalsIgnoreCase("docker1")) {
                try {
                    ChromeOptions options = new ChromeOptions();
                        /*options.addArguments("window-size=" + getProperty.readBrowserName("Hub_screen_width") + ","
                                + getProperty.readBrowserName("Hub_screen_height"));*/
                    options.addArguments("--disable-web-security");
                    options.addArguments("--no-proxy-server");
                    options.addArguments("enable-features=NetworkServiceInProcess");

                    //options.addArguments("--headless");

                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setBrowserName("chrome");
                    dc.setCapability(ChromeOptions.CAPABILITY, options);
                    dc.setPlatform(Platform.LINUX);
                    dc.setJavascriptEnabled(true);

                    driver = new RemoteWebDriver(new URL((getProperty.readBrowserName("Hub_Url1"))), dc);
                    session.set(((RemoteWebDriver) driver).getSessionId());
                    log.info("Session ID is -----> " + session.get().toString());
                    webDriverPool.add(driver);
                    driverThread.set(driver);
                    return driverThread.get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        else if (isSolaris()) {
            log.info("This is Solaris");
            driverThread.set(driver);
            return driverThread.get();
        }
        else {
            log.info("Your OS is not supported, please check configuration logic.");
            driverThread.set(driver);
            return driverThread.get();
        }
        return null;
    }

    /**
     * <h1>This will close all the web pages after the completion of scenario</h1>
     *
     * @return nothing
     */
    public synchronized void quitDriver()
    {
        driverThread.get().quit();
        /*webDriverPool.stream().filter(driver -> driver != null)
                .filter(driver -> ((RemoteWebDriver) driver).getSessionId() != null).forEach(driver -> {
            if (((RemoteWebDriver) driver).getSessionId() != null)
            {
                driver.quit();
                session = null;
                log.info("Webdriver session is closed successfully.");
            } else if (((RemoteWebDriver) driver).getSessionId() == null)
            {
                driver.quit();
                log.info("Webdriver session is closed successfully while session id is null");
            } else
            {
                driver.quit();
                log.info("Webdriver session is closed forcefully");
            }
        });*/
        driverThread.remove();
    }

    /**
     * @param element
     */
    public abstract <T> void ClickOnElement(T element);

    /**
     * @param allRow
     * @return
     */
    public abstract List<List<WebElement>> handleTable(List<WebElement> allRow);

    /**
     * @param element
     * @param text
     * @return
     */
    public abstract <T, T1> void SendKeysTo(T element, T1 text);

}// End of Class
