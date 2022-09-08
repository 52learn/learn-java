package com.study.function.basic.stream;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @link
 * {https://mkyong.com/java8/java-8-stream-iterate-examples/}
 * {https://mkyong.com/java8/java-8-filter-a-null-value-from-a-stream/}
 * {https://mkyong.com/java/java-8-should-we-close-the-stream-after-use/}
 *
 */
public class StreamExample {
    /**
     *  For Stream whose source are an IO channel, close it with try-with-resources
     */
    public static void releaseIoResource(){
        String path = "c:\\projects\\app.log";
        // auto close
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void resueStreamBySupplier(){
        String[] array = {"a", "b", "c", "d", "e"};
        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }

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

        resueStreamBySupplier();

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