package com.study.function.basic.stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @link {https://mkyong.com/java8/java-8-stream-iterate-examples/}
 * {https://mkyong.com/java8/java-8-filter-a-null-value-from-a-stream/}
 *
 */
public class StreamExample {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("mkyong", 30),
            new Person("jack", 20),
            new Person("lawrence", 40)
        );

        Integer age = persons.stream()
            .filter(x -> "jack".equals(x.getName()))
            .map(Person::getAge)                        //convert stream to String
            .findAny()
            .orElse(null);

        System.out.println(" jack age:"+age);

        Stream.iterate(0, n -> n + 1)
            .limit(10)
            .forEach(x -> System.out.println(x));

        // Stop the stream iteration if n >= 6
        Stream.iterate(1, n -> n < 6 , n -> n * 2)
            .forEach(x -> System.out.println(x));

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> languageList = language.filter(Objects::nonNull).collect(Collectors.toList());
        languageList.forEach(System.out::println);

    }
}
@Data
class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //gettersm setters, toString
}