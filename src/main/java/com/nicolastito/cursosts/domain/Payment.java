package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.nicolastito.cursosts.domain.enums.StatusPayment;

@Entity
@Inheritance (strategy = InheritanceType.JOINED )
public abstract class Payment implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer status;

	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Order order;

	public Payment() {
	}

	public Payment(Integer id, StatusPayment status, Order order) {
		this.id = id;
		this.status = status.getCod();
		this.order = order;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPayment getStatus() {
		return StatusPayment.toEnum(status);
	}

	public void setStatus(StatusPayment status) {
		this.status = status.getCod();
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Payment)) {
			return false;
		}
		Payment payment = (Payment) o;
		return Objects.equals(id, payment.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
