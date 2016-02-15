package org.example.java8.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println("###");
        Files.walk(Paths.get(System.getProperty("user.dir"))).filter((p) -> p.toFile().getName().endsWith(".java")).forEach(System.out::println);
        System.out.println("###");
        Files.walk(Paths.get(System.getProperty("user.dir")), 6).filter((p) -> p.toFile().getName().endsWith(".java")).forEach(System.out::println);
        System.out.println("###");
        Files.find(Paths.get(System.getProperty("user.dir")), Integer.MAX_VALUE, (p, a) -> p.toFile().getName().endsWith(".java")).forEach(System.out::println);
        System.out.println("###");
        System.out.println(
                Files.find(Paths.get(System.getProperty("user.dir")), Integer.MAX_VALUE, (p, a) -> p.toFile().getName().endsWith(".java")).flatMap((p) -> {
                    try {
                        return Files.lines(p);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).filter(s -> s.contains("public")).collect(Collectors.joining("\n")));

    }
}
