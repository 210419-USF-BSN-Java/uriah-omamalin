package com.shop.services;

import java.util.List;

import com.shop.exceptions.BusinessException;
import com.shop.models.Item;

public interface ItemService {
	List<Item> getAvailableSoaps();
	Item selectSoap(int id) throws BusinessException;
}