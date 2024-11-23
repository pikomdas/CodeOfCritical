/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * TransactionJSONBuilder.java belongs to codeOfCritical
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 08/07/21, 9:43 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.JSONutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class TransactionJSONBuilder
{
	private static final Logger log = LogManager.getLogger(TransactionJSONBuilder.class.getName());
	private static final Set<JSONObject> transactionJSONData = new CopyOnWriteArraySet();

	public void collectData(String scenario_name, String fieldName, String UIValue, String JSONValue, List<String> screenshotLocation, String executionDate)
	{
		JSONObject jo = new JSONObject();
		// Adding scenario,position,column name, Expect and actual values into
		jo.put("Scenario Name", scenario_name);
		jo.put("Page Name", fieldName);
		jo.put("Expected Value", UIValue);
		jo.put("Actual Value", JSONValue);
		// Adding screenshots
		/*JSONArray ss = new JSONArray();
		screenshotLocation.forEach(x ->
		{
			ss.add(x);
		});
		jo.put("ScreenShot", ss);*/
		// Adding Date stamp
		jo.put("Date", executionDate);
		// Adding to JSON array which will be available during the whole run time
		transactionJSONData.add(jo);
		System.out.println(transactionJSONData.toString());
	}

	public synchronized JSONObject getJSONObject()
	{
		// need to sort
		List<JSONObject> jsonData = transactionJSONData
				.stream()
				.sorted(Comparator.comparing(x -> x.get("Scenario Name").toString()))
				.collect(Collectors.toList());

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
			String field_name = (String) jsonData.get(i).get("Page Name");
			String UI_Value = (String) jsonData.get(i).get("Expected Value");
			String json_value = (String) jsonData.get(i).get("Actual Value");
			String date = (String) jsonData.get(i).get("Date");

			if (scenario.containsValue(scenario_name))
			{
//				fields = new JSONArray();

				fieldName = new JSONObject();
				fieldName.put("Page Name", field_name);
				//Updated 'Expected Value' to 'Actual Value'
				fieldName.put("Actual Value", UI_Value);
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
				fieldName.put("Page Name", field_name);
				//Updated 'Expected Value' to 'Actual Value'
				fieldName.put("Actual Value", UI_Value);
				fieldName.put("Expected Value", json_value);

				fields.add(fieldName);

				scenario.put("Fields", fields);

				scenarios.add(scenario);
			}

		}
		scenarioName.put("Scenarios", scenarios);

		return scenarioName;
	}

	/**
	 * This method will get the JSON object for Voucher data
	 * @author amulya.p
	 * @return
	 */
	public synchronized JSONObject getJSONObject_Voucher()
	{
		// need to sort
		List<JSONObject> jsonData = transactionJSONData
				.stream()
				.sorted(Comparator.comparing(x -> x.get("Scenario Name").toString()))
				.collect(Collectors.toList());

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
			String field_name = (String) jsonData.get(i).get("Page Name");
			String UI_Value = (String) jsonData.get(i).get("Expected Value");
			String json_value = (String) jsonData.get(i).get("Actual Value");
			String date = (String) jsonData.get(i).get("Date");

			if (scenario.containsValue(scenario_name))
			{
//				fields = new JSONArray();

				fieldName = new JSONObject();
				fieldName.put("Page Name", field_name);
				//Updated 'Actual Value' to 'Credit Value'
				fieldName.put("Credit Value", UI_Value);
				//Updated 'Expected Value' to 'Debit Value'
				fieldName.put("Debit Value", json_value);

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
				fieldName.put("Page Name", field_name);
				//Updated 'Actual Value' to 'Credit Value'
				fieldName.put("Credit Value", UI_Value);
				//Updated 'Expected Value' to 'Debit Value'
				fieldName.put("Debit Value", json_value);

				fields.add(fieldName);

				scenario.put("Fields", fields);

				scenarios.add(scenario);
			}

		}
		scenarioName.put("Scenarios", scenarios);

		return scenarioName;
	}

	public synchronized String getJSONString()
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(getJSONObject());
	}

	/**
	 * This method will get the JSON string for Voucher data
	 * @author amulya.p
	 * @return
	 */
	public synchronized String getJSONString_Voucher()
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(getJSONObject_Voucher());
	}

	/**
	 * @param path_of_json_file
	 */
	public synchronized void createJSONFile(String path_of_json_file)
	{
		try
		{
			String projectPath = path_of_json_file;
			String tempFile = projectPath + File.separator + "deviations.json";
			File file = new File(tempFile);
			// if file does exists, then delete and create a new file
			if (file.exists())
			{
				File newFileName;
				try
				{
					newFileName = new File(projectPath + File.separator + "backup_" + "deviations.json");
					file.renameTo(newFileName);
					file.createNewFile();
				}
				catch (IOException e)
				{
					log.warn("JSON file creation is not completed, so waiting ");
					try
					{
						// Wait until the file is created
						file.wait(2000);
						file.createNewFile();
					}
					catch (InterruptedException | IOException f)
					{
						f.printStackTrace();
					}
					e.printStackTrace();
				}
			}
			// write to file with OutputStreamWriter
			OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
			Writer writer = new OutputStreamWriter(outputStream);
			// Writing JSONObject to file
			writer.write(getJSONString());
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			log.info("JSON file creation process completed");
		}
	}

	/**
	 * This method will create Deviation JSON file for Voucher values
	 * @author amulya.p
	 * @param path_of_json_file
	 */
	public synchronized void createJSONFile_Voucher(String path_of_json_file)
	{
		try
		{
			String projectPath = path_of_json_file;
			String tempFile = projectPath + File.separator + "deviations.json";
			File file = new File(tempFile);
			// if file does exists, then delete and create a new file
			if (file.exists())
			{
				File newFileName;
				try
				{
					newFileName = new File(projectPath + File.separator + "backup_" + "deviations.json");
					file.renameTo(newFileName);
					file.createNewFile();
				}
				catch (IOException e)
				{
					log.warn("JSON file creation is not completed, so waiting ");
					try
					{
						// Wait until the file is created
						file.wait(2000);
						file.createNewFile();
					}
					catch (InterruptedException | IOException f)
					{
						f.printStackTrace();
					}
					e.printStackTrace();
				}
			}
			// write to file with OutputStreamWriter
			OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
			Writer writer = new OutputStreamWriter(outputStream);
			// Writing JSONObject to file
			writer.write(getJSONString_Voucher());
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			log.info("JSON file creation process completed");
		}
	}
}
