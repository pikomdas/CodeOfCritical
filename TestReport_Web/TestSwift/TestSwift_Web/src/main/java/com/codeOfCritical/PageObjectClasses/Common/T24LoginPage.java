package com.codeOfCritical.PageObjectClasses.Common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class T24LoginPage extends VPN {
    private WebDriver driver = null;
    private static final Logger log = LogManager.getLogger(T24LoginPage.class);
    public T24LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "signOnName")
    private WebElement T24_UserName_txtBox;
    @FindBy(id = "password")
    private WebElement T24_Password_txtBox;
    @FindBy(id = "sign-in")
    private WebElement T24_LogIn_Btn;

    protected final synchronized WebElement getT24_UserName_txtBox() {
        return T24_UserName_txtBox;
    }

    protected final synchronized WebElement getT24_Password_txtBox() {
        return T24_Password_txtBox;
    }

    protected final synchronized WebElement getT24_LogIn_Btn() {
        return T24_LogIn_Btn;
    }

    public void loginT24(String userName, String password) {
//        w1.until(ExpectedConditions.titleIs("Transact Sign in"));
        switchToWindows("Transact Sign in");
//        ClickOnElement(getT24_UserName_txtBox());
        SendKeysTo(getT24_UserName_txtBox(), userName);
//        ClickOnElement(getT24_Password_txtBox());
        SendKeysTo(getT24_Password_txtBox(), password);
//        SendKeysTo(getT24_UserName_txtBox(), userName);
        ClickOnElement(getT24_LogIn_Btn());
        log.info("T24 log in successful");
    }
}
