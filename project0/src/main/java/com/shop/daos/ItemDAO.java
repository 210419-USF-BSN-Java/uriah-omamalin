package com.shop.daos;

import java.util.List;

import com.shop.models.Item;

public interface ItemDAO extends GenericDAO<Item, Integer> {
	List<Item> getAvailableItems();
}