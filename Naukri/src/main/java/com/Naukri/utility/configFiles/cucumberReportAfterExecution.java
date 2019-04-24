package com.Naukri.utility.configFiles;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.Naukri.BrowserBase.browser;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

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
			try
			{
				JavascriptExecutor jsExec = (JavascriptExecutor) driver;

				jsExec.executeScript("window.scrollTo(0, 0);"); // Scroll To Top

				Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;");
				Long scroll = innerHeight;

				Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;");

				scrollHeight = scrollHeight + scroll;
				do
				{
					TakesScreenshot ts = (TakesScreenshot) driver;
					File sourcePath = ts.getScreenshotAs(OutputType.FILE);
					File destinationPath = new File(
							getProperty.readScreenshotLocation("failedImageLocation") + screenshotName + ".png");
					FileUtils.copyFile(sourcePath, destinationPath);
					Reporter.addScreenCaptureFromPath(destinationPath.toString());
					jsExec.executeScript("window.scrollTo(0, " + innerHeight + ");");

					innerHeight = innerHeight + scroll;
				}
				while (scrollHeight > innerHeight);
			}
			catch (WebDriverException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// Reporter.addStepLog(System.setOut(new PrintStream("test")));
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
				new File("../demoBDDFramework/src/main/java/com/assetvantage/configFiles/extent-config.xml"));
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
