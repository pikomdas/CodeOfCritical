/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * VerificationOfTransactionPopupFields.java belongs to codeOfCritical
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 05/07/21, 12:33 AM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.TransactionPopupScreen;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Transaction pop-up verification
 *
 * @author partha.das
 */
public class VerificationOfTransactionPopupFields extends TransactionDeviationCollector
{
	private static final Logger log = LogManager.getLogger(VerificationOfTransactionPopupFields.class.getName());

	/**
	 * This will verify the exact values for transaction pop-up
	 *
	 * @param scenario
	 * @param UIValue   values from UI
	 * @param JSONValue Value from JSON/ Test data
	 * @param fieldName from {@link TransactionPopupElements}
	 */
	public VerificationOfTransactionPopupFields verifyTransactionPopupFields(Scenario scenario, String UIValue, String JSONValue, Enum fieldName)
	{
		try
		{
//			JSONValue = JSONValue + "2";
			if (UIValue.equals(JSONValue))
			{
				log.info(fieldName + " value is matched");
			}
			else
			{
				// Storing the field name with expected and actual value with scenario name
				deviationDetails.get().add(new TransactionPopupDeviation(scenario.getName(), fieldName.toString(), JSONValue, UIValue));
				log.error(fieldName + " Units value is NOT matched");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * This will verify partially the exact values for transaction pop-up
	 *
	 * @param scenario
	 * @param UIValue   values from UI
	 * @param JSONValue Value from JSON/ Test data
	 * @param fieldName from {@link TransactionPopupElements}
	 */
	public VerificationOfTransactionPopupFields partialVerifyTransactionPopupFields(Scenario scenario, String UIValue, String JSONValue, Enum fieldName)
	{
		try
		{
//			JSONValue = JSONValue + "2";
			if (UIValue.contains(JSONValue))
			{
				log.info(fieldName + " value is matched");
			}
			else
			{
				// Storing the field name with expected and actual value with scenario name
				deviationDetails.get().add(new TransactionPopupDeviation(scenario.getName(), fieldName.toString(), JSONValue, UIValue));
				log.error(fieldName + " Units value is NOT matched");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}


}// End of class
