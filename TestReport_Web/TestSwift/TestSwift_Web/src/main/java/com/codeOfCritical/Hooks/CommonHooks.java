package com.codeOfCritical.Hooks;


import com.codeOfCritical.BaseClass.Browser;
import com.codeOfCritical.CucumberExtentReport.Reporter;
import com.codeOfCritical.commonUtils.CucumberAfterStepCode;
import com.codeOfCritical.commonUtils.CucumberBeforeExecution;
import com.codeOfCritical.commonUtils.Log;
import com.codeOfCritical.commonUtils.cucumberReportAfterExecution;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CommonHooks extends Browser
{

    private static final Logger log = LogManager.getLogger(CommonHooks.class.getName());
    Log log_ = new Log();

    public CommonHooks()
    {
        log.info("_____________ INITIALIZE CUSTOM HOOKS FOR DEMO APPLICATION _____________");
    }

    //	@After("not @ClientURLChecks and not @HealthCheckTest and not @HealthCheck and not @HealthCheck_pb and not @DE_popup and not @Transaction")
    @Before()
    public void doSomethingBeforeStep(Scenario scenario) throws Exception
    {
        @SuppressWarnings("unused")
        CucumberBeforeExecution cbe = new CucumberBeforeExecution(scenario);
    }

    @After()
    public void beforeSecondRnd(Scenario scenario) throws Exception
    {
        log_.endTestCase(scenario.getName());

        @SuppressWarnings("unused")
        cucumberReportAfterExecution crae = new cucumberReportAfterExecution(scenario);
        // Stop execution recording
        //ExecutionRecorder.stopExecutionRecord();
    }

    @AfterStep()
    public void doSomethingAfterStep() throws Exception
    {

        Reporter.addStepLog("XXXXXXXXXXXXXXXX Refer to ScreenShot XXXXXXXXXXXXXXXX");
        @SuppressWarnings("unused")
        CucumberAfterStepCode cas = new CucumberAfterStepCode();

    }


}
