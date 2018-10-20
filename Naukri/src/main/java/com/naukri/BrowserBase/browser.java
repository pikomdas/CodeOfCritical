package com.naukri.BrowserBase;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Naukri.FileReaderManager.ConfigFileReader;
import com.Naukri.FileReaderManager.Log;



public class browser {

    public static WebDriver driver;
	ConfigFileReader cfr=new ConfigFileReader();
	
	public void selectBrowser() {
		System.setProperty("webdriver.chrome.driver", cfr.getDriverPath());
		driver = new ChromeDriver();
		driver.get(cfr.getApplicationUrl());
		driver.manage().window().maximize();
		BasicConfigurator.configure();
		Log.info("Naukri.com launched");
		
		String originalHandle = driver.getWindowHandle();
		// Closing all popUp windows while LogIn
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(originalHandle);
	}
}