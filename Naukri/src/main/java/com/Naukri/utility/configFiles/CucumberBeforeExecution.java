package com.Naukri.utility.configFiles;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Naukri.BrowserBase.browser;
import com.Naukri.PageObjectClasses.JobSearchResultPage;
import com.Naukri.PageObjectClasses.LandingPage;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

public class CucumberBeforeExecution extends browser {

	private Scenario scenario;
	private static final Logger log = LogManager.getLogger(JobSearchResultPage.class.getName());
	protected static String screenshotFolderName;

	public CucumberBeforeExecution() {
		
	}
	
	public CucumberBeforeExecution(Scenario scenario) throws Exception {
		this.setScenario(scenario);
		log.info("Scenario is =========================================:" + scenario.getName());
		Reporter.assignAuthor(System.getProperty("user.name"));
		log.info(getClass().getName());
		browser br = new browser();
		br.selectBrowser(getProperty.readBrowserName("br_name"));
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		
		String originalHandle = driver.getWindowHandle();
		// Closing all popUp windows while LogIn
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(originalHandle);

		// Create a directory to collect screenshot
		java.util.Calendar cal = java.util.Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String formattedDate = dateFormat.format(date);
		File sDirectory = new File(getProperty.readScreenshotLocation("stepImageLocation") + "/"+formattedDate);
		boolean b = sDirectory.mkdir();
		log.info("Folder creation to captureScreenShot is :" + b);

		screenshotFolderName = sDirectory.getName();

		LandingPage lp = new LandingPage(driver);
		lp.clickOnTopsideLoginButton();
		try {
			lp.loginToNaukri("pikom.das@gmail.com", "9038583164");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		log.info("Login Successful");

	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

}
