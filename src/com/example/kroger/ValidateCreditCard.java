package com.example.kroger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateCreditCard {
    public static void main(String args[]) throws Exception{
    	String[] bannedPrefixes = {"11","3434","67453","9"};
    	String[] cardsToValidate = {"6724843711060148","9758289300869651"};
    	for(Map<String, Object> myMap :  validateCards(bannedPrefixes,cardsToValidate)){
    		printCardResult(myMap);
    	}
    	
    }
    
    public static void printCardResult(Map<String , Object> cardResult){
    	System.out.println("card:"+cardResult.get("card"));
    	System.out.println("isValid:"+cardResult.get("isValid"));
    	System.out.println("isAllowed:"+cardResult.get("isAllowed"));
    }
    
    static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {
    	List<Map<String, Object>> validationList = new ArrayList<Map<String, Object>>();
    	for(String cardToValidate : cardsToValidate){
    		Map<String, Object> validationMap = new HashMap<String, Object>();
    		validationMap.put("card", cardToValidate);
    		validationMap.put("isValid", isValid(cardToValidate));
    		validationMap.put("isAllowed", isAllowed(bannedPrefixes, cardToValidate));
    		validationList.add(validationMap);
    	}
    	return validationList;

    }
    
    private static boolean isValid(String cardNumber){
    	int[] intArray = new int[cardNumber.length()-1];
    	for (int count = 0; count < cardNumber.length()-1; ++count)
    		   intArray[count] = cardNumber.charAt(count)-'0';
    	
    	int sum =0; 
    	for(int i : intArray){
    		 sum+= i*2;
    	 }
    	// System.out.println("sum:"+sum);
    	 int reminder = sum % 10;
    	// System.out.println("reminder:"+reminder);
    	 int lastDigit = Integer.parseInt(cardNumber.substring(cardNumber.length()-1));
    	// System.out.println("last digit :"+lastDigit);
    	 
    	 
    	return (lastDigit == reminder) ;
    }
    
    private static boolean isAllowed(String[] bannedPrefixes, String cardNumber){
    	boolean isAllowed = true;
    	for(String bannedPrefix : bannedPrefixes){
    		if(cardNumber.startsWith(bannedPrefix)) {isAllowed = false; break;}
    	}
    	return isAllowed;
    }

}

