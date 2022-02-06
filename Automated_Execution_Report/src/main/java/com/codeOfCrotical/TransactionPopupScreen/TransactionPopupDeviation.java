/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 * TransactionPopupDeviation.java belongs to codeOfCrotical
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 05/07/21, 11:12 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical.TransactionPopupScreen;

public class TransactionPopupDeviation
{
	private String ledgerName = null;
	private String fieldName = null;
	private String expectedValue = null;
	private String actualValue = null;
	private String scenarioName = null;
	private String passMessgae = null;

	/**
	 * This Constructor will be used to capture deviation in the form Objects
	 * This will capture only Transaction pop-up verification
	 *
	 * @param scenarioName
	 * @param fieldName
	 * @param expectedValue
	 * @param actualValue
	 */
	public TransactionPopupDeviation(String scenarioName, String fieldName, String expectedValue, String actualValue)
	{
		this.fieldName = fieldName;
		this.scenarioName = scenarioName;
		this.expectedValue = expectedValue;
		this.actualValue = actualValue;
	}


	/**
	 * Transaction voucher data to be captured in form of Objects
	 * JSON to UI verification
	 *
	 * @param valueFromJSON
	 * @param ValueFromUI
	 * @param passMessage
	 * @param ledgerName
	 * @param columnName
	 */
	public TransactionPopupDeviation(String scenarioName, Double valueFromJSON, Double ValueFromUI, String passMessage, String ledgerName,
	                                 String columnName)
	{
		this.scenarioName = scenarioName;
		this.fieldName = columnName;
		this.expectedValue = String.valueOf(valueFromJSON);
		this.actualValue = String.valueOf(ValueFromUI);
		this.passMessgae = passMessage;
		this.ledgerName = ledgerName;
	}

	public synchronized String getLedgerName()
	{
		return ledgerName;
	}

	public synchronized String getFieldName()
	{
		return fieldName;
	}

	public synchronized String getExpectedValue()
	{
		return expectedValue;
	}

	public synchronized String getActualValue()
	{
		return actualValue;
	}

	public synchronized String getScenarioName()
	{
		return scenarioName;
	}


	@Override
	public String toString()
	{
		if (this.ledgerName != null)
		{
			return "GetDetailsOfDeviations{" +
					"ledgerName='" + ledgerName + '\'' +
					", fieldName='" + fieldName + '\'' +
					", expectedValue='" + expectedValue + '\'' +
					", actualValue='" + actualValue + '\'' +
					", scenarioName='" + scenarioName + '\'' +
					'}';
		}
		else
		{
			return "GetDetailsOfDeviations{" +
					"ledgerName='" + ledgerName + '\'' +
					", fieldName='" + fieldName + '\'' +
					", expectedValue='" + expectedValue + '\'' +
					", actualValue='" + actualValue + '\'' +
					'}';
		}
	}
}
