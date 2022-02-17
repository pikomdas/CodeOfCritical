package generateReport;

import htmlBuilder.HTMLBuilder;

import java.io.*;

public class JenkinsEmailableReport {

	public void generateReport(String actualJenkinsReportLocation) {
		try {
			HTMLBuilder mn = new HTMLBuilder();
			File file = new File(System.getProperty("user.dir") + File.separator + "jenkinsEmailableReport"
					+ File.separator + "Report_Jenkins_Email.html");

			// write to file with OutputStreamWriter
			OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
			Writer writer = new OutputStreamWriter(outputStream);
			writer.write(mn.firstPartOfReport(actualJenkinsReportLocation));
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
