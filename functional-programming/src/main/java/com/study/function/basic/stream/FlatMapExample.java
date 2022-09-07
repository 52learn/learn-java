package com.study.function.basic.stream;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @link {https://mkyong.com/java8/java-8-flatmap-example/}
 */
public class FlatMapExample {
    public static void example1(){
        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        Set<String> collect =
            list.stream()
                .map(x -> x.getBook())                              //  Stream<Set<String>>
                .flatMap(x -> x.stream())                           //  Stream<String>
                .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);
        Set<String> collect2 = list.stream()
            //.map(x -> x.getBook())
            .flatMap(x -> x.getBook().stream())                 //  Stream<String>
            .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
            .collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    public static void countWords(){
        Stream<String> lines = Stream.of("hello what is your name","I am in hangzhou");
        long count = lines.flatMap(x-> Arrays.stream(x.split(" ")))
            .count();
        System.out.println("word count:"+count);
    }

    public static void flatMapToInt(){
        Stream<int[]> intArrayStream = Stream.of(new int[]{1,2,3},new int[]{4,5});
        IntStream intStream = intArrayStream.flatMapToInt(x->Arrays.stream(x));
        intStream.forEach(System.out::println);
    }
    public static void main(String[] args) {
        example1();
        countWords();
        flatMapToInt();
    }

    @Data
    static class Developer {

        private Integer id;
        private String name;
        private Set<String> book;

        //getters, setters, toString

        public void addBook(String book) {
            if (this.book == null) {
                this.book = new HashSet<>();
            }
            this.book.add(book);
        }
    }
}
