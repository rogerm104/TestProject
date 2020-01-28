package com.rogerproj.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rogerproj.model.Employee;

public class HasMapExample {
	private static final Logger logNow = 	Logger.getLogger(HasMapExample.class);

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

		Map <Employee,String> empMap = new HashMap<Employee,String>();
		empMap.put(emp1, "Pass");
		empMap.put(emp2, "Fail");
		empMap.put(emp3, "Pass");
		empMap.put(emp4, "Fail");
		empMap.put(null, "Failed null");

		logNow.debug("empMap.size() null key " + empMap.size());		
		logNow.debug("empMap.get(0) null key " + empMap.get(null));		
		logNow.debug("empMap.get " + empMap.get(new Employee(102,"Second Employee", "IT","Prashant Rai")));		
		//Entry set
		Set<Entry<Employee, String>> entrysetEmp = empMap.entrySet();
		logNow.debug("entrysetEmp " + entrysetEmp);		

		for (Entry<Employee, String> e : entrysetEmp){
			logNow.debug("e.getKey() " + e.getKey());		
			logNow.debug("e.getValue() " + e.getValue());					
		}	
		//Key set
		Set<Employee> empSet = empMap.keySet();
		for(Employee e :empSet){
			logNow.debug("e.getValue() " + empMap.get(e));							
		}
		//Iterator
		Iterator<Map.Entry<Employee,String>> it =  empMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Employee,String> entry = it.next();
			logNow.debug("NEW entry.getKey() " + entry.getKey());							
			logNow.debug("NEW entry.getValue() " + entry.getValue());							
		}
	}
}
