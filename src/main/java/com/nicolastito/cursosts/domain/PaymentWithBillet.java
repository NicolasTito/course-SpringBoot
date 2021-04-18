package com.nicolastito.cursosts.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.nicolastito.cursosts.domain.enums.StatusPayment;

@Entity
public class PaymentWithBillet extends Payment {
	private static final long serialVersionUID = 1L;

	@Temporal (TemporalType.DATE)
	private Date expirationDate;
	@Temporal (TemporalType.DATE)
	private Date paymentDate;

	public PaymentWithBillet() {
	}

	public PaymentWithBillet(Integer id, StatusPayment status, Order order, Date expirationDate, Date paymentDate) {
		super(id, status, order);
		this.expirationDate = expirationDate;
		this.paymentDate = paymentDate;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
