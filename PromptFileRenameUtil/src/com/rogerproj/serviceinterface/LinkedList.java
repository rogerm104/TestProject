package com.rogerproj.serviceinterface;

import org.apache.log4j.Logger;

import com.rogerproj.model.Node;
import com.rogerproj.model.Phone;

public class LinkedList {

	Node currentNodes;
	private static final Logger logNow = 	Logger.getLogger(LinkedList.class);

	public boolean addNode(Phone data){
		boolean result =false;
		Node newNode = new Node();
		newNode.Data=data;
		newNode.next=null;

		if(currentNodes==null){
			currentNodes=newNode;
			result=true;
		}else{
			Node node = currentNodes;
			while(node.next!=null){
				node=node.next;
			}
			node.next= newNode;
			result=true;
		}
		return result;
	}

	public void DisplayAll(){
		Node n =currentNodes;
		do{
			logNow.debug("The current data is "+ n.Data);
			n=n.next;
		}
		while(n.next!=null);
		logNow.debug("The current data is "+ n.Data);

	}
}
