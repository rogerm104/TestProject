/**
 * 
 */
package com.assignments;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author roger.m
 *
 */
public class Showroom {

	/**
	 * 
	 */
	public Showroom() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factoryObj = new Factory();
		List<Car> newCars= factoryObj.orderCars(5);
		System.out.println(newCars);
		
	//	Set<Car> carSet = new TreeSet<Car>();
	//	Car car = new Car();
	//	car.setCarName("name");
	//	car.setCarRegNo(12);
	//	carSet.add(car);
		
		
		
		
	}

}
