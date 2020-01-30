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

	public Phone DeleteNode(Phone data){
		Node thisNodes =currentNodes;
		Node PreviousNode= null;
		Node NextNextNode= null;

		boolean found=false;
		if(data instanceof Phone){
			if(thisNodes!=null){
				while(thisNodes.next!=null && !found){
					if(thisNodes.Data.equals(data)){
						found=true;
						if(PreviousNode==null && thisNodes.next==null){
							//this is the only node in the
							currentNodes=null;
							logNow.debug("Removed the only element in the LinkedList , Linked list is empty now!");
						}else if(PreviousNode==null & thisNodes.next!=null) {
							thisNodes.next=null;
						}else if(PreviousNode!=null) {
							//get the next-next node
							PreviousNode.next=NextNextNode;
						}
					}
					PreviousNode=thisNodes.next;
					thisNodes=thisNodes.next;
				}
				//ToDo when while finished executing
				NextNextNode=  thisNodes.next;

			}else {
				logNow.debug("No data in LinkedList");
			}

		}else {
			logNow.debug("Data is not instance of Phone/ invalid data");
		}
		return null;

	}
}

//n0|n1|n2|n3|n4
//case 1 //n0.next=n2 [n.data = n+2]
//case 2 //n0 is the only element[[ just set current node to null]]
//case 3 //n0 is the last entry  [Previous node set next =null]
