package LINKEDIN;

import org.apache.log4j.BasicConfigurator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.Log;
import com.linkedin.commomUtil.MyReport;
import com.linkedin.commomUtil.getMyProperty;
import com.linkedin.commomUtil.screenshotCapture;
import com.linkedin.interfaces.interfaceAsaService;
import com.linkedin.pages.JobsPage;
import com.linkedin.pages.feedPage;
import com.linkedin.pages.loginToLinkedin;
import com.linkedin.pages.searchJobApplyPage;

/**
 * www.linkedin.com
 *
 */

public class linkedin_DDT extends browser {

	interfaceAsaService log = new Log();
	interfaceAsaService screenShot = new screenshotCapture();
	interfaceAsaService report = new MyReport();

	public linkedin_DDT() {
		super();
	}

	@BeforeTest
	public void openBrowserToLogin(ITestContext result) throws Exception {
		BasicConfigurator.configure();
		log.startTestCase(getClass().getName());
		openBrowserandNavigate();
		report.onStart(result);

	}

	@BeforeMethod
	public void startingTest(ITestResult result) {
		report.onTestStart(result);
	}

	@Test
	public void execution() throws Throwable {

		log.info("$$$$$$$$$$$$$$$$$$ EXECUTION IN PROGRESS $$$$$$$$$$$$$$$$$$$$");

		// login to linkedin
		loginToLinkedin login = new loginToLinkedin(driver);

		// take screenshot
		screenShot.takeScreenShotofCurrentpage();

		// throw credential and login
		login.userNamePasswordAndlogin("pikom.das@" + getMyProperty.readmyFile("username"),
				getMyProperty.readmyFile("password"));
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  LOGIN SUCCESSFULL");

		// Click on Job Apply on FEEDS page
		feedPage fp = new feedPage(driver);
		fp.informationAboutMyProfile();
		fp.clickOnJobButton();
		log.info(">>>>>>>>>>>>>>>>>>>>> Clicked on JOB link present on Feed page");
		screenShot.takeScreenShotofCurrentpage();

		// jobs pageSearch
		JobsPage jp = new JobsPage(driver);
		jp.jobSearch();
		log.info(">>>>>>>>>>>>>>>>>>>>> JOB details Entered and searched");
		screenShot.takeScreenShotofCurrentpage();

		// Search JOB page , check if the EasyApply button is active or not
		// Return Back to previous page

		searchJobApplyPage sjp = new searchJobApplyPage(driver);
		log.info(">>>>>>>>>>>>>>>>>>>>>  Applying for jobs");
		sjp.clickOnJoblink();
		screenShot.takeScreenShotofCurrentpage();

		// sjp.navigateBack();

	}

	@AfterMethod
	public void conclution(ITestResult result) {
		if (result.isSuccess()) {
			report.onTestSuccess(result);
		} else {
			report.onTestFailure(result);
		}
	}

	@AfterTest
	public void aaahhhh(ITestContext result) {
		// teardown();
		log.endTestCase(getClass().getName());
		report.onFinish(result);
	}

}