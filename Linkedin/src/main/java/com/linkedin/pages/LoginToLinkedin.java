package src.main.java.com.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.CheckPageLoadingState;

public class LoginToLinkedin extends browser
{
	private WebDriverWait w1 = new WebDriverWait(driver, 10);
	private static Logger log = LogManager.getLogger(LoginToLinkedin.class.getName());

	@FindBy(xpath = "//input[@id='username']")
	private WebElement loginEmailId;
	@FindBy(css = "input[id*='password']")
	private WebElement password;
	@FindBy(xpath = "//*[text()='Sign in']")
	private WebElement logInBtn;
	@FindBy(xpath = "//*[@class='nav__button-secondary' and text()='Sign in']")
	private WebElement signIn;

	public LoginToLinkedin(final WebDriver driver)
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

	public void userNamePasswordAndlogin(final String strUserName, final String strPasword) throws Exception
	{
		// Click on Sign in
		ClickOnElement(getSignIn());
		// Waiting to complete the page loading
		CheckPageLoadingState.waitToLoadPage();

		String title1 = driver.getTitle();
		log.info("Page title is :" + title1);

		// Sending userName
		SendKeysTo(getLoginEmailId(), strUserName);
		log.info("UserID is thrown");
		// Sending Password
		SendKeysTo(getPassword(), strPasword);
		log.info("Password is  thrown");
		// Click on Login Button
		ClickOnElement(getLogInBtn());

		// Waiting to complete the page loading
		CheckPageLoadingState.waitToLoadPage();
		
		// New page title
		String title2 = driver.getTitle();
		if (title1.equals(title2))
		{
			log.error("Login Failed");
		}
		else
		{
			log.info("LINKEDIN login successful");
		}

	}
}
