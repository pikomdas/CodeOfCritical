package com.Naukri.PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukri.BrowserBase.browser;

public class JobDetailsToApplyPage extends browser {

	WebDriverWait w2 = new WebDriverWait(driver, 10);

	public JobDetailsToApplyPage(WebDriver driver) {
		this.driver = driver;
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
			// driver.findElement(By.cssSelector("ul.listing.mt10.wb")).getText();
			// By buttonSelector = By.cssSelector("[id*='trig1']");
			// WebElement jobApply =
			// w1.until(ExpectedConditions.visibilityOfElementLocated(buttonSelector));
			w2.until(ExpectedConditions.elementToBeClickable(getJobApplyButton()));
			if (getJobApplyButton().isDisplayed() == true) {
				System.out.println("Blue Color Apply button is dispayed : " + getJobApplyButton().getText());
				Actions action = new Actions(driver);
				action.moveToElement(getJobApplyButton()).click().perform();
				System.out.println(getJobApplyButton().getText());
				// Finally Apply on Quickly Review and update your Profile
				getUpdateProfileButton().click();
				driver.close();
			} else {
				System.out.println("Job Apply blue colored button not found");
				driver.close(); // Closing the tab where apply not possible
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}// End of class
