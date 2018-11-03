package com.Naukri.PageObjectClasses;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Naukri.FileReaderManager.Log;
import com.naukri.BrowserBase.browser;

public class JobDetailsToApplyPage extends browser {

	WebDriverWait w2 = new WebDriverWait(driver, 10);

	public JobDetailsToApplyPage(WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[id*='trig1']")
	WebElement JobApplyButton;
	@FindBy(xpath = "//*[@id='qupSubmit']")
	WebElement updateProfileButton;

	protected WebElement getUpdateProfileButton() {
		return updateProfileButton;
	}

	protected void setUpdateProfileButton(WebElement updateProfileButton) {
		this.updateProfileButton = updateProfileButton;
	}

	protected WebElement getJobApplyButton() {
		return JobApplyButton;
	}

	protected void setJobApplyButton(WebElement jobApplyButton) {
		JobApplyButton = jobApplyButton;
	}

	public void appyTheJob() {
		System.out.println("Navigated to Job page Name: " + driver.getTitle());

		try {
			w2.until(ExpectedConditions.elementToBeClickable(getJobApplyButton()));
			if (getJobApplyButton().isDisplayed()) 
			{
				System.out.println("Blue Color Apply button is dispayed : " + getJobApplyButton().getText());
				Actions action = new Actions(driver);
				action.moveToElement(getJobApplyButton()).click().perform();
				Log.info("Apply button clicked on postion : " + getJobApplyButton().getLocation().getX()
						+ getJobApplyButton().getLocation().getY());

				// Finally Apply on Quickly Review and update your Profile
				if (getUpdateProfileButton().isDisplayed()) {
					System.out.print("update carieer pop-up displayed");
					getUpdateProfileButton().click();
				}
				driver.close();
				Thread.sleep(2000);
			} else {
				System.out.println("Job Apply blue colored button not found");
				driver.close(); // Closing the tab where apply not possible
				Thread.sleep(2000);
			}
		} catch (ElementNotVisibleException e) {
			e.getMessage();
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

}// End of class
