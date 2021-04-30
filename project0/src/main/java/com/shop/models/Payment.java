package com.shop.models;

import com.shop.models.enums.PaymentPlan;

public class Payment {
	private Integer offerId;
	private PaymentPlan paymentPlan;
	
	public Payment() { }
	public Payment(Integer offerId, PaymentPlan paymentPlan) {
		super();
		this.offerId = offerId;
		this.paymentPlan = paymentPlan;
	}
	
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public int getPaymentPlan() {
		return paymentPlan.getValue();
	}
	public void setPaymentPlan(int paymentPlan) {
		this.paymentPlan = PaymentPlan.values()[paymentPlan];
	}
}