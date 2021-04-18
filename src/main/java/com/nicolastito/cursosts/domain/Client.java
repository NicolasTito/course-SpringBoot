package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.nicolastito.cursosts.domain.enums.TypeClient;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private String cpfOuCnpj;
	private Integer type;

	private List<Address> addresses = new ArrayList<>();

	private Set<String> phone = new HashSet<>();

	private City city;

	public Client() {
	}

	public Client(Integer id, String name, String email, String cpfOuCnpj, TypeClient type, City city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.type = type.getCod();
		this.city = city;
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

	public Set<String> getPhone() {
		return this.phone;
	}

	public void setPhone(Set<String> phone) {
		this.phone = phone;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
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


