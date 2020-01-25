package com.advancedjpa.advancedjpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime createdDate;
	
	@CreationTimestamp
	private LocalDateTime lastUpdatedDate;
	
	protected Course() {
		
	}
	
	public Course(String name) {
		this.name = name;
	}

	public Course(Long id, String name) {
		super();
		this.id = id;
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
		return "\n Course [id=" + id + ", name=" + name + "]";
	}
	
}
