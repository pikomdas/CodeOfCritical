package com.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.Browser.browser;


public class loginToLinkedin extends browser
{
	private WebDriverWait w1=new WebDriverWait(driver,10);
	private static Logger log = LogManager.getLogger(loginToLinkedin.class.getName());

	@FindBy(xpath = "//input[@id='username']")
	private WebElement loginEmailId;
	@FindBy(css = "input[id*='password']")
	private WebElement password;
	@FindBy(xpath = "//*[text()='Sign in']")
	private WebElement logInBtn;
	@FindBy(xpath = "//*[@class='nav__button-secondary' and text()='Sign in']")
	private WebElement signIn;

	public loginToLinkedin(final WebDriver driver)
	{
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public final WebElement getLoginEmailId()
	{
		return loginEmailId;
	}

	public final WebElement getPassword()
	{
		return password;
	}

	public final WebElement getLogInBtn()
	{
		return logInBtn;
	}

	public final WebElement getSignIn()
	{
		return signIn;
	}


	public void userNamePasswordAndlogin(final String strUserName, final String strPasword) throws Throwable
	{
		// Click on Sign in
		ClickOnElement(getSignIn());
		String title=driver.getTitle();
		log.info(title);

		// Sending userName
		SendKeysTo(getLoginEmailId(), strUserName);
		log.info("UserID is thrown");
		// Sending Password
		SendKeysTo(getPassword(), strPasword);
		log.info("Password is  thrown");
		// Click on Login Button
		ClickOnElement(getLogInBtn());
		log.info("LINKEDIN login successful");
		
		try
		{
			if(w1.until(ExpectedConditions.titleIs(title))){
				userNamePasswordAndlogin(strUserName, strPasword);
			}
		} catch (Throwable e)
		{
			log.warn(e.getMessage());
		}
		
	}
}
