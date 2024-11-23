package com.codeOfCritical.PageObjectClasses.Account;

import com.codeOfCritical.PageObjectClasses.Deposit.DepositArrangementActivity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountArrangementSimulationDataCapture extends DepositArrangementActivity {
    private static final Logger log = LogManager.getLogger(DepositArrangementActivity.class.getName());

    private WebDriver driver;

    public AccountArrangementSimulationDataCapture(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='fieldName:EFFECTIVE.DATE']")
    private WebElement Redemtion_Date;
    @FindBy(xpath = "//*[@id='fieldName:CLOSURE.REASON']")
    private WebElement Closure_Reason;
    @FindBy(xpath = "//*[@id='goButton']/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/a")
    private WebElement VALIDATE_BUTTON;
    @FindBy(xpath = "//*[@id='goButton']/tbody/tr/td/table/tbody/tr/td/div[1]/table/tbody/tr/td[1]/a")
    private WebElement COMMIT_BUTTON;

    public WebElement getRedemtion_Date() {
        return Redemtion_Date;
    }

    public WebElement getClosure_Reason() {
        return Closure_Reason;
    }

    public WebElement getVALIDATE_BUTTON() {
        return VALIDATE_BUTTON;
    }

    public WebElement getCOMMIT_BUTTON() {
        return COMMIT_BUTTON;
    }
}
