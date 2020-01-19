package com.assignments;

public class Car {
	
	String carName="";
	String carType="";
	String ownerName="";
	int CarRegNo;
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getCarRegNo() {
		return CarRegNo;
	}
	public void setCarRegNo(int carRegNo) {
		CarRegNo = carRegNo;
	}
	
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carType=" + carType
				+ ", ownerName=" + ownerName + ", CarRegNo=" + CarRegNo + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CarRegNo;
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result
				+ ((ownerName == null) ? 0 : ownerName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		if (CarRegNo != other.CarRegNo) {
			return false;
		}
		if (carName == null) {
			if (other.carName != null) {
				return false;
			}
		} else if (!carName.equals(other.carName)) {
			return false;
		}
		if (carType == null) {
			if (other.carType != null) {
				return false;
			}
		} else if (!carType.equals(other.carType)) {
			return false;
		}
		if (ownerName == null) {
			if (other.ownerName != null) {
				return false;
			}
		} else if (!ownerName.equals(other.ownerName)) {
			return false;
		}
		return true;
	}
	
}
