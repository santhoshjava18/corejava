package com.example.codility;

import java.util.ArrayList;

class Forecast{
	public int temperature;
	public int pressure;
}
public class Main {
   public static void changeTheString(String weather){
	   weather = "sunny";
   }
   public static void changeTheArray(String[] rainydays){
	   rainydays[1] = "sunday";
   }
   public static void changeTheObject(Forecast foirecast){
	   foirecast.temperature = 35;
   }
   
   public static void addPi(ArrayList<Double> list){
list.add(Math.PI); 
}
   
   
   public static void main(String args[]){
	  /* String weather = "rainy";
	   changeTheString(weather);
	   System.out.println(weather);
	   
	   String [] rainyDays = new String[]{"Monday","Friday"};
	   changeTheArray(rainyDays);
	   System.out.println(rainyDays[0]+" "+rainyDays[1]);
	   */
	   
	   ArrayList<Double> dList = new ArrayList<>();
	   ArrayList<Double> numList = new ArrayList<>();
	   addPi(dList);
	   addPi(numList);
	   System.out.println(dList.toString());
	   System.out.println(numList.toString());
	   
   }

}
