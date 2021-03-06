package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nicolastito.cursosts.domain.enums.TypeClient;

@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String cpfOuCnpj;
	private Integer type;

	@JsonManagedReference
	@OneToMany (mappedBy = "client")
	private List<Address> addresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable (name = "phone")
	private Set<String> phones = new HashSet<>();

	@OneToMany (mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	public Client() {
	}

	public Client(Integer id, String name, String email, String cpfOuCnpj, TypeClient type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.type = type.getCod();
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return this.cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public TypeClient getType() {
		return TypeClient.toEnum(type);
	}

	public void setType(TypeClient type) {
		this.type = type.getCod();
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhones() {
		return this.phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Client)) {
			return false;
		}
		Client client = (Client) o;
		return Objects.equals(id, client.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}


