package com.Naukri.PageObjectClasses;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naukri.BrowserBase.browser;

public class JobSearchResultPage extends browser
{

	private static final Logger log = LogManager.getLogger(JobSearchResultPage.class.getName());
	JobDetailsToApplyPage jdta = null;
	Set<String> handlesOfAllJobpage;

	public JobSearchResultPage(WebDriver driver)
		{
			browser.driver = driver;
			PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "downArrow")
	WebElement sortby1;
	@FindAll({ @FindBy(xpath = "//*[@class='desig']") })
	public List<WebElement> JobName;
	@FindAll({ @FindBy(xpath = "//*[@class='other_details']/span[2]") })
	public List<WebElement> SalaryRange;
	@FindAll({ @FindBy(xpath = "//*[@class='content']/span/span") })
	public List<WebElement> organisation;
	@FindBy(xpath = "")
	WebElement sortby;
	@FindBy(xpath = "//*[@class='grayBtn' and text()='Next']")
	WebElement nextButton;

	protected WebElement getSortby1()
		{
			return sortby1;
		}

	protected void setSortby1(WebElement sortby1)
		{
			this.sortby1 = sortby1;
		}

	protected List<WebElement> getJobName()
		{
			return JobName;
		}

	protected void setJobName(List<WebElement> jobName)
		{
			JobName = jobName;
		}

	protected List<WebElement> getSalaryRange()
		{
			return SalaryRange;
		}

	protected void setSalaryRange(List<WebElement> salaryRange)
		{
			SalaryRange = salaryRange;
		}

	protected List<WebElement> getOrganisation()
		{
			return organisation;
		}

	protected void setOrganisation(List<WebElement> organisation)
		{
			this.organisation = organisation;
		}

	public final WebElement getNextButton()
		{
			return nextButton;
		}

	public final void setNextButton(WebElement nextButton)
		{
			this.nextButton = nextButton;
		}

	public void appyjob1by1() throws Throwable
		{
			Thread.sleep(4000);
			String JobSearchResultTab = driver.getWindowHandle();
			log.info("Total available job in the page is : " + getJobName().size());
			int i = 0;
			while (i <= getJobName().size()) {
				log.info("Job Name ================================> " + getJobName().get(i).getText().toString());
				log.info("Organisation Name ================================> "
						+ getOrganisation().get(i).getText().toString());
				log.info("Salary offere ranged: " + getSalaryRange().get(i).getText().toString());
				// navigating to job and highlighting
				Actions actions = new Actions(driver);
				actions.moveToElement(getJobName().get(i));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
						getJobName().get(i));
				actions.click();
				actions.perform();
				// getJobName().get(i).click();
				handlesOfAllJobpage = driver.getWindowHandles();
				for (String handleOfOnepage : handlesOfAllJobpage) {
					if (!handleOfOnepage.equals(JobSearchResultTab)) {
						driver.switchTo().window(handleOfOnepage);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						if (jdta == null) {
							jdta = new JobDetailsToApplyPage(driver);
							jdta.appyTheJob();
							jdta = null;
							handlesOfAllJobpage = null;
							break;
						}
					}
				}
				driver.switchTo().window(JobSearchResultTab);
				log.info("Navigated back to >>>>>>>>>>>>>>>>>>>>>>>>>>> : " + JobSearchResultTab.toUpperCase());

				i++;
				if (i == getJobName().size()) {
					log.info("Completed Page " + driver.getCurrentUrl());
					if (getNextButton().isDisplayed()) {
						getNextButton().click();
						log.info("Clicked on Next button");
						appyjob1by1();
					} else {
						log.info("Next button is not found");
					}

				}
			}
		}

}// End of class
