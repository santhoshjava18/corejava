package com.example.codility;

public class NumberPosition {

	public static void main(String[] args) {
		System.out.println(new NumberPosition().solution(978,1953786));

	}
	
	public int solution(int A, int B){
		int result =-1;
		result = String.valueOf(B).indexOf(String.valueOf(A));
		return result;
	}

}
