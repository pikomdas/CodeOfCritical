package com.linkedin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.Browser.browser;

public class afterApplyPopups extends browser {

	public afterApplyPopups(WebDriver driver) {
		browser.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button.button-secondary-large.full-width.mt3.js-post-apply-no-thanks")
	WebElement NoThanks;

	public final WebElement getNoThanks() {
		return NoThanks;
	}

	public final void setNoThanks(WebElement noThanks) {
		NoThanks = noThanks;
	}

	public void pop1() {

		getNoThanks().click();
	}

}
