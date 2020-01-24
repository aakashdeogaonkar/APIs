package com.advancedjpa.advancedjpa.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancedjpa.advancedjpa.entity.Course;


@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(long id) {
		return em.find(Course.class, id);
	}

}
