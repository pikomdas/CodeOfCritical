/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * MethodRefference.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 19-May-2020 - 1:30:54 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 * 
 */
package demo123;

import java.util.Arrays;
import java.util.List;

/**
 * @author partha.das
 *
 */
public class MethodRefference
{
	public static void main(String[] args)
	{
		List<String> str=Arrays.asList("Asa Akira","JordanLee","Nick Jones","Riki Benz","John Edge");
		str.forEach(MethodRefference::doSomething);
	}
	
	public static void doSomething(String s) {
		System.out.println(s.toUpperCase());
	}
}
