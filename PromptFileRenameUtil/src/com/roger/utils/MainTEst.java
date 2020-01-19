package com.roger.utils;

public class MainTEst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonClassDemo SingletonObj1 = SingletonClassDemo.getInstance();
		SingletonClassDemo SingletonObj2 = SingletonClassDemo.getInstance();
		SingletonClassDemo SingletonObj3 = SingletonClassDemo.getInstance();
		
		System.out.println("Obj created "+SingletonObj1.s.toUpperCase());
		System.out.println("Obj created "+SingletonObj2.s);
		System.out.println("Obj created "+SingletonObj3.s.toLowerCase());
		

	}

}
