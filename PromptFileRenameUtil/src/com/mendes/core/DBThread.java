package com.mendes.core;

import java.util.Date;

import org.apache.log4j.Logger;

public class DBThread implements Runnable{

	private static boolean isRunning= false; 
	private static final Logger logNow = 	Logger.getLogger(DBThread.class);
	private static Thread threadHandler = null;
	private static long ThreadID = -1;
	private static int TIME_INTERVAL = 30*1000;
	private static String boxID = "1";


	private static DBThread DBThreadInstance;

	/**
	 * @return the dBThreadInstance
	 */
	public static  DBThread getDBThreadInstance() {
		if(DBThreadInstance==null){
			logNow.debug("**Creating new DBThread singleton instance ");
			DBThreadInstance= new DBThread();
		}
		return DBThreadInstance;
	}
	public boolean init(String _boxID){
		boolean result =false;
		if(boxID.trim().isEmpty()){
			result=false;
			logNow.error("boxID is Empty ");
		}else {
			boxID=_boxID;
			try{
				if(!isRunning){
				threadHandler = new Thread(this);
				threadHandler.setName("dbServiceThread");
				threadHandler.start();			
				logNow.debug("boxID is  "+boxID);
				logNow.debug("*** Thread has officially Started! ***");
				result=true;
				}else{
					logNow.error("*** Thread is already runnning ***");
					result=false;
				}
				
			}catch(Exception e){
				logNow.error("##### Could not start Thread #######"+e.getStackTrace());
				result=false;
			}
		}
		return result;
	}

	private DBThread() {
		super();
		// do not Create my object
	}
	public void getStatus(){
		logNow.debug("Get Status called at  "+ new Date()+ " and  isRunning status is - " +isRunning);
	}

	@Override
	public void run() {
		isRunning=true;
		ThreadID = threadHandler.getId();
		logNow.debug("<><><>Thread Started at "+ new Date()+ " with Thread id - " +ThreadID +"<><><>");
		do{
			try {
				logNow.debug("Thread is Sleeping at ["+ new Date()+ "]"+ " Box ID "+ boxID);
				Thread.sleep(TIME_INTERVAL);
				logNow.debug("Thread is waking up at ["+ new Date()+  "]"+ " Box ID "+ boxID);
			} catch (InterruptedException e) {
				logNow.error("**Thread is running at "+ new Date()+" Exception "+e.getStackTrace());
				e.printStackTrace();
			}
		}while(isRunning);
	}
}
