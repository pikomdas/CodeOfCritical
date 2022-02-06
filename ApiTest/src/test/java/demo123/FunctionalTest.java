/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * FunctionalTest.java belongs to codeOfCritical 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 04-Apr-2020 - 5:58:51 pm
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
public class FunctionalTest
{
	public static void main(String[] args)
	{
		new B().test();
	}
}

class B
{

	X x = () -> {
		System.out.println("Hi");
	};

	public void test()
	{
		if (x == null)
			x.show();
	}
}

interface X
{
	void show();
}

interface Y
{
	void read();
}