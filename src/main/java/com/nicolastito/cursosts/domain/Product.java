package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;

	@JsonBackReference
	@ManyToMany
	@JoinTable (name = "PRODUCT_CATEGORY",
		joinColumns = @JoinColumn (name = "product_id"),
		inverseJoinColumns = @JoinColumn (name = "categoria_id")
		)
	private List<Categoria> categorias = new ArrayList<>();

	@OneToMany (mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();

	public Product() {
	}

	public List<Order> getOrders(){
		List<Order> list = new ArrayList<>();
		for (OrderItem x : items) {
			list.add(x.getOrder());
		}
		return list;
	}

	public Product(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<OrderItem> getItems() {
		return this.items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Product)) {
			return false;
		}
		Product product = (Product) o;
		return Objects.equals(id, product.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
