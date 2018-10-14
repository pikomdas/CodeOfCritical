package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {

	public static String browserName="chrome";
	static WebDriver driver=null;
	public static void selectBrowserToExecute(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			String exePath = "/opt/selenium/Chrome_Linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
		}
        else if(browserName.equalsIgnoreCase("IE")) {
			
		}
        else if(browserName.equalsIgnoreCase("safari")) {
	
        }
	}
}// End of Class
