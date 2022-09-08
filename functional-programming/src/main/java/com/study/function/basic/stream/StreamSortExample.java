package com.study.function.basic.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @link
 * {https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/}
 */
public class StreamSortExample {
    static List<User> users = Arrays.asList(
        new User("C", 10),
        new User("D", 40),
        new User("A", 30),
        new User("B", 20),
        new User("E", 50));
    public static void main(String[] args) {
        System.out.println("order by age:");
        List<User> sortedList = users.stream()
            .sorted(Comparator.comparingInt(User::getAge))
            .collect(Collectors.toList());
        sortedList.forEach(System.out::println);

        System.out.println("order by name:");
        sortedList = users.stream()
            .sorted(Comparator.comparing(User::getName))
            .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }
    @Data
    @AllArgsConstructor
    static class User {
        private String name;
        private int age;

    }
}
