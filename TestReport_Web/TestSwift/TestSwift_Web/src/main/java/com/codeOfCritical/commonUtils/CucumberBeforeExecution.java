package com.codeOfCritical.commonUtils;


import com.codeOfCritical.BaseClass.Browser;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * ############## WARNING ######################################################
 * Do not Extend this class never or ever because this class constructor will
 * create a new instance of browser every time it is called
 * ########### WARNING #####################################################
 *
 * @author partha.das
 */
public class CucumberBeforeExecution extends Browser
{
    private static final Logger log_ = LogManager.getLogger(CucumberBeforeExecution.class.getName());
    Log log = new Log();
    public static final ThreadLocal<Scenario> SCENARIO = new InheritableThreadLocal<>();
    public static ThreadLocal<List<String>> TAGNAME = new InheritableThreadLocal<>();
    public static final ThreadLocal<String> SCENARIO_ID = new InheritableThreadLocal<>();
    public CucumberBeforeExecution(Scenario scenario) throws Exception
    {
        // Getting scenario name
        SCENARIO.set(scenario);
        //Getting scenario ID
        SCENARIO_ID.set(scenario.getId());
        log_.info("Scenario is =========================================:" + SCENARIO.get().getName());
        log_.info("Scenario ID is =========================================:" + SCENARIO.get().getLine());

        // Starting recording of execution
        // ExecutionRecorder.startExecutionRecord(scenario.getName().replaceAll("[^A-Za-z0-9]",
        // "_"));
        // Getting tag names
        TAGNAME.set((List<String>) SCENARIO.get().getSourceTagNames());
        log_.info("Current tag is =======================================:" + TAGNAME);

        // Execution logger starts from here
        log.startTestCase(SCENARIO.get().getName());

        /*try {
            // Opening browser and navigating to URL
            openBrowserandNavigate(getProperty.readBrowserName("br_name"));
        }
        catch (Exception e) {
            if (e instanceof NoSuchSessionException) {
                log_.warn(e.getMessage());
                new CucumberBeforeExecution(scenario);
            }
            else {
                e.printStackTrace();
            }
        }*/

        // login to application
        /*logInPage lp = new logInPage(driverThread.get());
        String currentURL = driverThread.get().getCurrentUrl();
        if (currentURL.contains(getProperty.readmyFile("url_rc"))) {
            lp.loginToApp(getProperty.readmyFile("user_rc"), getProperty.readmyFile("password_rc"));
            log_.info("login Successful");
        }

        else {
            log_.error("login Failed due to incorrect data");
            throw new Error("login Failed due to incorrect data");
        }*/

    }

}
