 package com.tourism.canada.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.tourism.canada.dto.TransactionDTO;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private Integer transactionId;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="transaction_amount")
	private Double transactionAmount;
	
	@Column(name="transaction_status")
	private Boolean transactionStatus;

	@OneToOne
	private Booking booking;
	
	@Column(name="cardNumber" , length = 20)
	private String cardNumber;

	/**
	 * 
	 */
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param transactionId
	 */
	public Transaction(Integer transactionId) {
		super();
		this.transactionId = transactionId;
	}



	/**
	 * @param transactionId
	 * @param transactionDate
	 * @param transactionAmount
	 * @param transactionStatus
	 * @param booking
	 * @param cardNumber
	 */
	public Transaction(Integer transactionId, Date transactionDate, Double transactionAmount, Boolean transactionStatus,
			Booking booking, String cardNumber) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
		this.booking = booking;
		this.cardNumber = cardNumber;
	}
	
	/**
	 * @param transactionDTO
	 */
	public Transaction(TransactionDTO transactionDTO) {
		super();
		this.transactionId = transactionDTO.getTransactionId();
		this.transactionDate = transactionDTO.getTransactionDate();
		this.transactionAmount = transactionDTO.getTransactionAmount();
		this.transactionStatus = transactionDTO.getTransactionStatus();
		this.booking = new Booking(transactionDTO.getBookingId());
		this.cardNumber = transactionDTO.getCardNumber();
	}

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the transactionAmount
	 */
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionStatus
	 */
	public Boolean getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(Boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", transactionStatus=" + transactionStatus + ", booking="
				+ booking + ", cardNumber=" + cardNumber + "]";
	}
	
	

	

}
