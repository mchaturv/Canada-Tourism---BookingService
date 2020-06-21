package com.tourism.canada.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Embeddable
public class AvalibilityIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@OneToOne
	@JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
	private Bus busId;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "on_date")
	private Date onDate;

	/**
	 * @param busId
	 * @param onDate
	 */
	public AvalibilityIdentity(@NotNull Bus busId, @NotNull Date onDate) {
		super();
		this.busId = busId;
		this.onDate = onDate;
	}

	/**
	 * @param onDate
	 */
	public AvalibilityIdentity(@NotNull Date onDate) {
		super();
		this.onDate = onDate;
	}

	/**
	 * 
	 */
	public AvalibilityIdentity() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the onDate
	 */
	public Date getOnDate() {
		return onDate;
	}

	/**
	 * @param onDate the onDate to set
	 */
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	@Override
	public String toString() {
		return "AvalibilityIdentity [busId=" + busId + ", onDate=" + onDate + "]";
	}

}
