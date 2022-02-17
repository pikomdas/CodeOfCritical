package rnd;

public class my1 {
//TEstpassed
	public static void main(String[] args) {
		String s1 = "lartyal";
		pyramidstar(s1);
		pyramidstar1(s1);
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			System.out.println("i= " + i + " is " + s1.charAt(i));
			for (int j = 1 + i; j <= s1.length() - 1; j++) {
				System.out.println("j= " + j + " is " + s1.charAt(j));
				if (s1.charAt(i) == s1.charAt(j)) {
					//System.out.println("Duplicate is " + s1.charAt(j));
					count++;
					if (count == 2) {
						System.out.println("Duplicate at " + count + " time: " + s1.charAt(j));

					} else if (count == 1) {
						System.out.println("Duplicate at " + count + " time: " + s1.charAt(j));
					}
				}
			}
		}

	}

	static void pyramidstar(String mytext) {
      for(int i=0;i<mytext.length();i++) {
    	  for(int j=1+i;j<mytext.length();j++) {
    		  System.out.print(mytext.charAt(j-1));
    	  }
    	  System.out.println();
      }
	}
	static void pyramidstar1(String mytext) {
	      for(int i=0;i<mytext.length();i++) {
	    	  for(int j=1;j<i+1;j++) {
	    		  System.out.print(mytext.charAt(j-1));
	    	  }
	    	  System.out.println();
	      }
		}
}
