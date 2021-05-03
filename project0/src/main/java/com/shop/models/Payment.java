package com.shop.models;

import java.math.BigDecimal;

import com.shop.models.enums.PaymentPlan;

public class Payment {
	private Integer offerId;
	private PaymentPlan paymentPlan;
	private BigDecimal weeklyPayment;
	
	public Payment() { }
	public Payment(Integer offerId, PaymentPlan paymentPlan, BigDecimal weeklyPayment) {
		super();
		this.offerId = offerId;
		this.paymentPlan = paymentPlan;
		this.weeklyPayment = weeklyPayment;
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
	public BigDecimal getWeeklyPayment() {
		return weeklyPayment;
	}
	public void setWeeklyPayment(BigDecimal weeklyPayment) {
		this.weeklyPayment = weeklyPayment;
	}
	@Override
	public String toString() {
		return "payment on offer #" + offerId + ": " + (paymentPlan.getValue() + 1) + " weekly payment(s) of $" + weeklyPayment;
	}
}