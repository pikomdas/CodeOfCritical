package src.main.java.rnd;

import java.util.Scanner;

public class fibonacci {
	
	public void fibnaccii() {
		// TODO Auto-generated method stub

		int i=1;
		int t2=1;
		int t1=0;
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		s.close();
		System.out.println("First "+ n + " Terms");
		while(i<=n) {
		
		System.out.println(t1+ " + ");
		int sum=t1+t2;
		t1=t2;
		sum=t2;
		i++;
		
		System.out.print(sum);
		}
		
		}

}
