package com.shop.services;

import java.util.List;

import com.shop.models.Offer;
import com.shop.models.Payment;

public interface PaymentService {
	Payment getPaymentDetails(Offer o);
	void setUpPayment(Payment p);
	List<Payment> getAllPayments();
}