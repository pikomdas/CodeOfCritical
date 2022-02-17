package rnd;

import org.testng.annotations.Test;

import java.util.Scanner;

public class relayProgram {

    public static String Station1(String Name1) {

        return "Khardah";

    }

    public static String Station2(String Name2) {
		return "Balliguanj";

	}

	public static String Station() {
		return "Majherhat";

	}

	@Test
	public void relay() {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			String str = s.nextLine();
			s.close();
			if (Station1(str).isEmpty() && Station2(str).equals(Station1(str))
					|| Station2(str).isEmpty() && !Station1(str).isEmpty()
					|| Station1(str).isEmpty() && Station().isEmpty()) {

				System.out.println("Invalid input");
			} else {
				if (str.contentEquals("Khardah")) {

					System.out.println(Station1(str));
					if (str.contentEquals("Balliguanj")) {
						System.out.println(Station2(str));
						System.out.println(Station().toUpperCase());
					}
				}
			}

		}

	}
}