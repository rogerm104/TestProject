package com.roger.utils;

public class SingletonClassDemo {
	private  static SingletonClassDemo SingletonObj;
	public   String s;
	private SingletonClassDemo(){
		s="Hello I am s";
	}
	public static SingletonClassDemo getInstance(){
		synchronized (SingletonClassDemo.class){
		if(null==SingletonObj){
		  SingletonObj =new SingletonClassDemo();	
		} 
		}
		return SingletonObj;
	}

}
