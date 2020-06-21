/**
 * 
 */
package com.tourism.canada.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mayank
 *
 */

@Entity
@Table(name = "bus")
public class Bus {
	

	@Id
	@Column(name="bus_id")
	int busId;
	
	@Column(name="bus_type")
	String busType;
	
	@Column(name="capacity")
	int capacity;
	
	@Column
	double amount;

	/**
	 * 
	 */
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param busId
	 * @param busType
	 * @param capacity
	 */
	public Bus(int busId, String busType, int capacity) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.capacity = capacity;
	}
	
	/**
	 * @param busId
	 * @param busType
	 * @param capacity
	 */
	public Bus(int busId, String busType) {
		super();
		this.busId = busId;
		this.busType = busType;
	}
	
	

	/**
	 * @param busId
	 */
	public Bus(int busId) {
		super();
		this.busId = busId;
	}

	/**
	 * @return the busId
	 */
	public int getBusId() {
		return busId;
	}

	/**
	 * @param busId the busId to set
	 */
	public void setBusId(int busId) {
		this.busId = busId;
	}

	/**
	 * @return the busType
	 */
	public String getBusType() {
		return busType;
	}

	/**
	 * @param busType the busType to set
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", capacity=" + capacity + ", amount=" + amount + "]";
	}

	
	
	

}
