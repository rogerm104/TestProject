package com.rogerproj.collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rogerproj.model.Employee;
import com.rogerproj.model.Phone;

public class HashMapExample {
	//String is best as a key since it has hashcode calculate once ,wrapper classes already has compareTo implemented
	//HasMap  - Not sync , does not maintain insertion order,not sorted, allows one null key, faster(used only in case of no sync required)
	//HashTable -synchronized ,slow , other properties are same as HashMap(used only in case of  sync required)
	//TreeMap- Sorted, navigable , not sync, no null keys (used only in case of finding higher key ,lower key)
	//object/key must be comparable and should have duplicate avoidance logic in case of user defined objects
	//LinkedHashMap -single null key-failFast - best suited when client will send some data and you want to 
	//keep it in same order

	private static final Logger logNow = 	Logger.getLogger(HashMapExample.class);

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
		//Map <Employee,String> empMap = new Hashtable<Employee,String>();

		empMap.put(emp1, "Pass");
		empMap.put(emp2, "Fail");
		empMap.put(emp3, "Pass");
		empMap.put(emp4, "Fail");
		//empMap.put(null, "Failed null");

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
		Iterator<Employee> empSet = empMap.keySet().iterator();
		
		while(empSet.hasNext()){
			if(empSet.next().equals(emp4)){
			//	empSet.remove();
			}
		}
		
		
		//Iterator
		Iterator<Map.Entry<Employee,String>> it =  empMap.entrySet().iterator();
		while(it.hasNext()){
			 
			if(it.next().getKey().equals(emp4)){
				it.remove();
			}
			
			
			
			Map.Entry<Employee,String> entry = it.next();
			logNow.debug(new Date() + " NEW entry.getKey() " + entry.getKey());							
			logNow.debug(new Date() + " entry.getValue() " + entry.getValue());	
			logNow.debug(new Date() +" mapSize " + empMap.size() );

			if (entry.getKey().equals(emp1)){
				String d=empMap.remove(entry.getKey());	
				logNow.debug(new Date() +" mapSize " + empMap.size() + " String d = "+d);
				logNow.debug("removing key operation ");	
			}
			if (entry.getKey().equals(emp1)){
				empMap.put(emp1, "NEW");
				logNow.debug("***adding  emp1 key operation ");	
			}
			logNow.debug(new Date() +" mapSize " + empMap.size());

		}
	//	logNow.debug("mapSize " + empMap.size());	
	//	String d=empMap.remove(emp1);	
	//	logNow.debug("mapSize " + empMap.size() + " String d = "+d);	
		Phone phone1 =  new Phone(115,"Samusng note 10","Samsung",50000);
		Phone phone2 =  new Phone(101,"OnePlus 5T","OnePlus",35000);
		Phone phone3 =  new Phone(119,"Nokia 3310","Nokia",3310);
		Phone phone4 =  new Phone(145,"Samusng Galaxy","Samsung",45000);
		Phone phone5 =  new Phone(105,"iPhone 11","Apple",85000);
		Phone phone6 =  new Phone(119,"Nokia 3310","Nokia",3010);
		Phone phone7 =  new Phone(119,"Nokia 3310","Nokia",3010);
		
		
		Map<Phone,String> lHashMap = new LinkedHashMap<>();
		lHashMap.put(phone1, "Samusng Note");
		lHashMap.put(phone2, "Oneplus 5T");
		lHashMap.put(phone3, "Nokia 3310");
		lHashMap.put(phone4, "Samusng Galay");
		lHashMap.put(phone5, "iPhone 11");
		lHashMap.put(phone6, "Nokia 3310_1");
		lHashMap.put(phone7, "Nokia 3310_2");
		Iterator<Phone> PhnlhmIt =lHashMap.keySet().iterator();
		logNow.debug(new Date() +" lHashMap " + lHashMap.size());

		while(PhnlhmIt.hasNext()){
			
			if (PhnlhmIt.next().equals(phone1)){
				//PhnlhmIt.remove();
				logNow.debug(new Date() +" removing " );
			}
		}
		
		 Iterator<Entry<Phone, String>> entrysetItr= lHashMap.entrySet().iterator();		 
		 while(entrysetItr.hasNext()){
			  Entry<Phone, String> entry=entrysetItr.next();
				logNow.debug(new Date() +" priting Key "+entry.getKey());
				logNow.debug(new Date() +" priting value "+entry.getValue());
				if(entry.getKey().equals(phone5)){
					entrysetItr.remove();
				}
		 }
		logNow.debug(new Date() +" lHashMap " + lHashMap.size());


	}   
}
