package demo123;

import java.util.List;

public class Test implements Runnable
{

	public static int inputNumber;

	public static void main(String[] sfjkd)
	{
		//inputNumber = Integer.parseInt(System.getProperty("number"));
		//plusMinus(new int[] {4,1,1,0,-1,-1});
//		double d=12345678.1234567899999;
//		System.out.println(d);
//		System.out.println(String.format("%.12f", d));
//		String s="sdfds";
//		System.out.println(s.matches("[a-z]+"));
		/*List<Integer>ll=new ArrayList<>();
		ll.add(19);ll.add(3);ll.add(7);
		List<Integer>ff=ll.stream().skip(1).collect(Collectors.toList());
		System.out.println(ff);*/
//		String s="Verify Gains Report summation for \"TWR Checking\" between \"https://masterscenarios.assetvantage.com\" and \"https://hotfix.assetvantage.com\"";
//		System.out.println(s.replaceAll("[^a-zA-Z]","_").toString());
		String s1= "48.02248978% \n (S&P Indices S&P 500 Index Total Return)";
		System.out.println(s1.split("\n")[0]);
	}

	public void numberpattern(int a)
	{
		if (a > 10)
		{
			for (int i = 10; i <= a; i++)
			{
				for (int j = a; j >= i; j--)
				{
					System.out.print(" ");
				}
				for (int k = 10; k <= i; k++)
				{
					System.out.print(k + " ");
				}
				System.out.println();
			}
		} else
		{
			System.out.println("enter >10");
		}
	}

	public void numberpattern2(int a)
	{
		if (a > 10)
		{
			for (int i = a; i >= 10; i--)
			{
				for (int j = a; j >= i; j--)
				{
					System.out.print(" ");
				}
				for (int k = 10; k <= i; k++)
				{
					System.out.print(k + " ");
				}
				System.out.println();
			}
		}
	}

	@Override
	public void run()
	{
		Test t1 = new Test();
		t1.numberpattern(inputNumber);
		t1.numberpattern2(inputNumber);
	}

	public static int diagonalDifference(List<List<Integer>> arr)
	{
		int Lsum = 0;
		int Rsum = 0;
		int modDiff = 0;
		int i = 0;
		for (List<Integer> x : arr)
		{
			if (x.size() > 1)
			{
				Lsum = Lsum + x.get(i);
				Rsum=Rsum+x.get(x.size()-i-1);
				i++;
			}
		}
		modDiff = Math.abs(Lsum - Rsum);
		System.out.println();
		return modDiff;
	}
	
	static void plusMinus(int[] arr) {
        double size=arr.length;
        System.out.println("size: "+size);
        double P=0;
        double N=0;
        double z=0;
        for(int x:arr){
            if(x>0){
                P++;
                System.out.println("P: "+P);
            }
            else if(x==0){
                z++;
                System.out.println("z: "+z);
            }
            else{
                N++;
                System.out.println("N: "+N);
            }
        }
        Double d1=Double.valueOf(P/size);
        System.out.println(String.format("%.6f", d1));
        System.out.println(String.format("%.6f",(N/size)));
        System.out.println(String.format("%.6f",(z/size)));
    }
}