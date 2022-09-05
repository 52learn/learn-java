package com.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void of(){
        Stream.of(2,3,4);
    }

    @Test
    public void arrayToStream(){
        Integer[] intValues = new Integer[]{2,3,4};
        Arrays.stream(intValues)
            .findFirst()
            .ifPresent(System.out::println);
    }


    @Test
    public void listCourseByScoreAsc(){
        Student student = resetStudent();
        System.out.println("------------output course order by score on desc------------");
        student.courses.sort((c1,c2)->c2.score-c1.score);
        student.courses.forEach(System.out::println);
        student = resetStudent();

        student = resetStudent();
        System.out.println("------------output course order by score on desc------------");
        student.courses.stream().sorted((c1,c2)->c2.score-c1.score).forEach(System.out::println);

        student = resetStudent();
        System.out.println("------------output course order by score on desc------------");
        student.addCourse(new Course("Music",100));
        student.courses.stream().forEachOrdered(System.out::println);
    }


    @Test
    public void calcTotalScore(){
        Student student = resetStudent();
        int totalScore = student.courses.stream().mapToInt(c->c.score).sum();
        System.out.println("totoalScore:"+totalScore);

        totalScore = student.courses.stream().map(c->c.score).collect(Collectors.summingInt(x->x));
        System.out.println("totoalScore:"+totalScore);
    }

    @Test
    public void filterScoreGE60(){
        Student student = resetStudent();
        List<Course> courses = student.courses.stream().filter(x->x.score>=60).collect(Collectors.toList());
        courses.forEach(System.out::println);

        System.out.println("------ 原始课程列表(证明stream操作不会影响原先的课程集合)：-----");
        student.courses.forEach(System.out::println);

    }


    @Test
    public void infinity(){
        IntStream.iterate(0,i->i+2).limit(10).forEach(System.out::println);
    }

    @Test
    public void splitAsStream(){
        Pattern.compile(" ")
            .splitAsStream("java 8 streams")
            .forEach(System.out::println);
    }

    @Test
    public void ints(){
        new Random()
            .ints()
            .limit(10)
            .forEach(System.out::println);
    }

    @Test
    public void serial(){
        long numOfEven = LongStream.rangeClosed(2,100000000)
            .filter(x->x%2==0)
            .count();
        System.out.println(numOfEven);
    }
    @Test
    public void parallel(){
        long numOfEven = LongStream.rangeClosed(2,100000000)
            .parallel()
            .filter(x->x%2==0)
            .count();
        System.out.println(numOfEven);
    }
    private Student resetStudent() {
        Student student = new Student("kim");
        student.addCourse(new Course("Chinese",85));
        student.addCourse(new Course("Math",95));
        student.addCourse(new Course("English",98));
        student.addCourse(new Course("History",82));
        student.addCourse(new Course("Sport",50));
        return student;
    }

    class Student{
        public String name;
        public List<Course> courses = new ArrayList<>();
        public Student(String name){
            this.name = name;
        }
        public void addCourse(Course course){
            this.courses.add(course);
        }
    }
    class Course{
        public String name;
        public int score;
        public Course(String name,int score){
            this.name = name;
            this.score = score;
        }
        @Override
        public String toString(){
            return name+":"+score;
        }
    }
}
