package com.study.design.pattern.decorator.function;

import com.study.design.pattern.decorator.Book;
import com.study.design.pattern.decorator.Item;

import java.util.function.Function;

/**
 * 采用java8 函数编程的装饰器模式
 */
public class FunctionPriceMain {



    public static void main(String[] args) {
        Item book = new Book(100);

        Function<Integer,Integer> giftPacking = value -> value*2;
        Function<Integer,Integer> taxFeeService = value -> new Double(value*1.1).intValue();
        //giftPacking.apply(book.getPrice());
        Function<Integer,Integer> deliveryService = value -> value+10;
        Integer finalPrice = giftPacking  // 200
            .andThen(taxFeeService)// 220
            .andThen(deliveryService)// 230
            .apply(book.getPrice());
        System.out.println("finalPrice:"+finalPrice);
    }
}
