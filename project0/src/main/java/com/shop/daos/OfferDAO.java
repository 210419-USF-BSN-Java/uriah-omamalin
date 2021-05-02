package com.shop.daos;

import java.util.List;

import com.shop.models.Offer;

public interface OfferDAO extends GenericDAO<Offer, Integer> {
	List<Offer> getOffersByStatusAndCustomerId(int status, int custId);
	int updateOfferStatus(Offer o, int status);
	List<Offer> getOffersByStatus(int i);
	List<Offer> getOffersByItemId(int itemId);
}