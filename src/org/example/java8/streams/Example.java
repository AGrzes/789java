package org.example.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void before() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6", "8", "16");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (String string : strings) {
            int $int = Integer.parseInt(string);
            $int = $int * $int;
            if ($int % 2 == 0) {
                int group = $int / 100;
                if (!map.containsKey(group)) {
                    map.put(group, new ArrayList<Integer>());
                }
                map.get(group).add($int);
            }
        }
        System.out.println(map);
    }

    public static void after() {
        System.out.println(Stream.of("1", "2", "3", "4", "5", "6", "8", "16").mapToInt(Integer::parseInt).map((i) -> i * i).filter((i) -> i % 2 == 0)
                .mapToObj(Integer::new).collect(Collectors.groupingBy((I) -> I / 100)));
    }

    public static void main(String[] args) {
        before();
        after();
    }

}
