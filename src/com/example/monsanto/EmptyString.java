package com.example.monsanto;

public class EmptyString {

	public static void main(String[] args) {
		  String str ="1010001";
		  removeStr(str);
	}
	
	public static void removeStr(String input){
		if(!input.contains("100")){
			if(input.length() >0 ) 
				{System.out.println("false");return;}
			else
			{System.out.println("true");return;}
		}else{
		String myStr = input.replaceAll("100", "");
		removeStr(myStr.trim());
		}
	}

}
