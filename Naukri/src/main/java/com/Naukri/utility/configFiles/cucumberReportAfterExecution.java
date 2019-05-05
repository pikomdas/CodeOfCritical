package com.Naukri.utility.configFiles;

import java.io.File;
import java.net.InetAddress;
import javax.imageio.ImageIO;

import com.Naukri.BrowserBase.browser;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class cucumberReportAfterExecution extends browser
{

	public cucumberReportAfterExecution(Scenario scenario) throws Exception
	{

		String status = scenario.getStatus();
		System.out.println("SCENARIO STATUS: " + status);

		if (scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			scenario.write("Current Page URL is " + driver.getCurrentUrl());
			
			Screenshot screenshot = new AShot()
	                .takeScreenshot(driver);
			File destinationPath = new File(
					getProperty.readScreenshotLocation("failedImageLocation") + screenshotName + ".png");
	        ImageIO.write(screenshot.getImage(), "PNG", destinationPath);
	        Reporter.addScreenCaptureFromPath(destinationPath.toString());
		}
		/*
		 * System Information of the user machine
		 * 
		 * @throws Exception
		 * 
		 * @param scenario Which are added in CUCUMBER report
		 */
		InetAddress address = InetAddress.getLocalHost();
		String hostIP = address.getHostAddress();
		String hostName = address.getHostName();
		Reporter.loadXMLConfig(
				new File("../Naukri/src/main/java/com/Naukri/utility/configFiles/extent-config.xml"));
		Reporter.setSystemInfo("User Name :", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone :", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Host Name :", hostName);
		Reporter.setSystemInfo("Machine " + "Processors Identifier : ",
				System.getenv("PROCESSOR_IDENTIFIER") + "\n" + "Processors Arc1  : "
						+ System.getenv("PROCESSOR_ARCHITECTURE") + "\n" + "Processors Arc2  : "
						+ System.getenv("PROCESSOR_ARCHITEW6432") + "\n" + "Number of Processors : "
						+ System.getenv("NUMBER_OF_PROCESSORS"));
		Reporter.setSystemInfo("Selenium :", " 3.7.0");
		Reporter.setSystemInfo("IP Address :", hostIP);
		Reporter.setSystemInfo("Java Version :", System.getProperty("java.version"));
		// Reporter.setSystemInfo("Browser Name :",
		// System.getenv("CBT_BROWSER").toUpperCase());
		browser.quitDriver();

	}

}
