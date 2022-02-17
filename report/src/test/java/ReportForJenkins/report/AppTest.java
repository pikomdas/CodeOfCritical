package ReportForJenkins.report;

import generateReport.JenkinsEmailableReport;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        String loc = System.getProperty("location");
        //		String loc = "D:\\cucumber report generation test\\cucumber.json";
        JenkinsEmailableReport jer = new JenkinsEmailableReport();
        jer.generateReport(loc);
    }
}
