/**
 * 
 */
package LINKEDIN;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import com.linkedin.Browser.BrowserConfig;

/**
 * @author partha.das
 *
 */
public abstract class ScrollTest extends BrowserConfig
{
	public static void main(String[] args) throws InterruptedException
	{
		BrowserConfig.selectBrowserToExecute("chrome");
		driver.get("https://www.w3schools.com/js/default.asp");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		for (int i = 0; i < 10; i++)
//		{
			Thread.sleep(2000);
			js.executeScript("window.scroll(0,document.body.scrollHeight);");
			
			//js.executeScript("window.scroll(document.body.scrollHeight,0);");
//		}
	}
}
