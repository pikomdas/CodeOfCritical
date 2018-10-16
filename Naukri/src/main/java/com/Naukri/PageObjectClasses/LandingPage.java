package com.Naukri.PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukri.BrowserBase.browser;

public class LandingPage extends browser{

	WebDriverWait w1=new WebDriverWait(driver,10);
public LandingPage( WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//*[@id=\"login_Layer\"]/div")
WebElement LoginButtonOnTopSide;

@FindBy(name="email")
WebElement UserName;

@FindBy(name="PASSWORD")
WebElement Password;

@FindBy(xpath="")
WebElement loginButton;

public WebElement getLoginButton() {
	return loginButton;
}

public void setLoginButton(WebElement loginButton) {
	this.loginButton = loginButton;
}

public WebElement getLoginButtonOnTopSide() {
	return LoginButtonOnTopSide;
}

public void setLoginButtonOnTopSide(WebElement loginButtonOnTopSide) {
	LoginButtonOnTopSide = loginButtonOnTopSide;
}

public WebElement getUserName() {
	return UserName;
}

public void setUserName(WebElement userName) {
	UserName = userName;
}

public WebElement getPassword() {
	return Password;
}

public void setPassword(WebElement password) {
	Password = password;
}
 //Method to login
public void loginToNaukri(String username,String Password) {
	w1.until(ExpectedConditions.elementToBeClickable(getLoginButtonOnTopSide()));
	getLoginButtonOnTopSide().click();
	getUserName().sendKeys(username);
	getPassword().sendKeys(Password);
	getLoginButton().click();
}

}//End of Class