/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * Voucher_JSON.java belongs to AssetVantage
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 24-Apr-2020 4:35:41 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.commonUtils.JSONutils;

import com.codeOfCritical.CucumberExtentReport.Reporter;
import com.codeOfCritical.TransactionPopupScreen.TransactionVoucherVerification;
import com.codeOfCritical.commonUtils.CucumberBeforeExecution;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author partha.das
 * 		This class is responsible for Voucher related scenarios
 */
public class Voucher_JSON
{
    private static final Logger log = LogManager.getLogger(Voucher_JSON.class.getName());
    // For each thread it will store different json file into JSON array
    private final ThreadLocal<JSONArray> a = new ThreadLocal<JSONArray>();

    /**
     * Parsing the JSON File
     *
     * @param fileName voucher json file
     * @throws IOException
     * @throws ParseException
     */
    public Voucher_JSON(String fileName) throws IOException, ParseException
    {
        JSONParser jp = new JSONParser();
        Reader reader = new FileReader(fileName);
        this.a.set((JSONArray) jp.parse(reader));

    }

    /**
     * @param accountName      from UI of voucher
     * @param transactionValue debit/credit value
     * @param headerName       debit or credit voucher to verify
     * @author partha
     */
    public void verifyVoucher(String accountName, double transactionValue, String headerName)
    {
        int count = 0;
        for (Object o : a.get())
        {
            JSONObject trigger = (JSONObject) o;
            String pn = (String) trigger.get("Ledger Name");
            String ac = (String) trigger.get("Account Number");
            if (accountName.contains(pn) && accountName.contains(ac))
            {
                log.info("ledger Name found : " + pn);
                // Checking if the header is debit or not
                if (headerName.equalsIgnoreCase("Debit"))
                {
                    String debitValue = (String) trigger.get("Debit Amount");
                    double debitValueF = Double.parseDouble(debitValue);
                    log.info("Amount in JSON is : " + debitValueF);
                    TransactionVoucherVerification.getInstance().verifyDataFromJSONtoUI(CucumberBeforeExecution.SCENARIO.get().getName(),
                            debitValueF, transactionValue, "Debit Amount is same", accountName, "Debit");
                }
                // Checking if the header is credit or not
                if (headerName.equalsIgnoreCase("Credit"))
                {
                    String creditValue = (String) trigger.get("Credit Amount");
                    double creditValueF = Double.parseDouble(creditValue);
                    log.info("Amount in JSON is : " + creditValueF);
                    TransactionVoucherVerification.getInstance().verifyDataFromJSONtoUI(CucumberBeforeExecution.SCENARIO.get().getName(), creditValueF,
                            transactionValue, "Credit Amount is same", accountName, "Credit");
                }
            }
            else
            {
                if (count == a.get().size() - 1)
                {
                    log.warn("NOT FOUND IN JSON");
                    Reporter.addStepLog(accountName + " is found additionally in UI");
                }
                count++;
            }
        }
    }
}
