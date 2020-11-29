package src.main.java.rnd;

import org.testng.annotations.Test;

public class starProgram {

	@Test(priority = 1)
	public void program1() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

	@Test(priority = 2)
	public void program2() {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	@Test(priority = 3)
	public void numberPyramid() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}

	@Test(priority = 4)
	public void program3() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

	@Test(priority = 5)
	public void program4() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int k = 0; k <= 5; k++) {
			for (int l = 5; l >= k; l--) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	@Test(priority = 6)
	public void diamondProgram() {
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("6 ");
			}
			System.out.println();
		}
		for (int m = 0; m < 5; m++) {
			for (int n = 5; n > 5 - m; n--) {
				System.out.print(" ");
			}
			for (int k = 5; k > m; k--) {
				System.out.print("6 ");
			}
			System.out.println();
		}
	}

	@Test(priority = 7)
	public void diamondNumber() {
		int a = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {

				if (a > 9) {
					break;
				} else {
					System.out.print(a++ + " ");
				}
			}
			System.out.println();
		}
		for (int m = 0; m < 5; m++) {
			for (int n = 5; n > 5 - m; n--) {
				System.out.print(" ");
			}
			for (int k = 5; k > m; k--) {
				if (a > 0) {
					System.out.print(a-- + " ");
				} else {
					System.out.print(a++ + " ");
				}
			}
			System.out.println();
		}
	}

	@Test(priority = 8)
	public void RevNumberPyramid1() {
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		for (int m = 0; m < 5; m++) {
			for (int n = 5; n > 5 - m; n--) { // for spacing , m=0, so limit of n 5 for first Iteration
				System.out.print(" ");
			}
			for (int l = 5; l > m; l--) {
				System.out.print(l + " ");
			}
			System.out.println();
		}
	}

}// End of Class
