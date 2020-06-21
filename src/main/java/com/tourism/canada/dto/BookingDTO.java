package com.tourism.canada.dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.tourism.canada.entities.Booking;
import com.tourism.canada.entities.User;

@Component
public class BookingDTO {

	private Integer bookingId;

	@NotNull(message = "Journey date is Required")
	@Temporal(TemporalType.DATE)
	@JsonProperty(value = "journeyDate")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Canada/Atlantic")
	private Date journeyDate;

	@CreatedDate
	@DateTimeFormat(style = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Canada/Atlantic")
	private Date bookingDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	// @JsonIgnore
	private User userDetails;

	private String sourceLocation;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "source location is Required")
	private int sourceLocationId;

	private String destinationLocation;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "destination location is Required")
	private int destinationLocationId;

	@NotNull(message = "bus id is Required")
	private int busId;

	private String busType;

	@NotNull(message = "Number of seat to be booked is Required")
	private int noOfSeats;

	private boolean isPaid;

	private double bookingAmount;

	/**
	 * 
	 */
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookingId
	 * @param journeyDate
	 * @param bookingDate
	 * @param userDetails
	 * @param sourceLocation
	 * @param sourceLocationId
	 * @param destinationLocation
	 * @param destinationLocationId
	 * @param busId
	 * @param busType
	 * @param noOfSeats
	 * @param isPaid
	 */
	public BookingDTO(Integer bookingId, @NotNull(message = "Journey date is Required") Date journeyDate,
			Date bookingDate, User userDetails, String sourceLocation, int sourceLocationId, String destinationLocation,
			int destinationLocationId, int busId, String busType, int noOfSeats, boolean isPaid, double amount) {
		super();
		this.bookingId = bookingId;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.userDetails = userDetails;
		this.sourceLocation = sourceLocation;
		this.sourceLocationId = sourceLocationId;
		this.destinationLocation = destinationLocation;
		this.destinationLocationId = destinationLocationId;
		this.busId = busId;
		this.busType = busType;
		this.noOfSeats = noOfSeats;
		this.isPaid = isPaid;
		this.bookingAmount = amount;
	}

	/**
	 * @param bookingId
	 * @param journeyDate
	 * @param bookingDate
	 * @param userDetails
	 * @param sourceLocation
	 * @param destinationLocation
	 * @param busId
	 * @param busType
	 * @param noOfSeats
	 * @param isPaid
	 */
	public BookingDTO(Booking booking) {
		super();
		this.bookingId = booking.getBookingId();
		this.journeyDate = booking.getJourneyDate();
		this.bookingDate = booking.getBookingDate();
		this.userDetails = booking.getUserDetails();
		this.sourceLocation = booking.getSourceCities().getCityName();
		this.destinationLocation = booking.getDestinationCities().getCityName();
		this.busId = booking.getBusId().getBusId();
		this.busType = booking.getBusId().getBusType();
		this.noOfSeats = booking.getNoOfSeats();
		this.isPaid = booking.isPaid();
		this.bookingAmount = booking.getBookingAmount();
	}

	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
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
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the userDetails
	 */
	public User getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the sourceLocation
	 */
	public String getSourceLocation() {
		return sourceLocation;
	}

	/**
	 * @param sourceLocation the sourceLocation to set
	 */
	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	/**
	 * @return the destinationLocation
	 */
	public String getDestinationLocation() {
		return destinationLocation;
	}

	/**
	 * @param destinationLocation the destinationLocation to set
	 */
	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
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
	 * @return the noOfSeats
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}

	/**
	 * @param noOfSeats the noOfSeats to set
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	/**
	 * @return the isPaid
	 */
	public boolean isPaid() {
		return isPaid;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
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
	 * @return the bookingAmount
	 */
	public double getBookingAmount() {
		return bookingAmount;
	}

	/**
	 * @param bookingAmount the bookingAmount to set
	 */
	public void setBookingAmount(double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate
				+ ", userDetails=" + userDetails + ", sourceLocation=" + sourceLocation + ", destinationLocation="
				+ destinationLocation + ", busId=" + busId + ", busType=" + busType + ", noOfSeats=" + noOfSeats
				+ ", isPaid=" + isPaid + "]";
	}

}
