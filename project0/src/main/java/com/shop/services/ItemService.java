package com.shop.services;

import java.math.BigDecimal;
import java.util.List;

import com.shop.exceptions.BusinessException;
import com.shop.models.Item;
import com.shop.models.User;

public interface ItemService {
	List<Item> getAvailableSoaps();
	Item selectSoap(int id) throws BusinessException;
	List<Item> getMySoaps(User user);
	Integer addSoap(Item i);
	void deleteSoap(Item i) throws BusinessException;
	void updateSoapName(Item i, String s) throws BusinessException;
	void updateSoapPrice(Item i, BigDecimal d) throws BusinessException;
}