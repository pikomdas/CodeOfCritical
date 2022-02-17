package com.assetvantage;

import com.assetvantage.reader.ReadPath;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Execution {

	public static void main(String[] args) throws ConfigurationException {

		String environment = System.getProperty("env");
		String browserName = System.getProperty("br");
		String build = System.getProperty("build");

		PropertiesConfiguration config = new PropertiesConfiguration(ReadPath.environmentDetailsPath);
		config.setProperty("env_name", environment);
		config.save();
		System.out.println("Config Property Successfully Updated for Environment");

		PropertiesConfiguration config1 = new PropertiesConfiguration(ReadPath.browserDetailspath);
		config1.setProperty("br_name", browserName);
		config1.setProperty("BUILD", build);
		config1.save();
		System.out.println("Config Property Successfully Updated for Browser and Build");

	}

}
