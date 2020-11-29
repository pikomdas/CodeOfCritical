/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * execution.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 26-Apr-2020 - 3:38:13 pm
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
public class execution
{
	public static void main(String[] args) throws InterruptedException
	{
		List<Integer> ll;

		ll = new ArrayList<Integer>();
		for (int i = 11; i < 20; i++)
		{
			ll.add(i);
		}
		List<Integer> ss = new ArrayList<Integer>();
		ss.addAll(ll);
		Runnable r = () -> {

			for (int x : ss)
			{
				System.out.print(x + " ");
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		for (int i = 0; i < 10; i++)
		{
			Thread t = new Thread(r);
			t.start();
//			 t.join();
			Thread.sleep(2000);
			ll.clear();
			System.out.println(ll.isEmpty());
		}
	}
}
