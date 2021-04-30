package com.shop.models.enums;

public enum PaymentPlan {
	WHOLE(0), TWOWK(1), FOURWK(2), SIXTEENWK(3);
	private final int value;
	private PaymentPlan(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}