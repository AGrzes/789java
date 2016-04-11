package org.example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class Example {
    
    public static void before(){
        List<String> list = Arrays.asList("abc", "bac", "cba");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.codePointAt(1), o2.codePointAt(1));
            }
        });
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String t) {
                return t.toUpperCase();
            }
        });
        System.out.println(list);
    }
    
    public static void after(){
        List<String> list = Arrays.asList("abc", "bac", "cba");
        list.sort((o1,o2) -> -Integer.compare(o1.codePointAt(1), o2.codePointAt(1)));
        list.replaceAll(String::toUpperCase);
        System.out.println(list);
    }

    public static void main(String[] args) {
        before();
        after();
    }

}
