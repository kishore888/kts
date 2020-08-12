package com.hospitality.core;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.Date;


/**
 * The persistent class for the transaction_details database table.
 * 
 */
@Entity
@Table(name="transaction_details")
@NamedQuery(name="TransactionDetails.findAll", query="SELECT t FROM TransactionDetails t")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class TransactionDetails extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transaction_details_id")
	private String transactionDetailsId;

	private Float amount;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reservation_id")
	private Reservation reservation;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transaction_id")
	private Transaction transaction;

	public TransactionDetails() {
	}

	public String getTransactionDetailsId() {
		return transactionDetailsId;
	}

	public void setTransactionDetailsId(String transactionDetailsId) {
		this.transactionDetailsId = transactionDetailsId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}