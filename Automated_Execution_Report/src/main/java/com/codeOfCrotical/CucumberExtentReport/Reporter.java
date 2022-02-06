/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 *   customReportListener.java belongs to codeOfCrotical
 *   Do not COPY or PASTE code to WEB from codeOfCrotical
 *   Creation date-time : 21/06/20, 10:05 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical.CucumberExtentReport;

import com.codeOfCrotical.CucumberExtentReport.adapter.ExtentCucumberAdapter;
import com.codeOfCrotical.CucumberExtentReport.service.ExtentService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reporter
{
    private static Map<String, Boolean> systemInfoKeyMap = new HashMap<>();
    
    public static synchronized void addStepLog(String text)
    {
        ExtentCucumberAdapter.addTestStepLog(text);
    }
    
    public static synchronized void addScreenCaptureFromPath(String imagePath) throws IOException
    {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(imagePath);
    }
    
    public static void setSystemInfo(String key, String value)
    {
        if (systemInfoKeyMap.isEmpty() || !systemInfoKeyMap.containsKey(key))
        {
            systemInfoKeyMap.put(key, false);
        }
        if (systemInfoKeyMap.get(key))
        {
            return;
        }
        
        ExtentService.getInstance().setSystemInfo(key, value);
        systemInfoKeyMap.put(key, true);
    }
}