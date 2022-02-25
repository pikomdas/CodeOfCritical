/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   DataCollector.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from codeOfCritical
 *   Creation date-time : 04/06/20, 8:03 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.deviatonListner;

import com.codeOfCritical.JSONutils.JSONBuilder;
import com.codeOfCritical.html.HTML_Generator;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * This class will interact with verification logic in framework where two different Map will be accepted
 * as arguments. Post that, It will simplify the Map into readable String and finally a JSON String will
 * be generated.
 *
 * @author partha.das
 */
public class DataCollector
{
    private static final ThreadLocal<PageLevelData> pageLevelData = new ThreadLocal<>();
    private final ThreadLocal<String> scenarioName = new ThreadLocal<>();
    private final ThreadLocal<String> sessionId = new ThreadLocal<>();
    private final ThreadLocal<String> currentTagName = new ThreadLocal<>();
    private final ThreadLocal<List<String>> screenshot = new ThreadLocal<>();
    private final JSONBuilder jsonBuilder = new JSONBuilder();
    private HTML_Generator html_generator;
    private String path_of_json_file;

    /**
     * These parameters will capture details for particular once scenario only.
     *
     * @param scenarioName   - will be provided manually from base
     * @param sessionId      - will be provided manually from base
     * @param currentTagName - will be provided manually from base
     * @param screenShot     - an Array of Screenshot location which will be provided from AfterStep hook
     * @param pageLevelData  - will be provided by Report summation capture and must be in format of
     *                       Map<String,Map<String,Double>
     */
    public DataCollector(String scenarioName, String sessionId, String currentTagName, List<String> screenShot, PageLevelData pageLevelData)
    {
        System.out.println("Starting Thread to collect data " + Thread.currentThread().getName());
        this.scenarioName.set(scenarioName);
        this.sessionId.set(sessionId);
        this.currentTagName.set(currentTagName);
        DataCollector.pageLevelData.set(pageLevelData);
        this.screenshot.set(screenShot);

    }

    /**
     * This will generate a List of Object of GetDetailsOfDeviations class
     *
     * @return simplified object from Maps
     */
    private synchronized List<GetDetailsOfDeviations> getListofDeviations()
    {
        return pageLevelData.get().data;
    }

    /**
     * This method will create a JSON file internally, User need to pass the path of output file
     *
     * @return JSON object of the captured deviation
     * @throws IOException
     */
    private synchronized JSONObject buildJSON() throws IOException
    {
        getListofDeviations()
                .stream()
                .forEach(x ->
                {
//                    System.out.println("Thread: " + Thread.currentThread().getName());
                    jsonBuilder.collectData(scenarioName.get(), x.getPageName(), x.getFieldName(), x.getExpectedValue(),
                            x.getActualValue(), screenshot.get(), LocalDate.now().toString());
                });
        jsonBuilder.createJSONFile(path_of_json_file);
        return jsonBuilder.getJSONObject();
    }

    /**
     * This method is the terminal operation of the Report generation process
     *
     * @param path_of_HTML_output path where HTML report want to store (Development obsoleted)
     * @throws IOException
     */
    public synchronized void buildHTML(String path_of_HTML_output) throws IOException
    {
        this.path_of_json_file = path_of_HTML_output;
        this.html_generator = new HTML_Generator(buildJSON());
        this.html_generator.getHTML(path_of_HTML_output);
    }
}
