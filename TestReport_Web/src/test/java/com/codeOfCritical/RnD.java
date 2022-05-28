package com.codeOfCritical;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class RnD {

    public static void main(String[] args) throws IOException {
        int[] arri = {1, 33, 4, 5, 1, 2, 22, 5};
//        Character[] arr = IntStream.of(arri).boxed().toArray(Character[]::new);

//        findDuplicate(arri);
//        System.out.println("===========================");
//        findDuplicate1(arr);
//        System.out.println("===========================");
//        sort(arr);
        /*writeFile(convertArrToString(findDuplicate(arri))
                .concat("\n")
                .concat(convertArrToString(sort(arri)))
                .concat("\n"));*/
        writeFile(startPattern(10));
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
            System.out.println(x);
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
            s=s.concat(" ");
            for (int j = 0; j < i; j++) {
//                System.out.print(" *");
               s= s.concat(" *");
            }
//            System.out.println();
            s=s.concat("\n");

        }
        for (int i = 0; i < x; i++) {
//            System.out.print(" ");
            s=s.concat(" ");
            for (int j = x; j > i; j--) {
//                System.out.print(" *");
                s=s.concat(" *");
            }
//            System.out.println();
            s=s.concat("\n");
        }
        return s;
    }


}
