package com.study.optional;

import java.util.Optional;

/**
 * @see {https://mkyong.com/java8/java-8-optional-in-depth/}
 */
public class OptionalExample {

    public static void  map(){
        System.out.println(Optional.of("male").map(String::toUpperCase));
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.map(String::toUpperCase));
    }

    public static void filter(){
        Optional<String> optional = Optional.of("male");
        Optional<String> filterOptional = optional.filter(value->value.equals("MALE"));
        System.out.println(filterOptional);
    }

    public static void main(String[] args) {
        map();
        filter();
    }
}
