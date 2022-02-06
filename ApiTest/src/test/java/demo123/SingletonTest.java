/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   SingletonTest.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 05/06/20, 12:22 AM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package demo123;

public class SingletonTest
{
    public static void main(String[] args)
    {
        Box b1 = Box.getInstance();
        Box b2 = Box.getInstance();
        Box b3 = Box.getInstance();


    }

}

class Box
{

    public static Box box = null;
    private static int i = 199;

    private Box()
    {
        i++;
        System.out.println("called " + i);
    }

    public static Box getInstance()
    {
        if (box == null)
        {
            box = new Box();
            return box;
        }
        return box;
    }
}