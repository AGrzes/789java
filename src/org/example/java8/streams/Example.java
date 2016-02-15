package org.example.java8.streams;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {
        System.out.println(Stream.of("ala", "ma", "kota", "kota", "burego").distinct().collect(Collectors.joining(" ")));
        System.out.println(Stream.of("1", "2", "4", "8", "16").mapToInt(Integer::parseInt).reduce(0, (a, b) -> a + b));
        System.out.println(Stream.of("1", "2", "4", "8", "16").mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b));
        System.out.println(Stream.of("1", "2", "3", "4", "5", "6", "8", "16").mapToInt(Integer::parseInt).map((i) -> i * i).filter((i) -> i % 2 == 0)
                .mapToObj(Integer::new).collect(Collectors.groupingBy((I) -> I / 100)));
        Random random = new Random();
        System.out.println(random.doubles(1, 2).allMatch((d) -> d < 1));
        // System.out.println(random.doubles(1, 2).anyMatch((d) -> d<1));
        System.out.println(Stream.of("ala ma kota", "kota burego", "kot kocha ale", "a ala jego").map(s -> s.split(" ")).flatMap(Stream::of)
                .sorted((s1, s2) -> new StringBuilder(s1).reverse().toString().compareTo(new StringBuilder(s2).reverse().toString())).distinct()
                .peek(System.out::println).count());
    }

}
