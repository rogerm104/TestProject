package com.rogerproj.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rogerproj.model.Node;
import com.rogerproj.model.Phone;
import com.rogerproj.serviceinterface.LinkedList;

public class LinkedListTest {
	LinkedList ll= new LinkedList();
	Node node=new Node();
	
	
@Test
	public void LinkedListTest(){
		assertEquals(true,ll.addNode(new Phone()));
	}
}
