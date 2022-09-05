package com.study.design.pattern.decorator.function;

import java.util.List;
import java.util.function.Function;

public class Book {
    private int price;
    private List<Function<Integer,Integer>> additionalPrices;

    public Book(int price, List<Function<Integer,Integer>> additionalPrices){
        this.price = price;
        this.additionalPrices = additionalPrices;
    }
    public int getPrice() {
        Function<Integer,Integer> combinePriceFunction = additionalPrices
            .stream()
            .reduce(Function.identity(),Function::andThen);

        return combinePriceFunction.apply(price);
    }
}
