package com.study.design.pattern.decorator.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 采用java8 函数编程的装饰器模式
 */
public class FunctionPriceMain2 {



    public static void main(String[] args) {
        List<Function<Integer,Integer>> additionalPrices = new ArrayList<>();
        additionalPrices.add(x -> x*2);
        additionalPrices.add(x -> new Double(x*1.1).intValue());
        additionalPrices.add(x -> x+10);
        Book book = new Book(100,additionalPrices);
        System.out.println("finalPrice:"+book.getPrice());
    }
}
