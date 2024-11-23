/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * TransactionJSONTest.java belongs to codeOfCritical
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 20/07/21, 9:55 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TransactionJSONTest
{

	public static void main(String[] args) throws IOException, ParseException
	{
		TransactionJSONTest transactionJSONTest = new TransactionJSONTest();
		transactionJSONTest.getJSONString();
	}

	public JSONObject test() throws IOException, ParseException
	{

		JSONParser parser = new JSONParser();
		List<JSONObject> jsonData = (List<JSONObject>) parser.parse(new FileReader("E:\\gitClone\\Automated_Execution_Report\\src\\test\\java\\com\\codeOfCritical\\Transaction_JSON_Test_Data.json"));

		JSONObject scenarioName = new JSONObject();
		JSONArray scenarios = new JSONArray();
		JSONObject scenario = new JSONObject();
		JSONObject fieldName = null;
		JSONArray UIValue = null;
		JSONArray JSOnValue = null;
		JSONArray fields = null;

		for (int i = 0; i < jsonData.size(); i++)
		{

			String scenario_name = (String) jsonData.get(i).get("Scenario Name");
			String field_name = (String) jsonData.get(i).get("Field Name");
			String UI_Value = (String) jsonData.get(i).get("UI Value");
			String json_value = (String) jsonData.get(i).get("JSON Value");
			String date = (String) jsonData.get(i).get("Date");

			if (scenario.containsValue(scenario_name))
			{
//				fields = new JSONArray();

				fieldName = new JSONObject();
				fieldName.put("Field Name", field_name);
				fieldName.put("UI Value", UI_Value);
				fieldName.put("Expected Value", json_value);

				fields.add(fieldName);

				scenario.put("Fields", fields);

			}
			else
			{
				scenario = new JSONObject();
				scenario.put("Scenario Name", scenario_name);
				scenario.put("Date", date);


				fields = new JSONArray();

				fieldName = new JSONObject();
				fieldName.put("Field Name", field_name);
				fieldName.put("UI Value", UI_Value);
				fieldName.put("Expected Value", json_value);

				fields.add(fieldName);

				scenario.put("Fields", fields);

				scenarios.add(scenario);
			}

		}
		scenarioName.put("Scenarios", scenarios);
		return scenarioName;
	}

	public synchronized String getJSONString() throws IOException, ParseException
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(test()));
		return gson.toJson(test());
	}
}