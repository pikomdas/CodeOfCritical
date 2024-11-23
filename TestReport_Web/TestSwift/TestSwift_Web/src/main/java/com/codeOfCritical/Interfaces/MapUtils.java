/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * MapUtils.java belongs to AssetVantage
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 26-May-2020 12:17:17 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.Interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author partha.das
 */
@Deprecated
public interface MapUtils
{
    /**
     *
     * @param m
     * @return
     */
    default Map<String, String> mapConverter(Map<String, Double> m)
    {
        Map<String, String> fm = new HashMap<String, String>();
        m.forEach((k, v) -> {
            fm.put(k, String.format("%.8f", v));
        });
        return fm;
    }
    

    Function<Map<String, String>, String> htmlString = (x) -> {
        StringBuilder sb = new StringBuilder();
        x.forEach((a, b) -> {
            sb.append(a + " : ");
            sb.append(b);
            sb.append("</br>");
        });
        return sb.toString();
        
    };
}
