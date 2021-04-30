package com.shop.models.enums;

public enum ItemStatus {
	AVAILABLE(0), SOLD(1);
	private final int value;
	private ItemStatus(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}