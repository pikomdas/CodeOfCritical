package com.linkedin.pages;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.getMyProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.linkedin.commomUtil.CheckPageLoadingState.waitToLoadPage;

public class JobsPage extends browser
{

	private static Logger log = LogManager.getLogger(JobsPage.class.getName());

	public JobsPage(final WebDriver driver)
	{
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverWait w1 = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//*[@id=':r2d:']")
	WebElement jobSeaarchBox1;
	@FindBy(xpath = "//input[starts-with(@id,'jobs-search-box-location-')]")
	WebElement location1;
	@FindBy(xpath = "//div[contains(@id,'ember')]/button[1][text()='Search']")
	WebElement jobSearchButtonOnJobpage;

	public WebElement getJobSeaarchBox() {
		return jobSeaarchBox1;
	}

	public WebElement getLocation1() {
		return location1;
	}

	public WebElement getJobSearchButtonOnJobpage() {
		return jobSearchButtonOnJobpage;
	}

	public void jobSearch() throws IOException, InterruptedException
	{
		waitToLoadPage();
		
		log.info("INSERTING JOB TEXT TO SEARCH");
		w1.until(ExpectedConditions.visibilityOf(getJobSeaarchBox())).click();
		String currentTitle = driver.getTitle();
		log.info("Current page name is : " + currentTitle);
		// Sending Job search text
		SendKeysTo(getJobSeaarchBox(), getMyProperty.readmyFile("jobsearch1"));
		// Sending Location
//		SendKeysTo(getLocation(), getMyProperty.readmyFile("location1"));
		// Clicking on job search button
		getJobSearchButtonOnJobpage().click();
		log.info("Clicked on JOB SEARCH BUTTON");
		
	}
	
}
