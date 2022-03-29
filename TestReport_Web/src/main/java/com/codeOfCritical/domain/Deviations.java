package com.codeOfCritical.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Deviations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ScenarioCount;

    private String scenarioName;
    private Double expectedValue;
    private String fieldName;
    private Double actulValue;
    @ElementCollection
    private List<String> screenShots;

    public Integer getScenarioCount() {
        return ScenarioCount;
    }

    public void setScenarioCount(Integer scenarioCount) {
        ScenarioCount = scenarioCount;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public Double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(Double expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Double getActulValue() {
        return actulValue;
    }

    public void setActulValue(Double actulValue) {
        this.actulValue = actulValue;
    }

    public List<String> getScreenShots() {
        return screenShots;
    }

    public void setScreenShots(List<String> screenShots) {
        this.screenShots = screenShots;
    }
}
