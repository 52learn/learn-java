package com.study.function.basic;

import java.util.*;
import java.util.function.Function;

public class FunctionExample {

    public static Integer stringLen(Function<String,Integer> func,String str){
        return func.apply(str);
    }

    public static <T,R> Map<T,R> listToMap(List<T> list, Function<T,R> func){
        Map<T,R> result = new HashMap<>();
        for(T item:list){
            result.put(item,func.apply(item));
        }
        return result;
    }

    public static <T> List<T> map(List<T> list,Function<T,T> func){
        List<T> result = new ArrayList<>();
        for(T item:list){
            result.add(func.apply(item));
        }
        return result;
    }
    public static void main(String[] args) {
        Function<String,Integer> stringLengthFunc = x -> x.length();
        System.out.println("test length:"+stringLen(stringLengthFunc,"test"));

        Function<Integer,Integer> doubleFunc = x-> x*2;
        System.out.println("test length *2 : " +stringLengthFunc.andThen(doubleFunc).apply("test"));

        Map<String,Integer> result = listToMap(Arrays.asList("hello","kill"),stringLengthFunc);
        System.out.println("calcListItemlength: "+result);


        List<String> listResult = map(Arrays.asList("a","b","c"),x->x.toUpperCase());
        System.out.println("list upperCase map result: "+listResult);
    }


}
