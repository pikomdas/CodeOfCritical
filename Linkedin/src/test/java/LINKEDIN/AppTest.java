package LINKEDIN;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.Log;
import com.linkedin.commomUtil.MyReport;
import com.linkedin.commomUtil.getMyProperty;
import com.linkedin.commomUtil.screenshotCapture;
import com.linkedin.interfaces.interfaceAsaService;
import com.linkedin.pages.loginToLinkedin;

/**
 * www.linkedin.com
 *
 */
public class AppTest extends MyReport {

	interfaceAsaService log = new Log();
	interfaceAsaService screenShot=new screenshotCapture();

	public AppTest() {
		super();
	}

	@BeforeMethod
	public void openBrowserToLogin() throws Exception {
		BasicConfigurator.configure();
		log.startTestCase("test");
		openBrowserandNavigate();
	}

	@Test(priority=0, description="Login Scenario with correct username and password.")
	public void executin() throws Throwable {

		System.out.println("EXECUTION IN PROGRESS");

		// login to linkedIn
		loginToLinkedin login = new loginToLinkedin(driver);
		// take screenshot
		screenShot.takeScreenShotofCurrentpage();

		// throw credential and login
		login.userNamePasswordAndlogin("pikom.das@" + getMyProperty.readmyFile("username"),
				getMyProperty.readmyFile("password"));
		screenShot.takeScreenShotofCurrentpage();

	}

	@AfterMethod
	public void aaahhhh() {
		browser br = new browser();
		br.teardown();
		log.endTestCase("Test");
	}
}
