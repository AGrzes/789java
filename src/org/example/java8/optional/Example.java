package org.example.java8.optional;

import java.util.Date;
import java.util.Optional;

public class Example {
    public static boolean test() {
        return new Date().getTime() % 4 != 0;
    }

    public static String generate() {
        if (test()) {
            return "Foo";
        }
        return null;
    }

    public static String transform(String s) {
        if (test()) {
            return s.toUpperCase();
        }
        return null;
    }

    public static void before() {
        String s = generate();
        if (s != null) {
            s = transform(s);
            if (s != null) {
                if (s.charAt(1) == 'O') {
                    System.out.println(s);
                }
            }
        }
    }

    public static void after() {
        Optional<String> os = Optional.ofNullable(generate());
        os.map(Example::transform).filter((s) -> s.charAt(1) == 'O').ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        before();
        after();
    }

}
