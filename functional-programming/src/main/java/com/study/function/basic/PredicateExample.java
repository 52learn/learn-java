package com.study.function.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for(T item:list){
            if(predicate.test(item)){
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> greaterThan50List = filterList(Arrays.asList(99,30,58,42),x->x>50);
        System.out.println("greaterThan50List: "+greaterThan50List);
        List<Integer> evenNumberList = filterList(Arrays.asList(99,30,58,42),x->x%2==0);
        System.out.println("evenNumberList: "+evenNumberList);
    }
}
