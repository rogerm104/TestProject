package com.assignments;

import java.util.ArrayList;
import java.util.List;


public class Factory {
	
	private List<Car> Cars = new ArrayList<Car>();

	public List<Car> orderCars(int orderQuantity){
		
		for(int i=1;i<=orderQuantity;i++){
			Car newCar = new Car();
			newCar.setCarName(i+"th Car");
			newCar.setCarRegNo(i);
			newCar.setCarType("Model-"+i+i+8);
			newCar.setOwnerName("Owner "+i);
			Cars.add(newCar);
		}
		return Cars;
	}
}
