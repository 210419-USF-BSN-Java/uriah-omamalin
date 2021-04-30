package com.shop.models.enums;

public enum UserType {
	CUSTOMER(0), EMPLOYEE(1), MANAGER(2);
	private final int value;
	private UserType(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}