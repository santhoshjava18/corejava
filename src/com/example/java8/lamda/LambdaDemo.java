package com.example.java8.lamda;

public class LambdaDemo {
	@FunctionalInterface
	interface Printer {
        void print(String val);
       // void doprint(String val);
    }
 
    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }
    
    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String something = "I am Lambda";
        /*demo.printSomething(something, new Printer() {
            @Override
            public void print(String val) {
                System.out.println(val);
            }
        });*/
        demo.printSomething(something,(val)->System.out.println(val));
        
    }
}
