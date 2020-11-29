/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * StackAndDeque.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 11-May-2020 - 11:40:53 am
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.Stack;

/**
 * @author partha.das
 *
 */
public class StackAndDeque
{
	public static void main(String[] args)
	{
		 new Thread() {
	         public void run() {
	            for (int i=1; i <= 5; i++) {
	               System.out.println("run() method: " + i);
	            }
	         }
	      }.start();
	      for (int j=1; j <= 5; j++) {
	         System.out.println("main() method: " + j);
	      }
	}
}
