package com.study.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListJava8 {

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(x-> x.length() == 3 ? true:false);
        list.forEach(System.out::println);

    }
}
