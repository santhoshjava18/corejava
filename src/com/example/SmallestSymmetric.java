package com.example;

public class SmallestSymmetric {

	public static void main(String[] args) {
		findSmallestInt(9);
	}

	public static void findSmallestInt(int n) {
		boolean foundSmall = false;
		while (foundSmall == false) {
			n++;
			if (Symmetric(n)) {
				foundSmall = true;
				System.out.println(n);
				break;
			}
		}
	}

	public static boolean Symmetric(int a) {
		return new StringBuilder(Integer.toString(a)).toString()
				.equals(new StringBuilder(Integer.toString(a)).reverse().toString());

	}

}
