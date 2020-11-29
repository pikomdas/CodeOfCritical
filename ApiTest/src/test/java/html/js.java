/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * js.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 07-May-2020 - 11:37:12 am
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package html;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author partha.das
 *
 */
public class js
{
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		FileWriter fw = null;

		try
		{
			fw = new FileWriter(new File("./src/test/java/html/table.html"));
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(new FileReader(new File("./src/test/java/html/test.json")));
			sb.append("<html>");

			sb.append("<head>" + "<title>Health Check Report</title>"
					+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" crossorigin=\"anonymous\">"
					+ "<link rel='stylesheet' href='a.css'></link>"
					+ "<link rel='stylesheet' href='space.css'></link></head>");
			sb.append("<body class=\"overlay\">");
			sb.append("<video autoplay=\"autoplay\" muted=\"muted\" loop=\"loop\">\r\n" + 
					"		<source\r\n" + 
					"			src=\"https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4\"\r\n" + 
					"			type=\"video/mp4\">\r\n" + 
					"	</video>");
			sb.append("<div><time> Date: "+LocalDate.now()+"</time></div>");
			sb.append("<div class=\"container\">\r\n" + "  <table class=\"table table-bordered\">\r\n");

			JSONArray ja1 = (JSONArray) jo.get("Scenarios");
			for (Object x : ja1)
			{
				JSONObject sc = (JSONObject) x;
				String scenario = (String) sc.get("Scenario Name");
				sb.append("<tr class=\"header\">\r\n" + "      <td colspan=\"2\">" + scenario + "</td>\r\n"
						+ "    </tr>");
				JSONArray entities = (JSONArray) sc.get("Entities");
				for (Object y : entities)
				{
					JSONObject en = (JSONObject) y;
					String entityName = (String) en.get("Entity Name");
					sb.append("<tr class='Entity'>\r\n" + "      <td>Entity Name</td>\r\n" + "      <td>" + entityName + "</td>\r\n"
							+ "</tr>\r\n");
					JSONArray deviations = (JSONArray) en.get("Deviations");
					for (Object z : deviations)
					{
						JSONObject deviation = (JSONObject) z;
						String devs = (String) deviation.get("Exception Message");

						sb.append("<tr class='Deviation'>\r\n" + "      <td>Mismatch Values</td>\r\n" + "      <td>" + devs
								+ "</td>\r\n" + "</tr>\r\n");

					}
				}

			}

			sb.append("</table></div>");
			sb.append("<script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>"
					+ "<script id='rendered-js' src='a.js'></script>");
			sb.append("</body>");
			sb.append("</html");
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
