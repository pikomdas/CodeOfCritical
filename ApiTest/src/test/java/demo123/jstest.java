/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * jstest.java belongs to codeOfCritical 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 18-Apr-2020 - 11:58:45 pm
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author partha.das
 *
 */
public class jstest
{
	public static List<JSONObject> jo = new ArrayList<JSONObject>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		JSONObject js0 = new JSONObject();
		js0.put("Scenario Name", "I am dead");
		js0.put("Position Name", "xyz xyz");
		js0.put("Column Name", "Market Price");
		js0.put("Actual Value", "0.0112");
		js0.put("Expected Value", "101.05");
		jo.add(js0);

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
		j4.put("Actual Value", "1111.132");
		j4.put("Expected Value", "88991.05");
		jo.add(j4);

		JSONObject js11 = new JSONObject();
		js11.put("Scenario Name", "ABC");
		js11.put("Position Name", "bla bla");
		js11.put("Column Name", "IRR");
		js11.put("Actual Value", "99.99");
		js11.put("Expected Value", "88.88");
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

		JSON_tiktok jb = new JSON_tiktok(jo);
		jb.getJSON();
	}

}

class JSON_tiktok
{
	private List<JSONObject> ll;

	public JSON_tiktok(List<JSONObject> ll)
	{
		this.ll = ll;
	}

	@SuppressWarnings("unchecked")
	public void getJSON()
	{
		JSONObject scenario = new JSONObject();
		JSONArray scenarios = new JSONArray();
		JSONObject scenarioName = new JSONObject();
		JSONObject positionName = new JSONObject();
		JSONArray positions = null;
		JSONArray deviations = null;
		int count = 0;
		for (int i = 0; i < ll.size(); i++)
		{

			String sc1 = (String) ll.get(i).get("Scenario Name");
			String pn1 = (String) ll.get(i).get("Position Name");
			String col1 = (String) ll.get(i).get("Column Name");
			String ev1 = (String) ll.get(i).get("Expected Value");
			String av1 = (String) ll.get(i).get("Actual Value");

			if (scenarioName.containsValue(sc1))
			{
				if (positionName.containsValue(pn1))
				{
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Column Name", col1);
					columnsAndValues.put("Expected value", ev1);
					columnsAndValues.put("Actual Value", av1);

					deviations.add(columnsAndValues);
					positionName.put("Deviationss", deviations);
				}
				else
				{
					positionName = new JSONObject();
					positionName.put("Position Name", pn1);
					
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Column Name", col1);
					columnsAndValues.put("Expected value", ev1);
					columnsAndValues.put("Actual Value", av1);
					deviations = new JSONArray();
					deviations.add(columnsAndValues);

					positionName.put("Deviationss", deviations);
					
					positions.add(positionName);
					scenarioName.put("Positions", positions);
				}
			}
			else
			{
				scenarioName = new JSONObject();
				scenarioName.put("Scenario Name", sc1);
				scenarios.add(scenarioName);

				positionName = new JSONObject();
				positionName.put("Position Name", pn1);

				positions = new JSONArray();
				positions.add(positionName);

				scenarioName.put("Positions", positions);

				JSONObject columnsAndValues = new JSONObject();
				columnsAndValues.put("Column Name", col1);
				columnsAndValues.put("Expected value", ev1);
				columnsAndValues.put("Actual Value", av1);
				deviations = new JSONArray();
				deviations.add(columnsAndValues);

				positionName.put("Deviationss", deviations);
			}

		}
		scenario.put("Scenarios", scenarios);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(scenario).toString());

	}
}