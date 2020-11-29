/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * Kangaroo.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 12-Apr-2020 - 1:00:19 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

/**
 * @author partha.das
 *
 */
public class Kangaroo
{
	public static void main(String[] args)
	{
		System.out.println(kangaroo(2932, 7030, 9106, 4840));
		System.out.println(kangaroo(43, 2, 70, 2));
		System.out.println(kangaroo(21, 6, 47, 3));
	}

	static String kangaroo(int x1, int v1, int x2, int v2)
	{
		try
		{
			int dd = (x2 - x1) / (v1 - v2);
			if (x1 + (v1 * dd) == x2 + (v2 * dd) && dd > 0)
			{
				return "YES";
			} else
			{
				return "NO";
			}
		} catch (ArithmeticException e)
		{
			return "NO";
		}

	}

}
