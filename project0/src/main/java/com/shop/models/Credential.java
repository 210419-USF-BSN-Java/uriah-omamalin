package com.shop.models;

public class Credential {
	private Integer id;
	private String userPass;
	
	public Credential() { }
	public Credential(Integer id, String userPass) {
		super();
		this.id = id;
		this.userPass = userPass;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}