package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String logradouro;
	private String number;
	private String complemento;
	private String bairro;
	private String cep;

	private Client client;


	public Address() {
	}

	public Address(Integer id, String logradouro, String number, String complemento, String bairro, String cep, Client client) {
		this.id = id;
		this.logradouro = logradouro;
		this.number = number;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.client = client;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Address)) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(id, address.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}
