package com.example.kroger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ValidateCreditCard {
	public static void main(String args[]) throws Exception {
		String[] bannedPrefixes = { "11", "3434", "67453", "9" };
		String[] cardsToValidate = { "6724843711060148", "9758289300869651" };
		for (Map<String, Object> myMap : validateCards(bannedPrefixes, cardsToValidate)) {
			printCardResult(myMap);
		}

	}

	public static void printCardResult(Map<String, Object> cardResult) {
		System.out.println("card:" + cardResult.get("card"));
		System.out.println("isValid:" + cardResult.get("isValid"));
		System.out.println("isAllowed:" + cardResult.get("isAllowed"));
	}

	static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {
		List<Map<String, Object>> validationList = new ArrayList<Map<String, Object>>();
		for (String cardToValidate : cardsToValidate) {
			Map<String, Object> validationMap = new HashMap<String, Object>();
			validationMap.put("card", cardToValidate);
			validationMap.put("isValid",
					(Integer.parseInt(cardToValidate.substring(cardToValidate.length() - 1)) == (IntStream.range(0, cardToValidate.length() - 1).map(i -> (cardToValidate.charAt(i) - '0') * 2).sum() % 10)));
			validationMap.put("isAllowed",
					!Arrays.asList(bannedPrefixes).stream().anyMatch(s -> cardToValidate.startsWith(s)));
			validationList.add(validationMap);
		}
		return validationList;

	}

}
