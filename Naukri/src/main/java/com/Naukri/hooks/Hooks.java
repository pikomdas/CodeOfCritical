package com.Naukri.hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Naukri.BrowserBase.browser;
import com.Naukri.PageObjectClasses.JobSearchResultPage;
import com.Naukri.utility.configFiles.CucumberAfterStepCode;
import com.Naukri.utility.configFiles.CucumberBeforeExecution;
import com.Naukri.utility.configFiles.cucumberReportAfterExecution;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hooks extends browser
{

	private static final Logger log = LogManager.getLogger(JobSearchResultPage.class.getName());

	public Hooks()
	{
		log.info("_____________ INITIALIZE CUSTOM HOOKS FOR NAUKRI.COM _____________");
	}

	// @Before
	// public void beforeScenarioWithOutTag(Scenario scenario) throws Exception {
	//
	// @SuppressWarnings("unused")
	// CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
	// }

	@Before("@test")//({ "@ReportCheck,@SmokeTest,@addTxn,@srchTxn" })
	public void beforeScenario(Scenario scenario) throws Exception {

		@SuppressWarnings("unused")
		CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
	}

	@After
	public void beforeSecondRnd(Scenario scenario) throws Exception {
		log.info(getClass().getName());

		@SuppressWarnings("unused")
		cucumberReportAfterExecution crae = new cucumberReportAfterExecution(scenario);
	}

	@AfterStep
	public void doSomethingAfterStep() throws Exception {

		Reporter.addStepLog("XXXXXXXXXXXXXXXX Refer to ScreenShot XXXXXXXXXXXXXXXX");
		@SuppressWarnings("unused")
		CucumberAfterStepCode cas = new CucumberAfterStepCode();

	}

}
