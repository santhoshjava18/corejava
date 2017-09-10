package com.example.codility;

import java.util.List;

class Pet{
	public String getName(){
		return "pet";
	}
}

class Cat extends Pet{
	public String getName(){
		return "cat";
	}
}

class Shape{
	private String name;
	public Shape(){
		name= "shape";
	}
	public String getName(){
		return name;
	}
	
	 void addTo(List<String> list){
		list.add("foo");
	}
	
}

class Ball extends Shape{
	private String name;
	public Ball(){
		name ="ball";
	}
}

public class MainClass {
    
	
	public static void main(String[] args) {
          Pet myPet = new Cat();
          Cat johnsCat = new Cat();
          Ball ball = new Ball();
          System.out.println(String.format("My %s is playing with a %s, Johns %s is slapping", myPet.getName(), ball.getName(), johnsCat.getName()));
	}

}
