package com.codeOfCritical;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
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
//        writeFile(startPattern(10));
//        findOccourance(new String("Pioneer"));
        /*Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Apple", 3);
        map.put("Banana", 1);
        map.put("Orange", 2);
        sortMapByValue(map);*/

        List<String> list = Arrays.asList("Apple", "Banana", "Kiwi", "Strawberry");
        sortStringByLength(list);

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

    public static void findOccourance(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : arr) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        System.out.println(counter);

    }

    public static void sortMapByValue(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedMap);
    }
    public static void sortStringByLength(List<String>words){
        List<String>asc=words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(asc);

        List<String>desc=words.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());

        System.out.println(desc);
    }
}
