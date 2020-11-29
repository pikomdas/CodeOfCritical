/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * StairCase.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 08-Apr-2020 - 10:33:46 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author partha.das
 *
 */
public class StairCase
{
	public static void main(String[] args)
	{
		//staircase(6);
		//miniMaxSum(new int[] { 254961783, 604179258, 462517083, 967304281, 860273491 });
		//birthdayCakeCandles(new int[] { 33, 5, 66, 33, 5, 6, 7, 33, 66 });
		System.out.println(timeConversion("07:05:45PM"));
	}

	static void staircase(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = n; j > i; j--)
			{
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++)
			{
				System.out.print("#");
			}
			if (1 != n)
			{
				System.out.println();
			}

		}

	}

	static void miniMaxSum(int[] arr)
	{
		long max = 0;
		long min = 0;
		List<Long> ll = new ArrayList<Long>();
		for (long x : arr)
		{
			ll.add(x);
		}
		Collections.sort(ll);
		long c = 0;
		for (long y : ll)
		{
			if (c > 0)
			{
				max = max + y;
			}
			c++;
		}
		long d = 0;
		for (long y : ll)
		{
			if (d < ll.size() - 1)
			{
				min = min + y;
			}
			d++;
		}
		System.out.println(min + " " + max);
	}

	static int birthdayCakeCandles(int[] ar)
	{

		SortedMap<Integer, Integer> mm = new TreeMap<Integer, Integer>();
		for (int x : ar)
		{
			if (mm.containsKey(x))
			{
				mm.put(x, mm.get(x) + 1);
			} else
			{
				mm.put(x, 1);
			}
		}

		return mm.lastKey();

	}

	static String timeConversion(String s)
	{
		DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
		//Desired format: 24 hour format: Change the pattern as per the need
		DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		String output = null;
		try
		{
			//Converting the input String to Date
			date = df.parse(s);
			//Changing the format of date and storing it in String
			output = outputformat.format(date);
			//Displaying the date

		} catch (ParseException pe)
		{
			pe.printStackTrace();
		}
		return output;
	}
}
