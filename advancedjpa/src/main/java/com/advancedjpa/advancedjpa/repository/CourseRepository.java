package com.advancedjpa.advancedjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Review;

@Transactional
@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
	
	public void addHardCodedReviewsForCourse() {
		//getting the review
		Course c1 = findById(6250);
		logger.info("Reviews for course 6250 -> {}",c1.getReviews());
		
		//Adding Reviews
		Review review1 = new Review("Practical work", "4");
		Review review2 = new Review("Great Teaching", "5");
		
		//Setting review to course relationship
		c1.addReviews(review1);
		review1.setCourse(c1);
		
		c1.addReviews(review2);
		review2.setCourse(c1);
		
		//Save to database
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		//getting the review
		Course c1 = findById(courseId);
		logger.info("Reviews for course -> {}", c1.getReviews());
		
		for(Review review: reviews) {
			c1.addReviews(review);
			review.setCourse(c1);
			em.persist(review);
		}
	}

}
