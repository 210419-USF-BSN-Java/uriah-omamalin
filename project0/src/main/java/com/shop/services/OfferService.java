package com.shop.services;

import java.util.List;

import com.shop.exceptions.BusinessException;
import com.shop.models.Offer;
import com.shop.models.User;

public interface OfferService {
	Integer makeOffer(Offer offer);
	List<Offer> getPendingOffers();
	List<Offer> getAcceptedOffersByCustomerId(int id);
	List<Offer> getRejectedOffersByCustomerId(int id);
	Offer selectPendingOffer(int id) throws BusinessException;
	Offer selectAcceptedOffer(int id, User u) throws BusinessException;
	void acceptOffer(Offer offer) throws BusinessException;
	void rejectOffer(Offer offer) throws BusinessException;
}