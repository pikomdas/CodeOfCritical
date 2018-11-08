package com.linkedin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.interfaces.interfaceAsaService;

import Browser.browser;
import commomUtil.Log;

//TEST PASSED

public class loginToLinkedin extends browser {

	interfaceAsaService Log = new Log();

	@FindBy(xpath = "//input[@id='login-email']")
	WebElement loginEmailId;

	@FindBy(css = "input[id*='-password']")
	WebElement password;
	@FindBy(css = "input[id*='login-submit']")
	WebElement logInBtn;

	public loginToLinkedin(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return this.loginEmailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(final WebElement emailId) {
		this.loginEmailId = emailId;
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final WebElement password) {
		this.password = password;
	}

	/**
	 * @return the logInBtn
	 */
	public WebElement getLogInBtn() {
		return this.logInBtn;
	}

	/**
	 * @param logInBtn
	 *            the logInBtn to set
	 */
	public void setLogInBtn(final WebElement logInBtn) {
		this.logInBtn = logInBtn;
	}

	// WebDriverWait wait2 = new WebDriverWait(driver, 10);
	// wait2.until(ExpectedConditions.elementToBeClickable(getEmailId()));
	// wait2.until(ExpectedConditions.elementToBeClickable(getPassword()));
	// public void userNamePasswordAndlogin () throws Exception
	public void userNamePasswordAndlogin(final String strUserName, final String strPasword)
			throws ExceptionInInitializerError {
	{
		try {
			Log.info(driver.getTitle());
			System.out.print(getEmailId().getText());
            getEmailId().sendKeys(strUserName);
            Log.info("UserID is thrown");
            getPassword().sendKeys(strPasword);
            Log.info("Password is  thrown");
			getLogInBtn().click();
			Log.info("LINKEDIN login successful");
		} catch (final Exception e) {
			System.out.println(e);
			Log.warn("LogIn Failed");
		}
	}
}
}
