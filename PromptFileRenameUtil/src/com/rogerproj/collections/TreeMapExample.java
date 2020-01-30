package com.rogerproj.collections;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.rogerproj.model.Phone;

//Lesson Learn  have a very strong compare / compareTo implementation for sorting and duplicate detection
//Internally node with node(Key,Value,Color)- Balanced tree implementation red- black algorithm
class PhoneCompatator implements Comparator<Phone>{

	@Override
	public int compare(Phone arg0, Phone arg1) {
		int result =-1;
		if(arg0.getSrNo()==arg1.getSrNo() &&
				arg0.getPhoneMake().equalsIgnoreCase(arg1.getPhoneMake()) &&
				arg0.getPhoneModel().equalsIgnoreCase(arg1.getPhoneModel())&&
				arg0.getPhonePrice()==arg1.getPhonePrice()){
			result= 0;
		}
		else if(arg0.getSrNo()>arg1.getSrNo()){
			result= 1;
			}
		else if(arg0.getSrNo()==arg1.getSrNo()){{
			if(arg0.getPhonePrice()>arg1.getPhonePrice())
				result= 1;
			}
		}
		return result;
	}
}

public class TreeMapExample {
	private static final Logger logNow = 	Logger.getLogger(Phone.class);

	public static void main(String[] args) {

		Phone phone1 =  new Phone(115,"Samusng note 10","Samsung",50000);
		Phone phone2 =  new Phone(101,"OnePlus 5T","OnePlus",35000);
		Phone phone3 =  new Phone(119,"Nokia 3310","Nokia",3310);
		Phone phone4 =  new Phone(145,"Samusng Galaxy","Samsung",45000);
		Phone phone5 =  new Phone(105,"iPhone 11","Apple",85000);
		Phone phone6 =  new Phone(119,"Nokia 3310","Nokia",3010);
		Phone phone7 =  new Phone(119,"Nokia 3310","Nokia",3010);

		TreeMap<Phone,String> phoneMap = new TreeMap<>(new PhoneCompatator());
		TreeMap<Phone,String> phoneMap_implClass = new TreeMap<>();

		phoneMap.put(phone1, "Samusng Note");
		phoneMap.put(phone2, "Oneplus 5T");
		phoneMap.put(phone3, "Nokia 3310");
		phoneMap.put(phone4, "Samusng Galay");
		phoneMap.put(phone5, "iPhone 11");
		phoneMap.put(phone6, "Nokia 3310_1");
		phoneMap.put(phone7, "Nokia 3310_2");

		phoneMap_implClass.put(phone7, "Nokia 3310_2");
		logNow.debug("The size of PhoneMap is " + phoneMap.size());

		Set<Entry<Phone,String>> setOfPhones= phoneMap.entrySet();
		for(Entry<Phone,String> entry : setOfPhones){
			logNow.debug("entry KEY=  " +entry.getKey());
			logNow.debug("entry VALUE=" +entry.getValue());
		}

		logNow.debug("phoneMap  firstEntry" + phoneMap_implClass.firstEntry());
		logNow.debug("phoneMap  lastEntry" + phoneMap_implClass.lastEntry());

		Set<Phone> phoneKeys = phoneMap.keySet();
		logNow.debug("The size of PhoneMap is " + phoneMap.size());
		logNow.debug("The value of PhoneMap key phone1 " + phoneMap.get(phone2));

		for(Phone phonek : phoneKeys){
			logNow.debug("phoneMap for key ="+phonek+ " Value =" + phoneMap.get(phonek));
		}
	}
}
