package com.nicolastito.cursosts.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class City implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn (name = "state_id")
	private State state;


	public City() {
	}


	public City(Integer id, String name, State state) {
		this.id = id;
		this.name = name;
		this.state = state;
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

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof City)) {
			return false;
		}
		City city = (City) o;
		return Objects.equals(id, city.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
