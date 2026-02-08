package com.codeOfCritical.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RnD {

    public static void main(String[] args) {
//        findDuplicateHowManyTimes(new String[]{"Partha", "Sarathi Das"});
//        findDuplicate(new int[]{55, 5, 6, 55, 3, 6, 61, 9});
//        sort(new int[]{55, 5, 6, 55, 3, 6, 61, 9});
//        findDuplicate1(new Integer[]{55, 5, 6, 55, 3, 6, 61, 9});
//        findMaxMin(new Integer[]{43,44,211,3,5,44,5,6,1,5});
//        findDuplicateHowManyTimes1(new String("partha sarathi das"));
//        findDuplicateHowManyTimes(new String("partha sarathi das"));
        removeConsonants(new String("partha sarathi das"));
    }

    public static int[] findDuplicate(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.println(a[i]);
                }
            }
        }
        return a;
    }

    public static Integer[] findDuplicate1(Integer[] a) {
        List<Integer> ll = List.of(a);
        Set<Integer> ss = new HashSet<>();
        for (int x : ll) {
            if (ss.add(x) == true) {

            } else {
                System.out.println(x);
            }
        }
        return a;
    }

    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int x = a[i];
                    a[i] = a[j];
                    a[j] = x;
                }
            }
        }
        for (int x : a) {
            System.out.println("Sorting " + x);
        }
        return a;
    }

    public static void writeFile(String x) throws IOException {
        FileOutputStream fo = new FileOutputStream("D:\\AM_FM\\autofw\\TemenosT24\\TemenosT24_Web\\src\\test\\java\\com\\temenos\\test\\abc.txt");

        fo.write(x.getBytes());
        fo.close();

        BufferedReader br = new BufferedReader(new FileReader("D:\\AM_FM\\autofw\\TemenosT24\\TemenosT24_Web\\src\\test\\java\\com\\temenos\\test\\abc.txt"));
        System.out.println(br.readLine());
    }

    public static String convertArrToString(int[] a) {
//        StringBuffer ss = new StringBuffer();
        String s = "";
        for (int x : a) {
            s = s.concat(String.valueOf(x));
        }
        System.out.println(s.toString());
        return s.toString();
    }

    public static String startPattern(int x) {
        String s = "";
        for (int i = 0; i < x; i++) {
//            System.out.print(" ");
            s = s.concat(" ");
            for (int j = 0; j < i; j++) {
//                System.out.print(" *");
                s = s.concat(" *");
            }
//            System.out.println();
            s = s.concat("\n");

        }
        for (int i = 0; i < x; i++) {
//            System.out.print(" ");
            s = s.concat(" ");
            for (int j = x; j > i; j--) {
//                System.out.print(" *");
                s = s.concat(" *");
            }
//            System.out.println();
            s = s.concat("\n");
        }
        return s;
    }

    public static void findDuplicateHowManyTimes(String[] arr) {
        Stream.of(arr).forEach(x -> {
            char[] eachString = x.toCharArray();
            Map<Character, Integer> m = new HashMap<Character, Integer>();
            for (char c : eachString) {
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                } else {
                    m.put(c, 1);
                }
            }
            System.out.println(x + " have " + m);
        });

    }

    public static void findDuplicateHowManyTimes(String text){
        List<Character> arr=new ArrayList<>();
        char[] carr=text.toCharArray();
        for(char c:carr){
            arr.add(c);
        }
        Map<Character,Integer> counter=arr.stream()
                .collect(Collectors.toMap(item->item,item->1,Integer::sum));
        System.out.println(counter);
    }
    public static void findDuplicateHowManyTimes1(String text){
        char [] arr=text.toCharArray();
        Map<Character,Integer> count=new HashMap<>();
        for(char c: arr){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        System.out.println(count);
    }

    public static void findMaxMin(Integer[] a) {
        int max = Integer.MAX_VALUE,min= Integer.MIN_VALUE;
        for (int i = 0; i <= a.length-1; i++) {
            if(max>a[i]){
                max=a[i];
            }
            if(min<a[i]){
                min=a[i];
            }
        }
        System.out.println("max "+max +" min"+min);

        List<Integer>ll= Arrays.asList(a);
        System.out.println("max "+Collections.max(ll) +" min "+Collections.min(ll));
    }

    public static void removeConsonants(String text){
        String ss=text.replaceAll("[AEIOUaeiou]", "");
        System.out.println(ss);
        String vv=text.replaceAll("[^AEIOUaeiou]", "");
        System.out.println(vv);
    }

}

