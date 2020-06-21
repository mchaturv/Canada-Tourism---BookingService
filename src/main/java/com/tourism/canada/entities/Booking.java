package com.tourism.canada.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import com.tourism.canada.dto.BookingDTO;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")
	private Integer bookingId;

	@ManyToOne
	private City sourceCities;

	@ManyToOne
	private City destinationCities;

	@Temporal(TemporalType.DATE)
	@Column(name = "journey_date")
	private Date journeyDate;

	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name = "booking_date")
	private Date bookingDate;

	@Column(name = "no_of_seats")
	private int noOfSeats;

	@ManyToOne
	private Bus busId;

	// @JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	private User userDetails;

	private boolean isPaid;

	private double bookingAmount;

	/**
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookingId
	 */
	public Booking(Integer bookingId) {
		super();
		this.bookingId = bookingId;
	}

	/**
	 * @param bookingId
	 * @param sourceCities
	 * @param destinationCities
	 * @param journeyDate
	 * @param bookingDate
	 * @param noOfSeats
	 * @param busId
	 * @param userDetails
	 * @param isPaid
	 * @param bookingAmount
	 */
	public Booking(Integer bookingId, City sourceCities, City destinationCities, Date journeyDate, Date bookingDate,
			int noOfSeats, Bus busId, User userDetails, boolean isPaid, double bookingAmount) {
		super();
		this.bookingId = bookingId;
		this.sourceCities = sourceCities;
		this.destinationCities = destinationCities;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.noOfSeats = noOfSeats;
		this.busId = busId;
		this.userDetails = userDetails;
		this.isPaid = isPaid;
		this.bookingAmount = bookingAmount;
	}

	/**
	 * @param booking
	 */
	public Booking(BookingDTO bookingDTO) {
		super();
		this.bookingId = bookingDTO.getBookingId();
		this.sourceCities = new City(bookingDTO.getSourceLocationId());
		this.destinationCities = new City(bookingDTO.getDestinationLocationId());
		this.journeyDate = bookingDTO.getJourneyDate();
		this.bookingDate = bookingDTO.getBookingDate();
		this.noOfSeats = bookingDTO.getNoOfSeats();
		this.busId = new Bus(bookingDTO.getBusId(), bookingDTO.getBusType());
		this.userDetails = bookingDTO.getUserDetails();
		this.isPaid = bookingDTO.isPaid();
		this.bookingAmount = bookingDTO.getBookingAmount();
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
	 * @return the sourceCities
	 */
	public City getSourceCities() {
		return sourceCities;
	}

	/**
	 * @param sourceCities the sourceCities to set
	 */
	public void setSourceCities(City sourceCities) {
		this.sourceCities = sourceCities;
	}

	/**
	 * @return the destinationCities
	 */
	public City getDestinationCities() {
		return destinationCities;
	}

	/**
	 * @param destinationCities the destinationCities to set
	 */
	public void setDestinationCities(City destinationCities) {
		this.destinationCities = destinationCities;
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
	 * @return the busId
	 */
	public Bus getBusId() {
		return busId;
	}

	/**
	 * @param busId the busId to set
	 */
	public void setBusId(Bus busId) {
		this.busId = busId;
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
		return "Booking [bookingId=" + bookingId + ", sourceCities=" + sourceCities + ", destinationCities="
				+ destinationCities + ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate + ", noOfSeats="
				+ noOfSeats + ", busId=" + busId + ", isPaid=" + isPaid + ", bookingAmount=" + bookingAmount + "]";
	}

}
