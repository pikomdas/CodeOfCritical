package com.linkedin.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.browser;
import commomUtil.Log;

public class searchJobApplyPage extends browser {

	WebDriverWait w =new WebDriverWait(driver,5);
	
	public searchJobApplyPage(final WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//button[starts-with(@class,'jobs-apply-form__upload-options-text Sans-15px-black-70%-semibold')]")
	WebElement resumeSelect;
	@FindBy(xpath= "//button[starts-with(@class,'jobs-apply-form__submit-button button-primary-large ')]")
	WebElement submitApplicationButton;
	@FindBy(xpath= "//button[starts-with(@class,'jobs-candidate-initiate-referral__referral-button button-tertiary-large full-width')]")
	WebElement askForAReferral;
	@FindAll({
		@FindBy(css = "div[class='.job-card-search__title-line']")})
	List<WebElement> jobName;
	@FindAll({
		@FindBy(xpath = "//h3[@class,'job-card-search__company-name']")})
	List<WebElement> cmpanyName;
	
	@FindBy(xpath= "//button[starts-with(@class,'job-card-search__easy-apply-text')]")
	WebElement easyApplyButton;
	/**
	 * @return the easyApplyButton
	 */
	public final WebElement getEasyApplyButton() {
		return easyApplyButton;
	}
	/**
	 * @param easyApplyButton the easyApplyButton to set
	 */
	public final void setEasyApplyButton(WebElement easyApplyButton) {
		this.easyApplyButton = easyApplyButton;
	}
	/**
	 * @return the resumeSelect
	 */
	public final WebElement getResumeSelect() {
		return resumeSelect;
	}
	/**
	 * @param resumeSelect the resumeSelect to set
	 */
	public final void setResumeSelect(WebElement resumeSelect) {
		this.resumeSelect = resumeSelect;
	}
	/**
	 * @return the submitApplicationButton
	 */
	public final WebElement getSubmitApplicationButton() {
		return submitApplicationButton;
	}
	/**
	 * @param submitApplicationButton the submitApplicationButton to set
	 */
	public final void setSubmitApplicationButton(WebElement submitApplicationButton) {
		this.submitApplicationButton = submitApplicationButton;
	}
	/**
	 * @return the askForAReferral
	 */
	public final WebElement getAskForAReferral() {
		return askForAReferral;
	}
	/**
	 * @param askForAReferral the askForAReferral to set
	 */
	public final void setAskForAReferral(WebElement askForAReferral) {
		this.askForAReferral = askForAReferral;
	}
	/**
	 * @return the jobName
	 */
	public final List<WebElement> getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public final void setJobName(List<WebElement> jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the cmpanyName
	 */
	public final List<WebElement> getCmpanyName() {
		return cmpanyName;
	}
	/**
	 * @param cmpanyName the cmpanyName to set
	 */
	public final void setCmpanyName(List<WebElement> cmpanyName) {
		this.cmpanyName = cmpanyName;
	}

	public void clickOnJoblink() 
	{

		for (WebElement e : getJobName()) {

			//w.until(ExpectedConditions.elementToBeClickable(e));
			System.out.println(e.getText().toString());
			e.click();
			Log.info("Clicked on Job --- Location on Page :     " + e.getLocation());
			int jobApplyNumber =0;
			for (WebElement f : getCmpanyName()) {
			   // w.until(ExpectedConditions.visibilityOf(f));
				System.out.println(f.getText());
				Log.info("Company name is : " + f.getText());
				try {
					clickonEasyApply();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jobApplyNumber =jobApplyNumber + 1;
				Log.info("Completed One Job Apply." + jobApplyNumber);
			}
		}
     }
	//Navigate Back
	public void navigateBack()
	{
		
		String prvPage=driver.getTitle();
		driver.navigate().back();
		String curPage=driver.getTitle();
		System.out.println(prvPage + "is currentpage and navigated back to " +curPage);
		Log.info(prvPage + "is currentpage and navigated back to " +curPage);
		
	}
	//Click on Easy Apply
	public void clickonEasyApply() {
		if(getEasyApplyButton().isDisplayed()) {
			System.out.println("Button is displayed: " + getEasyApplyButton().getText());
		    getEasyApplyButton().click();
		    Log.info("clicked on " + getEasyApplyButton().getText() );
		}
	}








} //end of class