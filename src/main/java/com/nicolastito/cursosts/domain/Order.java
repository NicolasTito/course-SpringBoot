package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "TB_ORDER")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date instant;

	@OneToOne (cascade = CascadeType.ALL, mappedBy="order")
	private Payment payment;

	@ManyToOne
	@JoinColumn (name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn (name = "ship_address_id")
	private Address shipAdress;


	public Order() {
	}

	public Order(Integer id, Date instant, Client client, Address shipAdress) {
		this.id = id;
		this.instant = instant;
		this.client = client;
		this.shipAdress = shipAdress;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return this.instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getShipAdress() {
		return this.shipAdress;
	}

	public void setShipAdress(Address shipAdress) {
		this.shipAdress = shipAdress;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Order)) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(id, order.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
