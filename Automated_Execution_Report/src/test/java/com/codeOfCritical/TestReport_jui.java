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

import java.io.IOException;

public class TestReport_jui extends TestData
{
    public static void main(String[] a) throws IOException, InterruptedException
    {
        /*Thread t1 = new Thread(() ->
        {
            DataCollectorMultipleTime dc = null;
            try
            {
//                System.out.println(exp);
                dc = new DataCollectorMultipleTime("6e057dt99ae33t", "HealthCheck",
                        SCENARIO_ID.get(), new PageLevelData("test scenario_1", "P1", "C1", 22.2, 22.3, "passed"));
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
            DataCollectorMultipleTime dc = null;
            try
            {
//                System.out.println(exp);
                dc = new DataCollectorMultipleTime("6e057et99ae33t", "HealthCheck",
                        SCENARIO_ID.get(), new PageLevelData("test scenario_2", "P2", "C2", 22.2, 22.2, "passed"));
                
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
        t2.start();*/
    }
}
