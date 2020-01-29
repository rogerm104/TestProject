package com.rogerproj.model;

import org.apache.log4j.Logger;

public class Phone implements Comparable<Object>{
	private int srNo;
	private String phoneModel;
	private String PhoneMake;
	private int  PhonePrice;

	private static final Logger logNow = 	Logger.getLogger(Phone.class);

	public Phone() {
		logNow.debug("Phone constructer called");
	}

	public Phone(int srNo, String phoneModel, String phoneMake,
			int phonePrice) {
		super();
		this.srNo = srNo;
		this.phoneModel = phoneModel;
		PhoneMake = phoneMake;
		PhonePrice = phonePrice;
	}

	/**
	 * @return the srNo
	 */
	public int getSrNo() {
		return srNo;
	}

	/**
	 * @param srNo the srNo to set
	 */
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	/**
	 * @return the phoneModel
	 */
	public String getPhoneModel() {
		return phoneModel;
	}

	/**
	 * @param phoneModel the phoneModel to set
	 */
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}

	/**
	 * @return the phoneMake
	 */
	public String getPhoneMake() {
		return PhoneMake;
	}

	/**
	 * @param phoneMake the phoneMake to set
	 */
	public void setPhoneMake(String phoneMake) {
		PhoneMake = phoneMake;
	}

	/**
	 * @return the phonePrice
	 */
	public int getPhonePrice() {
		return PhonePrice;
	}

	/**
	 * @param phonePrice the phonePrice to set
	 */
	public void setPhonePrice(int phonePrice) {
		PhonePrice = phonePrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Phone [srNo=" + srNo + ", phoneModel=" + phoneModel
				+ ", PhoneMake=" + PhoneMake + ", PhonePrice=" + PhonePrice
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((PhoneMake == null) ? 0 : PhoneMake.hashCode());
		result = prime * result + PhonePrice;
		result = prime * result
				+ ((phoneModel == null) ? 0 : phoneModel.hashCode());
		result = prime * result + srNo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (PhoneMake == null) {
			if (other.PhoneMake != null)
				return false;
		} else if (!PhoneMake.equals(other.PhoneMake))
			return false;
		if (PhonePrice != other.PhonePrice)
			return false;
		if (phoneModel == null) {
			if (other.phoneModel != null)
				return false;
		} else if (!phoneModel.equals(other.phoneModel))
			return false;
		if (srNo != other.srNo)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		int value=-1;
		if(this.srNo>((Phone)arg0).getSrNo()){
			value= 1;}
		else if(this.srNo==((Phone)arg0).getSrNo()){{
				if(this.PhonePrice>((Phone)arg0).getPhonePrice())
					value= 1;
			}
		}
		return value;
	}
}
