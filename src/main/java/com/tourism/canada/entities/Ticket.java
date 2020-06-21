package com.tourism.canada.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tourism.canada.dto.TicketDTO;

@Entity
@Table(name="ticket")

public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="document")
	private String document;
	
	@OneToOne
	private Transaction transaction;
	
	public Integer getTicketId() {
		return ticketId;
	}

	public Ticket(Integer ticketId, String document, Transaction transaction) {
		super();
		this.ticketId = ticketId;
		this.document = document;
		this.transaction = transaction;
	}

	public Ticket(TicketDTO ticketDTO) {
		super();
		this.ticketId = ticketDTO.getTicketId();
		this.document = ticketDTO.getDocumentPath();
		this.transaction = new Transaction(ticketDTO.getTransactionId());
	}
	
	public String getDocument() {
		return document;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", document=" + document + ", transaction=" + transaction + "]";
	}
	
	public Ticket() {
		
	}	
}
