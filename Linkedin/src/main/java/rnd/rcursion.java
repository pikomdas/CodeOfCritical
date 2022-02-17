package rnd;

import org.testng.annotations.Test;

public class rcursion {

	@Test
	void rvsttrTest() {
		reverseString("par");
	}
	
	String reverseString(String string) {
		String s1="PARTHA";
		System.out.println("Original String is : "+s1);
		int i=0;
		while( i==s1.length()) {
			
			return reverseString(s1.substring(1)+ s1.charAt(0));
		}
		return s1;
		
	}
}