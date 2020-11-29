package src.main.java.rnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class collectionExample {

	public static List<Character> T1_Exaample(String input) {
		char[] input1 = input.toCharArray();
		List<Character> c = new ArrayList<Character>();
		for (char c1 : input1) {
			c.add(c1);
		}
		Collections.reverse(c);
		return c;
	}
	public static String T2_Exaample(String input) {
		char[] input1 = input.toCharArray();
		List<Character> strinToarrayChar = new ArrayList<Character>();
		for (char any : input1) {
			strinToarrayChar.add(any);
		}
		Collections.replaceAll(strinToarrayChar,'a', ' ');
		Collections.replaceAll(strinToarrayChar,'e', ' ');
		Collections.replaceAll(strinToarrayChar,'i', ' ');
		Collections.replaceAll(strinToarrayChar,'o', ' ');
		Collections.replaceAll(strinToarrayChar,'u', ' ');
		
		ListIterator<Character> lr= strinToarrayChar.listIterator();
		while(lr.hasNext()) {
		   System.out.print(lr.next());
		}
		return input;
	}

	public static void main(String[] args) {

		System.out.println(T1_Exaample("partha"));
		System.out.println(T2_Exaample("partha_sarathi_das"));

	}

}
