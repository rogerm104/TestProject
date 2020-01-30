package com.rogerproj.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.rogerproj.model.Employee;

public class ListExample {
	private static final Logger logNow = 	Logger.getLogger(ListExample.class);
	
	//ArrayList -index based dynamic array - 10 ,load factor 100%, copies all elements to new array, not sync 
	//maintains insertion order
	//cannot remove elements using for loop causes concurrent modification use iterator.remove()

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
		logNow.debug(new Date()+" empList.size() BEFORE " +empList.size());
		Iterator<Employee> it =empList.iterator();
		while(it.hasNext()){
			logNow.debug("iterating through all the objects in arraylist ***" );
			if(it.next().equals(emp1)){
				logNow.debug("Removing "+emp1);
				it.remove();
			}
		}
		logNow.debug(new Date()+" empList.size() AFTER " +empList.size());

		
		//Second way to iterate

		for(Employee e: empList){
			logNow.debug("For through all the objects in arraylist " +e.getEmpManager());
			if(e.equals(emp2)){
			//	logNow.debug("##Removing using for "+emp2);
			//	empList.remove(emp2);
				//causes concurrent modification exception
			}
		}
		logNow.debug("empList.size() " +empList.size());
		logNow.debug("empList.get(0) " +empList.get(0));
		logNow.debug("empList.get(1) equals " +empList.get(1).equals(new  Employee(102,"Second Employee", "IT","Prashant Rai") ));	
	}

}
