package com.codeOfCritical.PageObjectClasses.Account;

import com.codeOfCritical.PageObjectClasses.Common.HomePageAndLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountArrangementOverviewDeposits extends HomePageAndLogin {
    private static final Logger log = LogManager.getLogger(AccountArrangementOverviewDeposits.class.getName());

    public AccountArrangementOverviewDeposits(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@id,'RequestPayoff')]/td[2]/a")
    private WebElement Redeem_Deposit;
    @FindBy(xpath = "//*[contains(@id,'PartialWithdrawal')]/td[2]/a")
    private WebElement Withdraw_Deposit;

}
