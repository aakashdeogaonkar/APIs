package com.advancedjpa.advancedjpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;

	public Employee() {
		super();
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n Employee [id=" + id + ", name=" + name + "]";
	}
	
}
