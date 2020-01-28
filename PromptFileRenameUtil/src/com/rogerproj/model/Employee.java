package com.rogerproj.model;

import org.apache.log4j.Logger;

import com.rogerproj.collections.ListExample;

public class Employee {
	private int empID;
	private String empName;
	private String empDesg;
	private String empManager;
	private static final Logger logNow = 	Logger.getLogger(ListExample.class);

	public Employee(int empID,String empName,String empDesg,String empManager){
		this.empID=empID;
		this.empName= empName;
		this.empDesg=empDesg;
		this.empManager=empManager;	
		
		logNow.debug("Employee constructor called !");
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}
	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the empDesg
	 */
	public String getEmpDesg() {
		return empDesg;
	}
	/**
	 * @param empDesg the empDesg to set
	 */
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	/**
	 * @return the empManager
	 */
	public String getEmpManager() {
		return empManager;
	}
	/**
	 * @param empManager the empManager to set
	 */
	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName
				+ ", empDesg=" + empDesg + ", empManager=" + empManager + "]";
	}

}
