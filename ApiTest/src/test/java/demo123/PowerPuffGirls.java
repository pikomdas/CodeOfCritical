/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 * PowerPuffGirls.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 13-Apr-2020 - 3:27:31 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */


/**
 * 
 */
package demo123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author partha.das
 *
 */
public class PowerPuffGirls
{
	static int ppg(List<Integer> upadan,List<Integer>stocks){
		List<Integer>xx=new ArrayList<Integer>();
	      for(int i=0;i<upadan.size();i++) {
	    	  int result=(stocks.get(i)/upadan.get(i));
	    	  if(result>1) {
	    		  xx.add(result);
	    	  }
	    	  else {
	    		  return 0;
	    	  }
	      }
	      
	      return  Collections.min(xx);
	   }
	
	public static void main(String[] args)
	{
		/*Scanner s=new Scanner(System.in);
		int updanNumber=s.nextInt();
		List<Integer>ll=new ArrayList<Integer>();
		for(int i=0;i<updanNumber;i++) {
			ll.add(s.nextInt());
		}
		List<Integer>ll2=new ArrayList<Integer>();
		for(int i=0;i<updanNumber;i++) {
			ll2.add(s.nextInt());
		}
		
		System.out.println(ppg(ll,ll2));*/
		System.out.println(ppg(Arrays.asList(2,5,6,3),Arrays.asList(20,40,90,50)));
	}
}
