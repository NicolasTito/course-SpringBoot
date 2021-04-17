package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@JsonManagedReference
	@ManyToMany (mappedBy = "categorias")
	private List<Product> products = new ArrayList<>();

	public Categoria(){
	}

	public Categoria(Integer id, String name) {
		this.id = id;
		this.name = name;
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


	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
		public boolean equals(Object o) {
				if (o == this)
						return true;
				if (!(o instanceof Categoria)) {
						return false;
				}
				Categoria categoria = (Categoria) o;
				return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
