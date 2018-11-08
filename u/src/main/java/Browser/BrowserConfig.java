package Browser;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

	public static WebDriver driver;

	public static String getBrowserName() {
		Scanner browserName = new Scanner(System.in);
		System.out.println("Select Browser : ");
		String br = browserName.nextLine();
		browserName.close();
		return br;
	}

	public static void selectBrowserToExecute(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			String exePath = "/opt/selenium/Chrome_Linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			String exePath = "/opt/selenium/firefoxDriver/geckodriver";
			System.setProperty("webdriver.firefox.marionette", exePath);
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			String exePath = "/opt/selenium/IE_driver/MicrosoftWebDriver.exe";
			System.setProperty("webdriver.edge.driver", exePath);
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("opera")) {
			String exePath = "/opt/selenium/opera_Linux/operadriver";
			System.setProperty("webdriver.opera.driver", exePath);
			driver = new ChromeDriver();
		}
	}
}// End of Class
