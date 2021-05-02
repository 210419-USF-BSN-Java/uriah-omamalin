package com.shop.services;

import java.util.List;

import com.shop.exceptions.BusinessException;
import com.shop.models.Offer;

public interface OfferService {
	Integer makeOffer(Offer offer);
	List<Offer> getPendingOffers();
	List<Offer> getAcceptedOffersByCustomerId(int id);
	List<Offer> getRejectedOffersByCustomerId(int id);
	Offer selectOffer(int id) throws BusinessException;
	void acceptOffer(Offer offer) throws BusinessException;
	void rejectOffer(Offer offer) throws BusinessException;
}