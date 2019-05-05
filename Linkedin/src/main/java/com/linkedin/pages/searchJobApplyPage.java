package com.linkedin.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.Log;
import com.linkedin.commomUtil.screenshotCapture;
import com.linkedin.interfaces.interfaceAsaService;

public class searchJobApplyPage extends browser {

	WebDriverWait w = new WebDriverWait(driver, 5);
	interfaceAsaService Log = new Log();
	interfaceAsaService screenShot = new screenshotCapture();

	public searchJobApplyPage(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Final JOB apply selectors
	@FindBy(xpath = "//*[@id='jobs-file-upload']/div/button")
	WebElement resumeSelect;
	@FindBy(xpath = "//*[contains(@id,'ember')]/ul/li[4]/div[1]/button")
	WebElement selectAttachedResume;
	@FindBy(xpath = "//button[starts-with(@class,'jobs-apply-form__submit-button button-primary-large ')]")
	WebElement submitApplicationButton;
	// Selecting a particular job link and company name etc
	@FindBy(xpath = "//button[starts-with(@class,'jobs-candidate-initiate-referral__referral-button button-tertiary-large full-width')]")
	WebElement askForAReferral;
	@FindAll({
			@FindBy(xpath = "//*[@class='jobs-search-results__list artdeco-list artdeco-list--offset-4']/li/div/artdeco-entity-lockup/artdeco-entity-lockup-content/h3[1]") })
	List<WebElement> jobName;
	@FindAll({ @FindBy(css = ".job-card-search__company-name-link.ember-view") })
	List<WebElement> cmpanyName;
	// Apply buttons on page
	@FindBy(xpath = "//*[@class='jobs-apply-button__text' and text()='Easy Apply']")
	WebElement easyApplyButton;
	@FindBy(css = ".jobs-apply-button--top-card.artdeco-button--3.jobs-apply-button.artdeco-button.ember-view")
	WebElement ApplyButton;
	@FindBy(css = ".artdeco-inline-feedback__message")
	WebElement messageWhereApplynotPossible;
	@FindBy(css = "//*[@class='continue-btn' and text()='Submit']")
	WebElement submitButtonNewWindow;

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

	public final WebElement getSubmitButtonNewWindow() {
		return submitButtonNewWindow;
	}

	public final void setSubmitButtonNewWindow(WebElement submitButtonNewWindow) {
		this.submitButtonNewWindow = submitButtonNewWindow;
	}

	public void clickOnJoblink() throws Throwable {
		int jobApplyNumber = 0;
		for (WebElement e : getJobName()) {
			w.until(ExpectedConditions.elementToBeClickable(e));
			System.out.println("Job Title is: " + e.getText().toString());
			e.click();
			w.until(ExpectedConditions.visibilityOf(getCmpanyName().get(jobApplyNumber)));
			System.out.println("Company name is: " + getCmpanyName().get(jobApplyNumber).getText());
			Log.info("Company name is : " + getCmpanyName().get(jobApplyNumber).getText().toUpperCase());
			// Click on easy apply
			clickonEasyApply();
			jobApplyNumber = jobApplyNumber + 1;
			Log.info("Completed Job Apply and count is -------------- " + jobApplyNumber);
		}
	}

//	public void clickOnJoblink() throws Throwable {
//		int jobApplyNumber = 0;
//		label: for (WebElement e : getJobName()) {
//			w.until(ExpectedConditions.elementToBeClickable(e));
//			System.out.println("Job Title is: " + e.getText().toString());
//			e.click();
//			// Log.info("Clicked on Job continue;--- Location on Page : " +
//			// e.getLocation());
//			for (WebElement f : getCmpanyName()) {
//				w.until(ExpectedConditions.visibilityOf(f));
//				System.out.println("Company name is: " + f.getText().toString());
//				Log.info("Company name is : " + f.getText());
//				// Click on easy apply
//				clickonEasyApply();
//				jobApplyNumber = jobApplyNumber + 1;
//				Log.info("Completed Job Apply and count is -------------- " + jobApplyNumber);
//				if (jobApplyNumber - 1 == getCmpanyName().indexOf(e)) {
//					continue label;
//				}
//
//			}
//		}
//	}

	// Navigate Back
	public void navigateBack() {

		String prvPage = driver.getTitle();
		driver.navigate().back();
		String curPage = driver.getTitle();
		System.out.println(prvPage + "is currentpage and navigated back to " + curPage);
		Log.info(prvPage + "is currentpage and navigated back to " + curPage);

	}

	// Click on Easy Apply
	public void clickonEasyApply() throws Throwable {
		String originWindow=driver.getWindowHandle();
		try {
			if (getEasyApplyButton().isDisplayed()) {
				getEasyApplyButton().click();
				if(driver.getWindowHandle()!=originWindow) {
					getSubmitApplicationButton().click();
				}else {
					submitApplication();
				}
				
			} else {
				Log.error("Easy Apply Failed");
				if (getApplyButton().getText() == "Apply") {
					getApplyButton().click();
					Log.info("Apply Button is available");
				} else {
					Log.error("Apply Button is not available");
					Log.info(getMessageWhereApplynotPossible().getText());
				}
			}
		} catch (Exception e) {
			Log.error("Execution  error");

		}
	}

	// SUbmit Application pop-up
	public void submitApplication() throws Exception {
		WebDriverWait w = new WebDriverWait(driver, 20);

		w.until(ExpectedConditions.elementToBeClickable(getResumeSelect()));
		Actions act = new Actions(driver);
		act.moveToElement(getResumeSelect()).perform();
		act.click();
		Log.info("Clicked on " + getResumeSelect().getText());

		w.until(ExpectedConditions.elementToBeClickable(getSelectAttachedResume()));
		getSelectAttachedResume().click();
		Log.info("Selected resume name is " + getSelectAttachedResume().getText());
		screenShot.takeScreenShotofCurrentpage();

		getSubmitApplicationButton().click();
		Log.info("Job Application Submitted.");
	}

} // end of class