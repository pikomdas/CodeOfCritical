package com.codeOfCritical.domain;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "deviations")
@Component
public class Deviations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String scenarioName;

    @Column(name = "expectedValue")
    private Double expectedValue;

    @Column(name = "fieldName")
    private String fieldName;

    @Column(name = "actualValue")
    private Double actualValue;

    private String pageName;

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

    public Double getActualValue() {
        return actualValue;
    }

    public void setActualValue(Double actualValue) {
        this.actualValue = actualValue;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    //    @Column(name = "actualValue")
//    private List<String> screenShots;


    /*public List<String> getScreenShots() {
        return screenShots;
    }

    public void setScreenShots(List<String> screenShots) {
        this.screenShots = screenShots;
    }*/
}
