package com.rogerproj.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.rogerproj.model.Employee;

public class ListExample {
private static final Logger logNow = 	Logger.getLogger(ListExample.class);

public static void main(String[] args) {
	logNow.debug("Testing log4j start....");
	Employee emp1 = new Employee();
	emp1.setEmpID(101);
	emp1.setEmpName("First Employee");
	emp1.setEmpDesg("Genral");
	emp1.setEmpManager("Prashant Rai");
	logNow.debug("emp1 " + emp1);
	
	Employee emp2 = new Employee(102,"Second Employee", "IT","Prashant Rai");
	Employee emp3 = new Employee(103,"Third Employee", "Genral","Bhavesh");
	Employee emp4 = new Employee(103,"Fouth Employee", "IT","Nishanth");
		
	List <Employee> empList = new ArrayList<Employee>();
	empList.add(emp1);
	empList.add(emp2);
	empList.add(emp3);
	empList.add(emp4);
	//First way to iterate
	Iterator<Employee> it =empList.iterator();
	while(it.hasNext()){
		logNow.debug("iterating through all the objects in arraylist " +it.next().getEmpName());
	}
	//Second way to iterate
	for(Employee e: empList){
		logNow.debug("For through all the objects in arraylist " +e.getEmpManager());

	}


	
	
	
	
}
	
}
