package src.main.java.com.linkedin.commomUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.linkedin.Browser.browser;

/**
 * @author partha.das
 *
 */
public class ScrollAndHighlight extends browser
{

	public ScrollAndHighlight(WebElement[] element)
	{
		for (WebElement e : element)
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(e);
			actions.perform();
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style', 'background: yellow; border: 1px solidred;');", e);
		}

	}

	public ScrollAndHighlight(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: #FFFF00; border: 3px solid #000000;');", element);

	}
}
