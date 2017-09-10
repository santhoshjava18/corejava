package com.example.codility;

import java.util.Stack;

public class StackMachine {

	public static void main(String[] args) {
		System.out.println(stackMachine("5 6 + -"));

	}
	
	public static int stackMachine(String S){
		int result = 0;
		Stack<Integer> myStack = new Stack<Integer>();
		String operArr[] = S.split(" ");
		for(String operation : operArr){
		    switch(operation){
		       case "POP" : if(!myStack.isEmpty()){myStack.pop();} break;
		       case "DUP" : {
		    	           int top = myStack.peek();
		                   myStack.push(top);
		                  }; break;
		       case "+" : {
		    	   
		    	   int top1 = 0;
		    	   if(!myStack.isEmpty())
		    	    top1 = myStack.pop();
		    	   else{
		    		   return -1;
		    	   }
		    	   int top2 = 0;
		    	   if(!myStack.isEmpty())
			    	    top2 = myStack.pop();
		    	   else{
		    		   return -1;
		    	   }
		    	   myStack.push(top1+top2);
		       }; break;
		       case "-" : {
		    	   int top1 = 0;
		    	   if(!myStack.isEmpty())
		    	     top1 = myStack.pop();
		    	   else{
		    		   return -1;
		    	   }
                   int top2 = 0; 
		    	   if(!myStack.isEmpty())
			    	     top2 = myStack.pop();
		    	   else{
		    		   return -1;
		    	   }
		    	   myStack.push(top1-top2);
		       }; break;
		       default : myStack.push(Integer.parseInt(operation));
		    	   
		    }
		}
		result = myStack.peek();
		return result;
	}
	
	
	

}
