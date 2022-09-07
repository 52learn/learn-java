package com.study.function.basic;

import java.util.stream.IntStream;

/**
 * @link {https://mkyong.com/java8/java-8-parallel-streams-examples/}
 */
public class ParallelExample {
    static void printThreadName(){
        IntStream range = IntStream.rangeClosed(1, 5);
        range.forEach(x->{
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });
        IntStream range2 = IntStream.rangeClosed(1, 5);
        range2.parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });
    }
    public static void main(String[] args) {
        printThreadName();
    }
}
