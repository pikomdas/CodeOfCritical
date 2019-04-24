package com.Naukri.PageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Naukri.BrowserBase.browser;
import com.Naukri.FileReaderManager.Log;

public class LandingPage extends browser {
	private static final Logger log = LogManager.getLogger(LandingPage.class.getName());
	public LandingPage(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='login_Layer']/div") // xpath "/html/body/div[2]/div/ul/li[6]/a/div"
	WebElement LoginButtonOnTopSide;
    @FindBy(name = "email")
	WebElement UserName;
    @FindBy(name = "PASSWORD")
	WebElement Password;
    @FindBy(xpath = "//*[@id=\'lgnFrmNew\']/div[9]/button")
	WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(final WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getLoginButtonOnTopSide() {
		return LoginButtonOnTopSide;
	}

	public void setLoginButtonOnTopSide(final WebElement loginButtonOnTopSide) {
		this.LoginButtonOnTopSide = loginButtonOnTopSide;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public void setUserName(final WebElement userName) {
		this.UserName = userName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public void setPassword(final WebElement password) {
		this.Password = password;
	}

	// Click on top side login Button
	public void clickOnTopsideLoginButton() {
		 Log.info("Page name is: " +driver.getTitle());
//		 WebDriverWait w1 = new WebDriverWait(driver, 10);
//		 w1.until(ExpectedConditions.visibilityOf(getLoginButtonOnTopSide()));
//       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (getLoginButtonOnTopSide().isDisplayed() == true) {
			log.info("TOP SIDE LOGIN button is Present");
			getLoginButtonOnTopSide().click();
		} else {
			throw new ElementNotVisibleException("Top Side LogIn button is not available");
		}
	}

	// Method to login
	public void loginToNaukri(final String username, final String Password) throws Throwable {
		getUserName().sendKeys(username);
		getPassword().sendKeys(Password);
		getLoginButton().click();
	}

}// End of Class