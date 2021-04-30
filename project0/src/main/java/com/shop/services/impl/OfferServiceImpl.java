package com.shop.services.impl;

import com.shop.daos.OfferDAO;
import com.shop.daos.impl.OfferDAOImpl;
import com.shop.models.Offer;
import com.shop.services.OfferService;

public class OfferServiceImpl implements OfferService {
	OfferDAO od = new OfferDAOImpl();
	@Override
	public Integer makeOffer(Offer offer) {
		return od.create(offer);
	}
}