package src.main.java.rnd;

import java.util.ArrayList;
import java.util.List;

public class revStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PARTHA_SARATHI_DAS_IS_AN_QA";
		char[] a = s.toCharArray();
		int lnth = a.length;
		int it = 0;
		for (char c : a) {
			System.out.println(it++ + " number element is: " + c);
		}
		System.out.println("Length of array is : " + lnth);
		List<Character> st = new ArrayList<Character>();
		for (int i = 0; i <= lnth - 1; i++) {
			st.add(a[i]);
			System.out.println(it++ + " th element added to LIST array: " + st.get(i));
		}
		System.out.println();
		for (int j = lnth - 1; j > -1; j--) {
			System.out.print(st.get(j));
		}
		System.out.println();
		System.out.println("******************************************************************");
		System.out.println();

		for (int k = 0; k <= st.size() - 1; k++) {
			for (int l = 0; l <= st.size() - 1; l++) {

				System.out.print(st.get(k));
			}
			System.out.println();
		}
		System.out.println("******************************************************************");
		for (int k = 0; k <= st.size() - 1; k++) {
			for (int l = st.size() - 1; l >= k; l--) {

				System.out.print(st.get(l));
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("****************Finding duplicates****************************");
		System.out.println();
		System.out.println("Duplicates are : ");
		for(int a1=0;a1<st.size();a1++) {
			for(int b=a1+1;b<st.size();b++) {
				if(st.get(a1)==st.get(b)) {
					System.out.print(st.get(b));
					
				}
			}
		}
		
		
		
		
		
		
		
		
		
	
	
	}
}
