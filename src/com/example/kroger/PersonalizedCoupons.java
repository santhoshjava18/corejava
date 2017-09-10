package com.example.kroger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonalizedCoupons {

	static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons,
			List<String> preferredCategories) {
		List<Map<String, Object>>  preferredCoupons = coupons.stream().filter(coupon -> preferredCategories.contains(coupon.get("category"))).collect(Collectors.toList());
		preferredCoupons.forEach(coupon -> {coupon.entrySet().removeIf(entry -> entry.getKey().equals("code"));});
		preferredCoupons.sort((Map<String, Object> m1, Map<String, Object> m2) -> 
		                 ((new Double(m1.get("itemPrice").toString()).doubleValue() / new Double(m1.get("couponAmount").toString()).doubleValue())   > 
		                   (new Double(m2.get("itemPrice").toString()).doubleValue() / new Double(m2.get("couponAmount").toString()).doubleValue())) ? 1 : -1);
		return  preferredCoupons.stream().limit(10).collect(Collectors.toList());
	}
	

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		List<String> preferredCategories = Arrays.asList(input.nextLine().split(","));
		List<Map<String, Object>> coupons = new ArrayList<>();
		int lines = Integer.parseInt(input.nextLine());
		IntStream.range(0, lines).forEach(i -> coupons.add(readCoupon(input)));
		List<Map<String, Object>> personalizedCoupons = personalizeCoupons(coupons, preferredCategories);
		personalizedCoupons.stream().forEach(PersonalizedCoupons::printCoupon);
	}

	public static Map<String, Object> readCoupon(Scanner input) {
		String[] couponItems = input.nextLine().split(",");
		Map<String, Object> coupon = new HashMap<>();
		coupon.put("upc", couponItems[0]);
		coupon.put("code", couponItems[1]);
		coupon.put("category", couponItems[2]);
		coupon.put("itemPrice", Float.parseFloat(couponItems[3]));
		coupon.put("couponAmount", Float.parseFloat(couponItems[4]));
		return coupon;
	}

	public static void printCoupon(Map<String, Object> coupon) {
		System.out.print("{");
		System.out.print("\"couponAmount\":" + coupon.get("couponAmount") + ",");
		System.out.print("\"upc\":\"" + coupon.get("upc") + "\",");
		if (coupon.containsKey("code")) {
			System.out.print("\"code\":\"" + coupon.get("code") + "\",");
		}
		System.out.print("\"itemPrice\":" + coupon.get("itemPrice") + ",");
		System.out.println("\"category\":\"" + coupon.get("category") + "\"}");
	}
	


}
