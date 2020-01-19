package com.assignments;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		if(o1.CarRegNo==1)
			return 0;
		return -1;
	}

}
