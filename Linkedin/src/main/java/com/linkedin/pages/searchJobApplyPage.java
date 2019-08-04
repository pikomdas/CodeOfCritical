package com.linkedin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class searchJobApplyPage extends browser
{

	WebDriverWait w = new WebDriverWait(driver, 5);
	interfaceAsaService Log = new Log();
	interfaceAsaService screenShot = new screenshotCapture();

	// Constructor with parameter
	public searchJobApplyPage(final WebDriver driver)
	{
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 * LOCATORS
	 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */
	// Final JOB apply selectors
	@FindBy(xpath = "//*[@id='jobs-file-upload']/div/button")
	private WebElement resumeSelect;
	@FindBy(xpath = "//*[contains(@id,'ember')]/ul/li[4]/div[1]/button")
	private WebElement selectAttachedResume;
	@FindBy(xpath = "//*[text()='Submit application']")
	private WebElement submitApplicationButton;
	// Selecting a particular job link and company name etc
	@FindBy(
			xpath = "//button[starts-with(@class,'jobs-candidate-initiate-referral__referral-button button-tertiary-large full-width')]"
	)
	private WebElement askForAReferral;
	@FindAll(
		{ @FindBy(
				xpath = "//*[@class='jobs-search-results__list artdeco-list']/li/div/artdeco-entity-lockup/artdeco-entity-lockup-content/h3"
		) }
	)
	private List<WebElement> jobName;
	@FindAll(
		{ @FindBy(css = ".job-card-search__company-name.t-14.t-black.artdeco-entity-lockup__subtitle.ember-view") }
	)
	private List<WebElement> cmpanyName;
	// Apply or Easy Apply buttons common Xpath on page
	@FindBy(xpath = "//*[@class='jobs-details-top-card__actions mt4 display-flex align-items-center']/div[3]/button]")
	private WebElement easyApplyORApplyButton;

	@FindBy(css = ".artdeco-inline-feedback__message")
	private WebElement messageWhereApplynotPossible;
	@FindBy(css = "//*[@class='continue-btn' and text()='Submit']")
	private WebElement submitButtonNewWindow;

	/*
	 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 * Getter and Setter // EncapSulation
	 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 */

	protected synchronized final interfaceAsaService getScreenShot()
	{
		return screenShot;
	}

	protected synchronized final WebElement getResumeSelect()
	{
		return resumeSelect;
	}

	protected synchronized final WebElement getSelectAttachedResume()
	{
		return selectAttachedResume;
	}

	protected synchronized final WebElement getSubmitApplicationButton()
	{
		return submitApplicationButton;
	}

	protected synchronized final WebElement getAskForAReferral()
	{
		return askForAReferral;
	}

	protected synchronized final List<WebElement> getJobName()
	{
		return jobName;
	}

	protected synchronized final List<WebElement> getCmpanyName()
	{
		return cmpanyName;
	}

	protected synchronized final WebElement getEasyApplyORApplyButton()
	{
		return easyApplyORApplyButton;
	}

	protected synchronized final WebElement getMessageWhereApplynotPossible()
	{
		return messageWhereApplynotPossible;
	}

	protected synchronized final WebElement getSubmitButtonNewWindow()
	{
		return submitButtonNewWindow;
	}

	protected synchronized final void setScreenShot(interfaceAsaService screenShot)
	{
		this.screenShot = screenShot;
	}

	protected synchronized final void setResumeSelect(WebElement resumeSelect)
	{
		this.resumeSelect = resumeSelect;
	}

	protected synchronized final void setSelectAttachedResume(WebElement selectAttachedResume)
	{
		this.selectAttachedResume = selectAttachedResume;
	}

	protected synchronized final void setSubmitApplicationButton(WebElement submitApplicationButton)
	{
		this.submitApplicationButton = submitApplicationButton;
	}

	protected synchronized final void setAskForAReferral(WebElement askForAReferral)
	{
		this.askForAReferral = askForAReferral;
	}

	protected synchronized final void setJobName(List<WebElement> jobName)
	{
		this.jobName = jobName;
	}

	protected synchronized final void setCmpanyName(List<WebElement> cmpanyName)
	{
		this.cmpanyName = cmpanyName;
	}

	protected synchronized final void setEasyApplyORApplyButton(WebElement easyApplyORApplyButton)
	{
		this.easyApplyORApplyButton = easyApplyORApplyButton;
	}

	protected synchronized final void setMessageWhereApplynotPossible(WebElement messageWhereApplynotPossible)
	{
		this.messageWhereApplynotPossible = messageWhereApplynotPossible;
	}

	protected synchronized final void setSubmitButtonNewWindow(WebElement submitButtonNewWindow)
	{
		this.submitButtonNewWindow = submitButtonNewWindow;
	}

	/*
	 * METHODS start from here ONLY This method will be called to apply job
	 */
	public void clickOnJoblink() throws Throwable
	{
		int totalJobInPage = getJobName().size();
		Log.info("Total job available in page : " + totalJobInPage);
		int jobApplyNumber = 0;
		for (WebElement e : getJobName()) {
			w.until(ExpectedConditions.elementToBeClickable(e));
			Log.info("Job Title is: " + e.getText().toString());
			navigateAndHighLight(e);
			e.click();
			w.until(ExpectedConditions.visibilityOf(getCmpanyName().get(jobApplyNumber)));

			Log.info("Company name is : " + getCmpanyName().get(jobApplyNumber).getText().toUpperCase());
			// Click on easy apply
			clickonEasyApply();
			jobApplyNumber++;
			Log.info("Completed Job Apply and count is -------------- " + jobApplyNumber);
			if (jobApplyNumber == totalJobInPage) {
				Log.info("Calling Method through Recursion");
				jobName = driver.findElements(By.xpath(
						"//*[@class='jobs-search-results__list artdeco-list']/li/div/artdeco-entity-lockup/artdeco-entity-lockup-content/h3"));
				Thread.sleep(2000);
				if (jobApplyNumber == 25)
					break;
				clickOnJoblink();

			}

		}
	}

	// Navigate Back
	public void navigateBack()
	{

		String prvPage = driver.getTitle();
		driver.navigate().back();
		String curPage = driver.getTitle();
		Log.info(prvPage + "is currentpage and navigated back to " + curPage);
		Log.info(prvPage + "is currentpage and navigated back to " + curPage);

	}

	/*
	 * This method is liable to Handle EasyApply , Apply button If Already Applied
	 * the it will show message that "Apply Button is not available"
	 */
	private void clickonEasyApply() throws Throwable
	{
		String originWindow = driver.getWindowHandle();
		try {
			if (getEasyApplyORApplyButton().getText() == "Easy Apply") {
				getEasyApplyORApplyButton().click();
				// After Clicking on Easy Apply if new Window is opened
				// Then navigate to new Window and come back to origin window
				if (driver.getWindowHandle() != originWindow) {
					getSubmitApplicationButton().click();
				} else {
					// while new window is not opened
					submitApplication();
				}

			} else if (getEasyApplyORApplyButton().getText() == "Apply") {
				// While easy Apply failed check if "Apply" button present or not
				Log.error("Easy Apply Failed");
				// Code to be added to Apply
				Log.info("Apply Button is available");
			} else {
				Log.error("Apply Button is not available");
				Log.info(getMessageWhereApplynotPossible().getText());
			}
		} catch (Exception e) {
			Log.error("Execution  error -- ");
			throw new Error("Execution  error -- ");

		}
	}

	// SUbmit Application pop-up
	private void submitApplication() throws Exception
	{
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
		try {
			afterApplyPopups.class.getDeclaredConstructor(WebDriver.class).newInstance(driver).pop1();
		} catch (Exception e) {
			Log.info("POP1 UP NOT DISPLAYED");
		}
		try {
			afterApplyPopups.class.getDeclaredConstructor(WebDriver.class).newInstance(driver).pop2();
		} catch (Exception f) {
			Log.info("POP2 UP NOT DISPLAYED");
		}
	}

	private void navigateAndHighLight(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
} // end of class