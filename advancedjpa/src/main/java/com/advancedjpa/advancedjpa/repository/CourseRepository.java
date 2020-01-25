package com.advancedjpa.advancedjpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancedjpa.advancedjpa.entity.Course;

@Transactional
@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}
	
	public void entityManagerFunctions() {
		Course course1 = new Course("Angular JS");
		em.persist(course1);
		// em.flush();
		
		Course course2 = new Course("React JS");
		em.persist(course2);
		
		em.flush();
		
		//em.clear();
		
		course1.setName("Angular JS - Updated");
		// em.flush();
		
		// em.detach(course2);
		
		course2.setName("React JS - Updated");
		
		em.refresh(course1);
		
		em.flush(); 
		
		Course course3 = findById(6225);
		course3.setName("Advanced Cloud Computing");
	}

}
