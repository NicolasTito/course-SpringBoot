package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "TB_ORDERITEM")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IDOrderItemPK id = new IDOrderItemPK();

	private Double discount;
	private Integer amount;
	private Double price;


	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Double discount, Integer amount, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.discount = discount;
		this.amount = amount;
		this.price = price;
	}

	public Order getOrder(){
		return id.getOrder();
	}

	public Product getProduct(){
		return id.getProduct();
	}

	public IDOrderItemPK getId() {
		return this.id;
	}

	public void setId(IDOrderItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof OrderItem)) {
			return false;
		}
		OrderItem orderItem = (OrderItem) o;
		return Objects.equals(id, orderItem.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}
