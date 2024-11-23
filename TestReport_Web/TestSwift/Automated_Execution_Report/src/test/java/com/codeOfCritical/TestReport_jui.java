/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   TestReport.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 05/06/20, 9:02 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical;

import com.codeOfCritical.deviatonListner.DataCollectorMultipleTime;
import com.codeOfCritical.deviatonListner.PageLevelData;
import io.cucumber.java.eo.Do;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestReport_jui extends TestData {
    public static void main(String[] a) throws IOException, InterruptedException {
        Runnable t1 = () ->
        {
            DataCollectorMultipleTime dc = null;
            try {
//                System.out.println(exp);
                dc = new DataCollectorMultipleTime("1", "6e057dt99ae33t", "HealthCheck",
                        new PageLevelData("test scenario_1", "P1", "C1", 22.2, 22.3, "passed"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    dc.buildHTML(pathOfReportGeneration, screens);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable t2 = () -> {
            DataCollectorMultipleTime dc = null;
            try {
//                System.out.println(exp);
                dc = new DataCollectorMultipleTime("2", "6e057et99ae33t", "HealthCheck",
                        new PageLevelData("test scenario_2", "P2", "C2", 22.2, 22.2, "passed"));

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    dc.buildHTML(pathOfReportGeneration, screens);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

            executorService.execute(t1);
            executorService.execute(t2);}

//        t1.start();
//        t2.start();
//        System.out.println(pathOfReportGeneration);
    }
