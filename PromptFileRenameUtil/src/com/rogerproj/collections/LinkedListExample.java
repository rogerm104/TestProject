package com.rogerproj.collections;

import org.apache.log4j.Logger;

import com.rogerproj.exception.ExceptionHandler;
import com.rogerproj.model.Phone;
import com.rogerproj.serviceinterface.LinkedList;

public class LinkedListExample extends ExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9046894651764059899L;
	private static final Logger logNow = 	Logger.getLogger(LinkedListExample.class);

	public static void main(String[] args) {
		Phone phone1 =  new Phone(115,"Samusng note 10","Samsung",50000);
		Phone phone2 =  new Phone(101,"OnePlus 5T","OnePlus",35000);
		Phone phone3 =  new Phone(119,"Nokia 3310","Nokia",3310);
		
		LinkedList myList =  new LinkedList();
		logNow.debug("Adding node Result = "+myList.addNode(phone1) );
		logNow.debug("Adding node Result = "+myList.addNode(phone2) );
		logNow.debug("Adding node Result = "+myList.addNode(phone3) );
		myList.DisplayAll();

	}
}
