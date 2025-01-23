package com.codeOfCritical.services;

import com.codeOfCritical.data.ReadData;
import com.codeOfCritical.domain.Deviations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class DeviationServiceImpl implements DeviationsService {

    private static final Logger log = LogManager.getLogger(DeviationServiceImpl.class);

    public Map<String, Map<String, String>> fieldDeviationDetails = new HashMap<>();
    public Set<String> users = new HashSet<>();
    public Set<String> dates = new HashSet<>();
    public Set<String> scenarioName = new HashSet<>();
    public Set<Deviations> deviationsObject = new HashSet<>();

    private String fileName = "../TestReport_Web/TestSwift/TestSwift_Web/test-outout/Custom-Report-HealthCheck/deviations.json";

    private JSONParser parser;
    private JSONObject obj;

    public DeviationServiceImpl() throws IOException, ParseException {
        this.parser = new JSONParser();
        this.obj = (JSONObject) parser.parse(new FileReader(fileName));
    }

    @Override
    public ReadData readJSON() {

        JSONArray jsonArray = (JSONArray) obj.get("Scenarios");
        for (Object o : jsonArray) {
            JSONObject trigger = (JSONObject) o;
            String s = (String) trigger.get("Scenario Name");
            String scenarioId = (String) trigger.get("Scenario Id");
            String user = (String) trigger.get("User");
            String date = (String) trigger.get("Date");
            System.out.println(s + " " + user + " " + date);
            scenarioName.add(s);
            users.add(user);
            dates.add(date);

            JSONArray positions = (JSONArray) trigger.get("Positions");
            for (Object position : positions) {
                JSONObject trigger1 = (JSONObject) position;
                String pageName = (String) trigger1.get("Page Name");
                String sessionId = (String) trigger1.get("Session ID");
                String tagName = (String) trigger1.get("Tag Name");

                JSONArray deviations = (JSONArray) trigger1.get("Deviations");
                Map<String, Map<String, String>> deviationsDetailsMap = new HashMap<>();
                for (Object deviation : deviations) {
                    JSONObject trigger2 = (JSONObject) deviation;
                    String expectedValue = (String) trigger2.get("Expected value");
                    String fieldName = (String) trigger2.get("Field Name");
                    String actualValue = (String) trigger2.get("Actual Value");

                    deviationsDetailsMap.put(fieldName, Map.of(expectedValue, actualValue));
                    log.info("-----> "+s + " , " + scenarioId + " , " + expectedValue + " , " + fieldName + " , " + actualValue + " , " + pageName + " , " + sessionId + " , " + tagName + " , " + List.of("A" + " , " + "B"));
                    deviationsObject.add(new Deviations(s, scenarioId, expectedValue, fieldName, actualValue, pageName, sessionId, tagName, List.of("A", "B")));
                }

            }

        }
        return null;
    }

    @Override
    public Set<String> getUsers() {
        return users;
    }

    @Override
    public Set<String> getDate() {
        return dates;
    }

    @Override
    public Set<String> listAllFailedScenarios() {
        return scenarioName;
    }

    @Override
    public List<Integer> listOfAllScenarios() {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> getFieldNameWithDeviationDetails() {
        return null;
    }

    @Override
    public Map<String, Map<String, Map<String, String>>> getdeviationDetailsWithPageName() {
        return null;
    }

    @Override
    public Integer getNumberOfAllFailedScenarios() {
        return scenarioName.size();
    }

    @Override
    public Set<Deviations> getListOfAllDeviations() {
        return deviationsObject;
    }

}
