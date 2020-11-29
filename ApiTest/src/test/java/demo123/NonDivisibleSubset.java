/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * NonDivisibleSubset.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 12-Apr-2020 - 2:21:53 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author partha.das
 *
 */
public class NonDivisibleSubset
{
	public static int nonDivisibleSubset(int k, List<Integer> s)
	{
		Set<Integer> subset = new HashSet<Integer>();
		
		for (int i = 0; i < s.size(); i++)
		{
			for (int j = i + 1; j < s.size(); j++)
			{
				int sum = s.get(i) + s.get(j);
				System.out.println(s.get(i) +" + "+ s.get(j)+" = "+sum);
				if (sum % k == 0)
				{
					subset.add(s.get(i));
					subset.add(s.get(j));
					
				}
			}
		}

		return subset.size();
	}

	public static void main(String[] args)
	{
		System.out.println(nonDivisibleSubset(7,
				Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)));
	}
}
