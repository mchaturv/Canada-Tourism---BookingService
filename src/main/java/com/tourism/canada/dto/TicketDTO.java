package com.tourism.canada.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.tourism.canada.entities.Ticket;
@Component
public class TicketDTO {
	
	private Integer ticketId;

	@Override
	public String toString() {
		return "TicketDTO [ticketId=" + ticketId + ", transactionId=" + transactionId + ", documentPath=" + documentPath
				+ "]";
	}


	@NotNull(message = "Transaction Id is required")
	//@NotBlank(message = "Transaction Id is required")
	private Integer transactionId;

	@NotNull(message = "Path is required")
	private String documentPath;
	/**
	 * 
	 */
	public TicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TicketDTO(Integer transactionId, Integer ticketId, String documentPath) {
		super();
		this.transactionId = transactionId;
		this.ticketId = ticketId;
		this.documentPath = documentPath;
	}

	public TicketDTO(Ticket ticket) {
		super();
		this.ticketId = ticket.getTicketId();
		this.documentPath = ticket.getDocument();
		this.transactionId = ticket.getTransaction().getTransactionId();
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	public String getDocumentPath() {
		return documentPath;
	}


	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

}
