package com.codeOfCritical.commonUtils;


import com.codeOfCritical.CucumberExtentReport.Reporter;
import com.codeOfCritical.BaseClass.Browser;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class cucumberReportAfterExecution extends Browser
{
	private static final Logger log = LogManager.getLogger(cucumberReportAfterExecution.class.getName());
	private static final ThreadLocal<Scenario> scenarios = new ThreadLocal();
	private static final ThreadLocal<Screenshot> screenshot = new InheritableThreadLocal<>();

	public cucumberReportAfterExecution(Scenario scenario) throws Exception
	{
		scenarios.set(scenario);
		Status status = scenarios.get().getStatus();
		log.info("SCENARIO STATUS: " + status);

		if (scenarios.get().isFailed()) {
			String screenshotName = scenarios.get().getName().replaceAll("[^a-zA-Z0-9]", "_");
			// scenario.write("Current Page URL is " + driver.getCurrentUrl());
			try {
				screenshot.set(new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
						.takeScreenshot(driverThread.get()));
				File destinationPath = new File(
						getProperty.readScreenshotLocation("failedImageLocation") + screenshotName + ".png");
				ImageIO.write(screenshot.get().getImage(), "PNG", destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.getAbsolutePath());
				// Adding failed screenshot file to list
				CucumberAfterStepCode.screenShots.get().add(destinationPath.getAbsolutePath());
			}
			catch (WebDriverException | IOException e) {
				e.printStackTrace();
			}
			finally {
				screenshot.remove();
			}

		}

		/**
		 * System Information of the user machine
		 *
		 * @throws Exception
		 *
		 * @param scenario
		 *                     Which are added in CUCUMBER report
		 */
		InetAddress address = InetAddress.getLocalHost();
		String hostIP = address.getHostAddress();
		String hostName = address.getHostName();
		/*
		 * Reporter.loadXMLConfig(
		 * new File(
		 * "../AV_QA_Framework_Core/src/main/java/com/TechMReport/configFiles/extent-config.xml"
		 * ));
		 */
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

		/**
		 * Generating custom report
		 */
		if (CustomExecutionStatus.DataCollectorMultipleTime.get() != null)
		{
			String path = "../TestSwift_Web/test-outout/Custom-Report-HealthCheck/";
//			String path="D:\\Automation_Framework\\autofw\\TemenosT24\\TemenosT24_Web\\test-outout\\Custom-Report-HealthCheck";
			CustomExecutionStatus.DataCollectorMultipleTime.get().buildHTML(path, CucumberAfterStepCode.screenShots.get());
			CustomExecutionStatus.DataCollectorMultipleTime.remove();
			CucumberAfterStepCode.screenShots.remove();
		}
		else {
			System.out.println("             *               ");
			System.out.println("           *   *             ");
			System.out.println("         *  NO   *           ");
			System.out.println("	   *   JSON    *		 ");
			System.out.println("	 *	  CREATED	 *		 ");
			System.out.println("    *******************		 ");
			System.out.println("    *******************      ");
			log.warn("Execution was not related to directly JSON to UI,\n"
					+ "it might be \n "
					+ "UI and JSON Map<Position,Map<ColumnName,Value> hashMap verification \n"
					+ "OR No VERIFICATION was happened");
		}
		/**
		 * Log out and clear cookies and then terminate browser
		 */
		scenarios.remove();
		teardown();

	}

}
