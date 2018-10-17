package com.Naukri.PageObjectClasses;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.BrowserBase.browser;

public class JobSearchResultPage extends browser {

	public JobSearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "downArrow")
	WebElement sortby1;
	@FindAll({ @FindBy(xpath = "//*[@class='desig']") })
	public List<WebElement> JobName;
	@FindAll({ @FindBy(xpath = "//*[@class='salary  ']") })
	public List<WebElement> SalaryRange;
	@FindAll({ @FindBy(xpath = "//*[@class='org']") })
	public List<WebElement> organisation;
	@FindBy(xpath = "")
	WebElement sortby;

	protected WebElement getSortby1() {
		return sortby1;
	}

	protected void setSortby1(WebElement sortby1) {
		this.sortby1 = sortby1;
	}

	protected List<WebElement> getJobName() {
		return JobName;
	}

	protected void setJobName(List<WebElement> jobName) {
		JobName = jobName;
	}

	protected List<WebElement> getSalaryRange() {
		return SalaryRange;
	}

	protected void setSalaryRange(List<WebElement> salaryRange) {
		SalaryRange = salaryRange;
	}

	protected List<WebElement> getOrganisation() {
		return organisation;
	}

	protected void setOrganisation(List<WebElement> organisation) {
		this.organisation = organisation;
	}

	public void appyjob1by1() throws Throwable {
		Thread.sleep(4000);
		JobDetailsToApplyPage jdta=new JobDetailsToApplyPage(driver)
		
		for (WebElement e : getJobName()) {
			System.out.println("Job Name ================================> " + e.getText());
			for (WebElement f : getOrganisation()) {
				System.out.print("Organisation Name ================================> " + f.getText());
				for (WebElement g : getSalaryRange()) {
					System.out.println("Salary offere ranged: " + g.getText());
					String JobSearchResultTab = driver.getWindowHandle();
					e.click();
					Set<String> handlesOfAllJobpage = driver.getWindowHandles();
					for (String handleOfOnepage : handlesOfAllJobpage) {

						if (!handleOfOnepage.equals(JobSearchResultTab)) {
							driver.switchTo().window(handleOfOnepage);
							driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							jdta.appyTheJob();
							Thread.sleep(4000);
						}
					}
					driver.switchTo().window(JobSearchResultTab);
					System.out.println(
							"Navigated back to >>>>>>>>>>>>>>>>>>>>>>>>>>> : " + JobSearchResultTab.toUpperCase());
				}
			}
		}
	}

}// End of class
