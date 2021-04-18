package com.nicolastito.cursosts.domain;

import javax.persistence.Entity;

import com.nicolastito.cursosts.domain.enums.StatusPayment;

@Entity
public class PaymentWithCard extends Payment{
	private static final long serialVersionUID = 1L;

	private Integer numberOfPlots;

	public PaymentWithCard() {
	}

	public PaymentWithCard(Integer id, StatusPayment status, Order order, Integer numberOfPlots) {
		super(id, status, order);
		this.numberOfPlots = numberOfPlots;
	}

	public Integer getNumberOfPlots() {
		return this.numberOfPlots;
	}

	public void setNumberOfPlots(Integer numberOfPlots) {
		this.numberOfPlots = numberOfPlots;
	}
}
