/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCrotical.COM PRIVACY POLICY ÂŠ 2012
 * JSONBuilder.java belongs to codeOfCrotical
 * Do not COPY or PASTE code to WEB from codeOfCrotical
 * Creation date-time : 29-Jan-2020 2:18:53 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCrotical.JSONutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * @author partha.das
 * This will help to build custom HTML report after execution
 * of Analytics or General Ledger It accepts only scenarioName,
 * positionName, columnName, fromJSON, fromUI to generate a JSON
 * after
 * each successful scenario
 */
public class JSONBuilder
{
    private static final Logger log = LogManager.getLogger(JSONBuilder.class);
    // During the execution all thread will merge deviations into this List
    //private static volatile List<JSONObject> jsonData1 = Collections.synchronizedList(new ArrayList<JSONObject>());
    private static final Set<JSONObject> jsonData1 = new CopyOnWriteArraySet();

    /**
     * This method will capture data from the DataCollector class
     *
     * @param scenarioName
     * @param positionName
     * @param columnName
     * @param fromJSON
     * @param fromUI
     * @param screenshotLocation
     * @param executionDate
     */
    @SuppressWarnings("unchecked")
    public synchronized void collectData(String scenarioName, String positionName, String columnName, String fromJSON,
                                         String fromUI, List<String> screenshotLocation, String executionDate)
    {
        JSONObject jo = new JSONObject();
        // Adding scenario,position,column name, Expect and actual values into
        jo.put("Scenario Name", scenarioName);
        jo.put("Position Name", positionName);
        jo.put("Column Name", columnName);
        jo.put("Expected Value", fromJSON);
        jo.put("Actual Value", fromUI);
        // Adding screenshots
        JSONArray ss = new JSONArray();
        screenshotLocation.forEach(x ->
        {
            ss.add(x);
        });
        jo.put("ScreenShot", ss);
        // Adding Date stamp
        jo.put("Date", executionDate);
        // Printing raw json
        /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(jo));*/
//      System.out.println(jo.toJSONString());
//      Storing the JSONObject inside arraylist
        jsonData1.add(jo);

    }

    /**
     * @return the customized JSON data which is more efficient to build report
     */
    @SuppressWarnings("unchecked")
    public synchronized JSONObject getJSONObject()
    {
        // need to sort
        List<JSONObject> jsonData = jsonData1
                .stream()
                .sorted(Comparator.comparing(x -> x.get("Scenario Name").toString()))
                .collect(Collectors.toList());

        JSONObject scenario = new JSONObject();
        JSONArray scenarios = new JSONArray();
        JSONObject scenarioName = new JSONObject();
        JSONObject positionName = new JSONObject();
        JSONArray positions = null;
        JSONArray deviations = null;

        for (int i = 0; i < jsonData.size(); i++)
        {
            String sc1 = (String) jsonData.get(i).get("Scenario Name");
            String pn1 = (String) jsonData.get(i).get("Position Name");
            String col1 = (String) jsonData.get(i).get("Column Name");
            String ev1 = (String) jsonData.get(i).get("Expected Value");
            String av1 = (String) jsonData.get(i).get("Actual Value");
            JSONArray sch = (JSONArray) jsonData.get(i).get("ScreenShot");
            String date = (String) jsonData.get(i).get("Date");

            if (scenarioName.containsValue(sc1))
            {
                if (positionName.containsValue(pn1))
                {
                    JSONObject columnsAndValues = new JSONObject();
                    columnsAndValues.put("Column Name", col1);
                    columnsAndValues.put("Expected value", ev1);
                    columnsAndValues.put("Actual Value", av1);

                    deviations.add(columnsAndValues);
                    positionName.put("Deviations", deviations);
                } else
                {
                    positionName = new JSONObject();
                    positionName.put("Position Name", pn1);

                    JSONObject columnsAndValues = new JSONObject();
                    columnsAndValues.put("Column Name", col1);
                    columnsAndValues.put("Expected value", ev1);
                    columnsAndValues.put("Actual Value", av1);

                    deviations = new JSONArray();
                    deviations.add(columnsAndValues);

                    positionName.put("Deviations", deviations);

                    positions.add(positionName);
                    scenarioName.put("Positions", positions);
                }
            } else
            {
                scenarioName = new JSONObject();
                scenarioName.put("Scenario Name", sc1);
                scenarioName.put("Screen Shots", sch);
                scenarioName.put("Date", date);
                scenarios.add(scenarioName);

                positionName = new JSONObject();
                positionName.put("Position Name", pn1);

                positions = new JSONArray();
                positions.add(positionName);

                scenarioName.put("Positions", positions);

                JSONObject columnsAndValues = new JSONObject();
                columnsAndValues.put("Column Name", col1);
                columnsAndValues.put("Expected value", ev1);
                columnsAndValues.put("Actual Value", av1);

                deviations = new JSONArray();
                deviations.add(columnsAndValues);

                positionName.put("Deviations", deviations);
            }

        }
        scenario.put("Scenarios", scenarios);
        return scenario;
    }

    private synchronized String getJSONString()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(getJSONObject());
    }

    /**
     * @param path_of_json_file
     */
    public synchronized void createJSONFile(String path_of_json_file)
    {
        try
        {
            String projectPath = path_of_json_file;
            String tempFile = projectPath + File.separator + "deviations.json";
            File file = new File(tempFile);
            // if file does exists, then delete and create a new file
            if (file.exists())
            {
                File newFileName;
                try
                {
                    newFileName = new File(projectPath + File.separator + "backup_" + "deviations.json");
                    file.renameTo(newFileName);
                    file.createNewFile();
                }
                catch (IOException e)
                {
                    log.warn("JSON file creation is not completed, so waiting ");
                    try
                    {
                        // Wait until the file is created
                        file.wait(2000);
                        file.createNewFile();
                    }
                    catch (InterruptedException | IOException f)
                    {
                        f.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
            // write to file with OutputStreamWriter
            OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
            Writer writer = new OutputStreamWriter(outputStream);
            // Writing JSONObject to file
            writer.write(getJSONString());
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            log.info("JSON file creation process completed");
        }
    }

}