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

import com.codeOfCritical.deviatonListner.DataCollector;
import com.codeOfCritical.deviatonListner.PageLevelData;

import java.io.IOException;
import java.util.List;

public class TestReport extends TestData
{
    public static void main(String[] a) throws IOException, InterruptedException
    {
        Thread t1 = new Thread(() ->
        {
            try
            {
//                System.out.println(exp);
                DataCollector dc = new DataCollector("test scenario_1", "6e057dt99ae33t", "HealthCheck",
                        screens, new PageLevelData("url1", "url2", exp, act));
                dc.buildHTML(pathOfReportGeneration);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        
        System.out.println(exp.keySet().size() + " " + act1.keySet().size());

        Thread t2 = new Thread(() -> {
            try
            {
                DataCollector dc2 = new DataCollector("test scenario_2", "6e057dt66ae33g", "HealthCheck",
                        screens, new PageLevelData("url1", "url2", exp, act1));
                dc2.buildHTML(pathOfReportGeneration);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try
            {
                DataCollector dc2 = new DataCollector("test scenario_3", "6e057dt66ae44g", "HealthCheck",
                        screens, new PageLevelData(act2, List.of(""))); //List.of("QWNK"))
                dc2.buildHTML(pathOfReportGeneration);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
