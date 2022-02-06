/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * AppleOrangeTree.java belongs to codeOfCritical
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 11-Apr-2020 - 8:58:24 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.ArrayList;
import java.util.List;

/**
 * @author partha.das
 *
 */
public class AppleOrangeTree
{

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges)
	{
		//System.out.println(s + " " + t + " " + a + " " + b + " " + apples + " " + oranges);
		int appleCountWithInHouseRange = 0;
		int orangeCountWithInHouseRange = 0;

		List<Integer> locationOfAppleFromOrigin = new ArrayList<Integer>();
		for (int apple : apples)
		{
			locationOfAppleFromOrigin.add(a + apple);
		}
		
		List<Integer> locationOfOrangeFromOrigin = new ArrayList<Integer>();
		for (int orange : oranges)
		{
			locationOfOrangeFromOrigin.add(b + orange);
		}
		
		for (int apple : locationOfAppleFromOrigin)
		{
			if (apple >= s && apple <= t)
			{
				appleCountWithInHouseRange++;
			}
		}
		System.out.println(appleCountWithInHouseRange);

		for (int orange : locationOfOrangeFromOrigin)
		{
			if (orange >= s && orange <= t)
			{
				orangeCountWithInHouseRange++;
			}
		}
		System.out.println(orangeCountWithInHouseRange);
	}
}
