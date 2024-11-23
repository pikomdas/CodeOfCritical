package com.codeOfCritical.PageObjectClasses.Common;

import com.codeOfCritical.BaseClass.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VPN extends Browser
{
    private static final Logger log = LogManager.getLogger(VPN.class.getName());
    private WebDriver driver = null;

    public VPN(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement VPN_UserName_txtBox;
    @FindBy(id = "credential")
    private WebElement VPN_Password_txtBox;
    @FindBy(id = "login_button")
    private WebElement VPN_LogIn_Btn;
    @FindBy(xpath = "//body/section[@id='navbar-view-section']/div[1]/div[1]/div[2]/div[2]/div[2]/button[1]/div[1]/f-icon[1]")
    private WebElement VPN_Bookmark_Btn;

    protected final synchronized WebElement getVPN_UserName_txtBox()
    {
        return VPN_UserName_txtBox;
    }

    protected final synchronized WebElement getVPN_Password_txtBox()
    {
        return VPN_Password_txtBox;
    }

    protected final synchronized WebElement getVPN_LogIn_Btn()
    {
        return VPN_LogIn_Btn;
    }

    protected final synchronized WebElement getVPN_Bookmark_Btn()
    {
        return VPN_Bookmark_Btn;
    }

    public void loginToVPN(String userName, String password)
    {
        SendKeysTo(getVPN_UserName_txtBox(), userName);
        SendKeysTo(getVPN_Password_txtBox(), password);
        ClickOnElement(getVPN_LogIn_Btn());
        ClickOnElement(getVPN_Bookmark_Btn());
    }
}
