/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   DataCollector.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 04/06/20, 8:03 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package template;

import java.util.List;

public class DataCollector
{
    private String scenarioName;
    private String sessionId;
    private String currentTagName;
    private PageLevelData pageLevelData;

    public DataCollector(String scenarioName, String sessionId, String currentTagName, PageLevelData pageLevelData)
    {
        this.scenarioName = scenarioName;
        this.sessionId = sessionId;
        this.currentTagName = currentTagName;
        this.pageLevelData = pageLevelData;
    }

    public List<PageLevelData.GetDetailsOfMap> getListofDeviations(){
        return this.pageLevelData.data;
    }
}
