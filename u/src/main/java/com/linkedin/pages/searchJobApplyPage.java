package com.linkedin.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.Log;
import com.linkedin.interfaces.interfaceAsaService;

public class searchJobApplyPage extends browser {

	WebDriverWait w = new WebDriverWait(driver, 5);
	interfaceAsaService Log = new Log();

	public searchJobApplyPage(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Final JOB apply selectors
	@FindBy(css = ".jobs-apply-form__upload-options-text.t-14.t-black--light.t-bold")
	WebElement resumeSelect;
	@FindBy(css = ".jobs-apply-form__recent-resume.display-flex.align-items-center")
	WebElement selectAttachedResume;
	@FindBy(xpath = "//button[starts-with(@class,'jobs-apply-form__submit-button button-primary-large ')]")
	WebElement submitApplicationButton;
	// Selecting a particular job link and company name etc
	@FindBy(xpath = "//button[starts-with(@class,'jobs-candidate-initiate-referral__referral-button button-tertiary-large full-width')]")
	WebElement askForAReferral;
	@FindAll({ @FindBy(css = ".job-card-search__title-line") })
	List<WebElement> jobName;
	@FindAll({ @FindBy(css = ".job-card-search__company-name") })
	List<WebElement> cmpanyName;
	// Apply buttons on page
	@FindBy(css = ".jobs-apply-button--top-card.artdeco-button--3.jobs-apply-button.artdeco-button.ember-view")
	WebElement easyApplyButton;
	@FindBy(css = ".jobs-apply-button--top-card.artdeco-button--3.jobs-apply-button.artdeco-button.ember-view")
	WebElement ApplyButton;
	@FindBy(css = ".artdeco-inline-feedback__message")
	WebElement messageWhereApplynotPossible;

	public final WebElement getMessageWhereApplynotPossible() {
		return messageWhereApplynotPossible;
	}

	public final void setMessageWhereApplynotPossible(WebElement messageWhereApplynotPossible) {
		this.messageWhereApplynotPossible = messageWhereApplynotPossible;
	}

	public final WebElement getSelectAttachedResume() {
		return selectAttachedResume;
	}

	public final void setSelectAttachedResume(WebElement selectAttachedResume) {
		this.selectAttachedResume = selectAttachedResume;
	}

	public final WebElement getResumeSelect() {
		return resumeSelect;
	}

	public final WebElement getSubmitApplicationButton() {
		return submitApplicationButton;
	}

	public final WebElement getAskForAReferral() {
		return askForAReferral;
	}

	public final List<WebElement> getJobName() {
		return jobName;
	}

	public final List<WebElement> getCmpanyName() {
		return cmpanyName;
	}

	public final WebElement getEasyApplyButton() {
		return easyApplyButton;
	}

	public final WebElement getApplyButton() {
		return ApplyButton;
	}

	public final void setResumeSelect(WebElement resumeSelect) {
		this.resumeSelect = resumeSelect;
	}

	public final void setSubmitApplicationButton(WebElement submitApplicationButton) {
		this.submitApplicationButton = submitApplicationButton;
	}

	public final void setAskForAReferral(WebElement askForAReferral) {
		this.askForAReferral = askForAReferral;
	}

	public final void setJobName(List<WebElement> jobName) {
		this.jobName = jobName;
	}

	public final void setCmpanyName(List<WebElement> cmpanyName) {
		this.cmpanyName = cmpanyName;
	}

	public final void setEasyApplyButton(WebElement easyApplyButton) {
		this.easyApplyButton = easyApplyButton;
	}

	public final void setApplyButton(WebElement applyButton) {
		ApplyButton = applyButton;
	}

	public void clickOnJoblink() {
		int jobApplyNumber = 0;
		for (WebElement e : getJobName()) {
			for (WebElement f : getCmpanyName()) {
				// w.until(ExpectedConditions.elementToBeClickable(e));
				System.out.println("Company name is: " + e.getText().toString());
				e.click();
				Log.info("Clicked on Job --- Location on Page :     " + e.getLocation());
				// w.until(ExpectedConditions.visibilityOf(f));
				System.out.println("Job  Title is : " + f.getText().toString());
				Log.info("Company name is : " + f.getText());
				// Click on easy apply
				clickonEasyApply();

				jobApplyNumber = jobApplyNumber + 1;
				Log.info("Completed One Job Apply." + jobApplyNumber);
				break;
			}
		}
	}

	// Navigate Back
	public void navigateBack() {

		String prvPage = driver.getTitle();
		driver.navigate().back();
		String curPage = driver.getTitle();
		System.out.println(prvPage + "is currentpage and navigated back to " + curPage);
		Log.info(prvPage + "is currentpage and navigated back to " + curPage);

	}

	// Click on Easy Apply
	public void clickonEasyApply() {
		try {
			if (getEasyApplyButton().isDisplayed() && !getApplyButton().isDisplayed()) {
				System.out.println("Button is displayed: " + getEasyApplyButton().getText());
				getEasyApplyButton().click();
				Log.info("clicked on " + getEasyApplyButton().getText());
				submitApplication();
			} else if (!getEasyApplyButton().isDisplayed() && getApplyButton().isDisplayed()) {
				String currentWindowHandle = driver.getWindowHandle();
				getApplyButton().click();
				Set<String> allWindowHandles = driver.getWindowHandles();
				for (String window : allWindowHandles) {
					if (!window.equalsIgnoreCase(currentWindowHandle)) {
						driver.switchTo().window(currentWindowHandle);
					}
				}
			} else if (!getEasyApplyButton().isDisplayed() && !getApplyButton().isDisplayed()) {
				String mesage = getMessageWhereApplynotPossible().getText().toString();
				Log.info(mesage);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// SUbmit Application pop-up
	public void submitApplication() {
		getResumeSelect().click();
		getSelectAttachedResume().click();
		getSubmitApplicationButton().click();
	}

} // end of class