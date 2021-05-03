package com.shop.services;

import com.shop.models.Offer;
import com.shop.models.Payment;

public interface PaymentService {
	Payment getPaymentDetails(Offer o);
	void setUpPayment(Payment p);
}