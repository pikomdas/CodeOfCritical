/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 *   DataCollectorJSONToUI.java belongs to codeOfCrotical
 *   Do not COPY or PASTE code to WEB from codeOfCrotical
 *   Creation date-time : 05/07/20, 1:01 AM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical.deviatonListner;

import com.codeOfCrotical.JSONutils.JSONBuilder;
import com.codeOfCrotical.html.HTML_Generator;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * This class will be used to Listen deviation from JSON to UI verification scenarios
 *
 * @author partha.das
 */
public class DataCollectorJSONToUI
{
    private static final ThreadLocal<PageLevelData> pageLevelData = new ThreadLocal<>();
    private static final ThreadLocal<JSONBuilder> jsonBuilder = ThreadLocal.withInitial(() -> new JSONBuilder());
    private static final ThreadLocal<HTML_Generator> html_generator = new ThreadLocal<>();
    private final ThreadLocal<String> sessionId = new ThreadLocal<>();
    private final ThreadLocal<String> currentTagName = new ThreadLocal<>();
    private final ThreadLocal<List<String>> screenshot = new ThreadLocal<>();
    private String path_of_json_file;

    /**
     * This parameters will capture details for particular one scenario (JSON to UI verification) only.
     *
     * @param sessionId      will be provided manually from base
     * @param currentTagName will be provided manually from base
     * @param pageLevelData  CucumberBeforeExecution.SCENARIO.get().getName(), positionName, columnName,
     *                       fromJSON, fromUI, passMessage
     */
    public DataCollectorJSONToUI(String sessionId, String currentTagName, PageLevelData pageLevelData)
    {
        this.sessionId.set(sessionId);
        this.currentTagName.set(currentTagName);
        DataCollectorJSONToUI.pageLevelData.set(pageLevelData);
    }

    /**
     * This method will return the list of captured deviation from JSON to UI verification
     *
     * @return scenarios, Positions, Expected values,Actual Values in form of Objects
     */
    private synchronized List<GetDetailsOfDeviations> getListonDeviations() {
        return pageLevelData.get().jsonToUI_Data.get();
    }

    /**
     * This method will create a JSON file internally, User need to pass the path of output file
     *
     * @return JSON object of the captured deviation
     * @throws IOException
     */
    private synchronized JSONObject buildJSON(List<String> screenshots) throws IOException
    {
        getListonDeviations()
                .stream()
                .forEach(x ->
                {
                    /*System.out.println("=============");
                    System.out.println(x);
                    System.out.println("=============");*/
                    jsonBuilder.get().collectData(x.getScenarioName(), x.getPageName(), x.getFieldName(), x.getExpectedValue(),

                            x.getActualValue(), screenshots, LocalDate.now().toString());
                });
        jsonBuilder.get().createJSONFile(path_of_json_file);
        return jsonBuilder.get().getJSONObject();
    }

    /**
     * This method is the terminal operation of the Report generation process
     *
     * @param path_of_HTML_output path where HTML report want to store (Development obsoleted)
     * @param screenShots         list of screenshots path
     * @throws IOException
     */
    public synchronized void buildHTML(String path_of_HTML_output, List<String> screenShots) throws IOException
    {
        this.screenshot.set(screenShots);
        this.path_of_json_file = path_of_HTML_output;
        html_generator.set(new HTML_Generator(buildJSON(this.screenshot.get())));
        html_generator.get().getHTML(path_of_HTML_output);
        // Clearing Thread Local values
        html_generator.remove();
        jsonBuilder.remove();
        /*
         * remove values from linkedList to over come data duplication
         * remove the linked list from the particular thread as it is denoted as a static
         * If second time the same thread will using the same linked list, it will get a
         * blank list to store data for the particular scenario.
         * ### Here Iteration of same result in JSON issue fixed ###
         */
        pageLevelData.get().jsonToUI_Data.get().clear();
        pageLevelData.get().jsonToUI_Data.remove();
    }
}
