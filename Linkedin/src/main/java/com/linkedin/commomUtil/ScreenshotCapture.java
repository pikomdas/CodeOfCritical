package com.linkedin.commomUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.j2objc.annotations.AutoreleasePool;
import com.linkedin.Browser.browser;

public class ScreenshotCapture extends browser
{
	
	private static Logger log = LogManager.getLogger(ScreenshotCapture.class.getName());

	public void takeScreenShotofCurrentpage() throws IOException
	{

		try
		{
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenShots/" + System.currentTimeMillis() + ".png"));
			log.info("ScreenShot is Captured");
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
