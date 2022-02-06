/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   Test.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 18/06/20, 2:46 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package FunctionalInterfaces;

public class Test
{
    public static void main(String[] args)
    {
        Listener<ex2,ex1> listener = (x) -> x.do1();
        listener.act(new ex1());
    }
}

class ex1
{
    public ex2 do1()
    {
        System.out.println("return ex2");
        return new ex2();
    }
}

class ex2
{
    public void do2()
    {
        System.out.println("Done");
    }
}