package com.codeOfCritical.PageObjectClasses.Deposit;

import com.codeOfCritical.CucumberExtentReport.Reporter;
import com.codeOfCritical.PageObjectClasses.Common.HomePageAndLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositArrangementActivity extends HomePageAndLogin {
    private static final Logger log = LogManager.getLogger(DepositArrangementActivity.class.getName());
    private WebDriver driver = null;
    public static ThreadLocal<String> FD_AC_NO = new ThreadLocal<>();

    public DepositArrangementActivity(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@id='treestop4']")
    private WebElement Deposit_img;
    @FindBy(xpath = "//*[@id='r4']/td[4]/a/img")
    private WebElement FixedDeposit_Img;

    @FindBy(xpath = "//*[@id='r2']/td[4]/a[@title='New Arrangement']")
    private WebElement SixMonths_Img;

    @FindBy(id = "fieldName:CUSTOMER:1")
    private WebElement Customer_txtBox;
    @FindBy(id = "fieldName:CURRENCY")
    private WebElement Currency_txtBox;

    @FindBy(xpath = "//*[@id='goButton']/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/a/img")
    private WebElement Validate_btn;
    @FindBy(xpath = "//*[@id='goButton']/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/a/img")
    private WebElement Commit_btn;

    @FindBy(xpath = "//a[text()='Account']")
    private WebElement Account_Link_Amount;

    @FindBy(xpath = "//*[@id='topPart']/div[4]/a")
    private WebElement Commitment_Link;
    @FindBy(xpath = "//a[text()='Settlement Instructions']")
    private WebElement SettlementInstructions_Link;

    @FindBy(id = "fieldName:ACCOUNT.REFERENCE")
    private WebElement AccountRef_txtBox;
    @FindBy(id = "fieldName:AMOUNT")
    private WebElement CommitmentAmount_txtBox;
    @FindBy(id = "fieldName:TERM")
    private WebElement CommitmentTerm_txtBox;
    @FindBy(id = "fieldName:COOLING.PERIOD")
    private WebElement CommitmentCoolingPeriod_txtBox;
    @FindBy(id = "fieldName:PAYIN.ACCOUNT:1:1")
    private WebElement settlementAccount1;
    @FindBy(id = "fieldName:PAYOUT.ACCOUNT:1:1")
    private WebElement settlementAccount2;


    protected final synchronized WebElement getDeposit_img() {
        return Deposit_img;
    }

    protected final synchronized WebElement getFixedDeposit_Img() {
        return FixedDeposit_Img;
    }

    protected final synchronized WebElement getSixMonths_Img() {
        return SixMonths_Img;
    }

    protected final synchronized WebElement getCustomer_txtBox() {
        return Customer_txtBox;
    }

    protected final synchronized WebElement getCurrency_txtBox() {
        return Currency_txtBox;
    }

    protected final synchronized WebElement getValidate_btn() {
        return Validate_btn;
    }

    protected final synchronized WebElement getCommit_btn() {
        return Commit_btn;
    }

    protected final synchronized WebElement getAccount_Link_Amount() {
        return Account_Link_Amount;
    }

    protected final synchronized WebElement getCommitment_Link() {
        return Commitment_Link;
    }

    protected final synchronized WebElement getSettlementInstructions_Link() {
        return SettlementInstructions_Link;
    }

    protected final synchronized WebElement getAccountRef_txtBox() {
        return AccountRef_txtBox;
    }

    protected final synchronized WebElement getCommitmentAmount_txtBox() {
        return CommitmentAmount_txtBox;
    }

    protected final synchronized WebElement getCommitmentTerm_txtBox() {
        return CommitmentTerm_txtBox;
    }

    protected final synchronized WebElement getCommitmentCoolingPeriod_txtBox() {
        return CommitmentCoolingPeriod_txtBox;
    }

    protected final synchronized WebElement getSettlementAccount1() {
        return settlementAccount1;
    }

    protected final synchronized WebElement getSettlementAccount2() {
        return settlementAccount2;
    }

//    @FindBy(id = "PAYIN.ACCOUNT:1:1")
//    private WebElement SettlementInst_SettAcc_txtBox1;
//    @FindBy(id = "PAYOUT.ACCOUNT:1:1")
//    private WebElement SettlementInst_SettAcc_txtBox2;
//
//    protected final synchronized WebElement getSettlementInst_SettAcc_txtBox1() {
//        return SettlementInst_SettAcc_txtBox1;
//    }
//    protected final synchronized WebElement getSettlementInst_SettAcc_txtBox2() {
//        return SettlementInst_SettAcc_txtBox2;
//    }


    /**
     * This method will create a FD Arrangement operation
     *
     * @param Customer
     * @param Currency
     * @param COMMITMENTAMOUNT
     * @param COMMITMENTTERM
     * @param COMMITMENTCOOLINGPERIOD
     * @param SETTLEMENTACCOUNT
     * @throws InterruptedException
     */
    public void SelectArrangementData(String Customer, String Currency, String COMMITMENTAMOUNT, String COMMITMENTTERM, String COMMITMENTCOOLINGPERIOD, String SETTLEMENTACCOUNT) throws InterruptedException {
        try {

            Thread.sleep(2000);
            switchToWindows("AA ARRANGEMENT ACTIVITY");
            log.info("=================Frame Switched======================");

            SendKeysTo(getCustomer_txtBox(), Customer);
            log.info("=================Entered Customer No======================");

            SendKeysTo(getCurrency_txtBox(), Currency);
            log.info("=================Entered Currency======================");

            ClickOnElement(getValidate_btn());
            Thread.sleep(3000);
            ClickOnElement(getAccount_Link_Amount());
            FD_AC_NO.set(getAccountRef_txtBox().getAttribute("value"));
            Reporter.addStepLog("AC NO " + FD_AC_NO.get());
            log.info("AC NO " + FD_AC_NO.get());

            ClickOnElement(getCommitment_Link());
            log.info("Clicked on Commitment link");
            SendKeysTo(getCommitmentAmount_txtBox(), COMMITMENTAMOUNT);
            log.info("Entered Commitment amount :" + COMMITMENTAMOUNT);
            SendKeysTo(getCommitmentTerm_txtBox(), COMMITMENTTERM);
            log.info("Entered Commitment term :" + COMMITMENTTERM);
            SendKeysTo(getCommitmentCoolingPeriod_txtBox(), COMMITMENTCOOLINGPERIOD);
            log.info("Entered Cooling period :" + COMMITMENTCOOLINGPERIOD);

            ClickOnElement(getSettlementInstructions_Link());
            SendKeysTo(driver.findElement(By.id("fieldName:PAYIN.ACCOUNT:1:1")), SETTLEMENTACCOUNT);
            SendKeysTo(driver.findElement(By.id("fieldName:PAYOUT.ACCOUNT:1:1")), SETTLEMENTACCOUNT);

            ClickOnElement(getValidate_btn());
            Thread.sleep(3000);
            ClickOnElement(getCommit_btn());
        } catch (Exception e) {

            log.info(e.getMessage());
        }

//    @FindBy(xpath = "//body/div[@id='pane_']/ul[1]/li[1]/ul[1]/li[5]/ul[1]/li[7]/a[1]")
//    private WebElement Manu_FindDeposit_link;
//    @FindBy(xpath = "")
//    private WebElement CommandBox_editbox;


//    @FindBy(xpath = "//span[contains(text(),'Unauthorised')]")
//    private WebElement AAarrangement_Unauthorised_tab;
//    @FindBy(xpath = "//span[contains(text(),'Authorised')]")
//    private WebElement AAarrangement_Authorised_tab;
//    @FindBy(xpath = "//*[contains(@id,'r1_workarea')]/td[11]")
//    private WebElement AAarrangement_Status_Current;
//    @FindBy(xpath = "//*[contains(@name,'operand:1:1:1')]")
//    private WebElement AAarrangement_arrangement_dropdown;
//    @FindBy(xpath = "//label[text()='Arrangement']/ancestor::td/following-sibling::td[2]/input[1]")
//    private WebElement AAarrangement_arrangement_txtbox;
//    @FindBy(xpath = "//a[contains(text(),'Clear Selection')]")
//    private WebElement AAarrangement_ClearSelection_link;
//    @FindBy(xpath = "//a[contains(text(),'Find')]")
//    private WebElement AAarrangement_Find_btn;
//    @FindBy(xpath = "//a[@title='Overview']")
//    private WebElement AAarrangement_Binacular_btn;
//    @FindBy(xpath = "//*[contains(@id,'drillbox:1_1_Pending')]")
//    private WebElement DepositOverview_Approval_dropdown;
//    @FindBy(xpath = "//a[@title='Select Drilldown']")
//    private WebElement DepositOverview_Approval_DrilDown_img;

    }
}
