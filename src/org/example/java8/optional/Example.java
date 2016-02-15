package org.example.java8.optional;

import java.util.Optional;
import java.util.UUID;

public class Example {

    public static void main(String[] args) {
        Optional<String> os = Optional.of("Foo");
        System.out.println(os.get());
        os.map((s) -> s.toUpperCase()).filter((s) -> s.charAt(1) == 'O').ifPresent(System.out::println);
        System.out.println(os.map((s) -> s.toUpperCase()).filter((s) -> s.charAt(1) == 'o').orElse("Bar"));
        try {
            os.filter((s) -> s.charAt(1) == 'O').flatMap(Optional::ofNullable).orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            System.out.println(os.filter((s) -> s.charAt(1) == 'O').flatMap(Optional::ofNullable).orElseGet(() -> UUID.randomUUID().toString()));
        }
    }

}
