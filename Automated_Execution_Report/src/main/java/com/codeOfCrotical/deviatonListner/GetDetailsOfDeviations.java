/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.ra.COM PRIVACY POLICY © 2012
 *   Do not COPY or PASTE code to WEB from codeOfCrotical
 *   Creation date-time : 06/06/20, 12:04 AM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical.deviatonListner;

public class GetDetailsOfDeviations {
    private final String pageName;
    private final String fieldName;
    private final String expectedValue;
    private final String actualValue;
    private String scenarioName;

    /**
     * This Constructor will be used to capture deviation in the form Objects
     * This will capture only Health Check related scenarios
     *
     * @param pageName
     * @param fieldName
     * @param expectedValue
     * @param actualValue
     */
    public GetDetailsOfDeviations(String pageName, String fieldName, String expectedValue, String actualValue) {
        this.pageName = pageName;
        this.fieldName = fieldName;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }

    /**
     * This constructor will be used to capture deviation in the form of Objects
     * This will capture only for JSON to UI scenarios
     *
     * @param scenarioName
     * @param pageName
     * @param fieldName
     * @param expectedValue
     * @param actualValue
     */
    public GetDetailsOfDeviations(String scenarioName, String pageName, String fieldName, String expectedValue, String actualValue) {
        this.scenarioName = scenarioName;
        this.pageName = pageName;
        this.fieldName = fieldName;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }

    public synchronized String getPageName() {
        return pageName;
    }

    public synchronized String getFieldName() {
        return fieldName;
    }

    public synchronized String getExpectedValue() {
        return expectedValue;
    }

    public synchronized String getActualValue() {
        return actualValue;
    }

    public synchronized String getScenarioName() {
        return scenarioName;
    }


    @Override
    public String toString() {
        if (scenarioName != null) {
            return "GetDetailsOfDeviations{" +
                    "pageName='" + pageName + '\'' +
                    ", fieldName='" + fieldName + '\'' +
                    ", expectedValue='" + expectedValue + '\'' +
                    ", actualValue='" + actualValue + '\'' +
                    ", scenarioName='" + scenarioName + '\'' +
                    '}';
        } else {
            return "GetDetailsOfDeviations{" +
                    "pageName='" + pageName + '\'' +
                    ", fieldName='" + fieldName + '\'' +
                    ", expectedValue='" + expectedValue + '\'' +
                    ", actualValue='" + actualValue + '\'' +
                    '}';
        }
    }
}

