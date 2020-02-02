package com.rogerproj.collections;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rogerproj.model.Phone;

public class HashSetExample {
	//does not allow duplicates , its a set with internal implementation as Hashmap with key as set value and value 
	//as constant
	//allows 1 null
	//Uses Hashing - initial capacity 16 load factor .75
	//internal working same as Hashmap
	//HashSet allows null value
	//Unlike other set it does not use comparator for sorting
	//cannot remove elements from set concurrently/use iterator to remove
	private static final Logger logNow = 	Logger.getLogger(HashSetExample.class);

	public static void main(String[] args) {
		Phone phone1 =  new Phone(115,"Samusng note 10","Samsung",50000);
		Phone phone2 =  new Phone(101,"OnePlus 5T","OnePlus",35000);
		Phone phone3 =  new Phone(119,"Nokia 3310","Nokia",3310);
		Phone phone4 =  new Phone(145,"Samusng Galaxy","Samsung",45000);
		Phone phone5 =  new Phone(105,"iPhone 11","Apple",85000);
		Phone phone6 =  new Phone(119,"Nokia 3310","Nokia",3010);
		Phone phone7 =  new Phone(119,"Nokia 3310","Nokia",3010);
		
		HashSet<Phone> hashSetEx = new HashSet<>();
		hashSetEx.add(phone1);
		hashSetEx.add(phone2);
		hashSetEx.add(phone3);
		hashSetEx.add(phone4);
		hashSetEx.add(phone5);
		hashSetEx.add(phone6);
		hashSetEx.add(phone7);
		hashSetEx.add(null);
		
		logNow.debug(new Date() +" Size of  HashSet Before "+hashSetEx.size() );

		Iterator<Phone> phonItr= hashSetEx.iterator();
		
		while(phonItr.hasNext()){
			logNow.debug(new Date() +" Print the elements of HashSet"+phonItr.next() );
			phonItr.remove();
		}
		logNow.debug(new Date() +" Size of  HashSet After "+hashSetEx.size() );

			
		Set<Phone> lHashSet = new LinkedHashSet<>();
		lHashSet.add(phone1);
		lHashSet.add(phone2);
		lHashSet.add(phone3);
		lHashSet.add(phone4);
		lHashSet.add(phone5);
		lHashSet.add(phone6);
		lHashSet.add(phone7);
	//	lHashSet.add(null);
		
		logNow.debug(new Date() +" Size of  LinkedHashSet After "+lHashSet.size() );
		Iterator<Phone> lhsIt= lHashSet.iterator();
		while(lhsIt.hasNext()){
			if(lhsIt.next().equals(phone5)){
				//lHashSet.remove(phone5);-fails
				lhsIt.remove();
				logNow.debug(new Date() +"Removing element=>> " );
			}
		}
		Iterator<Phone> newIt= lHashSet.iterator();
		while(newIt.hasNext()){
			logNow.debug(new Date() +"lHashSet after=>> "+ newIt.next() );
		}

	}
	

}
