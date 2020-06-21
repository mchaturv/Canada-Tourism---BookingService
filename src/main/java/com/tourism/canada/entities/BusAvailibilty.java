package com.tourism.canada.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tourism.canada.dto.AvailibiltyDTO;

@Entity
@Table(name="bus_availibilty")
public class BusAvailibilty {
	
	@EmbeddedId
    private AvalibilityIdentity identityId;
	
	@Column(name = "booked_seat")
	private int bookedSeat;

	/**
	 * 
	 */
	public BusAvailibilty() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param identityId
	 * @param bookedSeat
	 */
	public BusAvailibilty(AvalibilityIdentity identityId, int bookedSeat) {
		super();
		this.identityId = identityId;
		this.bookedSeat = bookedSeat;
	}
	
	

	/**
	 * @param availibityDTO
	 */
	public BusAvailibilty(AvailibiltyDTO availibiltyDTO) {
		super();
		this.identityId = new AvalibilityIdentity(availibiltyDTO.getJourneyDate());
	}

	/**
	 * @return the identityId
	 */
	public AvalibilityIdentity getIdentityId() {
		return identityId;
	}

	/**
	 * @param identityId the identityId to set
	 */
	public void setIdentityId(AvalibilityIdentity identityId) {
		this.identityId = identityId;
	}

	/**
	 * @return the bookedSeat
	 */
	public int getBookedSeat() {
		return bookedSeat;
	}

	/**
	 * @param bookedSeat the bookedSeat to set
	 */
	public void setBookedSeat(int bookedSeat) {
		this.bookedSeat = bookedSeat;
	}

	@Override
	public String toString() {
		return "BusAvailibilty [identityId=" + identityId + ", bookedSeat=" + bookedSeat + "]";
	}
	
	

}
