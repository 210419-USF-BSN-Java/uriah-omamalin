package com.shop.models;

import java.math.BigDecimal;

import com.shop.models.enums.ItemStatus;

public class Item {
	private Integer id, ownerId;
	private String itemName;
	private BigDecimal price;
	private ItemStatus status;
	
	public Item() { }
	public Item(Integer id, Integer ownerId, String itemName, BigDecimal price, ItemStatus status) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.itemName = itemName;
		this.price = price;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStatus() {
		return status.getValue();
	}
	public void setStatus(int status) {
		this.status = ItemStatus.values()[status];
	}
	@Override
	public String toString() {
		return "soap #" + id + " " + itemName + ": selling for $" + price;
	}
}