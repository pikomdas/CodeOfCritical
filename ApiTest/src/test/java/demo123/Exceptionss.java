/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * Exceptionss.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 19-Apr-2020 - 2:59:07 pm
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
public class Exceptionss
{
	public void test()
	{
		try {
			int a=10;
			int b=100;
			if(a==b) {
				
			}else {
				throw new Exception("failed");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
