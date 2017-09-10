package com.example.java8.functionalInterfaces;

public class DefaultClass implements I1, I2 {

	@Override
	public int add(int a, int b) {
		return I2.super.add(a, b);
	}
	
	

}
