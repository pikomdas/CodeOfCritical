/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * AppTest.java belongs to codeOfCritical
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 16-Apr-2020 - 8:24:59 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author partha.das
 *
 */
public class AppTest
{
	public static List<JSONObject> jo = new ArrayList<JSONObject>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		JSONObject js = new JSONObject();
		js.put("Scenario Name", "ABC");
		js.put("Position Name", "xyz xyz");
		js.put("Column Name", "Market Price");
		js.put("Actual Value", "0.02");
		js.put("Expected Value", "0.05");
		jo.add(js);

		JSONObject js1 = new JSONObject();
		js1.put("Scenario Name", "ABC");
		js1.put("Position Name", "bla bla");
		js1.put("Column Name", "Cost Value");
		js1.put("Actual Value", "0.12");
		js1.put("Expected Value", "1.05");
		jo.add(js1);

		JSONObject j4 = new JSONObject();
		j4.put("Scenario Name", "ABC");
		j4.put("Position Name", "bla bla");
		j4.put("Column Name", "test Value");
		j4.put("Actual Value", "0.132");
		j4.put("Expected Value", "991.05");
		jo.add(j4);

		JSONObject js11 = new JSONObject();
		js11.put("Scenario Name", "ABC");
		js11.put("Position Name", "bla bla");
		js11.put("Column Name", "IRR");
		js11.put("Actual Value", "0.12");
		js11.put("Expected Value", "1.05");
		jo.add(js11);

		JSONObject js111 = new JSONObject();
		js111.put("Scenario Name", "EFG");
		js111.put("Position Name", "test Position");
		js111.put("Column Name", "Market Price");
		js111.put("Actual Value", "220.02");
		js111.put("Expected Value", "330.05");
		jo.add(js111);

		JSONObject j3 = new JSONObject();
		j3.put("Scenario Name", "EFG");
		j3.put("Position Name", "test Position");
		j3.put("Column Name", "Current Price");
		j3.put("Actual Value", "24420.02");
		j3.put("Expected Value", "99990.05");
		jo.add(j3);

		JSONObject js2 = new JSONObject();
		js2.put("Scenario Name", "HIJ");
		js2.put("Position Name", "test Position2");
		js2.put("Column Name", "IRR");
		js2.put("Actual Value", "10.02");
		js2.put("Expected Value", "30.05");
		jo.add(js2);

		// System.out.println(jo.toString());

		JSON_Builder jb = new JSON_Builder(jo);
		jb.getJSON();

	}

}

class JSON_Builder
{
	private List<JSONObject> ll;

	public JSON_Builder(List<JSONObject> ll)
	{
		this.ll = ll;
	}

	@SuppressWarnings("unchecked")
	public void getJSON()
	{
		int sameScenarioCount = 0;
		int samePositionCount = 0;
		JSONObject scenario = new JSONObject();
		JSONArray scenarios = new JSONArray();
		JSONArray positions = null;
		JSONObject scenarioName = null;
		JSONObject positionName = null;

		for (int x = 0; x < ll.size() - 1; x++)
		{
			String sc1 = (String) ll.get(x).get("Scenario Name");
			String sc2 = (String) ll.get(x + 1).get("Scenario Name");
			if (sc1.equalsIgnoreCase(sc2))
			{

				if (sameScenarioCount == 0)
				{
					scenarioName = new JSONObject();
					scenarioName.put("Scenario Name", sc1);
					scenarios.add(scenarioName);

					positions = new JSONArray();

				}
				String pn1 = (String) ll.get(x).get("Position Name");
				String pn2 = (String) ll.get(x + 1).get("Position Name");
				if (pn1.equalsIgnoreCase(pn2))
				{

					if (samePositionCount < 1)
					{
						positionName = new JSONObject();
						positionName.put("Position Name", pn1);
					}

					/*JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Column Name", ll.get(x + 1).get("Column Name"));
					columnsAndValues.put("Expected value", ll.get(x + 1).get("Expected Value"));
					columnsAndValues.put("Actual Value", ll.get(x + 1).get("Actual Value"));
					
					JSONObject columnsAndValues1 = new JSONObject();
					columnsAndValues1.put("Column Name", ll.get(x).get("Column Name"));
					columnsAndValues1.put("Expected value", ll.get(x).get("Expected Value"));
					columnsAndValues1.put("Actual Value", ll.get(x).get("Actual Value"));
					
					JSONArray alldeviation = new JSONArray();
					alldeviation.add(columnsAndValues);
					alldeviation.add(columnsAndValues1);*/

					positionName.put("Deviations", "");//alldeviation);
					positions.add(positionName);

					//scenarioName.put("Positions", positions);

					samePositionCount++;
				} else
				{
					samePositionCount = 0;
					// positions = new JSONArray();

					positionName = new JSONObject();
					positionName.put("Position Name", pn2);

					/*JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Column Name", ll.get(x + 1).get("Column Name"));
					columnsAndValues.put("Expected value", ll.get(x + 1).get("Expected Value"));
					columnsAndValues.put("Actual Value", ll.get(x + 1).get("Actual Value"));
					
					JSONArray alldeviation = new JSONArray();
					alldeviation.add(columnsAndValues);*/

					positionName.put("Deviations", "");//alldeviation);
					positions.add(positionName);

					//scenarioName.put("Positions", positions);

				}
				scenarioName.put("Positions", positions);
				sameScenarioCount++;
			} else
			{
				sameScenarioCount = 0;
				samePositionCount = 0;
				positions = new JSONArray();

				scenarioName = new JSONObject();
				scenarioName.put("Scenario Name", sc2);

				positionName = new JSONObject();
				positionName.put("Position Name", ll.get(x).get("Position Name"));
				
				/*JSONObject columnsAndValues = new JSONObject();
				columnsAndValues.put("Column Name", ll.get(x).get("Column Name"));
				columnsAndValues.put("Expected value", ll.get(x).get("Expected Value"));
				columnsAndValues.put("Actual Value", ll.get(x).get("Actual Value"));
				
				JSONArray alldeviation = new JSONArray();
				alldeviation.add(columnsAndValues);*/
				
				positionName.put("Deviations","" );//alldeviation);
				positions.add(positionName);

				scenarioName.put("Positions", positions);

			}
		}
		scenarios.add(scenarioName);
		scenario.put("Scenarios", scenarios);
		System.out.println(scenario.toString());
	}

}
