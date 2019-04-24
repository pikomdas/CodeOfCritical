package com.Naukri.BDDFrameworkTest;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "/home/amit/git/CodeOfCritical/Naukri/src/main/java/com/Naukri/featureFiles/ApplyJob.feature", //the path of the feature files
			glue={"com.Naukri"}, //the path of the step definition files
			plugin= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, //to generate different types of reporting
			monochrome = true, //display the console output in a proper readable format
			strict = true, //it will check if any step is not defined in step definition file
			dryRun = false //to check the mapping is proper between feature file and step def file
			//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			
			)
	 
public class execution_3 {
		private TestNGCucumberRunner testNGCucumberRunner;
		 
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {
	    	//BasicConfigurator.configure();
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }
	 
		@Test(groups = "cucumber", description = "Naukri TestAutomation", dataProvider = "features")
		public void feature(CucumberFeatureWrapper cucumberFeature) {

			testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		}
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
		@AfterClass
		public static void writeExtentReport() {
			//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
			Reporter.loadXMLConfig(new File("/home/amit/git/CodeOfCritical/Naukri/src/main/java/com/Naukri/utility/configFiles/extent-config.xml"));
			Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		    Reporter.setSystemInfo("Selenium", "3.7.0");
		    Reporter.setSystemInfo("Maven", "3.5.2");
		    Reporter.setSystemInfo("Java Version", "1.8.0_151");
		}
	 
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	