package org.example.java8.base64;

import java.nio.charset.Charset;
import java.util.Base64;

public class Example {

    public static void main(String[] args) {
        byte[] encoded = Base64.getEncoder().encode("Fooo".getBytes(Charset.forName("UTF-8")));
        System.out.println(new String(encoded, Charset.forName("UTF-8")));
        System.out.println(new String(Base64.getDecoder().decode(encoded), Charset.forName("UTF-8")));
    }

}
