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
//        sortStringByLength(list);
//        removeVowelsFromAListOfString();
//        String sentence = "Practice coding daily for interviews";
//        longestWordFind(sentence);
//        firstRepeatingCharacter("swiss");
//         countVowels("Hello World");
        findVowelsInEachWords(list);
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
    public static void removeVowelsFromAListOfString(){
        List<String> words = Arrays.asList("Interview", "Preparation", "Java", "Streams");
        List<String> withoutVowels=words.stream()
                .map(word->word.replaceAll("[AEIOUaeiou]",""))
                .collect(Collectors.toList());
        withoutVowels.forEach(System.out::println);
    }
    public static void longestWordFind(String sentence){
        String longest=Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(" ");
        System.out.println(longest);
    }
    public static void firstRepeatingCharacter(String text){
        Map<Character,Integer>freqMap=new LinkedHashMap<>();

        char[] arr=text.toCharArray();

        for(char c:arr){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer>charMap:freqMap.entrySet()){
            if(charMap.getValue()==1){
                System.out.println("First non-repeating character "+charMap.getKey());
                break;
            }
        }
    }
    public static void countVowels(String s){
        int count=0;
        String lowerCase=s.toLowerCase();
        char[] arr=lowerCase.toCharArray();
        for(int i=0;i<lowerCase.length();i++){
            if(arr[i]=='a' || arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'){
                count++;
            }
        }
        System.out.println("Count of vowels "+count);

        long counter=s.toLowerCase()
                .chars()
                .filter(ch->"aeiou".indexOf(ch)!=-1)
                .count();
        System.out.println("Count of vowels "+counter);
    }

    public static void findVowelsInEachWords(List<String> arr){
        //Map each words to its vowels count
        Map<String,Long>vowelsCountMap=arr.stream()
                .collect(Collectors.toMap(word->word,
                        word->word.toLowerCase().chars().filter(ch->"aeiou".indexOf(ch)!=-1)
                                .count()));
        System.out.println(vowelsCountMap);
    }
}
