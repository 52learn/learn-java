package com.study.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @see {https://mkyong.com/java8/java-8-stringjoiner-example/}
 */
public class StringJoinerExample {
    static void joinByDelimiter(){
        StringJoiner sj = new StringJoiner(",");
        sj.add("a");
        sj.add("b").add("c");
        System.out.println("result: "+sj.toString());
    }

    static void joinByDelimiterWithPrefixAndSuffix(){
        StringJoiner sj = new StringJoiner(",","start-","-end");
        sj.add("a");
        sj.add("b").add("c");
        System.out.println("result: "+sj.toString());
    }

    static void stringJoin(){
        String provinces = String.join("、","浙江","江苏","广东");
        System.out.println("province string : "+provinces);
    }

    static void collectorsJoining(){
        List<Game> list = Arrays.asList(
            new Game("Dragon Blaze", 5),
            new Game("Angry Bird", 5),
            new Game("Candy Crush", 5)
        );
        String result = list.stream().map(x -> x.getName())
            .collect(Collectors.joining(", ", "{", "}"));
        System.out.println("games : "+result);
    }
    public static void main(String[] args) {
        joinByDelimiter();
        joinByDelimiterWithPrefixAndSuffix();
        stringJoin();
        collectorsJoining();
    }
    @Data
    @AllArgsConstructor
    static class Game {
        String name;
        int ranking;
    }
}
