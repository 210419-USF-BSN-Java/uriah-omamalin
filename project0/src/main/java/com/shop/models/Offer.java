package com.shop.models;

import java.math.BigDecimal;
import java.util.Date;

import com.shop.models.enums.OfferStatus;
import com.shop.services.ItemService;
import com.shop.services.UserService;
import com.shop.services.impl.ItemServiceImpl;
import com.shop.services.impl.UserServiceImpl;

public class Offer {
	private Integer id, customerId, itemId;
	private BigDecimal amount;
	private OfferStatus status;
	private Date dateTime;
	
	private UserService us = new UserServiceImpl();
	private ItemService is = new ItemServiceImpl();
	
	public Offer() { }
	public Offer(Integer id, Integer customerId, Integer itemId, BigDecimal amount, OfferStatus status, Date date) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
		this.amount = amount;
		this.status = status;
		this.dateTime = date;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status.getValue();
	}
	public void setStatus(int status) {
		this.status = OfferStatus.values()[status];
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date date) {
		this.dateTime = date;
	}
	@Override
	public String toString() {
		User u = new User();
		u.setId(customerId);
		Item i = is.getItemDetails(itemId);
		return "offer #" + id + " by " + 
			   us.getCustomerDetails(u).getFirstName() + " " + 
			   us.getCustomerDetails(u).getLastName() + " on soap " + 
			   i.getItemName() + " (market value $" + 
			   i.getPrice() + ") of $" + amount;
	}
}