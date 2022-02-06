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
    private final String positionName;
    private final String columnName;
    private final String expectedValue;
    private final String actualValue;
    private String scenarioName;

    /**
     * This Constructor will be used to capture deviation in the form Objects
     * This will capture only Health Check related scenarios
     *
     * @param positionName
     * @param columnName
     * @param expectedValue
     * @param actualValue
     */
    public GetDetailsOfDeviations(String positionName, String columnName, String expectedValue, String actualValue) {
        this.positionName = positionName;
        this.columnName = columnName;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }

    /**
     * This constructor will be used to capture deviation in the form of Objects
     * This will capture only for JSON to UI scenarios
     *
     * @param scenarioName
     * @param positionName
     * @param columnName
     * @param expectedValue
     * @param actualValue
     */
    public GetDetailsOfDeviations(String scenarioName, String positionName, String columnName, String expectedValue, String actualValue) {
        this.scenarioName = scenarioName;
        this.positionName = positionName;
        this.columnName = columnName;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }

    public synchronized String getPositionName() {
        return positionName;
    }

    public synchronized String getColumnName() {
        return columnName;
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
                    "positionName='" + positionName + '\'' +
                    ", columnName='" + columnName + '\'' +
                    ", expectedValue='" + expectedValue + '\'' +
                    ", actualValue='" + actualValue + '\'' +
                    ", scenarioName='" + scenarioName + '\'' +
                    '}';
        } else {
            return "GetDetailsOfDeviations{" +
                    "positionName='" + positionName + '\'' +
                    ", columnName='" + columnName + '\'' +
                    ", expectedValue='" + expectedValue + '\'' +
                    ", actualValue='" + actualValue + '\'' +
                    '}';
        }
    }
}

