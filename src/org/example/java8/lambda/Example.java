package org.example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Example {

    public static void main(String[] args) {
        Supplier<String> source = () -> "String";
        Function<String, Integer> length = (s) -> s.length();
        System.out.println(length.apply(source.get()));
        UnaryOperator<String> upercase = String::toUpperCase;
        System.out.println(upercase.apply(source.get()));
        Consumer<String> println = System.out::println;
        println.accept(upercase.apply(source.get()));
        List<String> list = Arrays.asList("abc", "bac", "cba");
        list.sort(Comparator.comparingInt((String s) -> s.codePointAt(1)).reversed().thenComparingInt((String s) -> s.codePointAt(0)).reversed());
        list.forEach(println);
    }

}
