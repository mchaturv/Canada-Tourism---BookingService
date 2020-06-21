package com.tourism.canada.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.tourism.canada.entities.BusAvailibilty;

@Component
public class AvailibiltyDTO {

	private int busId;
	
	private String busType;
	
	@NotNull(message ="journey date is Required")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Canada/Atlantic")
	@Temporal(TemporalType.DATE)
	private Date journeyDate;
	
	private int totalCapacity;
	
	private int numberOfSeatsLeft;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message ="source location is Required")
	private int sourceLocationId;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message ="destination location is Required")
	private int destinationLocationId;
	
	private double amount;

	/**
	 * 
	 */
	public AvailibiltyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param busId
	 * @param busType
	 * @param journeyDate
	 * @param totalCapacity
	 * @param numberOfSeatsLeft
	 */
	public AvailibiltyDTO(int busId, String busType, Date journeyDate, int totalCapacity, int numberOfSeatsLeft) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.journeyDate = journeyDate;
		this.totalCapacity = totalCapacity;
		this.numberOfSeatsLeft = numberOfSeatsLeft;
	}
	
	/**
	 * @param busId
	 * @param busType
	 * @param journeyDate
	 * @param totalCapacity
	 * @param numberOfSeatsLeft
	 */
	public AvailibiltyDTO(BusAvailibilty availibility) {
		this.busId = availibility.getIdentityId().getBusId().getBusId();
		this.busType = availibility.getIdentityId().getBusId().getBusType();
		
		this.journeyDate = availibility.getIdentityId().getOnDate();
		this.totalCapacity = availibility.getIdentityId().getBusId().getCapacity();
		this.numberOfSeatsLeft = this.totalCapacity-availibility.getBookedSeat();
		this.amount=availibility.getIdentityId().getBusId().getAmount();
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
	 * @return the journeyDate
	 */
	public Date getJourneyDate() {
		return journeyDate;
	}

	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	/**
	 * @return the totalCapacity
	 */
	public int getTotalCapacity() {
		return totalCapacity;
	}

	/**
	 * @param totalCapacity the totalCapacity to set
	 */
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	/**
	 * @return the numberOfSeatsLeft
	 */
	public int getNumberOfSeatsLeft() {
		return numberOfSeatsLeft;
	}

	/**
	 * @param numberOfSeatsLeft the numberOfSeatsLeft to set
	 */
	public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
		this.numberOfSeatsLeft = numberOfSeatsLeft;
	}
	
	

	

	/**
	 * @return the sourceLocationId
	 */
	public int getSourceLocationId() {
		return sourceLocationId;
	}

	/**
	 * @param sourceLocationId the sourceLocationId to set
	 */
	public void setSourceLocationId(int sourceLocationId) {
		this.sourceLocationId = sourceLocationId;
	}

	

	/**
	 * @return the destinationLocationId
	 */
	public int getDestinationLocationId() {
		return destinationLocationId;
	}

	/**
	 * @param destinationLocationId the destinationLocationId to set
	 */
	public void setDestinationLocationId(int destinationLocationId) {
		this.destinationLocationId = destinationLocationId;
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
		return "AvailibiltyDTO [busId=" + busId + ", busType=" + busType + ", journeyDate=" + journeyDate
				+ ", totalCapacity=" + totalCapacity + ", numberOfSeatsLeft=" + numberOfSeatsLeft
				+ ", sourceLocationId=" + sourceLocationId + ", destinationLocationId=" + destinationLocationId
				+ ", amount=" + amount + "]";
	}

	

	
	
	 
	
}
