package JSONReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONReader {

    /**
     * @param fileLocation
     * @return a HTML String with table Every Feature starts with
     * <tr>
     * and scenario with
     * <td>, steps with
     * <td>
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public String getTable(String fileLocation) throws FileNotFoundException, IOException, ParseException {
        JSONParser jp = new JSONParser();

        Reader reader = new FileReader(new File(fileLocation));
        StringBuilder sb = new StringBuilder();
        // Status of scenario for all steps
        Object status = null;

        Object o = jp.parse(reader);

        JSONArray jo = (JSONArray) o;
        // Entering to JSON array
        for (Object x : jo) {
            //Starting of a single row
            sb.append("<tr>");

            JSONObject t1 = (JSONObject) x;
            //Capturing feature name
            Object featureName = t1.get("name");
            Object elements = t1.get("elements");
            //System.out.println(" Feature Name: --> " + featureName);

            /*
             * Entering into the elements where Scenario name, Steps, After and Before hooks
             * are available
             */
            JSONArray ja = (JSONArray) elements;
            sb.append("<td rowspan='" + ja.size() + "'>" + featureName + "</td>");
            for (Object element : ja) {

                JSONObject t2 = (JSONObject) element;
                //Capturing Scenario name
                Object scenarioName = t2.get("name");
                /*
                 * // Accessing before tag Object before = t2.get("before"); //Accessing after
                 * tag Object after = t2.get("after");
                 */
                // Steps accessing
                Object steps = t2.get("steps");
                sb.append("<td>" + scenarioName + "</td>");
                //System.out.println("SCENARIO:--> " + scenarioName);

                //Before tag status and duration
                /*
                 * JSONArray ja1 = (JSONArray) before; for (Object beforeTag : ja1) {
                 *
                 * JSONObject t3 = (JSONObject) beforeTag; JSONObject result = (JSONObject)
                 * t3.get("result"); Object duration = result.get("duration"); //Object status =
                 * result.get("status"); status = result.get("status");
                 *
                 * System.out.println("Before tag duration : " + duration + " \n" +
                 * "Before tag status: " + status);
                 *
                 * }
                 */

                JSONArray ja2 = (JSONArray) steps;
                for (Object step : ja2) {
                    JSONObject t4 = (JSONObject) step;
                    JSONObject result = (JSONObject) t4.get("result");
                    //Object stepName = t4.get("name");
                    //Object tagName = t4.get("keyword");
                    //Object status = result.get("status");
                    status = result.get("status");
                    if (status.equals("failed")) {
                        sb.append("<td class=\"failed\">failed</td>");
                        //sb.append("<td>" + stepName + "</td>");
                        break;
                    } else if (status.equals("skipped")) {
                        sb.append("<td class=\"skipped\">skipped</td>");
                        //sb.append("<td>" + stepName + "</td>");
                        break;
                    }
                    /*
                     * Object duration = result.get("duration"); System.out.println("Step Name: " +
                     * stepName); System.out.println("tagname: " + tagName);
                     * System.out.println("Status: " + status); System.out.println("duration: " +
                     * duration);
                     */

                }

                //After tag status and duration
                //JSONArray ja3 = (JSONArray) after;
                /*
                 * for (Object afterTag : ja3) {
                 *
                 * //JSONObject t3 = (JSONObject) afterTag; //JSONObject result = (JSONObject)
                 * t3.get("result"); //Object duration = result.get("duration"); //Object status
                 * = result.get("status"); //status = result.get("status");
                 *
                 * //System.out.println("after tag duration : " + duration + " \n" +
                 * "after tag status: " + status);
                 *
                 * }
                 */

                if (status.equals("passed")) {
                    sb.append("<td class=\"passed\">passed</td>");
                    //sb.append("<td>NA</td>");
                }
                sb.append("</tr>");
                status = null;
            }
            //sb.append("</tr>");
        }

        return sb.toString();

    }

}
