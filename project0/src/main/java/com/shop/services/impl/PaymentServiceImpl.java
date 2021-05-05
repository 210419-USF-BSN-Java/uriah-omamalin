package com.shop.services.impl;

import java.util.List;

import com.shop.daos.OfferDAO;
import com.shop.daos.PaymentDAO;
import com.shop.daos.impl.OfferDAOImpl;
import com.shop.daos.impl.PaymentDAOImpl;
import com.shop.models.Offer;
import com.shop.models.Payment;
import com.shop.services.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	PaymentDAO pd = new PaymentDAOImpl();
	OfferDAO od = new OfferDAOImpl();
	@Override
	public Payment getPaymentDetails(Offer o) {
		return pd.read(o.getId());
	}
	@Override
	public void setUpPayment(Payment p) {
		pd.create(p);
		Offer o = new Offer();
		o.setId(p.getOfferId());
		o.setHasPlan(true);
		od.updateOfferPaymentStatus(o);
	}
	@Override
	public List<Payment> getAllPayments() {
		return pd.getAllPaymnets();
	}
}