package com.Naukri.utility.configFiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class getProperty
{

	public static String readmyFile(String fieldname) throws IOException {
		Properties prop = new Properties();
		FileReader reader = new FileReader(
				"../demoBDDFramework/src/main/java/com/assetvantage/configFiles/basicDetails.properties");
		prop.load(reader);
		return prop.getProperty(fieldname);
	}

	public static String readScreenshotLocation(String fieldname) throws IOException {
		Properties prop = new Properties();
		FileReader reader = new FileReader(
				"./src/main/java/com/Naukri/utility/configFiles/TakeScreenShot.properties");
		prop.load(reader);
		return prop.getProperty(fieldname);
	}

	public static String readBrowserName(String fieldname) throws IOException {
		Properties prop = new Properties();
		FileReader reader = new FileReader("./src/main/java/com/Naukri/utility/configFiles/setBrowser.properties");
		prop.load(reader);
		return prop.getProperty(fieldname);
	}
}
