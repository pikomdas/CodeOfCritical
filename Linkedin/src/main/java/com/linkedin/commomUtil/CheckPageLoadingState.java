/**
 * 
 */
package com.linkedin.commomUtil;

import com.linkedin.Browser.browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author partha.das
 *
 */
public class CheckPageLoadingState extends browser
{
	private static Logger log = LogManager.getLogger(CheckPageLoadingState.class.getName());
	private static int count = 1;

	private static String getState()
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		String state = (String) je.executeScript("return document.readyState;");
		return state;
	}

	private enum PageStates
	{
		uninitialized, loading, loaded, interactive, complete
	}

	@SuppressWarnings("unlikely-arg-type")
	private static boolean isPageLoaded()
	{
		if (getState().equals(PageStates.complete))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void waitToLoadPage()
	{
		if (isPageLoaded())
		{
			log.info("Page load completed");
			count = 1;
		}
		else
		{
			try
			{
				Thread.sleep(1000);
				log.warn("Waiting for the page to be loaded " + count + " time");
				count++;
				if (count <= 3)
				{
					waitToLoadPage();
				}
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count=1;

		}
	}
}
