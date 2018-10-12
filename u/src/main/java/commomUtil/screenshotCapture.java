package commomUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import Browser.browser;



public class screenshotCapture extends browser implements interfaceAsaService {

//	public MyScreenshot(final WebDriver driver) {
//		// TODO Auto-generated constructor stub
	//	WebDriver driver;
//		
//	}
    public void takeScreenShotofCurrentpage() throws IOException {
		//final File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("/home/amit/eclipse-workspace/u/ScreenShots"
					+System.currentTimeMillis()+ ".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			e.getSuppressed();
		}
		System.out.println("ScreenShot is Captured");
		
	}

	
}
