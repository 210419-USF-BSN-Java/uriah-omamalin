package com.shop.services.impl;

import java.util.List;

import com.shop.daos.ItemDAO;
import com.shop.daos.OfferDAO;
import com.shop.daos.impl.ItemDAOImpl;
import com.shop.daos.impl.OfferDAOImpl;
import com.shop.exceptions.BusinessException;
import com.shop.models.Item;
import com.shop.models.Offer;
import com.shop.services.OfferService;

public class OfferServiceImpl implements OfferService {
	OfferDAO od = new OfferDAOImpl();
	ItemDAO id = new ItemDAOImpl();
	@Override
	public Integer makeOffer(Offer offer) {
		return od.create(offer);
	}
	@Override
	public List<Offer> getPendingOffers() {
		return od.getOffersByStatus(0);
	}
	@Override
	public List<Offer> getAcceptedOffersByCustomerId(int id) {
		return od.getOffersByStatusAndCustomerId(1, id);
	}
	@Override
	public List<Offer> getRejectedOffersByCustomerId(int id) {
		return od.getOffersByStatusAndCustomerId(2, id);
	}
	@Override
	public Offer selectPendingOffer(int id) throws BusinessException {
		Offer o = od.read(id);
		if (o != null) {
			if (o.getStatus() == 0) return o;
			else throw new BusinessException("that offer is not pending");
		} else throw new BusinessException("that offer does not exist");
	}
	public Offer selectAcceptedOffer(int id) throws BusinessException {
		Offer o = od.read(id);
		if (o != null) {
			if (o.getStatus() == 1) return o;
			else throw new BusinessException("that offer is not accepted");
		} else throw new BusinessException("that offer does not exist");
	}
	@Override
	public void acceptOffer(Offer offer) throws BusinessException {
		if (od.updateOfferStatus(offer, 1) == 0) throw new BusinessException("failed to accept offer");
		else {
			offer.setHasPlan(false);
			od.updateOfferPaymentStatus(offer);
			Item i = new Item();
			i.setId(offer.getItemId());
			i.setStatus(1);
			i.setOwnerId(offer.getCustomerId());
			id.updateStatusAndOwner(i);
			List<Offer> li = od.getOffersByItemId(offer.getItemId());
			for (Offer o : li) {
				if (offer.getId() != o.getId())
					rejectOffer(o);
			}
		}
	}
	@Override
	public void rejectOffer(Offer offer) throws BusinessException {
		if (od.updateOfferStatus(offer, 2) == 0) throw new BusinessException("failed to reject offer");
	}
}