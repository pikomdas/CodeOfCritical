/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * JSONBuilder.java belongs to codeOfCritical 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 16-Apr-2020 - 9:26:23 pm
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
public class JSONBuilder
{

	public static List<JSONObject> jo = new ArrayList<JSONObject>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		/*JSONObject js0 = new JSONObject();
		js0.put("Scenario Name", "I am dead");
		js0.put("Entity Name", "xyz xyz");
		js0.put("Exception Message", "Market Price");
		js0.put("Actual Value", "0.0112");
		js0.put("Expected Value", "101.05");
		jo.add(js0);*/

		JSONObject js = new JSONObject();
		js.put("Scenario Name", "ABC");
		js.put("Entity Name", "xyz xyz");
		js.put("Exception Message", "Market Price");
		js.put("Actual Value", "0.02");
		js.put("Expected Value", "0.05");
		jo.add(js);

		JSONObject js1 = new JSONObject();
		js1.put("Scenario Name", "ABC");
		js1.put("Entity Name", "bla bla");
		js1.put("Exception Message", "Cost Value");
		js1.put("Actual Value", "0.12");
		js1.put("Expected Value", "1.05");
		jo.add(js1);

		JSONObject j4 = new JSONObject();
		j4.put("Scenario Name", "ABC");
		j4.put("Entity Name", "bla bla");
		j4.put("Exception Message", "test Value");
		j4.put("Actual Value", "1111.132");
		j4.put("Expected Value", "88991.05");
		jo.add(j4);

		JSONObject js11 = new JSONObject();
		js11.put("Scenario Name", "ABC");
		js11.put("Entity Name", "bla bla");
		js11.put("Exception Message", "IRR");
		js11.put("Actual Value", "99.99");
		js11.put("Expected Value", "88.88");
		jo.add(js11);

		JSONObject js111 = new JSONObject();
		js111.put("Scenario Name", "EFG");
		js111.put("Entity Name", "test Entity");
		js111.put("Exception Message", "Market Price");
		js111.put("Actual Value", "220.02");
		js111.put("Expected Value", "330.05");
		jo.add(js111);

		JSONObject j3 = new JSONObject();
		j3.put("Scenario Name", "EFG");
		j3.put("Entity Name", "test Entity");
		j3.put("Exception Message", "Current Price");
		j3.put("Actual Value", "24420.02");
		j3.put("Expected Value", "99990.05");
		jo.add(j3);

		JSONObject js2 = new JSONObject();
		js2.put("Scenario Name", "HIJ");
		js2.put("Entity Name", "test Entity2");
		js2.put("Exception Message", "IRR");
		js2.put("Actual Value", "10.02");
		js2.put("Expected Value", "30.05");
		jo.add(js2);

		// System.out.println(jo.toString());

		JSON_Builder1 jb = new JSON_Builder1(jo);
		System.out.println(jb.getJSON());

	}

}

class JSON_Builder1
{
	private List<JSONObject> ll;

	public JSON_Builder1(List<JSONObject> ll)
	{
		this.ll = ll;
	}

	@SuppressWarnings("unchecked")
	public String getJSON()
	{
		JSONObject scenario = new JSONObject();
		JSONArray scenarios = new JSONArray();
		JSONObject scenarioName = new JSONObject();
		JSONObject entityName = new JSONObject();
		JSONArray entities = null;
		JSONArray deviations = null;

		for (int i = 0; i < ll.size(); i++)
		{

			String sc1 = (String) ll.get(i).get("Scenario Name");
			String en1 = (String) ll.get(i).get("Entity Name");
			String ex1 = (String) ll.get(i).get("Exception Message");

			if (scenarioName.containsValue(sc1))
			{
				if (entityName.containsValue(en1))
				{
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Exception Message", ex1);
					deviations.add(columnsAndValues);
					entityName.put("Exception Message", deviations);
				}
				else
				{
					entityName = new JSONObject();
					entityName.put("Entity Name", en1);

					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Exception Message", ex1);
					deviations.add(columnsAndValues);
					entityName.put("Exception Message", deviations);

					entities.add(entityName);
					scenarioName.put("Entities", entities);
				}
			}
			else
			{
				scenarioName = new JSONObject();
				scenarioName.put("Scenario Name", sc1);
				scenarios.add(scenarioName);

				entityName = new JSONObject();
				entityName.put("Entity Name", en1);

				entities = new JSONArray();
				entities.add(entityName);

				scenarioName.put("Entities", entities);

				JSONObject columnsAndValues = new JSONObject();
				columnsAndValues.put("Exception Message", ex1);

				deviations = new JSONArray();
				deviations.add(columnsAndValues);

				entityName.put("Exception Message", deviations);
			}

		}
		scenario.put("Scenarios", scenarios);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(scenario).toString();
	}

}
