package com.codeOfCritical.PageObjectClasses.Account;

import com.codeOfCritical.PageObjectClasses.Common.HomePageAndLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountArrangementActivityOverview extends HomePageAndLogin {
    private static final Logger log = LogManager.getLogger(AccountArrangementActivityOverview.class.getName());
    private WebDriver driver = null;

    public AccountArrangementActivityOverview(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@id,'Pending')]/td[6]/table/tbody/tr/td[2]/a")
    private WebElement ApproveButton;
    @FindBy(xpath = "//*[contains(@id,'FacilitiesEnquiry')]/td[4]/a")
    private WebElement Block_Funds;
    @FindBy(xpath = "//*[@id='fieldName:ACCOUNT.NUMBER']")
    private WebElement Block_Fund_AC_No;
    @FindBy(xpath = "//*[@id='fieldName:FROM.DATE']")
    private WebElement Block_Fund_FromDate;
    @FindBy(xpath = "//*[@id='fieldName:TO.DATE']")
    private WebElement Block_Fund_ToDate;
    @FindBy(xpath = "//*[@id='fieldName:LOCKED.AMOUNT']")
    private WebElement Block_Fund_LockedAmount;
    @FindBy(xpath = "//*[@id='goButton']/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/a")
    private WebElement Validate_Button;
    @FindBy(xpath = "//*[@id='goButton']/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/a")
    private WebElement Commit_Button;
    @FindBy(xpath = "//*[@id='errorImg']")
    private WebElement Accept_Override;
    @FindBy(xpath = "//*[@id='messages']/tbody/tr[2]/td[2]/table[2]/tbody/tr/td")
    private WebElement Block_Fund_Message;
    @FindBy(xpath = "//*[contains(@id,'r2_Balances')]/td[4]")
    private WebElement Balances_Locked;
    @FindBy(xpath = "//*[contains(@id,'r2_Balances')]/td[5]")
    private WebElement Balances_Available;
    @FindBy(xpath = "//*[contains(@id,'r2_Balances')]/td[3]")
    private WebElement Working_Balance;
    @FindBy(xpath = "//*[contains(@id,'r5_Arrangement')]/td[4]")
    private WebElement Account_Status;

    public WebElement getApproveButton() {
        return ApproveButton;
    }

    public WebElement getBlock_Funds() {
        return Block_Funds;
    }

    public WebElement getBlock_Fund_AC_No() {
        return Block_Fund_AC_No;
    }

    public WebElement getBlock_Fund_FromDate() {
        return Block_Fund_FromDate;
    }

    public WebElement getBlock_Fund_ToDate() {
        return Block_Fund_ToDate;
    }

    public WebElement getBlock_Fund_LockedAmount() {
        return Block_Fund_LockedAmount;
    }

    public WebElement getValidate_Button() {
        return Validate_Button;
    }

    public WebElement getCommit_Button() {
        return Commit_Button;
    }

    public WebElement getAccept_Override() {
        return Accept_Override;
    }

    public WebElement getBlock_Fund_Message() {
        return Block_Fund_Message;
    }

    public WebElement getBalances_Locked() {
        return Balances_Locked;
    }

    public WebElement getBalances_Available() {
        return Balances_Available;
    }

    public WebElement getWorking_Balance() {
        return Working_Balance;
    }

    public WebElement getAccount_Status() {
        return Account_Status;
    }
}
