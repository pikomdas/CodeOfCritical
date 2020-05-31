package LINKEDIN;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.CustomLog;
import com.linkedin.commomUtil.MyReport;
import com.linkedin.commomUtil.ScreenshotCapture;
import com.linkedin.commomUtil.getMyProperty;
import com.linkedin.pages.JobsPage;
import com.linkedin.pages.LoginToLinkedin;
import com.linkedin.pages.SearchJobApplyPage;
import com.linkedin.pages.feedPage;

/**
 * www.linkedin.com
 */

public class LinkedIn_DDT extends browser
{

	private static Logger log = LogManager.getLogger(LinkedIn_DDT.class.getName());
	ScreenshotCapture screenShot = new ScreenshotCapture();
	MyReport report = new MyReport();

	public LinkedIn_DDT()
	{
		super();
	}

	@BeforeTest
	public void openBrowserToLogin(ITestContext result) throws Exception
	{
		BasicConfigurator.configure();
		CustomLog.class.getDeclaredConstructor().newInstance().startTestCase(getClass().getName());
		openBrowserandNavigate();
		report.onStart(result);

	}

	@BeforeMethod
	public void startingTest(ITestResult result)
	{
		report.onTestStart(result);
	}

	@Test
	public void execution() throws Throwable
	{

		log.info("$$$$$$$$$$$$$$$$$$ EXECUTION IN PROGRESS $$$$$$$$$$$$$$$$$$$$");

		// login to LinkedIn
		LoginToLinkedin login = new LoginToLinkedin(driver);

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

		SearchJobApplyPage sjp = new SearchJobApplyPage(driver);
		log.info(">>>>>>>>>>>>>>>>>>>>>  Applying for jobs");
		sjp.applyAllAvailableJobs();
		screenShot.takeScreenShotofCurrentpage();

		// sjp.navigateBack();

	}

	@AfterMethod
	public void conclusion(ITestResult result)
	{
		if (result.isSuccess())
		{
			report.onTestSuccess(result);
		}
		else
		{
			report.onTestFailure(result);
		}
	}

	@AfterTest
	public void aaahhhh(ITestContext result) throws Throwable
	{
		// teardown();

		CustomLog.class.getDeclaredConstructor().newInstance().endTestCase(getClass().getName());
		report.onFinish(result);
	}

}