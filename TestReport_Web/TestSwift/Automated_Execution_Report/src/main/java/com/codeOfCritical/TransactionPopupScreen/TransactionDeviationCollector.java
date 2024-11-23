/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * TransactionDeviationCollector.java belongs to codeOfCritical
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 05/07/21, 9:58 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.TransactionPopupScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionDeviationCollector
{
	/**
	 * Map[fielsName],Map[Expected value,Actual Value]
	 */
	public static Map<Enum, Map<String, String>> transactionData = new ConcurrentHashMap<>();

	public static ThreadLocal<List<TransactionPopupDeviation>> deviationDetails = ThreadLocal.withInitial(ArrayList::new);
}
