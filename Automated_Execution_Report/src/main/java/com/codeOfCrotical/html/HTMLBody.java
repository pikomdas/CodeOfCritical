/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 *   HTMLBody.java belongs to codeOfCrotical
 *   Do not COPY or PASTE code to WEB from codeOfCrotical
 *   Creation date-time : 06/06/20, 7:28 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical.html;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HTMLBody
{
    @SuppressWarnings("unchecked")
    public String getBody(JSONObject jo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<tbody>");
        JSONArray scenarios = (JSONArray) jo.get("Scenarios");
        scenarios
                .stream()
                .forEach(x ->
                {
                    JSONObject sc = (JSONObject) x;
                    String scenario = (String) sc.get("Scenario Name");
                    sb.append("<tr class=\"header\">\r\n" + "      <td colspan=\"2\">" + scenario + "</td>\r\n"
                            + "    </tr>");
                    JSONArray screenshots = (JSONArray) sc.get("Screen Shots");
                    JSONArray positions = (JSONArray) sc.get("Positions");
                    positions
                            .stream()
                            .forEach(y ->
                            {
                                JSONObject en = (JSONObject) y;
                                String positionName = (String) en.get("Position Name");
                                sb.append("<tr class='Entity'>\r\n"
                                        + "<td>Asset/Position Name</td>\r\n"
                                        + "<td>" + positionName + "</td>\r\n"
                                        + "</tr>\r\n");
                                JSONArray deviations = (JSONArray) en.get("Deviations");
                                deviations
                                        .stream()
                                        .forEach(z ->
                                        {
                                            JSONObject deviation = (JSONObject) z;
                                            String columnName = (String) deviation.get("Column Name");
                                            String expectedValue = (String) deviation.get("Expected value");
                                            String actualValue = (String) deviation.get("Actual Value");

                                            sb.append("<tr class='Deviation'>\r\n"
                                                    + "   <td class=\"columnName\">Column Name</td>\r\n"
                                                    + "   <td>" + columnName + "</td>\r\n"
                                                    + "   <td class=\"expectedAndActual\">Expected value</br>Actual Value</td>\r\n"
                                                    + "   <td>" + expectedValue + "</br>" + actualValue + "</td>\r\n"
                                                    + "</tr>\r\n");

                                        });
                            });
                    // Adding image inside a tr
                    sb.append("<tr class=\"gallery\">");
                    // Creating td for each image
                    screenshots
                            .stream()
                            .forEach(ss ->
                            {
                                String modalId = RandomStringUtils.random(5, true, false);
                                sb.append("<td>"
                                        + "<a class=\"lightbox\" href=\"#" + modalId + "\">\n" +
                                        "  <img src=\"" + ss.toString() + "\" />\n" +
                                        "</a>\n" +
                                        "<div class=\"lightbox-target\" id=\"" + modalId + "\">\n" +
                                        "  <img src=\"" + ss.toString() + "\" />\n" +
                                        "  <a class=\"lightbox-close\" href=\"#\"></a>\n" +
                                        "</div>" +
                                        "</td>");
                            });
                    sb.append("</tr>");
                });
        sb.append("</tbody>");
        return sb.toString();
    }
}
