package org.example.java8.unsigned;

public class Example {

    public static void main(String[] args) {
        System.out.println(Integer.toUnsignedString(Integer.MAX_VALUE));
        System.out.println(Integer.toUnsignedString(Integer.MIN_VALUE));
        System.out.println(Integer.toUnsignedString(-1));
        System.out.println(Integer.toUnsignedString(Integer.MAX_VALUE*2+1));
        System.out.println(Integer.toUnsignedString(Integer.divideUnsigned(-1, 2)));
        System.out.println(Integer.toUnsignedString(Integer.remainderUnsigned(-1, 2)));
    }

}
