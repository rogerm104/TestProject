package com.assignments;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapImpl {
	public static void main(String args[]){
		
		//creating list of car
		 List<Car> Cars= new ArrayList<Car>(); 
		 
		 	Car newCar2 = new Car();
			newCar2.setCarName("the Car 2");
			newCar2.setCarRegNo(2);
			newCar2.setCarType("Model-2");
			newCar2.setOwnerName("Owner 2");
			Cars.add(newCar2);
		 	
			Car newCar = new Car();
			newCar.setCarName("the Car 1");
			newCar.setCarRegNo(1);
			newCar.setCarType("Model-1");
			newCar.setOwnerName("Owner 1");
			Cars.add(newCar);
			
			Car newCar3 = new Car();
			newCar3.setCarName("the Car 3");
			newCar3.setCarRegNo(3);
			newCar3.setCarType("Model-3");
			newCar3.setOwnerName("Owner 3");
			Cars.add(newCar3);
			
			
		//display the list of car
			Iterator<Car> carIterator = Cars.iterator();
			carIterator.next();

	
		//Creating a map	
		Map<Integer,Car> carMap = new Hashtable<Integer,Car>();
		//addiing each car obj to the map against their registration number as key
		
		for(Car c:Cars){
			carMap.put(c.getCarRegNo(), c);
		}
		//display map using iterator
		Iterator<Integer> mapIterator =  carMap.keySet().iterator();
		while(mapIterator.hasNext()){
		System.out.println("using map iterator : "+carMap.get(mapIterator.next()));
		}

		carMap.remove(2);
		System.out.println(carMap.containsKey(2));
		System.out.println(carMap.size());
		System.out.println(carMap.hashCode());
		
		//display all the car objects in map only using keys
		
		Set<Integer> carRegNos = carMap.keySet();
		
		for(int i : carRegNos)
		{
			System.out.println("Key "+i);
			System.out.println("Value "+carMap.get(i));
		}
		
		//display all the car objects in map only using key and values
		
		Set<Map.Entry<Integer, Car>> carKeyVal = carMap.entrySet();
		
		System.out.println("Entry set " +carKeyVal);
		for(Map.Entry<Integer, Car> entry : carKeyVal)
		{
			System.out.println("Key= "+ entry.getKey());
			System.out.println("Value= "+carMap.get(entry.getKey()));

		}
	}

}
