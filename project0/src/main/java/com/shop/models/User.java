package com.shop.models;

import com.shop.models.enums.UserType;

public class User {
	private Integer id;
	private UserType userType;
	
	public User() { }
	public User(Integer id, UserType userType) {
		super();
		this.id = id;
		this.userType = userType;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserType() {
		return userType.getValue();
	}
	public void setUserType(int userType) {
		this.userType = UserType.values()[userType];
	}
}