/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * BalancedCheck.java belongs to codeOfCritical 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 08-May-2020 - 6:34:48 pm
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
public class BalancedCheck extends BaseC implements BaseI
{
	public static void main(String[] args)
	{
//		SampleDemo A = new SampleDemo( "A");
//		SampleDemo B = new SampleDemo( "B");
//		
//		B.start();
//		A.start();

		BaseI i=new BalancedCheck();
		i.method();
	}
}


class SampleDemo implements Runnable
{

	private Thread t;
	private String threadName;

	SampleDemo(String threadName)
	{
		this.threadName = threadName;
	}

	public void run()
	{
		while (true)
			System.out.println(threadName);
	}

	public void start()
	{
		if (t == null)
		{
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

interface BaseI
{
	void method();
}

class BaseC
{
	public void method()
	{
		System.out.println("Inside BaseC::method");
	}
}