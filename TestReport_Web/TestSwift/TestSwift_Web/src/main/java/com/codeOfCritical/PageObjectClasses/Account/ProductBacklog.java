package com.codeOfCritical.PageObjectClasses.Account;

import com.codeOfCritical.PageObjectClasses.Common.HomePageAndLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductBacklog extends HomePageAndLogin {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(ProductBacklog.class.getName());

    public ProductBacklog(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//frame[contains(@id,'ProductGroups')]")
    private WebElement ProductGroups_Frame;
    @FindBy(xpath = "//*[@id='r3']/td[1]/a")
    private WebElement CurrentAccountExpand;
    @FindBy(xpath = "//*[@id='r1']/td[4]/a")
    private WebElement CurrentAccountGroups_Link;
    @FindBy(xpath = "//*[contains(@id,'Products')]")
    private WebElement CurrentAccount_Frame;
    @FindBy(xpath = "//*[@id='r1']/td[4]/a[@title='New Arrangement']")
    private WebElement CurrentAccountLink;
    @FindBy(xpath = "//*[text()='Multi-Currency Current Account']/following-sibling::td[2]/a")
    private WebElement MultiCurrencyCurrentAccount;
    @FindBy(xpath = "//*[@id='r5']/td[1]/a")
    private WebElement FixedDepositExpand;
    @FindBy(xpath = "//td[text()='Fixed Deposits']/following-sibling::td[2]/a")
    private WebElement FixedDepositGroups_Link;
    @FindBy(xpath = "//frame[contains(@id,'Products')]")
    private WebElement Fixed_Deposit_Frame;
    @FindBy(xpath = "//frame[contains(@id,'ProductGroups')]")
    private WebElement Fixed_Deposit_Frame_1;
    @FindBy(xpath = "//*[@id='r1']/td[4]/a[@title='New Arrangement']")
    private WebElement FixedDeposit;
    @FindBy(xpath = "//*[@id='r2']/td[4]/a[@title='New Arrangement']")
    private WebElement FixedDeposit06Months;
    @FindBy(xpath = "//*[@id='r3']/td[4]/a[@title='New Arrangement']")
    private WebElement FixedDeposit09Months;
    @FindBy(xpath = "//*[@id='r4']/td[4]/a[@title='New Arrangement']")
    private WebElement FixedDeposit12Months;
    @FindBy(xpath = "//*[@id='r5']/td[4]/a[@title='New Arrangement']")
    private WebElement FixedDeposit18Months;
    @FindBy(xpath = "//*[@id='r12']/td[1]/a")
    private WebElement MultiCurrencyAccount_Expand;
    @FindBy(xpath = "//*[@id='r11']/td[4]/a")
    private WebElement MultiCurrencyAccount_Product_Link;
    @FindBy(xpath = "//*[contains(@id,'Products')]")
    private WebElement MultiCurrencyAccount_Product_Frame;
    @FindBy(xpath = "//*[@id='r1']/td[4]/a")
    private WebElement MultiCurrencyAccount_arrangement;

    protected final synchronized WebElement getProductGroups_Frame() {
        return ProductGroups_Frame;
    }

    protected final synchronized WebElement getCurrentAccountExpand() {
        return CurrentAccountExpand;
    }

    protected final synchronized WebElement getCurrentAccountGroups_Link() {
        return CurrentAccountGroups_Link;
    }

    protected final synchronized WebElement getCurrentAccount_Frame() {
        return CurrentAccount_Frame;
    }

    protected final synchronized WebElement getCurrentAccountLink() {
        return CurrentAccountLink;
    }

    protected final synchronized WebElement getMultiCurrencyCurrentAccount() {
        return MultiCurrencyCurrentAccount;
    }

    protected final synchronized WebElement getFixedDepositExpand() {
        return FixedDepositExpand;
    }

    protected final synchronized WebElement getFixedDepositGroups_Link() {
        return FixedDepositGroups_Link;
    }

    protected final synchronized WebElement getFixed_Deposit_Frame() {
        return Fixed_Deposit_Frame;
    }

    protected final synchronized WebElement getFixedDeposit() {
        return FixedDeposit;
    }

    protected final synchronized WebElement getFixedDeposit06Months() {
        return FixedDeposit06Months;
    }

    protected final synchronized WebElement getFixedDeposit09Months() {
        return FixedDeposit09Months;
    }

    protected final synchronized WebElement getFixedDeposit12Months() {
        return FixedDeposit12Months;
    }

    protected final synchronized WebElement getFixedDeposit18Months() {
        return FixedDeposit18Months;
    }

    protected final synchronized WebElement getMultiCurrencyAccount_Expand() {
        return MultiCurrencyAccount_Expand;
    }

    protected final synchronized WebElement getMultiCurrencyAccount_Product_Link() {
        return MultiCurrencyAccount_Product_Link;
    }

    protected final synchronized WebElement getMultiCurrencyAccount_Product_Frame() {
        return MultiCurrencyAccount_Product_Frame;
    }

    protected final synchronized WebElement getMultiCurrencyAccount_arrangement() {
        return MultiCurrencyAccount_arrangement;
    }

    protected final synchronized WebElement getFixed_Deposit_Frame_1() {
        return Fixed_Deposit_Frame_1;
    }

    public void multiCurrencyArrangement() {
        switchToFrame(getCurrentAccount_Frame());
        ClickOnElement(getMultiCurrencyAccount_Expand());
        ClickOnElement(getMultiCurrencyCurrentAccount());
        ClickOnElement(getMultiCurrencyAccount_Product_Link());
        switchToFrame(getMultiCurrencyAccount_Product_Frame());
        ClickOnElement(getMultiCurrencyAccount_arrangement());
        log.info("Navigated to Multi-Currency arrangement and clicked");

    }

    public void currentAccountArrangement() {
        switchToFrame(getCurrentAccount_Frame());
        ClickOnElement(getCurrentAccountExpand());
        ClickOnElement(getCurrentAccountGroups_Link());
        switchToFrame(getCurrentAccount_Frame());
        ClickOnElement(getCurrentAccountLink());
        log.info("Navigated Current arrangement and clicked");
    }

    public void FixedDepositArrangement(String term) {
        switchToFrame(getFixed_Deposit_Frame_1());
        ClickOnElement(getFixedDepositExpand());
        ClickOnElement(getFixedDepositGroups_Link());
        switchToFrame(getFixed_Deposit_Frame());
        if (term.equals(6)) {
            ClickOnElement(getFixedDeposit06Months());
        } else if (term.equals(9)) {
            ClickOnElement(getFixedDeposit09Months());
        } else if (term.equals(12)) {
            ClickOnElement(getFixedDeposit12Months());
        } else if (term.equals(18)) {
            ClickOnElement(getFixedDeposit18Months());
        } else {
            ClickOnElement(getFixedDeposit());
        }

        log.info("Navigated Fixed Deposit and clicked");
    }
}
