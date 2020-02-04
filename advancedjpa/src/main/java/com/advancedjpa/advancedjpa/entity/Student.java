package com.advancedjpa.advancedjpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	private List<Course> courses = new ArrayList<>();
	
	protected Student() {
		
	}
	
	public Student(String name) {
		this.name = name;
	}

	public Student(Long id, String name) {
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course courses) {
		this.courses.add(courses);
	}
	
	public void removeCourses(Course courses) {
		this.courses.remove(courses);
	}

	@Override
	public String toString() {
		return "\n Student [id=" + id + ", name=" + name + "]";
	}
	
}
