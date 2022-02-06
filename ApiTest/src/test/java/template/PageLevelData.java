/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   PageLevelData.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 04/06/20, 8:17 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageLevelData
{
    public List<GetDetailsOfMap> data = new ArrayList<GetDetailsOfMap>();
    private GetDetailsOfMap gateDetailsOfMap = null;

    /**
     *
     * @param m1 - expected Map
     * @param m2 - actual Map
     */
    public PageLevelData(Map<String, Map<String, Double>> m1, Map<String, Map<String, Double>> m2)
    {
        if (m1.keySet().size() == m2.keySet().size())
        {
            m1.keySet().stream().forEach(positionName -> {
                m1.get(positionName).keySet().stream().forEach(columnName -> {
                    String position = positionName;
                    String colName = columnName;
                    double expectedValue = m1.get(positionName).get(columnName);
                    double actualValue = m2.get(positionName).get(columnName);
                    this.gateDetailsOfMap = new GetDetailsOfMap(positionName, columnName, expectedValue, actualValue);
                    gateDetailsOfMap.add(gateDetailsOfMap);
                });
            });
        }
    }

    class GetDetailsOfMap
    {

        private String positionName;
        private String columnName;
        private double expectedValue;
        private double actualValue;

        public GetDetailsOfMap(String positionName, String columnName, double expectedValue, double actualValue)
        {
            this.positionName = positionName;
            this.columnName = columnName;
            this.expectedValue = expectedValue;
            this.actualValue = actualValue;
        }

        public String getPositionName()
        {
            return positionName;
        }

        public String getColumnName()
        {
            return columnName;
        }

        public double getExpectedValue()
        {
            return expectedValue;
        }

        public double getActualValue()
        {
            return actualValue;
        }

        @Override
        public String toString()
        {
            return "GetDetailsOfMap{" +
                    "positionName=" + positionName +
                    ", columnName='" + columnName + '\'' +
                    ", expectedValue=" + expectedValue +
                    ", actualValue=" + actualValue +
                    '}';
        }

        public void add(GetDetailsOfMap e)
        {
            data.add(e);
            return ;
        }
    }


}
