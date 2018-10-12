package LINKEDIN;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.pages.JobsPage;
import com.linkedin.pages.feedPage;
import com.linkedin.pages.loginToLinkedin;
import com.linkedin.pages.searchJobApplyPage;

import Browser.browser;
import commomUtil.Log;
import commomUtil.getMyProperty;
import commomUtil.interfaceAsaService;
import commomUtil.screenshotCapture;
/**
 * www.linkedin.com
 *
 */
public class linkedin_DDT extends browser {

	interfaceAsaService myservice=new screenshotCapture();
	
	
	public linkedin_DDT() {
		super();
	}
	
	@BeforeMethod
	public void openBrowserToLogin() throws Exception {
		BasicConfigurator.configure();
		Log.startTestCase("test");
		openBrowserandNavigate();
		}

    @Test
	public void executin() throws Exception,InterruptedException,IOException {
    	
        Log.info("$$$$$$$$$$$$$$$$$$ EXECUTION IN PROGRESS $$$$$$$$$$$$$$$$$$$$");
        
        //login to linkedin
        loginToLinkedin login = new loginToLinkedin(driver);
   
        //take screenshot
        myservice.takeScreenShotofCurrentpage();
        
        //throw credential and login
        login.userNamePasswordAndlogin("pikom.das@"+getMyProperty.readmyFile("username"),getMyProperty.readmyFile("password"));
        Log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  LOGIN SUCCESSFULL");
        
        //Click on Job Apply on FEEDS page
        feedPage fp=new feedPage(driver);
        fp.informationAboutMyProfile();
        fp.clickOnJobButton();
        Log.info(">>>>>>>>>>>>>>>>>>>>> Clicked on JOB link present on Feed page");
        myservice.takeScreenShotofCurrentpage();
        
        //jobs pageSearch
        JobsPage jp=new JobsPage(driver);
        jp.jobSearch();
        Log.info(">>>>>>>>>>>>>>>>>>>>> JOB details Entered and searched");
        myservice.takeScreenShotofCurrentpage();
        
        // Search JOB page , check if the EasyApply button is active or not
        // Return Back to previous page
         
        searchJobApplyPage sjp=new searchJobApplyPage(driver);
        Log.info(">>>>>>>>>>>>>>>>>>>>>  Applying for jobs");
        sjp.clickOnJoblink();
        myservice.takeScreenShotofCurrentpage();
      //  sjp.navigateBack(); 
    }



	@AfterMethod
	public void aaahhhh() {
		//teardown();
		Log.endTestCase("Test");
	}

}
