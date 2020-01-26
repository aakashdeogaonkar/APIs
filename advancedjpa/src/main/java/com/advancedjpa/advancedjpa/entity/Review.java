package com.advancedjpa.advancedjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="description")
	private String description;
	
	private String rating;
	
	protected Review() {
		
	}

	public Review(String description, String rating) {
		super();
		this.description = description;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "\n Review [id=" + id + ", description=" + description + ", rating=" + rating + "]";
	}
}
