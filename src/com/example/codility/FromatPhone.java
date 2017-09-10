package com.example.codility;

public class FromatPhone {

	public static void main(String[] args) {
		System.out.println(formatPhone(""));

	}
	
	public static  String formatPhone(String input){
		String result = input;
        result = result.replaceAll("[\\s\\-()]", ""); 
        //System.out.println("after trimming:"+result);
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<result.length();){
			
            if(i+3 <= result.length()){			
			sb.append(result.substring(i, i+3)+"-");
			i=i+3;
			   if(result.substring(i, result.length()).length() == 4){
				   sb.append(result.substring(i,i+2)+"-");
				   sb.append(result.substring(i+2,result.length()));break;
			   }
            }else{
            	sb.append(result.substring(i, result.length())); break;
            }
		}
		result = sb.toString();
		if(result.endsWith("-"))
			result = result.substring(0, result.length()-1);
		return result;
	}

}
