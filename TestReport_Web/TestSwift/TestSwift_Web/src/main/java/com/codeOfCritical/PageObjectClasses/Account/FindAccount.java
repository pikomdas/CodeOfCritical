package com.codeOfCritical.PageObjectClasses.Account;

import com.codeOfCritical.CucumberExtentReport.Reporter;
import com.codeOfCritical.PageObjectClasses.Common.HomePageAndLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAccount extends HomePageAndLogin {

    private static final Logger log = LogManager.getLogger(FindAccount.class.getName());
    private WebDriver driver;

    public FindAccount(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id,'headtab_main')]/tbody/tr/td[1]/a")
    private WebElement Authorisedtab;
    @FindBy(xpath = "//*[contains(@id,'headtab_main')]/tbody/tr/td[2]/a")
    private WebElement UnAuthorisedtab;
    @FindBy(xpath = "//label[text()='Arrangement']/ancestor::td/following-sibling::td[2]/input[1]")
    private WebElement UnAuthorisedArrangement;
    @FindBy(xpath = "//label[text()='Arrangement']/ancestor::td/following-sibling::td[2]/input[1]")
    private WebElement AuthorisedArrangement;
    @FindBy(xpath = "//a[text()='Find']")
    private WebElement FindButton;
    @FindBy(xpath = "//a[@title='Overview']")
    private WebElement Overview;
    @FindBy(xpath = "//*[contains(@id,'workarea')]/td[11]")
    private WebElement Authorised_Status;
    @FindBy(xpath = "//*[contains(@id,'workarea')]/td[12]/a")
    private WebElement Authorised_Overview;
    @FindBy(xpath = "//a[text()='Clear Selection']")
    private WebElement ClearSelection;
    @FindBy(xpath = "//a[@title='Refresh']")
    private WebElement Refresh_Button;
    @FindBy(xpath = "//*[contains(@id,'r1_workarea')]/td[10]")
    private WebElement AuthorisedTab_Status;
    @FindBy(xpath = "//*[contains(@id,'r1_workarea')]/td[6]")
    private WebElement UnAutothorisedTab_Status;
    @FindAll({@FindBy(xpath = "//tr[contains(@id,'r1_workarea')]")})
    private List<WebElement> authorisedFindAccountDetailsValues;
    @FindAll({@FindBy(xpath = "//*[contains(@id,'headingdisplay_workarea')]/thead/tr")})
    private List<WebElement> authorisedFindAccountDetailsHeaders;

    protected final synchronized WebElement Authorisedtab() {
        return Authorisedtab;
    }

    protected final synchronized WebElement UnAuthorisedtab() {
        return UnAuthorisedtab;
    }

    protected final synchronized WebElement getUnAuthorisedArrangement() {
        return UnAuthorisedArrangement;
    }

    protected final synchronized WebElement AuthorisedArrangement() {
        return AuthorisedArrangement;
    }

    protected final synchronized WebElement getFindButton() {
        return FindButton;
    }

    protected final synchronized WebElement getOverview() {
        return Overview;
    }

    protected final synchronized WebElement getAuthorised_Status() {
        return Authorised_Status;
    }

    protected final synchronized WebElement getAuthorised_Overview() {
        return Authorised_Overview;
    }

    protected final synchronized WebElement getClearSelection() {
        return ClearSelection;
    }

    protected final synchronized WebElement getRefresh_Button() {
        return Refresh_Button;
    }

    protected final synchronized WebElement getAuthorisedTab_Status() {
        return AuthorisedTab_Status;
    }

    protected final synchronized WebElement UnAutothorisedTab_Status() {
        return UnAutothorisedTab_Status;
    }

    public List<WebElement> getAuthorisedFindAccountDetailsValues() {
        return authorisedFindAccountDetailsValues;
    }

    public List<WebElement> getAuthorisedFindAccountDetailsHeaders() {
        return authorisedFindAccountDetailsHeaders;
    }

    public FindAccount checkStatusAndClickOnOverview(Boolean details, Boolean Overview) {
        switchToWindows("AA Arrangement - GLDB Singapore");
        if (details) {
            List<String> values = handleTable(getAuthorisedFindAccountDetailsValues())
                    .get(0)
                    .stream()
                    .map(x -> x.getText())
                    .filter(x -> !x.isEmpty())
                    .collect(Collectors.toList());
//            System.out.println(values + " " + values.size());
            List<String> keys = getAuthorisedFindAccountDetailsHeaders()
                    .stream()
                    .flatMap(x -> x.findElements(By.xpath("./th")).stream().map(WebElement::getText))
                    .filter(x -> !x.isEmpty())
                    .collect(Collectors.toList());
//            System.out.println(keys + " " + keys.size());
            Map<String, String> findAccountDetails = IntStream.range(0, values.size())
                    .boxed()
                    .collect(Collectors.toMap(i -> keys.get(i), i -> values.get(i)));
            findAccountDetails.forEach((x, y) -> {
                Reporter.addStepLog(x + "=" + y);
                log.info(x + "=" + y);
            });
        }
        if (Overview) {
            ClickOnElement(getOverview());
            log.info("Clicked on overview button.");
        }
        return this;
    }

    public FindAccount enterAccountNumberAndFind(String acNo) {
        switchToWindows("AA Arrangement - GLDB Singapore");
        ClickOnElement(getClearSelection());
        SendKeysTo(getUnAuthorisedArrangement(), acNo);
        ClickOnElement(getFindButton());
        return this;
    }
}

