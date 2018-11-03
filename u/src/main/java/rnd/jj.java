package rnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jj {

	public static void main(final String[] args) {

		final Scanner s = new Scanner(System.in);
		final String w = s.nextLine();
		final String clean = w.replaceAll("[^a-z]", "");
		System.out.println(clean);
		s.close();s.close();
		getDiamondStructure(clean);
		getVowelsFromString(clean);
	}

	public static void getDiamondStructure(final String test) {

		for (int i1 = 0; i1 < test.length(); i1++) {
			for (int j = 0; j < test.length() - i1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i1; k++) {
				System.out.print(test.charAt(k) + " ");
			}
			System.out.println();
		}

		for (int i1 = 0; i1 < test.length(); i1++) {
			for (int j = 0; j <= i1; j++) {
				System.out.print(" ");
			}
			for (int l = 0; l < test.length() - i1; l++) {
				System.out.print(test.charAt(l) + " ");
			}
			System.out.println();
		}

	}

	public static void getVowelsFromString(final String input) {
		final List<Character> cl = new ArrayList<Character>();
		for (int i1 = 0; i1 <= input.length() - 1; i1++) {
			cl.add(input.charAt(i1));
		}
		int count = 0;
		for (int i = 0; i <= cl.size(); i++) {
			if (input.charAt(i) == 'u' || input.charAt(i) == 'o' || input.charAt(i) == 'i' || input.charAt(i) == 'e'|| input.charAt(i) == 'a'
					|| input.charAt(i) == 0) {
				System.out.println("Vowels found at position: " + i + " and the vowel is: " + input.charAt(i));
				cl.remove(i);
				count++;
			}
		}
		System.out.println("Total number of vowels are: " + count);
		System.out.println("String without vowels is " + cl.toString());
		
	}
}
