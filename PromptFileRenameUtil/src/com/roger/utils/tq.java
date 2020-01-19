package com.roger.utils;

 class resource{
	 static int  resourceID;

	public int getResourceID() {
		System.out.println(" Get "+resourceID);
		return resourceID;
	}

	public   void  setResourceID() {
		resourceID++;
		System.out.println(" Set "+resourceID);
	}
	 
}


public class tq   {
	public static void main(String[] args) throws InterruptedException{
		 final resource rs = new resource();
	
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				for (int i=0;i<10000;i++){
					rs.setResourceID();
					rs.getResourceID();
					}		
				
			}
		}
				);
		
		
	Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				resource rs = new resource();

				for (int i=0;i<100;i++){
					rs.setResourceID();
					rs.getResourceID();
					}				
			}
		}
				);	
		
		
		
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
	}

	
	
	
	
	}
	
	