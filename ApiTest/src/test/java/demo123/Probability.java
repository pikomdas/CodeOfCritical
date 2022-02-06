/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * Probability.java belongs to codeOfCritical 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 06-Apr-2020 - 4:42:25 pm
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
public class Probability
{
	public static void main(String[] args)
	{
		String ss = "fox";
		//System.out.println(ss.substring(3));
		
		P p = new P();
		p.hitntry(ss,"");
	}
	
}

class P
{
	public void hitntry(String str,String ans)
	{
		// If string is empty 
        if (str.length() == 0) { 
            System.out.println(ans + " "); 
           // return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            // Recurvise call 
            hitntry(ros, ans + ch); 
        } 
	}
}