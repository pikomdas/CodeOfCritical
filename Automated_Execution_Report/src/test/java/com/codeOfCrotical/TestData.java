/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 *   TestData.java belongs to codeOfCrotical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 03/07/20, 7:03 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData
{
    public static String pathOfReportGeneration = "../Automated_Execution_Report/src/main/java/com/codeOfCrotical/html/";
    public static List<String> screens = List.of("E:\\gitClone\\demoBDDFramework\\screenShots\\07-Aug-2019__02_39_46PM\\2019_08_07T14_39_58_004443700.png",
            "E:\\gitClone\\demoBDDFramework\\screenShots\\07-Aug-2019__02_39_46PM\\2019_08_07T14_43_28_970857100.png",
            "E:\\gitClone\\demoBDDFramework\\screenShots\\07-Aug-2019__02_39_46PM\\2019_08_07T14_50_50_689343400.png");
    
    public static Map<String, Map<String, Double>> exp = null;
    public static Map<String, Map<String, Double>> act = null;
    public static Map<String, Map<String, Double>> act1 = null;
    
    static
    {
        exp = new HashMap<String, Map<String, Double>>();
        act = new HashMap<String, Map<String, Double>>();
        act1 = new HashMap<String, Map<String, Double>>();
        
        exp.put("abc", Map.of("sav", 10120.00, "fd", 1130.30, "rd", 35540.55));
        exp.put("ice", Map.of("sav", 2213.20, "fd", 9805.00, "rd", 6340.65));
        exp.put("fire", Map.of("sav", 5127.00, "fd", 1130.00, "rd", 3450.58));
        exp.put("water", Map.of("sav", 6780.00, "fd", 22510.00, "rd", 3341.55));
        exp.put("spirit", Map.of("sav", 9770.00, "fd", 14710.00, "rd", 4334.55));
        exp.put("ether", Map.of("sav", 1780.00, "fd", 14540.00, "rd", 5541.55));
        
        
        act.put("abc", Map.of("sav", 10000.00, "fd", 1130.30, "rd", 34440.44));
        act.put("ice", Map.of("sav", 2883.20, "fd", 9804.00, "rd", 6340.64));
        act.put("fire", Map.of("sav", 4129.00, "fd", 1130.00, "rd", 3440.48));
        act.put("water", Map.of("sav", 9980.00, "fd", 14410.00, "rd", 9341.44));
        
        
        act1.put("abc", Map.of("sav", 10000.00, "fd", 1130.30, "rd", 34440.44));
        act1.put("ice", Map.of("sav", 2883.20, "fd", 9804.00, "rd", 6340.64));
        act1.put("fire", Map.of("sav", 4129.00, "fd", 1130.00, "rd", 3440.48));
        act1.put("water", Map.of("sav", 9980.00, "fd", 14410.00, "rd", 9341.44));
        act1.put("soda", Map.of("sav", 6780.00, "fd", 22510.00, "rd", 3341.55));
        act1.put("spirit", Map.of("sav", 9770.00, "fd", 14710.00, "rd", 4334.55));
        act1.put("ether", Map.of("sav", 1780.00, "fd", 14540.00, "rd", 5541.55));
        act1.put("wine", Map.of("sav", 6780.00, "fd", 92510.10, "rd", 3311.55));
        act1.put("Molt", Map.of("sav", 9770.00, "fd", 64710.00, "rd", 4134.55));
        act1.put("Coke", Map.of("sav", 1990.00, "fd", 94540.00, "rd", 5111.15));
    }
}
