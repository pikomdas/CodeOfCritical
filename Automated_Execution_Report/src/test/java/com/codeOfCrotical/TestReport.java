/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 *   TestReport.java belongs to codeOfCrotical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 05/06/20, 9:02 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical;

import com.codeOfCrotical.deviatonListner.DataCollector;
import com.codeOfCrotical.deviatonListner.PageLevelData;

import java.io.IOException;

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
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        
        t1.start();
        t2.start();
    }
}
