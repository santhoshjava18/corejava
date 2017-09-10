package com.example.codility;

public class ExceptionTest {
     public Integer divide(int a, int b){
    	 try{
    		 return a/b;
    	 }
    	 finally{
    		 System.out.println("finally");
    	 }
     }
	public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        try{
        	System.out.println(test.divide(10, 0));
        }catch(Exception ex){
        	System.out.println("division by 0!");
        }
	}

}
