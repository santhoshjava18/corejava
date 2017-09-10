package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.annotation.processing.RoundEnvironment;

public class TimeFormatObj {

	public static void main(String[] args) throws ParseException, NullPointerException {
	   Timestamp ts = Timestamp.valueOf("2017-12-25 08:00:34");
	   System.out.println(ts.getDate());
    
	   int [] old= {3,5,7,9};
	   int [] newA= {2,4,6,8,9,7,5,3};
	   System.arraycopy(old, 0, newA, 0, old.length);
	   for(int i : newA){
		   System.out.println(i);
	   }
	   
	   System.out.println("-");
	   String var1="xyz";
	   String var2 = new String("XYZ");
	   if(var1 == var2)
		   System.out.println(1);
	   else
		   System.out.println(2);
	   if(var1.equalsIgnoreCase(var2))
		   System.out.println(3);
	   else
		   System.out.println(4);
	   
	   System.out.println("-------------------");
	   System.out.println(Math.ceil(-82.4));
	   System.out.println(Math.pow(-6,2));
	   
	   int a = 5, b=7;
	   int c = a+=2*3+b--;
	   System.out.println("c="+c);
	   
	   System.out.println("-------------------");
	   RoundingMode mode = RoundingMode.CEILING;
	   BigDecimal big1 = new BigDecimal(-11);
	   BigDecimal big2 = new BigDecimal(2);
	   System.out.println(big1.divide(big2, mode));
	   
	   String currencyValue = "10.000,25 DM";
	   NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
	  
	   long ssn = 123_45_6789;
	   
	   
	}

}
