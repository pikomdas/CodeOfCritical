package com.codeOfCritical.test.Managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;

import java.io.File;

public class ExtentManagers {
    public static ITestContext context;
    //private static Platform platform;
    //context.getCurrentXmlTest().getSuite().getFileName();
    private static ExtentReports extent;
    //private static String reportFileName = "Summary_Test_Report_"+new Date().getTime()+".html";
    private static String reportFileName = "Summary_Test_Report_" + new java.util.Date().toString().replace(" ", "_").replace(":", "_") + ".html";
    //private static String macPath = System.getProperty("user.dir")+ "/TestReport";
    private static String windowsPath = System.getProperty("user.dir") + "\\TestReport";
    //private static String macReportFileLoc = macPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

    /*    public ExtentManager(ITestContext context){
            this.context=context;
        }
    */
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportFileLocation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        //htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Summary Test Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Summary Test Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    //Select the extent report file location based on platform
    private static String getReportFileLocation() {
        String reportFileLocation = null;
/*    	XmlSuite suiteName = context.getCurrentXmlTest().getSuite(); 
    	System.out.println("TestNG File Name is:- "+suiteName.getFileName());
*/
        reportFileLocation = winReportFileLoc;
        createReportPath(windowsPath);
        System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
        return reportFileLocation;
    }

    //Create the report path if it does not exist
    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    //Get current platform
    /*
     * private static Platform getCurrentPlatform () { if (platform == null) {
     * String operSys = System.getProperty("os.name").toLowerCase(); if
     * (operSys.contains("win")) { platform = Platform.WINDOWS; } else if
     * (operSys.contains("nix") || operSys.contains("nux") ||
     * operSys.contains("aix")) { platform = Platform.LINUX; } else if
     * (operSys.contains("mac")) { platform = Platform.MAC; } } return platform; }
     */
}
