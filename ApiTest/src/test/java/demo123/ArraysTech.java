/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * ArraysTech.java belongs to codeOfCritical
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 14-Apr-2020 - 7:29:48 pm
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
public class ArraysTech
{
    static int count = 0;
    
    public static void main(String[] args)
    {
        String s=new String ();
        List<Integer> x = new ArrayList<>(List.of(2, 6, 4, 7, 8));
        //x.add(100);
        x.stream().skip(3);
		System.out.println(x);
        
    }
    
    static void print(List<Integer> l)
    {
        
        if (count < l.size())
        {
            System.out.println(l.get(count));
            count++;
            print(l);
        }
    }
    
    static void printSubArray(List<Integer> l)
    {
        
        if (count < l.size())
        {
            System.out.println(l.subList(0, count));
            count++;
            printSubArray(l);
        }
    }
    
}
