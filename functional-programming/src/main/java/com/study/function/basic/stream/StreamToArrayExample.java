package com.study.function.basic.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @link
 * {https://mkyong.com/java8/java-8-how-to-convert-a-stream-to-array/}
 */
public class StreamToArrayExample {
    static void toIntegerArray(){
        int[] num = {1, 2, 3, 4, 5};
        Integer[] result = Arrays.stream(num)
            .map(x -> x * 2)
            .boxed()
            .toArray(Integer[]::new);
        System.out.println(Arrays.asList(result));
    }

    static void toIntArray(){
        int[] stream1 = IntStream.rangeClosed(1, 5).toArray();
        System.out.println(Arrays.toString(stream1));

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        int[] result = stream2.mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        toIntArray();
        toIntegerArray();
    }
}
