package com.study.function.basic;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * @link {https://mkyong.com/java8/java-8-supplier-examples/}
 */
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<LocalDateTime> s = ()->LocalDateTime.now();
        System.out.println(s.get());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s.get());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s.get());
    }
}
