package com.linkedin.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.Log;
import com.linkedin.commomUtil.getMyProperty;
import com.linkedin.interfaces.interfaceAsaService;

public class JobsPage extends browser {

	interfaceAsaService Log = new Log();
	public JobsPage(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait w=new WebDriverWait(driver, 5);
	

	@FindBy(xpath= "//input[starts-with(@id,'jobs-search-box-keyword-')]")
	WebElement jobSeaarchBox1;
	@FindBy(xpath = "//input[starts-with(@id,'jobs-search-box-location-')]")
	WebElement location1;
	@FindBy(xpath = "//div[contains(@id,'ember')]/button[1][text()='Search']")
	WebElement jobSearchButtonOnJobpage;

	/**
	 * @return the location
	 */
	public final WebElement getLocation() {
		return location1;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public final void setLocation(final WebElement location) {
		this.location1 = location;
	}

	/**
	 * @return the jobSeaarchBox
	 */
	public final WebElement getJobSeaarchBox() {
		return jobSeaarchBox1;
	}

	/**
	 * @param jobSeaarchBox
	 *            the jobSeaarchBox to set
	 */
	public final void setJobSeaarchBox(final WebElement jobSeaarchBox) {
		this.jobSeaarchBox1 = jobSeaarchBox;
	}

	/**
	 * @return the jobSearchButtonOnJobpage
	 */

	public final WebElement getJobSearchButtonOnJobpage() {
		return jobSearchButtonOnJobpage;
	}

	/**
	 * @param jobSearchButtonOnJobpage
	 *            the jobSearchButtonOnJobpage to set
	 */
	public final void setJobSearchButtonOnJobpage(final WebElement jobSearchButtonOnJobpage) {
		this.jobSearchButtonOnJobpage = jobSearchButtonOnJobpage;
	}

	public void jobSearch() throws IOException {
		System.out.println("Current page name is : " + driver.getTitle());
			
				System.out.println("INSERTING JOB TEXT TO SEARCH");
				//w.until(ExpectedConditions.attributeToBeNotEmpty(getJobSeaarchBox(), "Search jobs"));	
				    getJobSeaarchBox().clear();
					getJobSeaarchBox().sendKeys(getMyProperty.readmyFile("jobsearch1"));
		            getLocation().clear();
		            getLocation().sendKeys(getMyProperty.readmyFile("location1"));
		            getJobSearchButtonOnJobpage().click();
		            Log.info("Clicked on JOB SEARCH BUTTON");
	}
}
