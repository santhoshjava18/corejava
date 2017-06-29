package com.example.kroger;

public class MergeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static String mergeStrings(String a, String b) {
	    StringBuilder builder = new StringBuilder();
	    final int greaterLength = a.length() > b.length() ? a.length() : b.length();

	    for(int i = 0; i < greaterLength; i++){
	        if (i < a.length()) {
	            builder.append(a.charAt(i));
	        }
	        if (i < b.length()) {
	            builder.append(b.charAt(i));
	        }
	    }
	    return builder.toString();

	    }

}
