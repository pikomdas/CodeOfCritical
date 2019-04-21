package com.naukri.BrowserBase;

//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Naukri.FileReaderManager.ConfigFileReader;
import com.Naukri.FileReaderManager.Log;



public class browser {

    public static WebDriver driver;
	ConfigFileReader cfr=new ConfigFileReader();
	
	public void selectBrowser() {
		System.setProperty("webdriver.chrome.driver", cfr.getDriverPath());
		System.setProperty("log4j.configurationFile", cfr.getLog4j2Path());
		ChromeOptions options = new ChromeOptions();
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);
		//options.setCapability("enableVNC", false);
//		options.addArguments("--disable-default-apps");
//		options.addArguments("--disable-translate");
		options.addArguments("--disable-web-security");
		driver = new ChromeDriver(options);
		driver.get(cfr.getApplicationUrl());
		driver.manage().window().maximize();
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