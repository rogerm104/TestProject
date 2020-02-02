package com.rogerproj.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.rogerproj.model.Employee;
import com.rogerproj.model.Phone;

public class ListExample {
	private static final Logger logNow = 	Logger.getLogger(ListExample.class);
	
	//ArrayList -index based dynamic array - 10 ,load factor 50%, copies all elements to new array, not sync 
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
		int i=1;
		if(i==0)
		{
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
		else {
			//synchronized , implements list ,intialSoize10 load factor 100%
			Vector<Employee> objVec =  new Vector<>();
			objVec.add(emp1);
			objVec.add(emp2);
			objVec.add(emp3);
			objVec.add(emp4);		
			objVec.add(null);
			logNow.debug("objVec.size() " +objVec.size());
			Iterator<Employee> itrVec=objVec.iterator();
			while(itrVec.hasNext()){
				logNow.debug("objVec.size() " +itrVec.next());
				itrVec.remove();
			}
			logNow.debug("objVec.size() " +objVec.size());
			
			Stack<Employee> empStack= new Stack<>();
			empStack.add(emp1);
			empStack.add(emp2);
			empStack.add(emp3);
			empStack.add(emp4);
			empStack.add(null);
			logNow.debug("objVec.size() beofore " +empStack.size());
			logNow.debug("objVec.peek()  " +empStack.peek());
			logNow.debug("objVec.pop()  " +empStack.pop());
			logNow.debug("objVec.pop()  " +empStack.pop());
			logNow.debug("objVec.pop()  " +empStack.pop());
			logNow.debug("objVec.push()  " +empStack.push(null));

			Iterator<Employee> empStackIt=empStack.iterator();
			while(empStackIt.hasNext()){
				logNow.debug("objVec.next()"+empStackIt.next() );
				//empStackIt.remove();
			}
			logNow.debug("objVec.size() after " +empStack.size());
			
			//linkedList
			Phone phone1 =  new Phone(115,"Samusng note 10","Samsung",50000);
			Phone phone2 =  new Phone(101,"OnePlus 5T","OnePlus",35000);
			Phone phone3 =  new Phone(119,"Nokia 3310","Nokia",3310);
			Phone phone4 =  new Phone(145,"Samusng Galaxy","Samsung",45000);
			Phone phone5 =  new Phone(105,"iPhone 11","Apple",85000);
			Phone phone6 =  new Phone(119,"Nokia 3310","Nokia",3010);
			Phone phone7 =  new Phone(119,"Nokia 3310","Nokia",3010);
			
			//it starts with one and than load factor of 100% increments by 1
			LinkedList<Phone> LlinklistOfPhones = new LinkedList<>();
			LlinklistOfPhones.add(phone1);
			LlinklistOfPhones.add(phone2);
			LlinklistOfPhones.add(phone3);
			LlinklistOfPhones.add(phone4);
			LlinklistOfPhones.add(phone5);
			LlinklistOfPhones.add(phone6);
			LlinklistOfPhones.add(phone7);
			LlinklistOfPhones.add(null);
			logNow.debug("LlinklistOfPhones.size() after " +LlinklistOfPhones.size());

			Iterator<Phone> phoneItr= LlinklistOfPhones.iterator();
			while(phoneItr.hasNext()){
				logNow.debug("phoneItr.next() phoneItr " +phoneItr.next());
			}
			logNow.debug("LlinklistOfPhones.size() phoneItr " +LlinklistOfPhones.size());

			for (Phone p : LlinklistOfPhones ){
				p.getPhonePrice();
			}
		}	
	}

}
