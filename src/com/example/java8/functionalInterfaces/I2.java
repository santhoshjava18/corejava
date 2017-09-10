package com.example.java8.functionalInterfaces;

public interface I2 {
	default int add(int a, int b) {
		return a + b;
	}
}
