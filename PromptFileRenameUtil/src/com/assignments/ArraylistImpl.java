package com.assignments;
import com.assignments.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArraylistImpl {

	public static void main(String args[]){
		
		 List<Car> Cars= new ArrayList<Car>(); 
		 
		 	Car newCar = new Car();
			newCar.setCarName("the Car 1");
			newCar.setCarRegNo(1);
			newCar.setCarType("Model-1");
			newCar.setOwnerName("Owner 1");
			Cars.add(newCar);
			
			Car newCar2 = new Car();
			newCar2.setCarName("the Car 2");
			newCar2.setCarRegNo(2);
			newCar2.setCarType("Model-2");
			newCar2.setOwnerName("Owner 2");
			Cars.add(newCar2);
			
			//System.out.println(Cars);
			
			//Using iterator
			Iterator<Car> carIterator= Cars.iterator();
			
			while(carIterator.hasNext()){
				System.out.println(" Before: "+carIterator.next());
			}
			//using enhanced for loop
			
			//Sorting
			//Collections.sort(Cars);??
			Comparator<Car> carComparator=  new   ComparatorImpl(); 
			Collections.sort(Cars,carComparator);
			
			for(Car i:Cars){
				System.out.println("After: "+i);
			}
	}
}
