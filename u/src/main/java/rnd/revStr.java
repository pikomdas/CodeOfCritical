package rnd;

import java.util.ArrayList;
import java.util.List;

public class revStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String s="PARTHA";
          char[] a=s.toCharArray();
          int lnth=a.length;
          System.out.println(lnth);
          List<Character> st=new ArrayList<Character>();
          for(int i=0;i<=lnth;i++) {
        	  st.add(a[i]);
        	  System.out.println(st.get(a[i]));
        	  
          }
     
	}

}
