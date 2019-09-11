package rnd;

import java.util.ArrayList;
import java.util.List;

public class reverseVowelsofAString {

	public static String rv(String input) {
		
		List<Character> vowList = new ArrayList<Character>();
		vowList.add('a');
		vowList.add('e');
		vowList.add('i');
		vowList.add('o');
		vowList.add('u');
		vowList.add('A');
		vowList.add('E');
		vowList.add('I');
		vowList.add('O');
		vowList.add('U');

		char[] arr = input.toCharArray();

		int i = 0;
		int j = input.length() - 1;

		while (i < j) {
			if (!vowList.contains(arr[i])) {
				i++;
				continue;
			}

			if (!vowList.contains(arr[j])) {
				j--;
				continue;
			}

			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;

			i++;
			j--;
		}

		return new String(arr);
	}
	public static void main(String[] args) {
		System.out.println(rv("iamagoodboy"));
	}
}
