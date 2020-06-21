package com.tourism.canada.dto;

import java.util.Date;

import javax.annotation.RegEx;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tourism.canada.entities.Transaction;

public class TransactionDTO {
	
	private Integer transactionId;
	
	@CreatedDate
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Canada/Atlantic")
	private Date transactionDate;
	
	@NotNull(message = "Payment Amount is required")
	//@NotBlank(message = "Payment Amount is required")
	private Double transactionAmount;
	
	private Boolean transactionStatus;

	@NotNull(message = "Booking Id is required")
	//@NotBlank(message = "Booking Id is required")
	private int bookingId;


	@NotNull(message = "card Number is required")
	@NotBlank(message = "card Number is required")
	@Size(min = 10, max = 16,  message = "Card Number should be in 10 to 16")
	@Pattern(regexp = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
        "(?<mastercard>5[1-5][0-9]{14})|" +
        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
        "(?<amex>3[47][0-9]{13})|" +
        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$", message = "Please enter a valid card number")
	@CreditCardNumber(ignoreNonDigitCharacters = true, message ="Please enter a valid card number")
	@LuhnCheck(startIndex = 0, endIndex = Integer.MAX_VALUE, checkDigitIndex = -1 , message = "Please enter a valid card number")
	private String cardNumber;


	/**
	 * 
	 */
	public TransactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param transactionId
	 * @param transactionDate
	 * @param transactionAmount
	 * @param transactionStatus
	 * @param bookingId
	 * @param cardNumber
	 */
	public TransactionDTO(Integer transactionId, Date transactionDate,
			@NotNull(message = "Payment Amount is required") @NotBlank(message = "Payment Amount is required") Double transactionAmount,
			Boolean transactionStatus,
			@NotNull(message = "Booking Id is required") @NotBlank(message = "Booking Id is required") int bookingId,
			@NotNull(message = "Booking Id is required") @NotBlank(message = "Booking Id is required") String cardNumber) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
		this.bookingId = bookingId;
		this.cardNumber = cardNumber;
	}
	
	
	/**
	 * @param transaction
	 */
	public TransactionDTO(Transaction transaction) {
		super();
		this.transactionId = transaction.getTransactionId();
		this.transactionDate = transaction.getTransactionDate();
		this.transactionAmount = transaction.getTransactionAmount();
		this.transactionStatus = transaction.getTransactionStatus();
		this.bookingId = transaction.getBooking().getBookingId();
		this.cardNumber = transaction.getCardNumber();
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
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}


	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
		return "TransactionDTO [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", transactionStatus=" + transactionStatus
				+ ", bookingId=" + bookingId + ", cardNumber=" + cardNumber + "]";
	}
	
	

}
