package com.advancedjpa.advancedjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="number")
	private String number;
	
	protected Passport() {
		
	}

	public Passport(String number) {
		super();
		this.number = number;
	}
	
	public Passport(Long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "\n Passport [id=" + id + ", number=" + number + "]";
	}
	
}
