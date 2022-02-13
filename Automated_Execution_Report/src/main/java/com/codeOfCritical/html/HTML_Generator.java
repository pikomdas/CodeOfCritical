/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * HTML_Generator.java belongs to codeOfCritical
 * Do not COPY or PASTE code to WEB from codeOfCritical
 * Creation date-time : 07-May-2020 - 11:37:12 am
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 *
 */
package com.codeOfCritical.html;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;


/**
 * @author partha.das
 */
public class HTML_Generator extends HTMLBody
{
    private static final ThreadLocal<JSONObject> jsonObjectX = new ThreadLocal<>();

    public HTML_Generator(JSONObject jsonObjectX)
    {
        HTML_Generator.jsonObjectX.set(jsonObjectX);
    }

    public synchronized void getHTML(String path_Of_HTML_output)
    {
        StringBuilder sb = new StringBuilder();
        File file;
        FileWriter fw;

        try {
            file = new File(path_Of_HTML_output + File.separator + "AV_Report.html");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fw = new FileWriter(file);

            sb.append("<html>");
            sb.append("<head>"
                    + "<title>Health Check Report</title>"
                    + "<!-- Latest compiled and minified CSS -->\n" +
                    "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n" +
                    "\n" +
                    "<!-- jQuery library -->\n" +
                    "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
                    "\n" +
                    "<!-- Popper JS -->\n" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
                    "\n" +
                    "<!-- Latest compiled JavaScript -->\n" +
                    "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>"
                    + "<link rel='stylesheet' href='CSS/table.css'></link>"
                    + "<link rel='stylesheet' href='CSS/space.css'></link>"
                    + "<link rel='stylesheet' href='CSS/image.css'></link>"
                    + "<script src='JS/table.js'></script>"
                    + "<script src='JS/image.js'></script>"
                    + "</head>");
            sb.append("<body class=\"overlay\">");
            sb.append("<h2 class=\"text-center\">Automated Execution Report</h2>");
            sb.append("<div class=\"time\"><time> Date: " + LocalDate.now() + "</time></div>");
            sb.append("<div class=\"container\">\r\n"
                    + "<table class=\"table table-bordered\">\r\n");
            sb.append(getBody(jsonObjectX.get()));
            sb.append("</table></div>");
            sb.append("</body>");
            sb.append("</html>");

            fw.write(sb.toString());
            fw.flush();
            fw.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
