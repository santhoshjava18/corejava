package com.example.java8.functionalInterfaces;
@FunctionalInterface
public interface SimpleFuncInterface {
	public void doWork();
	public String toString();
}

@FunctionalInterface
interface ComplexInterface extends SimpleFuncInterface{
	default public void doSomeOtherwork(){
		System.out.println("do some other work");
	}
}
