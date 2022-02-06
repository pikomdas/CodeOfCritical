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

import com.codeOfCrotical.deviatonListner.DataCollectorJSONToUI;
import com.codeOfCrotical.deviatonListner.PageLevelData;

import java.io.IOException;

public class TestReport_jui extends TestData
{
    public static void main(String[] a) throws IOException, InterruptedException
    {
        Thread t1 = new Thread(() ->
        {
            DataCollectorJSONToUI dc = null;
            try
            {
//                System.out.println(exp);
                dc = new DataCollectorJSONToUI("6e057dt99ae33t", "HealthCheck",
                        new PageLevelData("test scenario_1", "P1", "C1", 22.2, 22.3, "passed"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    dc.buildHTML(pathOfReportGeneration, screens);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            DataCollectorJSONToUI dc = null;
            try
            {
//                System.out.println(exp);
                dc = new DataCollectorJSONToUI("6e057dt99ae33t", "HealthCheck",
                        new PageLevelData("test scenario_2", "P2", "C2", 22.2, 22.2, "passed"));
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    dc.buildHTML(pathOfReportGeneration, screens);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
    }
}
