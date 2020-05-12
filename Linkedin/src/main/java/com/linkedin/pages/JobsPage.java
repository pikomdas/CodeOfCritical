package com.linkedin.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.getMyProperty;

public class JobsPage extends browser
{

	private static Logger log = LogManager.getLogger(JobsPage.class.getName());

	public JobsPage(final WebDriver driver)
	{
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverWait w1 = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//input[starts-with(@id,'jobs-search-box-keyword-')]")
	WebElement jobSeaarchBox1;
	@FindBy(xpath = "//input[starts-with(@id,'jobs-search-box-location-')]")
	WebElement location1;
	@FindBy(xpath = "//div[contains(@id,'ember')]/button[1][text()='Search']")
	WebElement jobSearchButtonOnJobpage;

	/**
	 * @return the location
	 */
	public final WebElement getLocation()
	{
		return location1;
	}

	/**
	 * @param location the location to set
	 */
	public final void setLocation(final WebElement location)
	{
		this.location1 = location;
	}

	/**
	 * @return the jobSeaarchBox
	 */
	public final WebElement getJobSeaarchBox()
	{
		return jobSeaarchBox1;
	}

	/**
	 * @param jobSeaarchBox the jobSeaarchBox to set
	 */
	public final void setJobSeaarchBox(final WebElement jobSeaarchBox)
	{
		this.jobSeaarchBox1 = jobSeaarchBox;
	}

	/**
	 * @return the jobSearchButtonOnJobpage
	 */

	public final WebElement getJobSearchButtonOnJobpage()
	{
		return jobSearchButtonOnJobpage;
	}

	/**
	 * @param jobSearchButtonOnJobpage the jobSearchButtonOnJobpage to set
	 */
	public final void setJobSearchButtonOnJobpage(final WebElement jobSearchButtonOnJobpage)
	{
		this.jobSearchButtonOnJobpage = jobSearchButtonOnJobpage;
	}

	public void jobSearch() throws IOException, InterruptedException
	{

		log.info("INSERTING JOB TEXT TO SEARCH");
		w1.until(ExpectedConditions.visibilityOf(getJobSeaarchBox()));
		String currentTitle = driver.getTitle();
		log.info("Current page name is : " + currentTitle);
		// Sending Job search text
		SendKeysTo(getJobSeaarchBox(), getMyProperty.readmyFile("jobsearch1"));
		// Sending Location
		SendKeysTo(getLocation(), getMyProperty.readmyFile("location1"));
		// Clicking on job search button
		getJobSearchButtonOnJobpage().click();
		log.info("Clicked on JOB SEARCH BUTTON");
		
		Thread.sleep(5000);
		
	}
}
