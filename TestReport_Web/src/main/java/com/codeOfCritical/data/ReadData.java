package com.codeOfCritical.data;

import com.codeOfCritical.domain.Deviations;
import com.codeOfCritical.services.DeviationsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
@Service
public class ReadData implements DeviationsService {

    public Map<String, Map<String, String>> fieldDeviationDetails = new HashMap<>();
    public Set<String> users = new HashSet<>();
    public Set<String> dates = new HashSet<>();
    public List<String> scenarioName = new ArrayList<>();

    public List<Deviations> deviationsObject=new ArrayList<>();

//    private String fileName = "D:\\Automation_Framework\\autofw\\TemenosT24\\TestReport_Web\\src\\main\\java\\com\\codeOfCritical\\data\\backup_deviations.json";
private String fileName = "D:\\BitBucket\\autofw\\TemenosT24\\TemenosT24_Web\\test-outout\\Custom-Report-HealthCheck\\deviations.json";

    private JSONParser parser;
    private JSONObject obj;

    public ReadData() throws IOException, ParseException {
        this.parser = new JSONParser();
        this.obj = (JSONObject) parser.parse(new FileReader(fileName));
    }

    @Override
    public ReadData readJSON() {

        JSONArray jsonArray = (JSONArray) obj.get("Scenarios");
        for (Object o : jsonArray) {
            JSONObject trigger = (JSONObject) o;
            String s = (String) trigger.get("Scenario Name");
            String user = (String) trigger.get("User");
            String date=(String) trigger.get("Date");
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
                    System.out.println(expectedValue + " " + fieldName + " " + actualValue);
                    deviationsObject.add(new Deviations(s,expectedValue,fieldName,actualValue,pageName,sessionId,tagName,List.of("A","B")));
                }

            }

        }
        return this;
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
    public List<String> listAllFailedScenarios() {
        return scenarioName;
    }

    @Override
    public List<Integer> listOfAllScenarios() {
        return null;
    }

    @Override
    public Map<String, Map<String, String>> getFieldNameWithDeviationDetails() {
        return fieldDeviationDetails;
    }

    @Override
    public Map<String, Map<String, Map<String, String>>> getdeviationDetailsWithPageName() {
        return null;
    }

}
