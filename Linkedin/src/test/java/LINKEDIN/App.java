package LINKEDIN;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.ScreenshotCapture;
import com.linkedin.commomUtil.getMyProperty;
import com.linkedin.pages.JobsPage;
import com.linkedin.pages.SearchJobApplyPage;
import com.linkedin.pages.feedPage;
import com.linkedin.pages.loginToLinkedin;

/**
 * www.linkedin.com
 *
 */
public class App extends browser {
//	public ChromeDriver driver;
//	loginToLinkedin loginToLinkedin;
	ScreenshotCapture sc=new ScreenshotCapture();
	
	public App() {
		super();
	}
	
	@BeforeMethod
	public void openBrowserToLogin() throws Exception {
		openBrowserandNavigate();	
		}

    @Test
	public void executin() throws Throwable {
    	
        System.out.println("EXECUTION IN PROGRESS");
        
        //login to linkedin
        loginToLinkedin login = new loginToLinkedin(driver);
        //take screenshot
        sc.takeScreenShotofCurrentpage();
        
        //throw credential and login
        login.userNamePasswordAndlogin("pikom.das@"+getMyProperty.readmyFile("username"),getMyProperty.readmyFile("password"));
        
        //Click on Job Apply on FEEDS page
        feedPage fp=new feedPage(driver);
        fp.clickOnJobButton();
        sc.takeScreenShotofCurrentpage();
        
        //jobs pageSearch
        JobsPage jp=new JobsPage(driver);
        jp.jobSearch();
        sc.takeScreenShotofCurrentpage();
        /*
         * Search JOB page , check if the EasyApply button is active or not
         * Return Back to previous page
         */
        SearchJobApplyPage sjp=new SearchJobApplyPage(driver);
        sjp.clickOnJoblink();
        sc.takeScreenShotofCurrentpage();
      //  sjp.navigateBack();
    }



	@AfterMethod
	public void aaahhhh() {
		browser br = new browser();
		br.teardown();
	}
}
