package com.assignments;

import java.util.HashMap;
import java.util.Map;

public class HashMapAdvancedImpl {

	public static void main(String args[]){
		
		Map<Car,String> carMap=  createCache();
		
		System.out.println("CarMapEntries "+carMap);
		Car newCar = new Car();
		newCar.setCarName("the Car 1");
		newCar.setCarRegNo(1);
		newCar.setCarType("Model-1");
		newCar.setOwnerName("Owner 1");
		
		//Creating the same object and than assiging the values to the input (Comparisn)
		//array and than returing the values back to the hasmap
		
		System.out.println(" The first map entry"+ carMap.get(newCar));
		
	}
	public static Map<Car,String> createCache(){
		
		Map<Car,String> carMap=   new HashMap<Car,String>();

		//Create Car objects

		 	Car newCar2 = new Car();
			newCar2.setCarName("the Car 2");
			newCar2.setCarRegNo(2);
			newCar2.setCarType("Model-2");
			newCar2.setOwnerName("Owner 2");
		 	
			Car newCar = new Car();
			newCar.setCarName("the Car 1");
			newCar.setCarRegNo(1);
			newCar.setCarType("Model-1");
			newCar.setOwnerName("Owner 1");
			
			Car newCar3 = new Car();
			newCar3.setCarName("the Car 3");
			newCar3.setCarRegNo(3);
			newCar3.setCarType("Model-3");
			newCar3.setOwnerName("Owner 3");
			//adding elements to the carMap
			
			carMap.put(newCar, newCar.getOwnerName());
			carMap.put(newCar2, newCar2.getOwnerName());
			carMap.put(newCar3, newCar3.getOwnerName());
			return carMap;
	}
	
}

