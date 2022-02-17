package com.linkedin.pages;

import com.linkedin.Browser.browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

//Test passed

public class feedPage extends browser
{
	private static Logger log = LogManager.getLogger(feedPage.class.getName());

	public feedPage(final WebDriver driver)
	{
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span[id*='mynetwork-tab-icon']")
	private WebElement myNetworkTabIcon;
	@FindBy(css = "span[id*='jobs-tab-icon']")
	private WebElement jobSearchButtonOnFeedpage;
	@FindBy(css = "span[class*='nav-item__badge-count']")
	private WebElement notificationCount;
	@FindBy(css = "span[id*='notifications-tab-icon']")
	private WebElement notificationIcon;
	@FindBy(xpath = "//*[@class='feed-identity-module__member-photo profile-rail-card__member-photo EntityPhoto-circle-5 lazy-image ember-view']")
	private WebElement profiePicture;
	@FindBy(css = "span[class*='feed-identity-module__stat link-without-visited-state']")
	private WebElement howManyViewedmyProfile;
	@FindBy(css = "button[class*='widget-route']")
	private WebElement viewsOfMyPost;
	@FindBy(css = ".Sans-17px-black-85-semibold")
	private WebElement profileName;

	public WebElement getProfileName()
	{
		return profileName;
	}

	public void setProfileName(WebElement profileName)
	{
		this.profileName = profileName;
	}

	@FindBy(xpath = "//span[@id='feed-tab-icon']")
	WebElement feedIcon;

	/**
	 * @return the feedIcon
	 */
	public final WebElement getFeedIcon()
	{
		return feedIcon;
	}

	/**
	 * @param feedIcon the feedIcon to set
	 */
	public final void setFeedIcon(WebElement feedIcon)
	{
		this.feedIcon = feedIcon;
	}

	/**
	 * @return the myNetworkTabIcon
	 */
	public final WebElement getMyNetworkTabIcon()
	{
		return myNetworkTabIcon;
	}

	/**
	 * @param myNetworkTabIcon the myNetworkTabIcon to set
	 */
	public final void setMyNetworkTabIcon(WebElement myNetworkTabIcon)
	{
		this.myNetworkTabIcon = myNetworkTabIcon;
	}

	/**
	 * @return the jobSearchButtonOnFeedpage
	 */
	public final WebElement getJobSearchButtonOnFeedpage()
	{
		return jobSearchButtonOnFeedpage;
	}

	/**
	 * @param jobSearchButtonOnFeedpage the jobSearchButtonOnFeedpage to set
	 */
	public final void setJobSearchButtonOnFeedpage(WebElement jobSearchButtonOnFeedpage)
	{
		this.jobSearchButtonOnFeedpage = jobSearchButtonOnFeedpage;
	}

	/**
	 * @return the notificationCount
	 */
	public final WebElement getNotificationCount()
	{
		return notificationCount;
	}

	/**
	 * @param notificationCount the notificationCount to set
	 */
	public final void setNotificationCount(WebElement notificationCount)
	{
		this.notificationCount = notificationCount;
	}

	/**
	 * @return the notificationIcon
	 */
	public final WebElement getNotificationIcon()
	{
		return notificationIcon;
	}

	/**
	 * @param notificationIcon the notificationIcon to set
	 */
	public final void setNotificationIcon(WebElement notificationIcon)
	{
		this.notificationIcon = notificationIcon;
	}

	/**
	 * @return the profiePicture
	 */
	public final WebElement getProfiePicture()
	{
		return profiePicture;
	}

	/**
	 * @param profiePicture the profiePicture to set
	 */
	public final void setProfiePicture(WebElement profiePicture)
	{
		this.profiePicture = profiePicture;
	}

	/**
	 * @return the howManyViewedmyProfile
	 */
	public final WebElement getHowManyViewedmyProfile()
	{
		return howManyViewedmyProfile;
	}

	/**
	 * @param howManyViewedmyProfile the howManyViewedmyProfile to set
	 */
	public final void setHowManyViewedmyProfile(WebElement howManyViewedmyProfile)
	{
		this.howManyViewedmyProfile = howManyViewedmyProfile;
	}

	/**
	 * @return the viewsOfMyPost
	 */
	public final WebElement getViewsOfMyPost()
	{
		return viewsOfMyPost;
	}

	/**
	 * @param viewsOfMyPost the viewsOfMyPost to set
	 */
	public final void setViewsOfMyPost(WebElement viewsOfMyPost)
	{
		this.viewsOfMyPost = viewsOfMyPost;
	}

	public void clickOnJobButton()
	{
		ClickOnElement(getJobSearchButtonOnFeedpage());
		log.info("Clicked on JobButton on Feed Page");
		log.info("Current page name is : " + driver.getTitle());

	}

	public void informationAboutMyProfile()
	{
		log.info("Waiting to load the page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(getMyNetworkTabIcon().isDisplayed() || getProfileName().isDisplayed())
		{
			log.info("Profile picture x: " + getProfiePicture().getSize().getWidth() + " Profile picture y: "
					+ getProfiePicture().getSize().getHeight());
			log.info("Notification count " + "" + getNotificationCount().getText());
			log.info(getHowManyViewedmyProfile().getText().toString() + " viewed my profile");
			log.info(getMyNetworkTabIcon().getText().toString() + " button is Displayed");
			log.info("Completed with Profile checks");
		}
		else
		{
			log.info("Network icon not found , skipping to job search");
			clickOnJobButton();
			log.error("Profile Checks  Failed");
		}

	}

}
