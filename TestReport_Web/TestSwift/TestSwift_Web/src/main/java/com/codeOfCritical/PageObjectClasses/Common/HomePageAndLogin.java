package com.codeOfCritical.PageObjectClasses.Common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAndLogin extends T24LoginPage {
    private static final Logger log = LogManager.getLogger(HomePageAndLogin.class.getName());
    private WebDriver driver = null;

    public HomePageAndLogin(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/section[@id='navbar-view - section']/div[1]/div[1]/div[2]/div[2]/div[2]/button[1]/div[1]/f-icon[1]")
    private WebElement VPN_Bookmark_Btn;
    private WebElement T24_LogIn_Btn;
    @FindBy(xpath = "//span[text()='User Menu']") //""
    private WebElement Home_UserMenu_Menu;
    @FindBy(xpath = "//body/div[@id='pane_']/ul[1]/li[1]/ul[1]/li[2]/span[1]")
    private WebElement Home_Customer_Menu;

    @FindBy(xpath = "//frame[contains(@id,'menu')]")
    private WebElement Home_Menu_Frame;

//    @FindBy(xpath = "//frame[contains(@id,'banner')]")
//    private WebElement Home_Top_Frame;

    @FindBy(xpath = "")
    private WebElement Home_Help_Link;
    @FindBy(xpath = "//*[@id='pane_']/ul[1]/li/ul/li[8]/span")
    private WebElement Home_RetailOperation;
    @FindBy(xpath = "//*[@id='pane_']/ul[1]/li/ul/li[8]/ul/li[1]/a")
    private WebElement Home_RetailOperation_ProductCatalog;

    @FindBy(xpath = "//*[@id='pane_']/div[1]/div/table/tbody/tr/td[2]/a")
    private WebElement Home_Tools_link;

    @FindBy(xpath = "//*[@id='pane_']/ul[2]/li/span")
    private WebElement MyCompanies;
    @FindBy(xpath = "//a[text()='GLDB Singapore']")
    private WebElement GLDB_Singapore;
    @FindBy(xpath = "//a[text()='Find Account ']")
    private WebElement Home_RetailOperation_FindAccount;
    @FindBy(xpath = "//a[text()='Find Deposit']")
    private WebElement Home_RetailOperation_FindDeposit;
    @FindBy(xpath = "//*[@id='pane_']/div[1]/div/table/tbody/tr/td[3]/a")
    private WebElement SignOut;
    @FindBy(xpath = "//frame[contains(@id,'banner')]")
    private WebElement Home_ToolBar_Frame;
    //    @FindBy(xpath = "//frame[contains(@id,\"banner\")]")
//    private WebElement Home_MyCompanies_Menu;
    @FindBy(xpath = "//a[text()='GLDB Singapore ']")
    private WebElement Home_GLDB_Singapore;
    @FindBy(id = "commandValue")
    private WebElement GLDBSingaporeHome_Search_TextBox;
    @FindBy(xpath = "//a[@title='Go']")
    private WebElement GLDBSingaporeHome_Search_Button;
    @FindBy(xpath = "//a[contains(text(),'Sign Off')]")
    private WebElement Home_SignOff_Link;
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement Products_Link;
    @FindBy(xpath = "//a[text()='Product Catalog ']")
    private WebElement ProductCatalog_Link;
    @FindBy(xpath = "//*[@id='pane_']/ul[1]/li/ul/li[9]/span")
    private WebElement Payments_Link;
    @FindBy(xpath = "//*[@id='pane_']/ul[1]/li/ul/li[9]/ul/li[2]/span")
    private WebElement PaymentsHub_Link;
    @FindBy(xpath = "//a[text()='Account Transfer ']")
    private WebElement AccountTransfer_Link;
    @FindBy(xpath = "//*[@id='pane_']/ul[1]/li/ul/li[3]/span")
    private WebElement Account_Link;
    @FindBy(xpath = "//span[text()='Account Enquiries']")
    private WebElement AccountEnquiries_Link;
    @FindBy(xpath = "//a[text()='Locked Amounts']")
    private WebElement LockedAccount_Link;


    protected final synchronized WebElement getHome_ToolBar_Frame() {
        return Home_ToolBar_Frame;
    }

    protected final synchronized WebElement getHome_Tools_link() {
        return Home_Tools_link;
    }

    protected final synchronized WebElement getHome_UserMenu_Menu() {
        return Home_UserMenu_Menu;
    }

    protected final synchronized WebElement getHome_Customer_Menu() {
        return Home_Customer_Menu;
    }

    protected final synchronized WebElement getHome_Menu_Frame() {
        return Home_Menu_Frame;    }

    protected final synchronized WebElement getHome_Help_Link() {
        return Home_Help_Link;
    }

    protected final synchronized WebElement getHome_RetailOperation() {
        return Home_RetailOperation;
    }

    protected final synchronized WebElement getHome_RetailOperation_ProductCatalog() {
        return Home_RetailOperation_ProductCatalog;
    }

    protected final synchronized WebElement getMyCompanies() {
        return MyCompanies;
    }

    protected final synchronized WebElement getGLDB_Singapore() {
        return GLDB_Singapore;
    }

    protected final synchronized WebElement getHome_RetailOperation_FindAccount() {
        return Home_RetailOperation_FindAccount;
    }

    protected final synchronized WebElement getHome_RetailOperation_FindDeposit() {
        return Home_RetailOperation_FindDeposit;
    }

    protected final synchronized WebElement getSignOut() {
        return SignOut;
    }

    protected final synchronized WebElement getHome_GLDB_Singapore() {
        return Home_GLDB_Singapore;
    }

    protected final synchronized WebElement getGLDBSingaporeHome_Search_TextBox() {
        return GLDBSingaporeHome_Search_TextBox;
    }

    protected final synchronized WebElement getGLDBSingaporeHome_Search_Button() {
        return GLDBSingaporeHome_Search_Button;
    }

    protected final synchronized WebElement getHome_SignOff_Link() {
        return Home_SignOff_Link;
    }

    protected final synchronized WebElement getProducts_Link() {
        return Products_Link;
    }

    protected final synchronized WebElement getProductCatalog_Link() {
        return ProductCatalog_Link;
    }

    protected final synchronized WebElement getPayments_Link() {
        return Payments_Link;
    }

    protected final synchronized WebElement getPaymentsHub_Link() {
        return PaymentsHub_Link;
    }

    protected final synchronized WebElement getAccountTransfer_Link() {
        return AccountTransfer_Link;
    }

    protected final synchronized WebElement getAccount_Link() {
        return Account_Link;
    }

    protected final synchronized WebElement getAccountEnquiries_Link() {
        return AccountEnquiries_Link;
    }

    protected final synchronized WebElement getLockedAccount_Link() {
        return LockedAccount_Link;
    }

    // Manoj Added
    public HomePageAndLogin SelectCompany() {
        switchToFrame(getHome_ToolBar_Frame());
        log.info("Switch to Top Frame");

        ClickOnElement(getHome_Tools_link());
        log.info("Click on Tools Link");

        switchToWindows("Temenos T24");
        log.info("Switch to Windoe T24 TEMENOS");

        ClickOnElement(getMyCompanies());
        log.info("Click on My Company");

        ClickOnElement(getHome_GLDB_Singapore());
        log.info("Click on GLDB SIngapore");
        log.info("========= Company Selected =========");
        return this;
    }

    public HomePageAndLogin goTo88Menu(String text) throws InterruptedException {
        Thread.sleep(3000);
        switchToWindows("T24 - GLDB Singapore");
        log.info("Switch to Window T24 - GLDB Singapore");

        switchToWindows("Temenos T24");
        log.info("Again Switch to Windoe T24 TEMENOS");
        driver.close();
        log.info("Again Switch to Windoe T24 TEMENOS closed");

        switchToWindows("T24 - GLDB Singapore");
        log.info("Switch to Window T24 - GLDB Singapore");

        switchToFrame(getHome_ToolBar_Frame());
        log.info("Switch to Top Frame");

        SendKeysTo(getGLDBSingaporeHome_Search_TextBox(), text);
        log.info("Text entered into the search box");

        ClickOnElement(getGLDBSingaporeHome_Search_Button());
        log.info("Clicked on GLDB text box search button");

        Thread.sleep(3000);
        switchToWindows("Temenos T24");
        log.info("Switching to ?88 Temenos T24");
        return this;
    }

    public HomePageAndLogin navigateToFindAccount() {
        ClickOnElement(getHome_UserMenu_Menu());
        log.info("User Menu expanded.");
        ClickOnElement(getProducts_Link());
        log.info("Product link expanded.");
        ClickOnElement(getHome_RetailOperation_FindAccount());
        log.info("Clicked on Find Account");
        return this;
    }

    public HomePageAndLogin navigateToProductCatalog() throws InterruptedException {
        log.info("Again Switch to Window T24 TEMENOS");
        ClickOnElement(getHome_UserMenu_Menu());
        log.info("User Menu expanded.");
        ClickOnElement(getProducts_Link());
        log.info("Product link expanded.");
        ClickOnElement(getProductCatalog_Link());
        log.info("Clicked on Product Catalog");
        Thread.sleep(3000);
        switchToWindows("T24 Product Catalog - GLDB Singapore");
        log.info("Switched to T24 Product Catalog - GLDB Singapore");
        return this;
    }

    public HomePageAndLogin singOff() {
        switchToWindows("T24 - GLDB Singapore");
        log.info("Switch to Window T24 - GLDB Singapore");
        switchToFrame(getHome_ToolBar_Frame());
        log.info("Switch to Top Frame");
        ClickOnElement(getHome_SignOff_Link());
        log.info("clicked to sign off link");
        return this;
    }
}
