package com.shop.daos;

import java.util.List;

import com.shop.models.Item;
import com.shop.models.User;

public interface ItemDAO extends GenericDAO<Item, Integer> {
	List<Item> getAvailableItems();
	List<Item> getItemsByOwnerId(User user);
	int updateName(Item item);
	int updatePrice(Item item);
	int updateStatusAndOwner(Item item);
}