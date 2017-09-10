package com.example.kroger;

import java.util.HashMap;

public class RightShift {

	public static void main(String[] args) {
		String s = "";
		String result1 = leftShift(s,0);
		System.out.println("after left:"+result1);
		System.out.println("after right:"+rightShift(result1, 1));
		int a[] = {};
		
	
	}
	
	static String leftShift(String s, int k){
		if(s.length() >=  k){
		String result = s.substring(k,s.length());
		String result1 = s.substring(0,k);
		return result+result1;
		}else{
			return s;
		}
	}
	
	static String rightShift(String s, int k){
		if(s.length() >=  k){
		String result = s.substring(0,s.length()-k);
		String result1 = s.substring(s.length()-k,s.length());
		return result1+result;
		}else{
			return s;
		}
	}

}
