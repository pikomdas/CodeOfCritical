package com.codeOfCritical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8InterviewPrograms {

    public static List<Integer> numberArr= Arrays.asList(1,3,4,5,2,3,5);
    public static void main(String[] args) {
        long count=numberArr.stream().count();
        System.out.println(count);
    }
}
