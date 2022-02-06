/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * DateTest.java belongs to codeOfCritical 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 06-May-2020 - 4:00:42 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author partha.das
 *
 */
public class DateTest
{
	public static void main(String[] args)
	{
		String d = LocalDate.now().toString();
		System.out.println(getStartDate(d));

	}

	public static String getStartDate(String startDate)
	{
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		return LocalDate.parse(startDate, inputFormat).format(outputFormat);
	}

}
