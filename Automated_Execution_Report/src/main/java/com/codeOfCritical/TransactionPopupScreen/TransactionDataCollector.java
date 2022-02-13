/* *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * TransactionDataCollector.java belongs to codeOfCritical
 *  Do not COPY or PASTE code to WEB from codeOfCritical
 * Creation date-time : 08/07/21, 9:34 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.TransactionPopupScreen;

import com.codeOfCritical.JSONutils.TransactionJSONBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.codeOfCritical.TransactionPopupScreen.TransactionDeviationCollector.deviationDetails;

public class TransactionDataCollector
{
	private static final Logger log = LogManager.getLogger(TransactionDataCollector.class.getName());
	private final static ThreadLocal<TransactionJSONBuilder> transactionJSONBuilder = ThreadLocal.withInitial(TransactionJSONBuilder::new);

	public final ThreadLocal<List<String>> screenshot = new ThreadLocal<>();

	/**
	 * This will return the single deviation details in form of Objects
	 *
	 * @return
	 */
	public List<TransactionPopupDeviation> getListOfTransactionDeviation()
	{
		return deviationDetails.get();
	}

	/**
	 * This method will create a JSON file internally, User need to pass the path of output file
	 *
	 * @return JSON object of the captured deviation
	 *
	 * @throws IOException
	 */
	public synchronized JSONObject buildJSON(String whereToBuildJSON)
	{
		try
		{
			getListOfTransactionDeviation()
					.stream()
					.forEach(x ->
					{
//                    System.out.println("Thread: " + Thread.currentThread().getName());
						transactionJSONBuilder.get().collectData(x.getScenarioName(), x.getFieldName(), x.getActualValue(), x.getExpectedValue()
								, screenshot.get(), LocalDate.now().toString());
					});

			transactionJSONBuilder.get().createJSONFile(whereToBuildJSON);

			return transactionJSONBuilder.get().getJSONObject();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			deviationDetails.get().clear();
			deviationDetails.remove();
		}
		return null;
	}

	/**
	 * This method will create a JSON file internally, User need to pass the path of output file for Voucher verification
	 * @author amulya.p
	 * @return JSON object of the captured deviation
	 *
	 * @throws IOException
	 */
	public synchronized JSONObject buildJSON_Voucher(String voucherPath)
	{
		try
		{
			getListOfTransactionDeviation()
					.stream()
					.forEach(x ->
					{
//                    System.out.println("Thread: " + Thread.currentThread().getName());
						transactionJSONBuilder.get().collectData(x.getScenarioName(), x.getFieldName(), x.getActualValue(), x.getExpectedValue()
								, screenshot.get(), LocalDate.now().toString());
					});

			transactionJSONBuilder.get().createJSONFile_Voucher(voucherPath);

			return transactionJSONBuilder.get().getJSONObject_Voucher();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			deviationDetails.get().clear();
			deviationDetails.remove();
		}
		return null;
	}
}
