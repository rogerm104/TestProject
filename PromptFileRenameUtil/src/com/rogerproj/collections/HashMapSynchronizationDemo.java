package com.rogerproj.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapSynchronizationDemo {
	 public static void main(String args[]) {
	        
	        // HashMap with mapping containing country and their currency
	        Map<String, String> currencies = new HashMap<String, String>();
	        
	        currencies.put("USA", "USD");
	        currencies.put("England", "GBP");
	        currencies.put("Canada", "CAD");
	        currencies.put("HongKong", "HKD");
	        currencies.put("Australia", "AUD");
	        
	        // Synchronizing HashMap in Java
	        currencies = Collections.synchronizedMap(currencies);
	        
	        // Make sure to synchronize Map while Iterating 
	        // getting key set can be outside synchronized block
	        Set<String> keySet = currencies.keySet();  
	        System.out.println("before"+keySet);
	        
	        // Synchronizing on HashMap, not on Set
	        synchronized(currencies) {  
	            Iterator<String> itr = keySet.iterator(); // Must be in synchronized block            
	            while (itr.hasNext()){
	                System.out.println(itr.next());
	                itr.remove();
	            }
	        }
	        System.out.println("after"+keySet);

	       
	    }
}
