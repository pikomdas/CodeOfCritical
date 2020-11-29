/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * StidentGrade.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 12-Apr-2020 - 11:54:02 am
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author partha.das
 *
 */
public class StudentGrade
{
	public static List<Integer> gradingStudents(List<Integer> grades)
	{
		List<Integer> result = new ArrayList<Integer>();
		int count = 0;
		for (int x : grades)
		{
			int nextMultipilable = 0;
			if (x >= 38)
			{
				if (x % 5 != 0)
				{
					nextMultipilable = (x / 5) + 1;
					int nextGrade = 5 * nextMultipilable;
					int check = nextGrade - x;
					if (check < 3)
					{
						result.add(nextGrade);
					} else if (check == 3)
					{
						result.add(x);
					}
				} else
				{

				}
			} else
			{
				result.add(x);
			}
			count++;
		}
		return result;

	}

	public static void main(String[] args)
	{
		System.out.println(gradingStudents(Arrays.asList(39,27, 89, 56, 47, 38, 12, 98, 72, 85, 76, 72, 56, 23, 77, 25, 49,
				4, 52, 71, 43, 11, 2, 44, 10, 20, 3, 90, 64, 48, 31, 56, 51, 70, 91, 14, 25, 61, 41, 0)));
	}
}
