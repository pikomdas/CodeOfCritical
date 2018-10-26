package rnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Largest_Number 
{
    public static void main(String[] args) 
    {
        int n, max;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
       // n = s.nextInt();
        //int a[] = new int[n];
        List<Integer> a= new ArrayList<Integer>();
        for(int i=0;i<=4;i++) {
        a.add(s.nextInt());
    }
        System.out.println("highest "+ Collections.max(a)+  " minimum "+ Collections.min(a));
        }
    

}//end of class