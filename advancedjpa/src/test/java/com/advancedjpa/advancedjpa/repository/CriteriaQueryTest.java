package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.advancedjpa.advancedjpa.AdvancedjpaApplication;
import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Student;

@SpringBootTest(classes=AdvancedjpaApplication.class)
class CriteriaQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void all_courses() {
		//1. Use criteria builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are invloved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates using Criteria Builder
		
		//4. Add Predicates to the criteria Query
		
		//5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);		
	}
	
	@Test
	void all_courses_with_and() {
		//1. Use criteria builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are invloved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates using Criteria Builder
		Predicate likec = cb.like(courseRoot.get("name"), "%and%");
		
		//4. Add Predicates to the criteria Query
		cq.where(likec);
		
		//5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query with and -> {}", resultList);		
	}
	
	@Test
	void all_courses_without_students() {
		//1. Use criteria builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are invloved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates using Criteria Builder
		Predicate empty = cb.isEmpty(courseRoot.get("students"));
		
		//4. Add Predicates to the criteria Query
		cq.where(empty);
		
		//5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Course without students -> {}", resultList);		
	}
	
	@Test
	void join() {
		//1. Use criteria builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are invloved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students");
		
		//4. Add Predicates to the criteria Query
		
		
		//5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Course without students -> {}", resultList);		
	}
	
	@Test
	void left_join() {
		//1. Use criteria builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define roots for tables which are invloved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define predicates using Criteria Builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		
		//4. Add Predicates to the criteria Query
		
		
		//5. Build the TypedQuery using the entity manager and criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Course without students -> {}", resultList);		
	}
}
