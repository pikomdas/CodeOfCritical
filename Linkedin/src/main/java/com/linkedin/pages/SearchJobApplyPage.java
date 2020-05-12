package com.linkedin.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.linkedin.commomUtil.ScreenshotCapture;

public class SearchJobApplyPage extends JobsPage
{

	WebDriverWait w = new WebDriverWait(driver, 30);
	private static Logger log = LogManager.getLogger(SearchJobApplyPage.class.getName());
	ScreenshotCapture screenShot = new ScreenshotCapture();

	// Constructor with parameter
	public SearchJobApplyPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*
	 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	 * ************************************ LOCATORS
	 * **************************************************
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
	@FindBy(xpath = "//button[starts-with(@class,'jobs-candidate-initiate-referral__referral-button button-tertiary-large full-width')]")
	private WebElement askForAReferral;

	@FindBy(xpath = "//*[@class='jobs-search-results__list artdeco-list']")
	private WebElement jobDiv;
	@FindAll({
			@FindBy(css = ".job-card-search__company-name.t-14.t-black.artdeco-entity-lockup__subtitle.ember-view") })
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

	private final WebElement getJobDiv()
	{
		return jobDiv;
	}

	private final WebElement getResumeSelect()
	{
		return resumeSelect;
	}

	private final WebElement getSelectAttachedResume()
	{
		return selectAttachedResume;
	}

	private final WebElement getSubmitApplicationButton()
	{
		return submitApplicationButton;
	}

	private final WebElement getAskForAReferral()
	{
		return askForAReferral;
	}

	private final List<WebElement> getCmpanyName()
	{
		return cmpanyName;
	}

	private final WebElement getEasyApplyORApplyButton()
	{
		return easyApplyORApplyButton;
	}

	private final WebElement getMessageWhereApplynotPossible()
	{
		return messageWhereApplynotPossible;
	}

	private final WebElement getSubmitButtonNewWindow()
	{
		return submitButtonNewWindow;
	}

	/*
	 * METHODS start from here ONLY This method will be called to apply job
	 */
	int pageCount = 1;

	public void applyAllAvailableJobs() throws Throwable
	{
		Thread.sleep(10000);
		// Scrolling to end of div
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		long scrollHeightOfDiv = (long) jse.executeScript(
				"return document.getElementsByClassName('jobs-search-results jobs-search-results--is-two-pane')[0].scrollHeight;");
		long toScroll = 0;
		while (scrollHeightOfDiv >= toScroll)
		{
			toScroll = toScroll + 200;
			jse.executeScript(
					"document.getElementsByClassName('jobs-search-results jobs-search-results--is-two-pane')[0].scroll(0,"
							+ toScroll + ");");
		}

		Thread.sleep(2000);
		// Scrolling to beginning of div
		jse.executeScript(
				"document.getElementsByClassName('jobs-search-results jobs-search-results--is-two-pane')[0].scroll(0,0);");
		Thread.sleep(10000);

		// Storing all available jobs on Page
		List<WebElement> allJobsOnePage = getJobDiv().findElements(By.xpath("./li/div/div/div/h3"));
		int totalJobInPage = allJobsOnePage.size();
		log.info("Total job available on page : " + totalJobInPage);

		int count = 0;

		for (WebElement e : allJobsOnePage)
		{
			navigateAndHighLight(e);
			log.info("Job name " + e.getText());
//			WebElement companyName = e.findElement(By.xpath("./following-sibling::div/a"));
//			log.info("Company Name " + companyName.getText());
			ClickOnElement(e);

			if(count == allJobsOnePage.size() - 1)
			{
				log.info("Finished one page");
				driver.findElement(By.xpath(
						"//*[@class='artdeco-pagination__pages artdeco-pagination__pages--number']/li//span[text()='"
								+ ++pageCount + "']"))
						.click();
				applyAllAvailableJobs();
			}

			count++;
		}

	}

	// Navigate Back
	public void navigateBack()
	{

		String prvPage = driver.getTitle();
		driver.navigate().back();
		String curPage = driver.getTitle();
		log.info(prvPage + "is currentpage and navigated back to " + curPage);
		log.info(prvPage + "is currentpage and navigated back to " + curPage);

	}

	/*
	 * This method is liable to Handle EasyApply , Apply button If Already Applied
	 * the it will show message that "Apply Button is not available"
	 */
	private void clickonEasyApply() throws Throwable
	{
		String originWindow = driver.getWindowHandle();
		try
		{
			if(getEasyApplyORApplyButton().getText() == "Easy Apply")
			{
				getEasyApplyORApplyButton().click();
				// After Clicking on Easy Apply if new Window is opened
				// Then navigate to new Window and come back to origin window
				if(driver.getWindowHandle() != originWindow)
				{
					getSubmitApplicationButton().click();
				}
				else
				{
					// while new window is not opened
					submitApplication();
				}

			}
			else if(getEasyApplyORApplyButton().getText() == "Apply")
			{
				// While easy Apply failed check if "Apply" button present or not
				log.error("Easy Apply Failed");
				// Code to be added to Apply
				log.info("Apply Button is available");
			}
			else
			{
				log.error("Apply Button is not available");
				log.info(getMessageWhereApplynotPossible().getText());
			}
		} catch (Exception e)
		{
			log.error("Execution  error -- ");
			e.printStackTrace();
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
		log.info("Clicked on " + getResumeSelect().getText());

		w.until(ExpectedConditions.elementToBeClickable(getSelectAttachedResume()));
		getSelectAttachedResume().click();
		log.info("Selected resume name is " + getSelectAttachedResume().getText());
		screenShot.takeScreenShotofCurrentpage();

		getSubmitApplicationButton().click();
		log.info("Job Application Submitted.");
		try
		{
			afterApplyPopups.class.getDeclaredConstructor(WebDriver.class).newInstance(driver).pop1();
		} catch (Exception e)
		{
			log.info("POP1 UP NOT DISPLAYED");
		}
		try
		{
			afterApplyPopups.class.getDeclaredConstructor(WebDriver.class).newInstance(driver).pop2();
		} catch (Exception f)
		{
			log.info("POP2 UP NOT DISPLAYED");
		}
	}

} // end of class