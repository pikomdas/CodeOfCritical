/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * MigratoryBirds.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 12-Apr-2020 - 9:46:16 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author partha.das
 *
 */
public class MigratoryBirds
{
	static int migratoryBirds(List<Integer> arr)
	{
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int x : arr)
		{
			if (m.containsKey(x))
			{
				m.put(x, m.get(x) + 1);
			} else
			{
				m.put(x, 1);
			}
		}
		List<Integer>keys=new ArrayList<Integer>();
		int max = Collections.max(m.values());
		for (int x : m.keySet())
		{
			if (m.get(x) == max)
			{
			keys.add(x);	
			}
		}
		return Collections.min(keys);
	}
}
