/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCrotical.COM PRIVACY POLICY © 2012
 * TransactionVoucherVerification.java belongs to codeOfCrotical
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 09/07/21, 4:20 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCrotical.TransactionPopupScreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class will be used for voucher verification
 */
public class TransactionVoucherVerification extends TransactionDeviationCollector
{
	protected static final TransactionVoucherVerification TRANSACTION_VOUCHER_VERIFICATION = new TransactionVoucherVerification();
	private static final Logger log = LogManager.getLogger(TransactionVoucherVerification.class.getName());

	public static TransactionVoucherVerification getInstance()
	{
		return TRANSACTION_VOUCHER_VERIFICATION;
	}

	public void verifyDataFromJSONtoUI(String scenarioName, double valueFromJSON, double ValueFromUI, String passMessage, String ledgerName,
	                                   String columnName)
	{
		try
		{
			if (valueFromJSON == ValueFromUI)
			{
				log.info("Voucher JSON to UI values are same");
			}
			else
			{
				log.info("Voucher value not match UI " + ValueFromUI + " from JSON " + valueFromJSON);
				// Storing the field name with expected and actual value with scenario name
				deviationDetails.get().add(new TransactionPopupDeviation(scenarioName, valueFromJSON, ValueFromUI, passMessage, ledgerName, columnName));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
