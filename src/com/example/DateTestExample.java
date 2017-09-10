package com.example;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTestExample {
    
	public static void main(String args[]) {
		String myDate = "Thu Aug 17 2017 00:00:00 GMT-0400 (Eastern Daylight Time)";
	    myDate = myDate.substring(0,myDate.lastIndexOf(":")+3);//"Thu Aug 17 2017 00:00:00";
       SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
       try {
		Date myUtilDate = sdf.parse(myDate);
		System.out.println(myUtilDate.toString());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
