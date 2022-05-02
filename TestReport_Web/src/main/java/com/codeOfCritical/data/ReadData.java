package com.codeOfCritical.data;

import com.codeOfCritical.services.DeviationsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ReadData implements DeviationsService {


    public List<String> scenarioName = new ArrayList<>();
    private String fileName = "D:\\GitHub\\CodeOfCritical\\TestReport_Web\\src\\main\\java\\com\\codeOfCritical\\data\\backup_deviations.json";
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
            System.out.println(s);
            scenarioName.add(s);

            JSONArray positions = (JSONArray) trigger.get("Positions");
            for (Object position : positions) {
                JSONObject trigger1 = (JSONObject) position;
                String positionName = (String) trigger1.get("Position Name");
                System.out.println(positionName);

                JSONArray deviations = (JSONArray) trigger1.get("Deviations");
                for (Object deviation : deviations) {
                    JSONObject trigger2 = (JSONObject) deviation;
                    String expectedValue = (String) trigger2.get("Expected value");
                    String fieldName = (String) trigger2.get("Column Name");
                    String actualValue = (String) trigger2.get("Actual Value");

                    System.out.println(expectedValue + " " + fieldName + " " + actualValue);
                }

            }

        }
        return this;
    }

    @Bean
    @Override
    public List<String> listAllFailedScenarios() {
        return scenarioName;
    }

    @Override
    public List<Integer> listOfAllScenarios() {
        return null;
    }


}
