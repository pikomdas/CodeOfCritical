package com.linkedin.Browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	// TEST PASSED
	public void openBrowserandNavigate() throws Exception {
		try
		{

			BrowserConfig.selectBrowserToExecute("chrome");
			driver.get(getMyProperty.readmyFile("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			log.info("URL is Presented");

			// driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			log.info("Browser is MAXIMIZED");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void teardown() {
		if (driver != null)
		{
			driver.quit();
			log.info("Browser Closed");
		}

	}

	@Override
	public <T, T1> void DropdownSelect(T element, T1 text) {
		if (((WebElement) element).getTagName() != null)
		{
			w1 = new WebDriverWait(driver, 20);
			w1.until(
					ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
			Select select = new Select((WebElement) element);
			List<WebElement> allDropDownOptions = select.getOptions();
			try
			{
				select.deselectAll();
			}
			catch (Exception e)
			{
				log.error(e.getMessage());
			}
			for (WebElement e : allDropDownOptions)
			{
				if (e.getText().contains((String) text))
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
	public <T, T1> void ExactDropdownSelect(T element, T1 text) {
		if (((WebElement) element).getTagName() != null)
		{
			w1 = new WebDriverWait(driver, 20);
			w1.until(
					ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
			Select select = new Select((WebElement) element);
			List<WebElement> allDropDownOptions = select.getOptions();
			try
			{
				select.deselectAll();
			}
			catch (Exception e)
			{
				log.error(e.getMessage());
			}
			for (WebElement e : allDropDownOptions)
			{
				if (e.getText().equalsIgnoreCase((String) text))
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
	public <T, T1> void ClickOnElement(T element) {
		if (((WebElement) element).isDisplayed())
		{
			w1 = new WebDriverWait(driver, 10);
			w1.until(ExpectedConditions.elementToBeClickable(((WebElement) element)));
			((WebElement) element).click();
			// new ScrollAndHighlight(((WebElement) element));
		}
		else
		{
			throw new Error("Unable to Click on Element because element is not displayed");
		}
	}

	/**
	 * This method will clear the text box and send keys
	 */
	@Override
	public <T, T1> void SendKeysTo(T element, T1 text) {
		if (((WebElement) element).isDisplayed())
		{
			//new ScrollAndHighlight(((WebElement) element));
			((WebElement) element).clear();
			((WebElement) element).sendKeys((String) text);

		}
		else
		{
			throw new Error(String.format("Unable to Enter text %s to text box because element is not displayed",
					((String) text)));
		}
	}

	//	/**
	//	 * This method will handle the dynamic table All rows LIST need to be provided
	//	 * and return sorted List of List WebElement will be returned (non-Javadoc)
	//	 * 
	//	 * @see com.assetvantage.baseClass.browserConfig#handleTable(java.util.List)
	//	 * 
	//	 */
	//	@Override
	//	public List<List<WebElement>> handleTable(List<WebElement> allrow) {
	//		List<List<WebElement>> returnColumns = new ArrayList<List<WebElement>>();
	//		for (WebElement eachRow : allrow)
	//		{
	//			List<WebElement> eachColumnForOneRow = eachRow.findElements(By.tagName("td"));
	//			returnColumns.add(eachColumnForOneRow);
	//			// eachColumnForOneRow.clear();
	//		}
	//		Collections.sort(returnColumns, new Comparator<List<WebElement>>()
	//		{
	//
	//			@Override
	//			public int compare(List<WebElement> o1, List<WebElement> o2) {
	//				// TODO Auto-generated method stub
	//				return o1.hashCode() - o2.hashCode();
	//			}
	//
	//		});
	//
	//		Collections.reverse(returnColumns);
	//		return returnColumns;
	//	}
}
