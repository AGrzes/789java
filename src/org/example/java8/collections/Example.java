package org.example.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        list1.replaceAll((s) -> s.toUpperCase());
        System.out.println(list1);
        list1.sort(Comparator.<String>naturalOrder().reversed());
        System.out.println(list1);
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("A", "Ala");
        map1.put("B", "Bola");
        map1.put("C", "Cula");
        System.out.println(map1.getOrDefault("D", "Dana"));
        map1.forEach((k,v) -> System.out.println(v + " : "+ k));
        map1.replaceAll((k,v) -> new StringBuilder(v).reverse().toString());
        System.out.println(map1);
        map1.putIfAbsent("A", "ALa");
        System.out.println(map1);
        map1.remove("A", "Ala");
        System.out.println(map1);
        map1.replace("A","alA", "Ala");
        System.out.println(map1);
        map1.compute("A", (k,v) -> v == null ? k: v);
        map1.compute("D", (k,v) -> v == null ? k: v);
        System.out.println(map1);
        map1.computeIfAbsent("E", (k) -> k+k+k);
        System.out.println(map1);
        map1.computeIfPresent("D", (k,v) -> k+v+k);
        System.out.println(map1);
        map1.merge("A","Z", (o,n) -> n+o+n);
        map1.merge("Z","Z", (o,n) -> n+o+n);
        System.out.println(map1);
    }
}
