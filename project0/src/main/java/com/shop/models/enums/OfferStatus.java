package com.shop.models.enums;

public enum OfferStatus {
	PENDING(0), ACCEPTED(1), REJECTED(2);
	private final int value;
	private OfferStatus(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}