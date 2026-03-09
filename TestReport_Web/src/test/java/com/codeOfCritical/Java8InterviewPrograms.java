package com.codeOfCritical;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Java8InterviewPrograms {

    public static List<Integer> numberArr = Arrays.asList(1, 3, 4, 5, 2, 3, 5);

    public static void main(String[] args) {
        /*List<String> names = Arrays.asList("John", "Alice", "Bob","Beny","Tony Lane");
        names.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(names);

        List<String>names1=names.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println(names1);

        List<String>names2=names.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(names2);*/
//        int arr[] = {44, 3, 22, 12, 33, 9};
//        System.out.println(sort(arr));
//        System.out.println(revSort(arr));
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("Apple", 3);
//        map.put("Banana", 1);
//        map.put("Orange", 2);
//        sortMapByValue(map);
//        firstRepeteatingCharacter(new String("Partha"));
//        String text = "Partha Sarathi Das";
//        longestWord(text);
//        countVowels(text);
//        ascSort(arr);
//        sortDesc(arr);
//        String[] words = {"japan", "India", "Bhutan", "Sri Lanka"};
//        lengthOfStrings(words);
//        revString("Partha");
        reverseSentence("I love India");
    }

    public static List<Integer> sort(int[] arr) {
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> sortedArray = numbers.stream()
                .sorted().collect(Collectors.toList());
        return sortedArray;
    }

    public static List<Integer> revSort(int[] arr) {
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(numbers, Collections.reverseOrder());
        return numbers;
    }
    public static void ascSort(int[] arr) {
        List<Integer> intArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> ascSort = intArr.stream()
                .sorted((a, b) -> a - b)
                .collect(Collectors.toList());
        System.out.println("Asc " + ascSort);
    }

    public static void sortDesc(int[] arr) {
        List<Integer> intArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> descSort = intArr.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        System.out.println("Desc " + descSort);
    }
    public static void sortMapByValue(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, Integer>> ll = new ArrayList<>(map.entrySet());
        Collections.sort(ll, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (Map.Entry<String, Integer> entry : ll) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedMap);
    }

    public static void firstRepeteatingCharacter(String text) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = text.toCharArray();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> element : map.entrySet()) {
            if (element.getValue() == 1) {
                System.out.println(element.getKey());
                break;
            }
        }
    }

    public static void longestWord(String text) {
        String longestWord = Arrays.stream(text.split(" "))
                .max(Comparator.comparing(String::length))
                .orElse(" ");
        System.out.println(longestWord);
    }

    public static void countVowels(String text) {
        long counter = text.toLowerCase().chars()
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();
        System.out.println(counter);

    }

    public static void lengthOfStrings(String[] arr) {
        List<String> ll = Arrays.stream(arr).collect(Collectors.toList());
        Map<String, Integer> wordsLength = ll.stream()
                .collect(Collectors.toMap(k -> k, String::length))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap( Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        System.out.println(wordsLength);
    }
    public static void revString(String text){
        String revString=new StringBuilder(text).reverse().toString();
        System.out.println(revString);

        StringBuilder sb=new StringBuilder();
        char[] arr=text.toCharArray();
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static void reverseSentence(String text){
        String[] arr=text.split("\\s+");
       String rev= Arrays.stream(arr).map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(rev.trim());


    }
}
