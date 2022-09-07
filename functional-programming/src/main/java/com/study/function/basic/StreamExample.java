package com.study.function.basic;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

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