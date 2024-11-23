/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * ConvertDataToObject.java belongs to AssetVantage
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 08-Aug-2020 9:40:08 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.commonUtils.JSONutils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.codeOfCritical.commonUtils.cleanStringFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author partha.das
 *
 */
public class ConvertDataToObject
{

	private static Logger log = LogManager.getLogger(ConvertDataToObject.class.getName());

	private JSONArray readJSONfile(String fileLocation) throws IOException, ParseException
	{
		FileReader fileReader = new FileReader(new File(fileLocation));
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
		return jsonArray;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Map<String, Double>> getMap(String fileLocation) throws IOException, ParseException
	{

		Map<String, Map<String, Double>> map = new HashMap<>();

		readJSONfile(fileLocation).stream().forEach(x ->
		{
			// Taking one block of the JSONArray
			JSONObject oneJSONBlock = (JSONObject) x;

			// PositionName and Account Number
			String positionWithAccountNumber = ((String) oneJSONBlock.get("Position"));
			log.info("Position Name: " + positionWithAccountNumber);

			Map<String, Double> columnNameValues = new HashMap<>();
			// Iterating each block of JSON
			oneJSONBlock.keySet().stream().map(a -> (String) a).filter(b -> !(b.equals("Position")))
						.forEach(colAndValues ->
						{
							log.info(colAndValues);
							String colName = (String) colAndValues;
							Double colValue = cleanStringFormat.rmcComma((String) oneJSONBlock.get(colAndValues));
							// Capturing json files key and values except first two
							columnNameValues.put(colName, colValue);

						});

			map.put(positionWithAccountNumber, columnNameValues);
		});

		return map;
	}

	/*
	 * public static void main(String[] args)
	 * {
	 * String fileLocatio1 =
	 * "./src/main/java/com/TechMReport/dataFile/Defect_Triage/Client Issue 39305.json"
	 * ;
	 * ConvertDataToObject convertDataToObject = new ConvertDataToObject();
	 * try
	 * {
	 * convertDataToObject.getMap(fileLocatio1).forEach((k, v) ->
	 * {
	 * System.out.println("Poistion Name: " + k);
	 * v.forEach((x, y) ->
	 * {
	 * System.out.println("Column: " + x + " value: " + y);
	 * });
	 * System.out.println();
	 * });
	 * }
	 * catch (IOException | ParseException e)
	 * {
	 * // TODO Auto-generated catch block
	 * e.printStackTrace();
	 * }
	 * 
	 * }
	 */

}
