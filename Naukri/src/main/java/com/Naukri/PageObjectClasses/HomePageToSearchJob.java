package com.Naukri.PageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Naukri.BrowserBase.browser;

public class HomePageToSearchJob extends browser {
	WebDriverWait w1 = new WebDriverWait(driver, 10);
	 private static final Logger log = LogManager.getLogger(HomePageToSearchJob.class.getName());

	public HomePageToSearchJob(WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='qsb-keyskill-sugg' and @name='qp']")
	WebElement JobSearchBox;
	@FindBy(xpath = "//input[@name='qp']")
	WebElement JobSkill;
	@FindBy(xpath = "//input[@name='ql']")
	WebElement LocationofJob;
	@FindBy(xpath = "//*[@id='expDroope-experienceFor']")
	WebElement Experience;
	@FindBy(xpath = "//*[@id='salaryDroope-salaryFor']")
	WebElement Salary;
	@FindBy(xpath = "//*[@id='search-jobs']/button")
	WebElement JobSearchButton;

	@FindBy(css = ".user-name.roboto-bold-text")
	WebElement profilename;
	@FindBy(xpath = "//*[@id=\'root\']/div/div/span/div/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/a[1]/span[1]")
	WebElement profileViews;
	@FindBy(xpath = "//*[@class='actions']/a[2]/span[1]")
	WebElement pendingActions;
	@FindBy(xpath = "//span[@id='rJobCntr']")
	WebElement notificationCount;
	@FindBy(xpath = "//*[@class='row']/div/img")
	WebElement profilePicture;
	@FindBy(xpath = "/html/body/div[1]/div/div/ul[2]/li[1]/div/ul/li[1]/a/span[2]")
	WebElement JobRecommendationCount;
	@FindBy(xpath = "/html/body/div[1]/div/div/ul[2]/li[1]/div/ul/li[2]/a/span[2]")
	WebElement ApplicationStatusCount;
	@FindBy(xpath = "/html/body/div[1]/div/div/ul[2]/li[1]/div/ul/li[3]/a/span[2]")
	WebElement recruiterMessageCount;

	public WebElement getJobSearchBox() {
		return JobSearchBox;
	}

	public void setJobSearchBox(WebElement jobSearchBox) {
		JobSearchBox = jobSearchBox;
	}

	public WebElement getJobSkill() {
		return JobSkill;
	}

	public void setJobSkill(WebElement jobSkill) {
		JobSkill = jobSkill;
	}

	public WebElement getLocationofJob() {
		return LocationofJob;
	}

	public void setLocationofJob(WebElement locationofJob) {
		LocationofJob = locationofJob;
	}

	public WebElement getExperience() {
		return Experience;
	}

	public void setExperience(WebElement experience) {
		Experience = experience;
	}

	public WebElement getSalary() {
		return Salary;
	}

	public void setSalary(WebElement salary) {
		Salary = salary;
	}

	public WebElement getJobSearchButton() {
		return JobSearchButton;
	}

	public void setJobSearchButton(WebElement jobSearchButton) {
		JobSearchButton = jobSearchButton;
	}

	public WebElement getProfilename() {
		return profilename;
	}

	public void setProfilename(WebElement profilename) {
		this.profilename = profilename;
	}

	public WebElement getProfileViews() {
		return profileViews;
	}

	public void setProfileViews(WebElement profileViews) {
		this.profileViews = profileViews;
	}

	public WebElement getPendingActions() {
		return pendingActions;
	}

	public void setPendingActions(WebElement pendingActions) {
		this.pendingActions = pendingActions;
	}

	public WebElement getNotificationCount() {
		return notificationCount;
	}

	public void setNotificationCount(WebElement notificationCount) {
		this.notificationCount = notificationCount;
	}

	public WebElement getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(WebElement profilePicture) {
		this.profilePicture = profilePicture;
	}

	public WebElement getJobRecommendationCount() {
		return JobRecommendationCount;
	}

	public void setJobRecommendationCount(WebElement jobRecommendationCount) {
		JobRecommendationCount = jobRecommendationCount;
	}

	public WebElement getApplicationStatusCount() {
		return ApplicationStatusCount;
	}

	public void setApplicationStatusCount(WebElement applicationStatusCount) {
		ApplicationStatusCount = applicationStatusCount;
	}

	public WebElement getRecruiterMessageCount() {
		return recruiterMessageCount;
	}

	public void setRecruiterMessageCount(WebElement recruiterMessageCount) {
		this.recruiterMessageCount = recruiterMessageCount;
	}

//Search Job with desired text
	public void searchJob(String skill, String location) {
		w1.until(ExpectedConditions.elementToBeClickable(getJobSearchBox()));
		getJobSearchBox().click();
		getJobSkill().sendKeys(skill);
		getLocationofJob().sendKeys(location);
		getExperience().click();
		driver.findElement(By.xpath("//*[@id=\"ul_expDroope-experience\"]/ul/li[6]/a")).click();
		getSalary().click();
		driver.findElement(By.xpath("//*[@id=\"ul_salaryDroope-salary\"]/ul/li[8]/a")).click();
		getJobSearchButton().click();
		log.info("Clicked on JobSearch button");

	}

//get Profile details
	public void profileDetails() {
		w1.until(ExpectedConditions.elementToBeClickable(getProfilename()));
		log.info("Profile name: " + getProfilename().getText());
		log.info("Profile picture height: " + getProfilePicture().getSize().height + " and width: "
				+ getProfilePicture().getSize().width);
		log.info("Pending notification count: " + getPendingActions().getText());
		//log.info("Profile views count: " + getProfileViews().getText());
		log.info("Profile Notification count: " + getNotificationCount().getText());
		log.info("Job Application status count: " + getApplicationStatusCount().getText());
		log.info("Job recommendation count: " + getJobRecommendationCount().getText());
		log.info("Message from recruiter count: " + getRecruiterMessageCount());
		log.info("Completed Profile details");
	}
}// End of class
