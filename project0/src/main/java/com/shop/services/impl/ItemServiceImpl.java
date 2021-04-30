package com.shop.services.impl;

import java.util.List;

import com.shop.daos.ItemDAO;
import com.shop.daos.impl.ItemDAOImpl;
import com.shop.exceptions.BusinessException;
import com.shop.models.Item;
import com.shop.services.ItemService;

public class ItemServiceImpl implements ItemService {
	ItemDAO itd = new ItemDAOImpl();
	@Override
	public List<Item> getAvailableSoaps() {
		return itd.getAvailableItems();
	}
	@Override
	public Item selectSoap(int id) throws BusinessException {
		Item i = itd.read(id);
		if (i != null) {
			if (i.getStatus() == 0) return i;
			else throw new BusinessException("that soap is not available");
		} else throw new BusinessException("that soap does not exist");
	}
}