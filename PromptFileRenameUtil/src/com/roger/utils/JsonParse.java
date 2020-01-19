package com.roger.utils;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonParse {
	public static void main(String[] args) throws IOException{
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat dateFormatText = new SimpleDateFormat("dd MMMMM yyyy");

		
		String yyyymmdd,yyyymmdd_sdf="";
		try {
			yyyymmdd="19911026";
		 if(yyyymmdd.length()>7) { 
			yyyymmdd_sdf=yyyymmdd.substring(4, 6)+"/"+yyyymmdd.substring(6, 8)+"/"+yyyymmdd.substring(0, 4);
			 System.out.println(" manually Formatted Date is yyyymmdd =>"+yyyymmdd_sdf);
			Date Date1 = dateFormat.parse(yyyymmdd_sdf);
			System.out.println("Formatted Date 1 is yyyymmdd=>"+Date1.toString());
			String date2=new SimpleDateFormat("MMMMM dd  yyyy").format(Date1);
			System.out.println("date2 is yyyymmdd=> "+date2);
			
		 }	
		}catch(Exception ex) {
			System.out.println(ex.getStackTrace());
		}
		//Parsing other date format
		try {
			yyyymmdd="10261991";
		 if(yyyymmdd.length()>7) { 
			yyyymmdd_sdf=yyyymmdd.substring(0, 2)+"/"+yyyymmdd.substring(2, 4)+"/"+yyyymmdd.substring(4, 8);
			 System.out.println(" manually Formatted Date is =>"+yyyymmdd_sdf);
			Date Date1 = dateFormat.parse(yyyymmdd_sdf);
			System.out.println("Formatted Date 1 is =>"+Date1.toString());
			String date2=new SimpleDateFormat("MMMMM dd  yyyy").format(Date1);
			System.out.println("date2 is => "+date2);
		 }	
		}catch(Exception ex) {
			System.out.println(ex.getStackTrace());
		}
		

	
	}
	String ordinal(int num)
	{
	    String[] suffix = {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
	    int m = num % 100;
	    return String.valueOf(num) + suffix[(m > 3 && m < 21) ? 0 : (m % 10)];
	}
}