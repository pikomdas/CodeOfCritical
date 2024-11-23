/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * JSONBuilder.java belongs to AssetVantage
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 29-Jan-2020 2:18:53 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.commonUtils.JSONutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author partha.das This will help to build custom HTML report after execution
 * of Analytics or General Ledger It accepts only scenarioName,
 * positionName, columnName, fromJSON, fromUI to generate a JSON after
 * each successful scenario
 */
public final class JSONBuilder
{
	private static volatile List<JSONObject> jsonData = new ArrayList<JSONObject>();
	private static volatile List<JSONObject> jsonData_hc = new ArrayList<JSONObject>();
	private static JSONBuilder jsonbuilder = null;
	
	private JSONBuilder()
	{
	
	}
	
	public static JSONBuilder getInstance()
	{
		if (jsonbuilder == null)
		{
			jsonbuilder = new JSONBuilder();
			return jsonbuilder;
		}
		return jsonbuilder;
	}
	
	/**
	 * This method will add the respective key,value pairs
	 *
	 * @param scenarioName
	 * @param positionName
	 * @param columnName
	 * @param fromJSON
	 * @param fromUI
	 */
	@SuppressWarnings("unchecked")
	public synchronized void collectData(String scenarioName, String positionName, String columnName, double fromJSON,
										 double fromUI)
	{
		JSONObject jo = new JSONObject();
		jo.put("Scenario Name", scenarioName);
		jo.put("Position Name", positionName);
		jo.put("Column Name", columnName);
		jo.put("Expected Value", String.format("%.8f", fromJSON));
		jo.put("Actual Value", String.format("%.8f", fromUI));
		System.out.println(jo.toJSONString());
		// Storing the JSONObject inside arraylist
		jsonData.add(jo);
		
	}
	
	/**
	 * @param scenarioName
	 * @param entityName
	 * @param exceptionMessage
	 */
	@SuppressWarnings("unchecked")
	public synchronized void collectData(String scenarioName, String entityName, String exceptionMessage)
	{
		JSONObject jo = new JSONObject();
		jo.put("Scenario Name", scenarioName);
		jo.put("Entity Name", entityName);
		jo.put("Exception Message", exceptionMessage);
		// Storing the JSONObject inside arraylist
		jsonData_hc.add(jo);
	}
	
	/**
	 * @return the customized JOSN data which is more efficient to build report
	 */
	@SuppressWarnings("unchecked")
	private synchronized String getJSONString()
	{
		JSONObject scenario = new JSONObject();
		JSONArray scenarios = new JSONArray();
		JSONObject scenarioName = new JSONObject();
		JSONObject positionName = new JSONObject();
		JSONArray positions = null;
		JSONArray deviations = null;
		
		for (int i = 0; i < jsonData.size(); i++)
		{
			String sc1 = (String) jsonData.get(i).get("Scenario Name");
			String pn1 = (String) jsonData.get(i).get("Position Name");
			String col1 = (String) jsonData.get(i).get("Column Name");
			String ev1 = (String) jsonData.get(i).get("Expected Value");
			String av1 = (String) jsonData.get(i).get("Actual Value");
			
			if (scenarioName.containsValue(sc1))
			{
				if (positionName.containsValue(pn1))
				{
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Column Name", col1);
					columnsAndValues.put("Expected value", ev1);
					columnsAndValues.put("Actual Value", av1);
					
					deviations.add(columnsAndValues);
					positionName.put("Deviations", deviations);
				} else
				{
					positionName = new JSONObject();
					positionName.put("Position Name", pn1);
					
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Column Name", col1);
					columnsAndValues.put("Expected value", ev1);
					columnsAndValues.put("Actual Value", av1);
					deviations = new JSONArray();
					deviations.add(columnsAndValues);
					
					positionName.put("Deviations", deviations);
					
					positions.add(positionName);
					scenarioName.put("Positions", positions);
				}
			} else
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
				
				positionName.put("Deviations", deviations);
			}
			
		}
		scenario.put("Scenarios", scenarios);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(scenario).toString();
	}
	
	@SuppressWarnings("unchecked")
	private synchronized String getJSONString_hc()
	{
		JSONObject scenario = new JSONObject();
		JSONArray scenarios = new JSONArray();
		JSONObject scenarioName = new JSONObject();
		JSONObject entityName = new JSONObject();
		JSONArray entities = null;
		JSONArray deviations = null;
		
		for (int i = 0; i < jsonData_hc.size(); i++)
		{
			
			String sc1 = (String) jsonData_hc.get(i).get("Scenario Name");
			String en1 = (String) jsonData_hc.get(i).get("Entity Name");
			String ex1 = (String) jsonData_hc.get(i).get("Exception Message");
			
			if (scenarioName.containsValue(sc1))
			{
				if (entityName.containsValue(en1))
				{
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Exception Message", ex1);
					deviations.add(columnsAndValues);
					entityName.put("Deviations", deviations);
				} else
				{
					entityName = new JSONObject();
					entityName.put("Entity Name", en1);
					
					JSONObject columnsAndValues = new JSONObject();
					columnsAndValues.put("Exception Message", ex1);
					deviations.add(columnsAndValues);
					entityName.put("Deviations", deviations);
					
					entities.add(entityName);
					scenarioName.put("Entities", entities);
				}
			} else
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
				
				entityName.put("Deviations", deviations);
			}
			
		}
		scenario.put("Scenarios", scenarios);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(scenario).toString();
	}
	
	/**
	 * This method will create the JSON file
	 *
	 * @throws IOException
	 */
	public synchronized void createJSONFile() throws IOException
	{
		String projectPath = "../demoBDDFramework/test-outout/Custom-Report";
		String tempFile = projectPath + File.separator + "deviations.json";
		File file = new File(tempFile);
		// if file does exists, then delete and create a new file
		if (file.exists())
		{
			try
			{
				File newFileName = new File(projectPath + File.separator + "backup_" + "deviations.json");
				file.renameTo(newFileName);
				file.createNewFile();
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		// write to file with OutputStreamWriter
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer = new OutputStreamWriter(outputStream);
		writer.write(getJSONString());
		writer.close();
	}
	
	public synchronized void createJSONFile_hc() throws IOException
	{
		
		String projectPath = "../demoBDDFramework/test-outout/Custom-Report-HealthCheck";
		String tempFile = projectPath + File.separator + "deviations_hc.json";
		File file = new File(tempFile);
		// if file does exists, then delete and create a new file
		if (file.exists())
		{
			try
			{
				File newFileName = new File(projectPath + File.separator + "backup_" + "deviations_hc.json");
				file.renameTo(newFileName);
				file.createNewFile();
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		// write to file with OutputStreamWriter
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer = new OutputStreamWriter(outputStream);
		writer.write(getJSONString_hc());
		writer.close();
	}
	
}
