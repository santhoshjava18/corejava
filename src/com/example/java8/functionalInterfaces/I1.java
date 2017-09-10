package com.example.java8.functionalInterfaces;

public interface I1 {
	default int add(int a, int b) {
		return a + b;
	}
}
