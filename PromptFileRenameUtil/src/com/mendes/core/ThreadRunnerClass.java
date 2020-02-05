/**
 * 
 */
package com.mendes.core;

/**
 * @author roger.m
 *
 */
public class ThreadRunnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBThread dt1 = DBThread.getDBThreadInstance();
		dt1.getStatus();
		System.out.println(dt1.init("1"));
		dt1.getStatus();
		
		
		DBThread dt2 = DBThread.getDBThreadInstance();
		dt2.getStatus();
		System.out.println(dt2.init("2"));
		dt2.getStatus();
		
		
		DBThread dt3 = DBThread.getDBThreadInstance();
		dt3.getStatus();
		System.out.println(dt3.init("3"));
		dt3.getStatus();		
	}

}
