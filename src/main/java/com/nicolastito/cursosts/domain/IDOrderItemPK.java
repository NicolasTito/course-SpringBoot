package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class IDOrderItemPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn (name = "idOrder_id")
	private Order idOrder;
	@ManyToOne
	@JoinColumn (name = "product_id")
	private Product product;


	public Order getOrder() {
		return this.idOrder;
	}

	public void setOrder(Order order) {
		this.idOrder = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof IDOrderItemPK)) {
			return false;
		}
		IDOrderItemPK orderItemPK = (IDOrderItemPK) o;
		return Objects.equals(idOrder, orderItemPK.idOrder) && Objects.equals(product, orderItemPK.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrder, product);
	}
}
