package org.example.java7.multiCatch;

public class Example {

    public static void main(String[] args) {
        try {
            String[] arr = new String[1024*1024*1];
            main(arr);
        }
        catch (StackOverflowError | OutOfMemoryError e){
            System.err.println(e);
            throw e;
        }
    }

}
