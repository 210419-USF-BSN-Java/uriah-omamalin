package com.shop.daos;

import java.util.List;

import com.shop.models.Payment;

public interface PaymentDAO extends GenericDAO<Payment, Integer> { 
	List<Payment> getAllPaymnets();
}