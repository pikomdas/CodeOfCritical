package com.Naukri.PageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Naukri.BrowserBase.browser;

public class JobDetailsToApplyPage extends browser {

	private static final Logger log = LogManager.getLogger(JobSearchResultPage.class.getName());

	WebDriverWait w2;

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
		log.info("Navigated to Job page Name: " + driver.getTitle());
		try {
			w2 = new WebDriverWait(driver, 10);
			// w2.until(ExpectedConditions.elementToBeClickable(getJobApplyButton()));
			if (w2.until(ExpectedConditions.textToBe(By.id("trig1"), "Apply"))) {
				log.info("Blue Color Apply button is dispayed : " + getJobApplyButton().getText());
				Actions action = new Actions(driver);
				action.moveToElement(getJobApplyButton()).click().perform();
				log.info("Apply button clicked on postion : " + getJobApplyButton().getLocation().getX()
						+ getJobApplyButton().getLocation().getY());

				// Finally Apply on Quickly Review and update your Profile
				if (getUpdateProfileButton().isDisplayed()) {
					log.info("update carieer pop-up displayed");
					getUpdateProfileButton().click();
				}
				Thread.sleep(3000);
				driver.close();
			} else {
				log.info("Job Apply blue colored button not found");
				Thread.sleep(3000);
				driver.close(); // Closing the tab where apply not possible
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}// End of class
