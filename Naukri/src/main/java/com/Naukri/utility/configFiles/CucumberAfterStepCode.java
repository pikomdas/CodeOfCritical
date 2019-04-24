package com.Naukri.utility.configFiles;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;

public class CucumberAfterStepCode extends CucumberBeforeExecution
{

	public CucumberAfterStepCode() throws Exception
	{
		try
		{

			JavascriptExecutor jsExec = (JavascriptExecutor) driver;

			jsExec.executeScript("window.scrollTo(0, 0);"); // Scroll To Top

			Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;"); // height of one page or tab
			Long scroll = innerHeight;

			Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;"); // total scrollable
																									// height of page

			scrollHeight = scrollHeight + scroll;

			do
			{
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						getProperty.readScreenshotLocation("stepImageLocation") + screenshotFolderName + "\\"
								+ String.join("_", LocalDateTime.now().toString().split("[^A-Za-z0-9]")) + ".png");
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

}
