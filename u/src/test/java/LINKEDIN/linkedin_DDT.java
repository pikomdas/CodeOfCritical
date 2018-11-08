package LINKEDIN;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.interfaces.interfaceAsaService;
import com.linkedin.pages.JobsPage;
import com.linkedin.pages.feedPage;
import com.linkedin.pages.loginToLinkedin;
import com.linkedin.pages.searchJobApplyPage;

import Browser.browser;
import commomUtil.Log;
import commomUtil.MyReport;
import commomUtil.getMyProperty;
import commomUtil.screenshotCapture;
/**
 * www.linkedin.com
 *
 */
public class linkedin_DDT extends browser {

	interfaceAsaService log=new Log();
	interfaceAsaService screenShot=new screenshotCapture();
	interfaceAsaService report=new MyReport();
	ITestResult result = null;
	
	public linkedin_DDT() {
		super();
	}
	
	@BeforeMethod
	public void openBrowserToLogin() throws Exception {
		BasicConfigurator.configure();
		log.startTestCase("test");
		openBrowserandNavigate();
		report.onStart(result);
		}

    @Test
	public void executin() throws Exception,InterruptedException,IOException {
    	
        log.info("$$$$$$$$$$$$$$$$$$ EXECUTION IN PROGRESS $$$$$$$$$$$$$$$$$$$$");
        
        //login to linkedin
        loginToLinkedin login = new loginToLinkedin(driver);
   
        //take screenshot
        screenShot.takeScreenShotofCurrentpage();
        
        //throw credential and login
        login.userNamePasswordAndlogin("pikom.das@"+getMyProperty.readmyFile("username"),getMyProperty.readmyFile("password"));
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  LOGIN SUCCESSFULL");
        
        
        //Click on Job Apply on FEEDS page
        feedPage fp=new feedPage(driver);
        fp.informationAboutMyProfile();
        fp.clickOnJobButton();
        log.info(">>>>>>>>>>>>>>>>>>>>> Clicked on JOB link present on Feed page");
        screenShot.takeScreenShotofCurrentpage();
        
        
        //jobs pageSearch
        JobsPage jp=new JobsPage(driver);
        jp.jobSearch();
        log.info(">>>>>>>>>>>>>>>>>>>>> JOB details Entered and searched");
        screenShot.takeScreenShotofCurrentpage();
        
        
        // Search JOB page , check if the EasyApply button is active or not
        // Return Back to previous page
         
        searchJobApplyPage sjp=new searchJobApplyPage(driver);
        log.info(">>>>>>>>>>>>>>>>>>>>>  Applying for jobs");
        sjp.clickOnJoblink();
        screenShot.takeScreenShotofCurrentpage();
        
      //  sjp.navigateBack(); 
    }



	@AfterMethod
	public void aaahhhh() {
		//teardown();
		log.endTestCase("Test");
		report.onFinish(result);
	}

}
