package com.rogerproj.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class StaticExample {
	//https://beginnersbook.com/2013/04/java-static-class-block-methods-variables/
	private static String varStatic ;
	//static block
	static{
		varStatic="Value";
	}

	//nested static class
	static class nestedclass{

		public  String getVarStaticValue(){
			return varStatic;
		}
	}
	//static method
	public static String getVarStaticValue(){
		return varStatic;
	}

	private static final Logger logNow = 	Logger.getLogger(StaticExample.class);

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		logNow.debug( new Date()+" Getting Static method Output "+new StaticExample().getVarStaticValue());
		StaticExample.nestedclass obj = new StaticExample.nestedclass();
		logNow.debug( new Date()+" Getting Static method Output of nested static class "+obj.getVarStaticValue());
		 
		
		List<Double> doublelist = new ArrayList<Double>();
		 
		 for(int i=0;i<100000000;i++){
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 doublelist.add(Math.random());

		 }
		 System.out.println("done");
		
	}	
}
