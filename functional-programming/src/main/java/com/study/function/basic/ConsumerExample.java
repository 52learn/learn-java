package com.study.function.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @link {https://mkyong.com/java8/java-8-consumer-examples/}
 *
 */
public class ConsumerExample {
    public static <T> void forEach(List<T> list,Consumer<T> consumer){
        for(T item:list){
            consumer.accept(item);
        }
    }
    public static void main(String[] args) {
        Consumer<String> printConsumer = System.out::println;
        printConsumer.accept("test");

        List<String> list = Arrays.asList("a","b","c");
        list.forEach(x->{
            System.out.println(x);
        });
        System.out.println("------------------------");
        forEach(list,x->{
            System.out.println(x);
        });

    }
}
