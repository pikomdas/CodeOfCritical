package com.codeOfCritical.domain;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deviations")
@Component
public class Deviations {

    public Deviations() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String scenarioName;

    @Column(name = "expectedValue")
    private String expectedValue;

    @Column(name = "fieldName")
    private String fieldName;

    @Column(name = "actualValue")
    private String actualValue;

    @Column(name = "pageName")
    private String pageName;

    @Column(name = "sessionId")
    private String sessionId;

    @Column(name = "tagName")
    private String tagName;

//    @Column(name="screenshots")
//    private List<String> screenShots;

    public Deviations(String scenarioName, String expectedValue, String fieldName, String actualValue, String pageName, String sessionId, String tagName, List<String> screenShots) {
        this.scenarioName = scenarioName;
        this.expectedValue = expectedValue;
        this.fieldName = fieldName;
        this.actualValue = actualValue;
        this.pageName = pageName;
        this.sessionId = sessionId;
        this.tagName = tagName;
       // this.screenShots = screenShots;
    }

    public <E> Deviations(String s, String scenarioId, String expectedValue, String fieldName, String actualValue, String pageName, String sessionId, String tagName, List<E> a) {
    }

    @Override
    public String toString() {
        return "Deviations{" +
                "scenarioName='" + scenarioName + '\'' +
                ", expectedValue=" + expectedValue +
                ", fieldName='" + fieldName + '\'' +
                ", actualValue=" + actualValue +
                ", pageName='" + pageName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", tagName='" + tagName + '\'' +
//                ", screenShots=" + screenShots +
                '}';
    }

    public String scenarioName() {
        return scenarioName;
    }

    public String expectedValue() {
        return expectedValue;
    }

    public String fieldName() {
        return fieldName;
    }

    public String actualValue() {
        return actualValue;
    }

    public String pageName() {
        return pageName;
    }

    public String sessionId() {
        return sessionId;
    }

    public String tagName() {
        return tagName;
    }
}
