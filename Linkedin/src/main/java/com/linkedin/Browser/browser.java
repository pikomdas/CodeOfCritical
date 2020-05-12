package com.linkedin.Browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.commomUtil.getMyProperty;

public class browser extends BrowserConfig
{

	public static Properties prop;
	File file;
	FileInputStream fileInput;
	private static Logger log = LogManager.getLogger(browser.class.getName());
	private static WebDriverWait w1;
	private int exceptionCount = 0;

	// TEST PASSED
	public void openBrowserandNavigate() throws Exception
	{
		try
		{

			selectBrowserToExecute("chrome");
			driver.get(getMyProperty.readmyFile("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			log.info("URL is Presented");

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			log.info("Browser is MAXIMIZED");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void teardown()
	{
		if(driver != null)
		{
			driver.quit();
			log.info("Browser Closed");
		}

	}

	@Override
	public <T, T1> void DropdownSelect(T element, T1 text)
	{
		if(((WebElement) element).getTagName() != null)
		{
			w1 = new WebDriverWait(driver, 20);
			w1.until(
					ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
			Select select = new Select((WebElement) element);
			List<WebElement> allDropDownOptions = select.getOptions();
			try
			{
				select.deselectAll();
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
			for (WebElement e : allDropDownOptions)
			{
				if(e.getText().contains((String) text))
				{
					select.selectByVisibleText(e.getText());
					break;
				}
			}
		}
		else
		{
			throw new Error(String.format(
					"Unable to Select DropDown %s value from List because element is not displayed", ((String) text)));
		}
	}

	/**
	 * This method is liable to handle dropdown through Select Class This method
	 * will be shared among all classes
	 * 
	 * @return
	 */
	@Override
	public <T, T1> void ExactDropdownSelect(T element, T1 text)
	{
		if(((WebElement) element).getTagName() != null)
		{
			w1 = new WebDriverWait(driver, 20);
			w1.until(
					ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
			Select select = new Select((WebElement) element);
			List<WebElement> allDropDownOptions = select.getOptions();
			try
			{
				select.deselectAll();
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
			for (WebElement e : allDropDownOptions)
			{
				if(e.getText().equalsIgnoreCase((String) text))
				{
					select.selectByVisibleText(e.getText());
					break;
				}
			}
		}
		else
		{
			throw new Error(String.format(
					"Unable to Select DropDown %s value from List because element is not displayed", ((String) text)));
		}
	}

	/**
	 * This method will CLICK on element
	 */
	@Override
	public <T> void ClickOnElement(T element)
	{
		try
		{
			w1 = new WebDriverWait(driver, 10);
			w1.until(ExpectedConditions.visibilityOf(((WebElement) element)));

			if(((WebElement) element).isDisplayed())
			{
				w1 = new WebDriverWait(driver, 10);
				w1.until(ExpectedConditions.elementToBeClickable(((WebElement) element)));
				((WebElement) element).click();
				// new ScrollAndHighlight(((WebElement) element));
			}
			else
			{
				throw new Exception("Unable to Click on Element because element is not displayed");
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());

			if(e instanceof StaleElementReferenceException)
			{
				if(exceptionCount < 3)
				{
					exceptionCount++;
					log.warn(e.getMessage());
					ClickOnElement(element);
				}
			}
			else if(e.getCause() instanceof NoSuchElementException)
			{
				throw new Error("script breaked because of wrong element");
			}
			else
			{
				e.printStackTrace();
			}

		}
		exceptionCount = 0;
	}

	/**
	 * This method will clear the text box and send keys
	 */
	@Override
	public <T, T1> void SendKeysTo(T element, T1 text)
	{
		w1 = new WebDriverWait(driver, 20);
		w1.until(ExpectedConditions.visibilityOf((WebElement) element));
		if(((WebElement) element).isDisplayed())
		{
			((WebElement) element).clear();
			((WebElement) element).sendKeys((String) text);

		}
		else
		{
			throw new Error(String.format("Unable to Enter text %s to text box because element is not displayed",
					((String) text)));
		}

	}

	public void navigateAndHighLight(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

}
