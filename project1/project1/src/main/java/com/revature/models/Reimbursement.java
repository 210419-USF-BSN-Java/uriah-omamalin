package com.revature.models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

public class Reimbursement {
	int reimbId, reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId;
	BigDecimal reimbAmount;
	Date reimbSubmitted, reimbResolved;
	String reimbDescription;
	InputStream reimbReceipt;
	
	public Reimbursement() { }
	public Reimbursement(int reimbId, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimbTypeId,
			BigDecimal reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription,
			InputStream reimbReceipt) {
		super();
		this.reimbId = reimbId;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
	}
	
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public BigDecimal getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(BigDecimal reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Date reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Date getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Date reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public InputStream getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(InputStream reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
}