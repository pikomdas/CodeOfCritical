package com.codeOfCritical.commonUtils.JSONutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

/**
 * This class will read json data from Transaction JSON file
 * For all transaction it it will be used
 * This will be used in step definition of Transaction
 *
 * @author partha.das
 */

public class JSONReader
{
    private static final Logger log = LogManager.getLogger(JSONReader.class.getName());
    private final ThreadLocal<JSONObject> o = new InheritableThreadLocal<>();
    private final ThreadLocal<JSONObject> scenarioName = new InheritableThreadLocal<>();
    private final ThreadLocal<String> value = new InheritableThreadLocal<>();

    /**
     * Parsing the JSON File
     *
     * @param fileName Transaction json file
     * @throws IOException
     * @throws ParseException
     */
    public JSONReader(String fileName) throws IOException, ParseException
    {
        JSONParser jp = new JSONParser();
        Reader reader = new FileReader(new File(fileName));
        this.o.set((JSONObject) jp.parse(reader));

    }

    public static void main(String[] args) throws IOException, ParseException
    {
        JSONReader jr = new JSONReader("./src/main/java/com/TechMReport/dataFile/Transactions/DirectEquity.json");
        jr.getScenarioName("Scenario1.1");
        jr.getValue("Brokerage");
        jr.getValue("Entity name");

        jr.getScenarioName("Scenario1");
        jr.getValue("Brokerage");
        jr.getValue("Entity name");
    }

    /**
     * @param key is the node in JSON
     * @return the value of the given Jey
     */
    public String getValue(String key)
    {

        value.set(null);
        @SuppressWarnings("unchecked")
        Map<String, String> map = scenarioName.get();

        if (map.containsKey(key))
        {
            value.set(map.get(key));
            log.info("values to be injected to Page Object: " + value.get());
        }
        String valueX = value.get();
        return valueX;
    }

    /**
     * @param scenario
     * @return the scenario Name
     */
    public JSONObject getScenarioName(String scenario)
    {
        this.scenarioName.set((JSONObject) o.get().get(scenario));
        //System.out.println(scenarioName.toString());
        return scenarioName.get();
    }

}
