package com.study.function.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @link {https://mkyong.com/java8/java-8-predicate-examples/}
 *
 */
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
    public static <T> List<T> filterListByStream(List<T> list, Predicate<T> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> greaterThan50List = filterList(Arrays.asList(99,30,58,42),x->x>50);
        System.out.println("greaterThan50List: "+greaterThan50List);
        List<Integer> evenNumberList = filterList(Arrays.asList(99,30,58,42),x->x%2==0);
        System.out.println("evenNumberList: "+evenNumberList);
        evenNumberList = filterListByStream(Arrays.asList(99,30,58,42),x->x%2==0);
        System.out.println("filterListByStream evenNumberList: "+evenNumberList);

        Predicate<Integer> greaterThan50Predicate = x-> x > 50;
        Predicate<Integer> evenNumberPredicate = x-> x%2==0;

        Predicate<Integer> greaterThan50AndEvenNumberPredicate = greaterThan50Predicate.and(evenNumberPredicate);
        System.out.println("90 greaterThan50AndEvenNumberPredicate.test : "+greaterThan50AndEvenNumberPredicate.test(90));

    }
}
