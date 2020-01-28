package com.rogerproj.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.rogerproj.model.Employee;

class empCompatator implements Comparator<Employee>{

	//0- Remove duplicates
	//1- swap positions for sorting
	//-1- no changes
	@Override
	public int compare(Employee arg0, Employee arg1) {
		if(arg0.getEmpID()==arg1.getEmpID()&&
				arg0.getEmpName().equalsIgnoreCase(arg1.getEmpName())&& 
				arg0.getEmpDesg().equalsIgnoreCase(arg1.getEmpDesg())&&
				arg0.getEmpManager().equalsIgnoreCase(arg1.getEmpManager()))
			return 0;
		else if(arg0.getEmpID()>arg1.getEmpID())
			return 1;
		else 
			return -1;
	}
}


public class TreeSetExample {
	private static final Logger logNow = 	Logger.getLogger(TreeSetExample.class);

	public static void main(String[] args) {
		logNow.debug("Testing log4j start....");
		String str ="the dog barks all the night continousley the TEST"; 
		String [] strArr= str.split(" ");

		Set<String> tset =new TreeSet<String>();
		tset.addAll(Arrays.asList(strArr));
		logNow.debug("TreeSet Size...."+tset.size());

		for(String s: tset){
			logNow.debug("Printing contents of Teeset...."+s.toString());
		}

		Employee emp1 = new Employee();
		emp1.setEmpID(101);
		emp1.setEmpName("First Employee");
		emp1.setEmpDesg("Genral");
		emp1.setEmpManager("Prashant Rai");
		logNow.debug("emp1 " + emp1);
		Employee emp2 = new Employee(110,"Second Employee", "IT","Prashant Rai");
		Employee emp3 = new Employee(103,"Third Employee", "Genral","Bhavesh");
		Employee emp4 = new Employee(103,"Fouth Employee", "IT","Nishanth");
		Employee emp5 = new Employee(103,"Fouth Employee", "IT","Nishanth");

		tset.clear();
		Set<Employee> tsetEmp =new TreeSet<Employee>(new empCompatator());
		tsetEmp.add(emp1);
		tsetEmp.add(emp2);
		tsetEmp.add(emp3);
		tsetEmp.add(emp4);
		tsetEmp.add(emp5);

		for(Employee e: tsetEmp){
			logNow.debug("Printing Object based   Treeset...."+e.getEmpID());
		}
	}
}
