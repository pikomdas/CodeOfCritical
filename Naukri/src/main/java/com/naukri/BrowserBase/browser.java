package com.naukri.BrowserBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Naukri.FileReaderManager.ConfigFileReader;

public class browser {

	protected WebDriver driver=null;

	protected browser() {
		System.setProperty("webdriver.chrome.driver", ConfigFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.get(ConfigFileReader.getApplicationUrl());
		driver.manage().window().maximize();
		System.out.println("Naukri.com launched");
		
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