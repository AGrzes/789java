package org.example.java8.defaultMethods;

import java.text.MessageFormat;

public class Example {

    public static interface II {
        public String ii(String first, String second, String third);

        public default String ii(String first, String second) {
            return ii(first, second, "");
        }

        public default String ii(String first) {
            return ii(first, "", "");
        }

        public default String ii() {
            return ii("", "", "");
        }
    }

    public static void main(String[] args) {
        II ii = (f, s, t) -> MessageFormat.format(f, s, t);
        System.out.println(ii.ii("{0} {1} {0}","second", "third"));
        System.out.println(ii.ii("{0} {0}","second"));
        System.out.println(ii.ii("first"));
        System.out.println(ii.ii());
        
    }

}
