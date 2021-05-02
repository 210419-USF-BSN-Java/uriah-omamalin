package com.shop.services.impl;

import java.math.BigDecimal;
import java.util.List;

import com.shop.daos.ItemDAO;
import com.shop.daos.impl.ItemDAOImpl;
import com.shop.exceptions.BusinessException;
import com.shop.models.Item;
import com.shop.models.User;
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
	@Override
	public List<Item> getMySoaps(User user) {
		return itd.getItemsByOwnerId(user);
	}
	@Override
	public Integer addSoap(Item i) {
		return itd.create(i);
	}
	@Override
	public void deleteSoap(Item i) throws BusinessException {
		if (itd.delete(i.getId()) == 0) throw new BusinessException("soap deletion failed");
	}
	@Override
	public void updateSoapName(Item i, String s) throws BusinessException {
		i.setItemName(s);
		if (itd.updateName(i) == 0) throw new BusinessException("soap name edit failed");
	}
	@Override
	public void updateSoapPrice(Item i, BigDecimal d) throws BusinessException {
		i.setPrice(d);
		if (itd.updatePrice(i) == 0) throw new BusinessException("soap price edit failed");
	}
	@Override
	public Item getItemDetails(int id) {
		return itd.read(id);
	}
}