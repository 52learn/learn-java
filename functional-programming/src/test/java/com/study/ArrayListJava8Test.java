package com.study;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListJava8Test {
    List<String> list;
    @Before
    public void setUp(){
        list =  new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
    }

    @Test
    public void removeIf(){
        list.removeIf(x-> x.length() == 3 ? true:false);
        list.forEach(System.out::println);
    }
    @Test
    public void replaceAll(){
        list.replaceAll(x->{
            if(x.equals("I"))
                return "kim";
            if(x.equals("you"))
                return "fly";
            return x;
        });
        list.forEach(System.out::println);
    }

    @Test
    public void sort(){
        // 等同于：list.sort((x,y)->x.length()-y.length());
        list.sort(Comparator.comparingInt(String::length));
        list.forEach(System.out::println);
    }

    @Test
    public void spliterator(){
        //list.spliterator().trySplit()
    }
}
