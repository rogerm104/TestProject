package com.roger.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class Test3 {
	public static void main(String[] args){

		 String result = Test3.CheckWorkingHours("00:12,13:01");
		 System.out.println(" Result for working hours check= "+ result );
		 SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
		 System.out.println(" Result= "+ simpleDateformat.format(System.currentTimeMillis()-6*24*60*60*1000));
		 
		 String HolidayList= "12/02/2019,24/02/2019,25/02/2019,01/03/2019,";
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date date= new Date();
		 String[] Holidays=  HolidayList.split(",");
		 System.out.println("Printing Holidays>> "+Arrays.toString(Holidays));
		 for ( String holiday : Holidays){
		     try {
				date = dateFormat.parse(holiday);
				System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013
			     //String output = dateFormat.format(date);
			    // System.out.println("date output :  "+output); // 2013-12-04
			     System.out.println("isSamesDay"+isToday(date));
			     if(date!=null){
			     if(isToday(date)){
			    	 break;
			     }}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 
		 

	}
	public static boolean isToday(Date date) {
        return isSameDay(date,new Date());
    }
	 public static boolean isSameDay(Date date1, Date date2) {
	        if (date1 == null || date2 == null) {
	            throw new IllegalArgumentException("The dates must not be null");
	        }
	        Calendar cal1 = Calendar.getInstance();
	        cal1.setTime(date1);
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(date2);
	        return isSameDay(cal1, cal2);
	    }
	 public static boolean isSameDay(Calendar cal1, Calendar cal2) {
	        if (cal1 == null || cal2 == null) {
	            throw new IllegalArgumentException("The dates must not be null");
	        }
	        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
	                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
	                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
	    }
	 
	public static String CheckWorkingHours(String startEndTime) {
		String y_n="not defined";boolean result=false;
	try {
		String[] startEnd= startEndTime.split(",");
		String start=startEnd[0];
		String end=startEnd[1];
		if(start.equalsIgnoreCase("") && end.equalsIgnoreCase("")) {
			{
		 result=isHourInInterval(getCurrentHour(), start, end);
			}
		if(!result) {
			y_n="n";
		}}
	}catch(Exception ex){
		return y_n;		
	}
		return y_n;
	}
	
	//Check if working hours returns 'y' if yes and 'n' if not
	public static String CheckHoliday(String hDate) {
		return "";
	}
	
	//to get current hour
	public static String getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm");
        String hour = sdfHour.format(cal.getTime());
        return hour;
    }
	
	//Final Check interval
	public static boolean isHourInInterval(String target, String start, String end) {
        return ((target.compareTo(start) >= 0)
                && (target.compareTo(end) <= 0));
    }	
	}
	
	