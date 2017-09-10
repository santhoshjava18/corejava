package com.example.codility;

import java.util.ArrayList;
import java.util.List;

abstract class Animal{
   public abstract void makeNoise();
   public abstract void move();
}

abstract class Canine extends Animal{
	public void wagTail(){
		System.out.println("wagging");
	}
	
	public void move(){
		System.out.println("run");
	}
}


class Dog extends Canine{
  public void makeNoise(){
	  System.out.println("Bark");
  }
  public void fetch(){
	  System.out.println("Fetch");
  }
}

public class App{
	public static void main(String args[]){
		
		List<String> list1 = new ArrayList<>();
		list1.add("foo");
		
		List<String> list2 = list1;
		List<String> list3 = new ArrayList<>(list2);
		
		list1.clear();
		list2.add("bar");
		list3.add("baz");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
	}
	
}
