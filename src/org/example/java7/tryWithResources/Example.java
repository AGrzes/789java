package org.example.java7.tryWithResources;

public class Example {
    
    private static class Resource implements AutoCloseable {
        public Resource(){
            System.out.println("Creating");
        }
        
        @Override
        public void close()  {
            System.out.println("Closing");
        }
        
    }

    public static void main(String[] args) {
        try (Resource r1 = new Resource()){
            System.out.println("Procesing");
        }
        try (Resource r1 = new Resource();Resource r2 = new Resource()){
            System.out.println("Procesing");
            throw new RuntimeException();
        }
    }

}
