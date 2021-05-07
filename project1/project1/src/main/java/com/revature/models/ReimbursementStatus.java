package com.revature.models;

public enum ReimbursementStatus {
	PENDING(1), APPROVED(2), DENIED(3);
	
	private final int value;
	private ReimbursementStatus(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}