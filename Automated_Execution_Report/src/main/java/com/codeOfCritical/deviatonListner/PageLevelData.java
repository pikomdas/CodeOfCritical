/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   PageLevelData.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from codeOfCritical
 *   Creation date-time : 04/06/20, 8:17 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.deviatonListner;

import com.codeOfCritical.CucumberExtentReport.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h2>This class will interact with verification step and will collect data
 * specific to pages.
 * This class will simplify the Collected data by transforming into
 * GetDetailsOfDeviations.class object
 * This class also provides the facility to keep deviation into an LinkedList
 * for JSON to UI verification scenarios,
 * where multiple time this class object will be created, but HTML will be
 * generated at the end of scenario.</h2>
 */
public class PageLevelData
{

    private static final Logger log = LogManager.getLogger(PageLevelData.class);
    private static final ThreadLocal<GetDetailsOfDeviations> getDetailsOfDeviations = new ThreadLocal<>();
    /*
     * This will store data for JSON to UI verification scenarios
     * it is expected that each threads handles one scenario particularly. So each thread
     * will create a linked list to capture deviations else all scenarios deviations will mesh up and
     * it will be hard to isolate those objects.
     */
    public static ThreadLocal<List<GetDetailsOfDeviations>> jsonToUI_Data = ThreadLocal
            .withInitial(() -> Collections.synchronizedList(new LinkedList<>()));
    /*
     * This will store data from given HashMap
     * in a simplified format for All Health
     * Check related scenarios
     */
    public List<GetDetailsOfDeviations> data = new CopyOnWriteArrayList<>();

    {
        log.info("############################");
        log.info("VERIFICATION PROCESS STARTED");
        log.info("############################");
    }

    /**
     * <h2>This constructor will be used for verifying two Map (Cross Env
     * scenarios)</h2>
     *
     * @param url1 url of first environment
     * @param url2 url of second environment
     * @param m1   Transaction Vehicle Level summation from Env 1
     * @param m2   Transaction Vehicle Level summation from Env 2
     */
    public PageLevelData(String url1, String url2, Map<String, Map<String, Double>> m1,
                         Map<String, Map<String, Double>> m2)
    {
        if (m1.keySet().size() == m2.keySet().size())
        {
            log.info(url2 + " has EQUAL number page than " + url1);
            m1.keySet()
                    .stream()
                    .forEach(pageName ->
                    {
                        String page = pageName;
                        log.info("page in " + url1 + " : " + page);

                        m1.get(pageName).keySet()
                                .stream()
                                .forEach(attribute ->
                                {
                                    String colName = attribute;
                                    log.info("Column in " + url1 + " : " + colName);
                                    double expectedValue = m1.get(page).get(colName);
                                    log.info("Expected: " + expectedValue);

                                    // Checking if same key (headerName) is available in m2 or not,
                                    // java.lang.NullPointerException issue fixed here
                                    // Checking for page name, null pointer issue fixed also
                                    if (m2.containsKey(page))
                                    {
                                        // Checking is same column name is present or not in second Map<String,Double>
                                        if (m2.get(page).containsKey(colName))
                                        {
                                            double actualValue = m2.get(page).get(colName);
                                            log.info("Actual: " + actualValue);
                                            if (expectedValue == actualValue)
                                            {
                                                log.info("All values matched for page name: " + page + " & column name: "
                                                        + colName);
                                            }
                                            else
                                            {
                                                String expectedValueAsString = String.format("%.8f", expectedValue).concat(" (")
                                                        .concat(url1).concat(")");
                                                String actualValueAsString = String.format("%.8f", actualValue).concat(" (")
                                                        .concat(url2).concat(")");

                                                log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                        + expectedValueAsString + " Actual: " + actualValueAsString);
                                                Reporter.addStepLog(
                                                        "page: " + page + " Column Name: " + colName + " Expected: "
                                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                                getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                        expectedValueAsString, actualValueAsString));
                                                log.info(getDetailsOfDeviations.get());
                                                data.add(getDetailsOfDeviations.get());
                                            }
                                        }
                                        else
                                        {
                                            String expectedValueAsString = String.format("%.8f", expectedValue).concat("(")
                                                    .concat(url1).concat(")");
                                            String actualValueAsString = "Mismatch of header name ".concat("(")
                                                    .concat(url2).concat(")");

                                            log.warn("== > page: " + page + " Column Name: " + colName + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString);
                                            Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString);
                                            getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                    expectedValueAsString, actualValueAsString));
                                            log.info(getDetailsOfDeviations.get());
                                            data.add(getDetailsOfDeviations.get());
                                        }
                                    }
                                    else
                                    {
                                        String message = page + " NOT FOUND in " + url2;
                                        String expectedValueAsString = String.format("%.8f", expectedValue).concat("  (")
                                                .concat(url1).concat(")");
                                        getDetailsOfDeviations
                                                .set(new GetDetailsOfDeviations(message, colName.concat(" & Column Not Found"), expectedValueAsString, "Not Found"));
                                        log.info(getDetailsOfDeviations.get());
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                });
                    });
        }
        else if (m1.keySet().size() > m2.keySet().size())
        {
            log.info(url1 + " has more number page than " + url2);
            m1.keySet()
                    .stream()
                    .forEach(pageName ->
                    {
                        log.info("page in " + url1 + " : " + pageName);

                        m1.get(pageName).keySet()
                                .stream()
                                .forEach(attribute ->
                                {
                                    String page = pageName;
                                    String colName = attribute;
                                    double expectedValue = m1.get(pageName).get(attribute);

                                    // Checking if same page name key is available or not in m2
                                    if (m2.containsKey(pageName))
                                    {
                                        log.info("page in " + url2 + " : " + pageName);
                                        // Checking if same key (headerName) is available in m2 or not,
                                        // java.lang.NullPointerException issue fixed here
                                        if (m2.get(pageName).containsKey(attribute))
                                        {
                                            double actualValue = m2.get(pageName).get(attribute);
                                            if (expectedValue == actualValue)
                                            {
                                                log.info("All values matched for page name: " + page
                                                        + " & column name: " + colName);
                                            }
                                            else
                                            {
                                                String expectedValueAsString = String.format("%.8f", expectedValue).concat(" (")
                                                        .concat(url1).concat(")");
                                                String actualValueAsString = String.format("%.8f", actualValue).concat(" (")
                                                        .concat(url2).concat(")");

                                                log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                        + expectedValueAsString + " Actual: " + actualValueAsString);
                                                Reporter.addStepLog(
                                                        "page: " + page + " Column Name: " + colName + " Expected: "
                                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                                getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                        expectedValueAsString, actualValueAsString));
                                                log.info(getDetailsOfDeviations.get());
                                                data.add(getDetailsOfDeviations.get());
                                            }
                                        }
                                        else
                                        {
                                            String expectedValueAsString = String.format("%.8f", expectedValue).concat("(")
                                                    .concat(url1).concat(")");
                                            String actualValueAsString = "Mismatch of header name ".concat("(")
                                                    .concat(url2).concat(")");

                                            log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString);
                                            Reporter.addStepLog("page: " + page + " Column Name: " + colName.concat(" Not Found") + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString);
                                            getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName.concat(" Not Found"),
                                                    expectedValueAsString, actualValueAsString));
                                            log.info(getDetailsOfDeviations.get());
                                            data.add(getDetailsOfDeviations.get());
                                        }
                                    }
                                    else
                                    {
                                        String message = page + " NOT FOUND in " + url2;
                                        String expectedValueAsString = String.format("%.8f", expectedValue).concat("  (")
                                                .concat(url1).concat(")");
                                        getDetailsOfDeviations
                                                .set(new GetDetailsOfDeviations(message, colName.concat(" & Column Not Found"), expectedValueAsString, "Not Found"));
                                        log.info(getDetailsOfDeviations.get());
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                });
                    });
        }
        else
        {
            log.info(url2 + " has more number page than " + url1);
            m2.keySet()
                    .stream()
                    .forEach(pageName ->
                    {
                        m2.get(pageName)
                                .keySet()
                                .stream()
                                .forEach(attribute ->
                                {
                                    String page = pageName;
                                    String colName = attribute;
                                    double actualValue = m2.get(pageName).get(attribute);
                                    if (m1.containsKey(pageName))
                                    {
                                        // Checking if same key (headerName) is available in m2 or not,
                                        // java.lang.NullPointerException issue fixed here
                                        if (m1.get(pageName).containsKey(attribute))
                                        {
                                            double expectedValue = m1.get(pageName).get(attribute);
                                            if (expectedValue == actualValue)
                                            {
                                                log.info("All values matched for page name: " + page
                                                        + " & column name: " + colName);
                                            }
                                            else
                                            {
                                                String expectedValueAsString = String.format("%.8f", expectedValue).concat(" (")
                                                        .concat(url1).concat(")");
                                                String actualValueAsString = String.format("%.8f", actualValue).concat(" (")
                                                        .concat(url2).concat(")");

                                                log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                        + expectedValueAsString + " Actual: " + actualValueAsString);
                                                Reporter.addStepLog(
                                                        "page: " + page + " Column Name: " + colName + " Expected: "
                                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                                getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                        expectedValueAsString, actualValueAsString));
                                                log.info(getDetailsOfDeviations.get());
                                                data.add(getDetailsOfDeviations.get());
                                            }
                                        }
                                        else
                                        {
                                            String actualValueAsString = String.format("%.8f", actualValue).concat("(")
                                                    .concat(url2).concat(")");
                                            String expectedValueAsString = "Mismatch of header name ".concat("(")
                                                    .concat(url1).concat(")");
                                            String message = "page: " + page + " Column Name: " + colName.concat(" Not Found") + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString;
                                            log.warn(message);
                                            Reporter.addStepLog(message);
                                            getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName.concat(" Not Found"), expectedValueAsString, actualValueAsString));
                                            log.info(getDetailsOfDeviations.get());
                                            data.add(getDetailsOfDeviations.get());
                                        }
                                    }
                                    else
                                    {
                                        String message = page + " NOT FOUND in " + url1;
                                        String actualValueAsString = String.format("%.8f", actualValue).concat("  (")
                                                .concat(url2).concat(")");
                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(message, colName.concat(" & Column Not Found"), "Not Found", actualValueAsString));
                                        log.info(getDetailsOfDeviations.get());
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                });
                    });
        }
    }

    /**
     * <h2>This constructor will be used in JSON to UI verification for Reports
     * During the execution , this constructor will be called for each row's column
     * value verification
     * It will store each scenario's deviation into jsonToUI_Data in a way that will
     * not be visible to other thread</h2>
     *
     * @param pageName
     * @param attribute
     * @param fromJSON
     * @param fromUI
     * @param passMessage
     */
    public PageLevelData(String scenarioName, String pageName, String attribute, double fromJSON, double fromUI,
                         String passMessage)
    {
        if (fromJSON == fromUI)
        {
            log.info(passMessage);
        }
        else
        {
            String fromJSONAsString = String.format("%.8f", fromJSON);
            String fromUIAsString = String.format("%.8f", fromUI);
            String s = "page Name is : " + pageName.toUpperCase() + " " + attribute + " || "
                    + " Value is in JSON file: " + fromJSONAsString + " Value is in UI : " + fromUIAsString;
            log.warn(s);
            Reporter.addStepLog(s);
            // Creating object of GetDetailsOfDeviations to catch deviations
            getDetailsOfDeviations.set(new GetDetailsOfDeviations(scenarioName, pageName, attribute,
                    fromJSONAsString, fromUIAsString));
            // Storing objects deviation into a LikedList
            jsonToUI_Data.get().add(getDetailsOfDeviations.get());
        }
    }

    /**
     * <h2>This constructor will be used in JSON to UI verification for Reports
     * During the execution , this constructor will be called for each row's column
     * value verification
     * It will store each scenario's deviation into jsonToUI_Data in a way that will
     * not be visible to other thread</h2>
     * <p>
     * This method is added for string validation
     *
     * @param scenarioName
     * @param PageName
     * @param ExpectedValue
     * @param ActualValue
     * @param attribute
     */
    public PageLevelData(String scenarioName, String PageName, String ExpectedValue, String ActualValue, String attribute)
    {
        if (ActualValue.contains(ExpectedValue))
        {
            String s = "Page :" + PageName + " +attribute value is : " + ActualValue.toUpperCase() + " matched";
            log.info(s);
        }
        else
        {
            String s = "Page :" + PageName + " +attribute value is : " + ActualValue.toUpperCase();
            log.warn(s);
            Reporter.addStepLog(s);
            // Creating object of GetDetailsOfDeviations to catch deviations
            getDetailsOfDeviations.set(new GetDetailsOfDeviations(scenarioName, ActualValue, attribute, "0 (page Name should not be displayed in UI)", "1 (page Name is displayed in UI)"));
            // Storing objects deviation into a LikedList
            log.info(PageName + "Verification of " + attribute + " Failed");
        }

    }

    /**
     * <h2>This Constructor will be used to check Cross_Report_Summation</h2>
     *
     * @param firstPage  first page
     * @param m1         captured first page with respective page's header name with values
     * @param secondPage second page
     * @param m2         captured second page with respective page's header name with values
     */
    public PageLevelData(String firstPage, Map<String, Map<String, Double>> m1, String secondPage,
                         Map<String, Map<String, Double>> m2)
    {
        if (firstPage.split(" ")[0].equalsIgnoreCase(secondPage.split(" ")[0]))
        {
            log.info("First Page: " + firstPage + " and Second Page: " + secondPage);
            m1.keySet()
                    .stream()
                    .forEach(pageName ->
                    {
                        if ((pageName.contains("Total")) || (pageName.contains("TOTAL"))
                                || (pageName.contains("NET INCOME")))
                        {
                            log.info("Expected page found(First Report): " + pageName);
                            m1.get(pageName)
                                    .keySet()
                                    .stream()
                                    .filter(attribute -> attribute.contains(firstPage))
                                    .forEach(attribute ->
                                    {
                                        double valueInReport1 = m1.get(pageName).get(attribute);
                                        log.info("Transaction Vehicle: " + pageName + " Header Name: " + attribute
                                                + " Value: " + valueInReport1);
                                        m2.keySet()
                                                .stream()
                                                .forEach(pageName2 ->
                                                {
                                                    if ((pageName2.contains("Total")) || (pageName2.contains("TOTAL"))
                                                            || (pageName2.contains("NET INCOME")))
                                                    {
                                                        log.info("Expected page found(Second Report): " + secondPage);
                                                        m2.get(pageName2)
                                                                .keySet()
                                                                .stream()
                                                                .filter(attribute2 -> attribute2.contains(pageName2))
                                                                .forEach(attribute2 ->
                                                                {
                                                                    double valueInReport2 = m2.get(pageName2)
                                                                            .get(attribute2);
                                                                    log.info("Transaction Vehicle: " + secondPage + " Header Name: " + attribute2 + " Value: " + valueInReport2);
                                                                    if (valueInReport1 == valueInReport2)
                                                                    {
                                                                        log.info(firstPage + " value is same with " + secondPage);
                                                                    }
                                                                    else
                                                                    {
                                                                        String expectedValueAsString = String.format("%.8f", valueInReport1);
                                                                        String actualValueAsString = String.format("%.8f", valueInReport2);
                                                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(pageName, attribute, expectedValueAsString, actualValueAsString));
                                                                        log.info(getDetailsOfDeviations.get());
                                                                        data.add(getDetailsOfDeviations.get());
                                                                    }
                                                                });
                                                    }
                                                });

                                    });
                        }
                        else if (m2.containsKey(pageName))
                        {
                            log.warn("Verification is not on the Last row (Total), all page with its respective column's value");
                            log.warn("Verification of same pages where same page NAME is available ");

                            log.info("Expected page found " + pageName);
                            Map<String, Double> header_value_1 = m1.get(pageName);
                            Map<String, Double> header_value_2 = m2.get(pageName);

                            Iterator<Map.Entry<String, Double>> expected_iterator = header_value_1.entrySet().iterator();
                            Iterator<Map.Entry<String, Double>> actual_iterator = header_value_2.entrySet().iterator();

                            while (expected_iterator.hasNext() && actual_iterator.hasNext())
                            {
                                Map.Entry<String, Double> m11 = expected_iterator.next();
                                Map.Entry<String, Double> m22 = actual_iterator.next();
                                if (m11.getValue().equals(m22.getValue()))
                                {
                                    log.info("page: " + pageName + " " + m11.getKey() + " : " + m11.getValue() + " MATCHED " + m22.getKey() + " : " + m22.getValue());
                                }
                                else
                                {
                                    String message = m11.getKey() + " : " + String.format("%.8f", m11.getValue()) + " not matched "
                                            + m22.getKey() + " : " + String.format("%.8f", m22.getValue());
                                    log.warn(message);
                                    // Adding step log to cucumber report
                                    Reporter.addStepLog(message);
                                    // Capturing deviation details in a from of GetDetailsOfDeviations object
                                    getDetailsOfDeviations.set(new GetDetailsOfDeviations(pageName, m11.getKey().concat(" & ").concat(m22.getKey()),
                                            String.format("%.8f", m11.getValue()).concat(" (").concat(firstPage).concat(")"),
                                            String.format("%.8f", m22.getValue()).concat(" (").concat(secondPage).concat(")")));
                                    log.info(getDetailsOfDeviations.get());
                                    // Storing the GetDetailsOfDeviations object into an ArrayList
                                    data.add(getDetailsOfDeviations.get());
                                }

                            }
                        }
                        else
                        {
                            String message = pageName + " NOT FOUND in " + secondPage;
                            log.warn(message);
                            // Adding step log to cucumber report
                            Reporter.addStepLog(message);
                            // Capturing deviation details in a from of GetDetailsOfDeviations object
                            Map<String, Double> actual_header_value = m1.get(pageName);

                            String actual_header = actual_header_value.entrySet().iterator().next().getKey();
                            Double actual_value = actual_header_value.entrySet().iterator().next().getValue();

                            getDetailsOfDeviations.set(new GetDetailsOfDeviations(message,
                                    actual_header.concat(" & ").concat("NOT FOUND"),
                                    String.format("%.8f", actual_value).concat(" (").concat(firstPage).concat(")"),
                                    "NOT FOUND".concat(" (").concat(secondPage).concat(")")));
                            log.info(getDetailsOfDeviations.get());
                            // Storing the GetDetailsOfDeviations object into an ArrayList
                            data.add(getDetailsOfDeviations.get());

                        }
                    });
        }
        else
        {
            log.info("First Page: " + firstPage + " and Second Page: " + secondPage);
            if (m1.size() > 1 && m2.size() > 1)
            {
                log.warn("Verification of two different pages where same page name is NOT same");
                log.info("First page's Map size: " + m1.size() + " Second page's Map size: " + m2.size());
                m1.keySet()
                        .stream()
                        .forEach(pageName ->
                        {
                            if (m2.containsKey(pageName))
                            {
                                log.warn("Verification is not on the Last row (Total), all page with its respective column's value");
                                log.warn("Verification of same pages where same page NAME is available ");

                                log.info("Expected page found " + pageName);
                                Map<String, Double> header_value_1 = m1.get(pageName);
                                Map<String, Double> header_value_2 = m2.get(pageName);

                                Iterator<Map.Entry<String, Double>> expected_iterator = header_value_1.entrySet().iterator();
                                Iterator<Map.Entry<String, Double>> actual_iterator = header_value_2.entrySet().iterator();

                                while (expected_iterator.hasNext() && actual_iterator.hasNext())
                                {
                                    Map.Entry<String, Double> m11 = expected_iterator.next();
                                    Map.Entry<String, Double> m22 = actual_iterator.next();
                                    if (m11.getValue().equals(m22.getValue()))
                                    {
                                        log.info("page: " + pageName + " " + m11.getKey() + " : " + m11.getValue() + " MATCHED " + m22.getKey() + " : " + m22.getValue());
                                    }
                                    else
                                    {
                                        String message = m11.getKey() + " : " + String.format("%.8f", m11.getValue()) + " not matched "
                                                + m22.getKey() + " : " + String.format("%.8f", m22.getValue());
                                        log.warn(message);
                                        // Adding step log to cucumber report
                                        Reporter.addStepLog(message);
                                        // Capturing deviation details in a from of GetDetailsOfDeviations object
                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(pageName, m11.getKey().concat(" & ").concat(m22.getKey()),
                                                String.format("%.8f", m11.getValue()).concat(" (").concat(firstPage).concat(")"),
                                                String.format("%.8f", m22.getValue()).concat(" (").concat(secondPage).concat(")")));
                                        log.info(getDetailsOfDeviations.get());
                                        // Storing the GetDetailsOfDeviations object into an ArrayList
                                        data.add(getDetailsOfDeviations.get());
                                    }

                                }
                            }
                            else
                            {
                                String message = pageName + " NOT FOUND in " + secondPage;
                                log.warn(message);
                                // Adding step log to cucumber report
                                Reporter.addStepLog(message);
                                // Capturing deviation details in a from of GetDetailsOfDeviations object
                                Map<String, Double> actual_header_value = m1.get(pageName);

                                String actual_header = actual_header_value.entrySet().iterator().next().getKey();
                                Double actual_value = actual_header_value.entrySet().iterator().next().getValue();

                                getDetailsOfDeviations.set(new GetDetailsOfDeviations(message,
                                        actual_header.concat(" & ").concat("NOT FOUND"),
                                        String.format("%.8f", actual_value).concat(" (").concat(firstPage).concat(")"),
                                        "NOT FOUND".concat(" (").concat(secondPage).concat(")")));
                                log.info(getDetailsOfDeviations.get());
                                // Storing the GetDetailsOfDeviations object into an ArrayList
                                data.add(getDetailsOfDeviations.get());

                            }

                        });
            }
            else
            {
                log.warn("Verification of two different or same pages where same page name is NOT same");
                log.info("First page's Map size: " + m1.size() + " Second page's Map size: " + m2.size());

                String firstReportKey = m1.keySet().iterator().next();
                String secondReportKey = m2.keySet().iterator().next();

                Map<String, Double> firstReport_Header_Value = m1.get(firstReportKey);
                Map<String, Double> second_Report_Header_Value = m2.get(secondReportKey);

                String firstReport_Headers_name = firstReport_Header_Value.entrySet().iterator().next().getKey();
                String secondReport_Headers_name = second_Report_Header_Value.entrySet().iterator().next().getKey();

                Double firstReport_Headers_Value = firstReport_Header_Value.entrySet().iterator().next().getValue();
                Double secondReport_Headers_Value = second_Report_Header_Value.entrySet().iterator().next().getValue();

                if (firstReport_Headers_Value.equals(secondReport_Headers_Value))
                {
                    String message = ("Report: " + firstPage + " Header " + firstReport_Headers_name + " value " + firstReport_Headers_Value
                            + " matched with " + "Report: " + secondPage + " Header " + secondReport_Headers_name + " value " + secondReport_Headers_Value);
                    log.info(message);
                    Reporter.addStepLog(message);
                }
                else
                {
                    String message = ("Report: " + firstPage + " Header " + firstReport_Headers_name + " value " + firstReport_Headers_Value
                            + " NOT matched with " + "Report: " + secondPage + " Header " + secondReport_Headers_name + " value " + secondReport_Headers_Value);
                    log.info(message);
                    Reporter.addStepLog(message);
                    // Capturing deviation details in a from of GetDetailsOfDeviations object
                    getDetailsOfDeviations.set(new GetDetailsOfDeviations(firstReportKey + " & " + secondReportKey, firstReport_Headers_name + " & " + secondReport_Headers_name,
                            String.format("%.8f", firstReport_Headers_Value), String.format("%.8f", secondReport_Headers_Value)));
                    log.info(getDetailsOfDeviations.get());
                    // Storing the GetDetailsOfDeviations object into an ArrayList
                    data.add(getDetailsOfDeviations.get());
                }
            }

        }


    }

    /**
     * This constructor will be used to check filter combination scenarios
     *
     * @param m1                       idle page ,header values
     * @param m2                       actual page ,header values
     * @param primaryGroup_FirstFetch  primaryGroup
     * @param primaryGroup_secondFetch secondaryGroup
     */
    public PageLevelData(Map<String, Map<String, Double>> m1, Map<String, Map<String, Double>> m2,
                         String primaryGroup_FirstFetch, String primaryGroup_secondFetch)
    {
        m1.keySet()
                .stream()
                .forEach(pageName ->
                {
                    m1.get(pageName)
                            .keySet()
                            .stream()
                            .forEach(attribute ->
                            {
                                String page = pageName;
                                String colName = attribute;
                                double expectedValue = m1.get(pageName).get(attribute);
                                // Checking if page name is matching with idle pageName or not
                                if (m2.containsKey(pageName))
                                {
                                    // Checking if same key (headerName) is available in m2 or not,
                                    // java.lang.NullPointerException issue fixed here
                                    if (m2.get(pageName).containsKey(attribute))
                                    {
                                        double actualValue = m2.get(pageName).get(attribute);

                                        if (expectedValue == actualValue)
                                        {
                                            log.info(
                                                    "All values matched for page name: " + page + " & column name: " + colName);
                                        }
                                        else
                                        {
                                            String expectedValueAsString = String.format("%.8f", expectedValue).concat(" (")
                                                    .concat(primaryGroup_FirstFetch).concat(")");
                                            String actualValueAsString = String.format("%.8f", actualValue).concat(" (")
                                                    .concat(primaryGroup_secondFetch).concat(")");

                                            log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString);
                                            Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                                    + expectedValueAsString + " Actual: " + actualValueAsString);
                                            getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                    expectedValueAsString, actualValueAsString));
                                            log.info(getDetailsOfDeviations.get());
                                            data.add(getDetailsOfDeviations.get());
                                        }
                                    }
                                    else
                                    {
                                        String actualValueAsString = String.format("%.8f", expectedValue).concat("(").concat(primaryGroup_FirstFetch).concat(")");
                                        String expectedValueAsString = "Not found due to mismatch of header name";

                                        log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                        Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                expectedValueAsString, actualValueAsString));
                                        log.info(getDetailsOfDeviations.get());
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                }
                                else
                                {
                                    String expectedValueAsString = String.format("%.8f", expectedValue).concat("  (")
                                            .concat(primaryGroup_FirstFetch).concat(")");
                                    String actualValueAsString = "Not Found";

                                    log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                            + expectedValueAsString + " Actual: " + actualValueAsString);
                                    Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                            + expectedValueAsString + " Actual: " + actualValueAsString);
                                    getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                            expectedValueAsString, actualValueAsString));
                                    log.warn(getDetailsOfDeviations.get());
                                    data.add(getDetailsOfDeviations.get());
                                }
                            });
                });
    }

    /**
     * <h2>This constructor will be used to check Partnership scenarios</h2>
     *
     * @param m1            Transaction vehicle level summation without
     *                      Partnership
     * @param partnership   partnership
     * @param holdingMethod holding method
     * @param m2            Transaction Vehicle level summation with Partnership
     */
    public PageLevelData(Map<String, Map<String, Double>> m1, String partnership, String holdingMethod,
                         Map<String, Map<String, Double>> m2)
    {
        m1.keySet()
                .stream()
                .forEach(pageName ->
                {
                    String page = pageName;
                    m1.get(page)
                            .keySet()
                            .stream()
                            .forEach(attribute ->
                            {
                                String colName = attribute;
                                double expectedValue = m1.get(page).get(colName);
                                if (m2.containsKey(page))
                                {
                                    double actualValue = m2.get(page).get(colName);
                                    // Verifying column names' values
                                    if (expectedValue == actualValue)
                                    {
                                        log.info("All values matched for page name: " + page +
                                                " & column name: " + colName);
                                    }
                                    else
                                    {
                                        // Adding Without partnership name with expected Value
                                        String expectedValueAsString = String.format("%.8f", expectedValue);
                                        // Adding current partnership name with actual Value
                                        String actualValueAsString = String.format("%.8f", actualValue).concat(" (")
                                                .concat(partnership).concat(" & ").concat(holdingMethod).concat(")");

                                        log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                        // Adding step log to cucumber report
                                        Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                        // Capturing deviation details in a from of GetDetailsOfDeviations object
                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                expectedValueAsString, actualValueAsString));
                                        log.info(getDetailsOfDeviations.get());
                                        // Storing the GetDetailsOfDeviations object into an ArrayList
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                }
                                else
                                {
                                    // Adding Without partnership name with expected Value
                                    String expectedValueAsString = String.format("%.8f", expectedValue);
                                    // Adding current partnership name with actual Value
                                    String actualValueAsString = page + " not found".concat(" (")
                                            .concat(partnership).concat(" & ").concat(holdingMethod).concat(")");
                                    log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                            + expectedValueAsString + " Actual: " + actualValueAsString);
                                    // Adding step log to cucumber report
                                    Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                            + expectedValueAsString + " Actual: " + actualValueAsString);
                                    // Capturing deviation details in a from of GetDetailsOfDeviations object
                                    getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                            expectedValueAsString, actualValueAsString));
                                    log.info(getDetailsOfDeviations.get());
                                    // Storing the GetDetailsOfDeviations object into an ArrayList
                                    data.add(getDetailsOfDeviations.get());
                                }
                            });
                });
    }

    /**
     * <h2>This constructor will be used for Templates verification scenarios</h2>
     * <h2>This constructor will be used for PPS TWR verification scenarios</h2>
     *
     * @param m1               Transaction vehicle level summation from IDLE
     *                         template selection
     * @param idleTemplateName
     * @param m2               Transaction vehicle level summation from CURRENT
     *                         template selection
     * @param currentTemplate
     */
    public PageLevelData(Map<String, Map<String, Double>> m1, String idleTemplateName,
                         Map<String, Map<String, Double>> m2, String currentTemplate)
    {
        m1.keySet()
                .stream()
                .forEach(pageName ->
                {
                    m1.get(pageName).keySet()
                            .stream()
                            .forEach(attribute ->
                            {
                                String page = pageName;
                                String colName = attribute;
                                double expectedValue = m1.get(pageName).get(attribute);
                                // Checking if same page name with colmnName key is present or not
                                if (m2.containsKey(pageName) && m2.get(pageName).containsKey(attribute))
                                {
                                    double actualValue = m2.get(pageName).get(attribute);
                                    if (expectedValue == actualValue)
                                    {
                                        log.info("All values matched for page name: " + page + " & column name: "
                                                + colName);
                                    }
                                    else
                                    {
                                        // Adding idle template name with expected Value
                                        String expectedValueAsString = String.format("%.8f", expectedValue).concat(" (")
                                                .concat(idleTemplateName).concat(")");
                                        // Adding current template name with actual Value
                                        String actualValueAsString = String.format("%.8f", actualValue).concat(" (")
                                                .concat(currentTemplate).concat(")");

                                        log.warn("page: " + page + " Column Name: " + colName + " Expected: "
                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                        // Adding step log to cucumber report
                                        Reporter.addStepLog("page: " + page + " Column Name: " + colName + " Expected: "
                                                + expectedValueAsString + " Actual: " + actualValueAsString);
                                        // Capturing deviation details in a from of GetDetailsOfDeviations object
                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, colName,
                                                expectedValueAsString, actualValueAsString));
                                        log.info(getDetailsOfDeviations.get());
                                        // Storing the GetDetailsOfDeviations object into an ArrayList
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                }
                                else
                                {
                                    log.warn("Transaction Asset level or page NOT found in KeySet: " + page + " - " + colName);
                                }
                            });
                });
    }

    /**
     * This constructor will be used for summation verification inside the same page
     * This constructor MAY be used where <h1>keys are different</h1>keys are different, it depends on insertion order
     *
     * @param expected
     * @param actual
     */
    public PageLevelData(Map<String, Double> expected, Map<String, Double> actual)
    {
        Iterator<Map.Entry<String, Double>> expected_iterator = expected.entrySet().iterator();
        Iterator<Map.Entry<String, Double>> actual_iterator = actual.entrySet().iterator();

        while (expected_iterator.hasNext() && actual_iterator.hasNext())
        {
            Map.Entry<String, Double> m1 = expected_iterator.next();
            Map.Entry<String, Double> m2 = actual_iterator.next();
            if (m1.getValue().equals(m2.getValue()))
            {
                log.info(m1.getKey() + " : " + m1.getValue() + " MATCHED " + m2.getKey() + " : " + m2.getValue());
            }
            else
            {
                String message = m1.getKey() + " : " + String.format("%.8f", m1.getValue()) + " not matched "
                        + m2.getKey() + " : " + String.format("%.8f", m2.getValue());
                log.warn(message);
                // Adding step log to cucumber report
                Reporter.addStepLog(message);
                // Capturing deviation details in a from of GetDetailsOfDeviations object
                getDetailsOfDeviations.set(new GetDetailsOfDeviations("Total", m1.getKey() + " & " + m2.getKey(),
                        String.format("%.8f", m1.getValue()), String.format("%.8f", m2.getValue())));
                log.info(getDetailsOfDeviations.get());
                // Storing the GetDetailsOfDeviations object into an ArrayList
                data.add(getDetailsOfDeviations.get());
            }

        }
    }


    /**
     * This constructor will be used to verify if any column having zero values or not
     *
     * @param mapData        collection of data will be coming from other source
     * @param headersExclude exclude the keys
     */
    public PageLevelData(Map<String, Map<String, Double>> mapData, List<String> headersExclude)
    {
        if (headersExclude.isEmpty())
        {
            log.info("No headers or fields to exclude.");
        }

        mapData.keySet()
                .stream()
                .forEach(pageName ->
                {
                    String page = pageName;
                    mapData.get(page)
                            .keySet()
                            .stream()
                            .filter(headerName -> (headerName != null))
                            .filter(headerName -> !(headersExclude.contains(headerName)))
                            .forEach(field -> {
                                if (mapData.get(page).containsKey(field))
                                {
                                    Double actualValue = mapData.get(page).get(field);
                                    if ((actualValue == 0.0))//|| actualValue.isNaN())
                                    {
                                        String expectedValueAsString = "But should not be Zero";
                                        String message = page + " has " + field + " Value ".concat(String.format("%.8f", actualValue)).concat(expectedValueAsString);
                                        Reporter.addStepLog(message);
                                        // Capturing deviation details in a from of GetDetailsOfDeviations object
                                        getDetailsOfDeviations.set(new GetDetailsOfDeviations(page, field, expectedValueAsString, String.format("%.8f", actualValue)));
                                        log.info(getDetailsOfDeviations.get());
                                        // Storing the GetDetailsOfDeviations object into an ArrayList
                                        data.add(getDetailsOfDeviations.get());
                                    }
                                }


                            });
                });
    }
}