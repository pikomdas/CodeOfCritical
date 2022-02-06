/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   TestReport.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 05/06/20, 9:02 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReport
{
    public static void main(String[] args)
    {
        Map<String, Map<String, Double>> exp = new HashMap<String, Map<String, Double>>();
        exp.put("abc", Map.of("sav", 10120.00, "fd", 1130.30, "rd", 35540.55));
        exp.put("ice", Map.of("sav", 2213.20, "fd", 9805.00, "rd", 6340.65));
        exp.put("fire", Map.of("sav", 5127.00, "fd", 1130.00, "rd", 3450.58));
        exp.put("water", Map.of("sav", 9780.00, "fd", 14510.00, "rd", 9341.55));

        Map<String, Map<String, Double>> act = new HashMap<String, Map<String, Double>>();
        act.put("abc", Map.of("sav", 10000.00, "fd", 1130.30, "rd", 34440.44));
        act.put("ice", Map.of("sav", 2883.20, "fd", 9804.00, "rd", 6340.64));
        act.put("fire", Map.of("sav", 4129.00, "fd", 1130.00, "rd", 3440.48));
        act.put("water", Map.of("sav", 9980.00, "fd", 14410.00, "rd", 9341.44));

        DataCollector dc = new DataCollector("test", "6e057dt99ae33t", "HealthCheck", new PageLevelData(exp, act));
        List<PageLevelData.GetDetailsOfMap> m= dc.getListofDeviations();
        System.out.println(m.size());
        m.forEach(System.out::println);
    }
}
