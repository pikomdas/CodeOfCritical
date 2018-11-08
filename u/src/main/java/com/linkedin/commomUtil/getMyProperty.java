package com.linkedin.commomUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class getMyProperty {

	public static String readmyFile(String fieldname) throws IOException {
	Properties prop = new Properties();
	FileReader reader=new FileReader("/home/amit/eclipse-workspace/u/src/main/java/com/linkedin/config/config.properties"); 
	prop.load(reader);
	return prop.getProperty (fieldname);
	}
}
