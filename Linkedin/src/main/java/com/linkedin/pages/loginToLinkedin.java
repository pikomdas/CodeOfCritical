package com.linkedin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.Log;
import com.linkedin.interfaces.interfaceAsaService;

//TEST PASSED

public class loginToLinkedin extends browser {

	interfaceAsaService Log = new Log();

	@FindBy(xpath = "//input[@id='username']")
	WebElement loginEmailId;
	@FindBy(css = "input[id*='password']")
	WebElement password;
	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement logInBtn;
	@FindBy(xpath = "//*[@class='nav__button-secondary' and text()='Sign in']")
	WebElement signIn;

	public loginToLinkedin(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public final WebElement getLoginEmailId() {
		return loginEmailId;
	}

	public final WebElement getPassword() {
		return password;
	}

	public final WebElement getLogInBtn() {
		return logInBtn;
	}

	public final WebElement getSignIn() {
		return signIn;
	}

	public final void setLoginEmailId(WebElement loginEmailId) {
		this.loginEmailId = loginEmailId;
	}

	public final void setPassword(WebElement password) {
		this.password = password;
	}

	public final void setLogInBtn(WebElement logInBtn) {
		this.logInBtn = logInBtn;
	}

	public final void setSignIn(WebElement signIn) {
		this.signIn = signIn;
	}

	// WebDriverWait wait2 = new WebDriverWait(driver, 10);
	// wait2.until(ExpectedConditions.elementToBeClickable(getEmailId()));
	// wait2.until(ExpectedConditions.elementToBeClickable(getPassword()));
	// public void userNamePasswordAndlogin () throws Exception
	public void userNamePasswordAndlogin(final String strUserName, final String strPasword)
			throws Throwable {
		getSignIn().click();
		Log.info(driver.getTitle());
		System.out.print(getLoginEmailId().getText());
		getLoginEmailId().sendKeys(strUserName);
		Log.info("UserID is thrown");
		getPassword().sendKeys(strPasword);
		Log.info("Password is  thrown");
		getLogInBtn().click();
		Log.info("LINKEDIN login successful");

	}
}
