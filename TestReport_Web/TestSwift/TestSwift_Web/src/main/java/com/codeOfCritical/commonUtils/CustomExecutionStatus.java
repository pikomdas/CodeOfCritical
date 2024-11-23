package com.codeOfCritical.commonUtils;


import com.codeOfCritical.deviatonListner.DataCollectorMultipleTime;
import com.codeOfCritical.deviatonListner.PageLevelData;
import com.codeOfCritical.BaseClass.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeOfCritical.commonUtils.CucumberBeforeExecution.SCENARIO;
import static com.codeOfCritical.commonUtils.CucumberBeforeExecution.SCENARIO_ID;

/*
 Thread-safe singleton implemented
 */
public final class CustomExecutionStatus extends Browser {
    protected static final CustomExecutionStatus ces = new CustomExecutionStatus();
    private static final Logger log = LogManager.getLogger(CustomExecutionStatus.class.getName());
    /**
     * This List<String> steps will add the failed steps into it and it will be used
     * at the end of an scenario
     */
    //public static List<String> steps = Collections.synchronizedList(new LinkedList<String>());
    public static ThreadLocal<DataCollectorMultipleTime> DataCollectorMultipleTime = new ThreadLocal();

    private CustomExecutionStatus() {

    }

    public static CustomExecutionStatus getInstance() {
        /*if (ces == null)
        {
            return new CustomExecutionStatus();
        }*/
        return ces;
    }

    /**
     * @param fromJSON
     * @param fromUI
     * @param passMessage
     * @param positionName
     * @param columnName
     * @return
     */
    public synchronized void generateHTMLReport(double fromJSON, double fromUI, String passMessage,
                                                String positionName, String columnName) {
        DataCollectorMultipleTime.set(new DataCollectorMultipleTime(Browser.session.get().toString(),
                SCENARIO.get().getSourceTagNames().toString(), SCENARIO_ID.get()
                , new PageLevelData(SCENARIO.get().getName(), positionName, columnName, fromJSON, fromUI, passMessage)));
    }

    /**
     * If true then
     *
     * @param fromJSON
     * @param fromUI
     * @param passMessage
     * @param positionName
     * @param columnName
     * @return true false
     */
    public synchronized boolean verifyDataFromJSONtoUI(double fromJSON, double fromUI, String passMessage,
                                                       String positionName, String columnName) {
        DataCollectorMultipleTime.set(new DataCollectorMultipleTime(SCENARIO_ID.get(),
                Browser.session.get().toString(), SCENARIO.get().getSourceTagNames().toString()
                , new PageLevelData(SCENARIO.get().getName(), positionName, columnName, fromJSON, fromUI, passMessage)));
        return false;
    }

    /**
     * This method is used to verify position name in json exists in UI
     * If true then
     *
     * @param positionName_Json
     * @param positionName_UI
     * @param passMessage
     * @param columnName
     * @return true false
     * @author divya
     */
    public synchronized boolean verifySquareOffPositionFromJSONtoUI(String positionName_Json, String positionName_UI, String passMessage, String columnName) {
        DataCollectorMultipleTime.set(new DataCollectorMultipleTime(
                Browser.session.get().toString(), SCENARIO.get().getSourceTagNames().toString(), SCENARIO_ID.get()
                , new PageLevelData(SCENARIO.get().getName(), passMessage, positionName_Json, positionName_UI, columnName)));
        return false;
    }

    /**
     * If true then
     *
     * @param fromJSON
     * @param fromUI
     * @param passMessage
     * @param positionName
     * @param columnName
     * @return true false
     * @author sabaresh
     */
    public synchronized boolean verifyStringDataFromJSONtoUI(String fromJSON, String fromUI, String passMessage,
                                                             String positionName, String columnName) {
        DataCollectorMultipleTime.set(new DataCollectorMultipleTime(
                SCENARIO_ID.get(),
                Browser.session.get().toString(),
                SCENARIO.get().getSourceTagNames().toString()
                , new PageLevelData(SCENARIO.get().getName(), driverThread.get().getTitle(), fromJSON, fromUI, columnName)));
        return false;
    }


} // end of class
