package com.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		List<Optional<Dish>> intList = new ArrayList<Optional<Dish>>();
		intList.add(Optional.empty());
		intList.add(Optional.of(new Dish("pork", false, 800, Dish.Type.MEAT)));
		intList.add(Optional.of(new Dish("beef", false, 700, Dish.Type.MEAT)));
		intList.add(Optional.of(new Dish("chicken", false, 400, Dish.Type.MEAT)));
		//System.out.println(intList.get(0).isPresent().getName());

	}

}
