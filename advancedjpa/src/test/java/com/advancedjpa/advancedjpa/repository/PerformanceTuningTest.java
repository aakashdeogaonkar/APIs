package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.advancedjpa.advancedjpa.AdvancedjpaApplication;
import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Review;

@SpringBootTest(classes=AdvancedjpaApplication.class)
class PerformanceTuningTest {
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	@Transactional
	void creatingNPlusOneProblem() {
		List<Course> course = em.createNamedQuery("query_getAllCourses", Course.class)
				.getResultList();
		for(Course courses: course) {
			logger.info("Course -> {}, Students -> {}", courses, courses.getStudents());
		}	
	}
	
	@Test
	@Transactional
	void solvingNPlusOneProblem_EntityGraph() {
		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		Subgraph<Object> addSubgraph = entityGraph.addSubgraph("students");
		
		List<Course> courses = em.createNamedQuery("query_getAllCourses", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph)
				.getResultList();
		for(Course course: courses) {
			logger.info("Course -> {}, Students -> {}", course, course.getStudents());
		}	
	}
	
	@Test
	@Transactional
	void solvingNPlusOneProblem_JoinFetch() {
		List<Course> course = em.createNamedQuery("query_getAllCourses_join_fetch", Course.class)
				.getResultList();
		for(Course courses: course) {
			logger.info("Course -> {}, Students -> {}", courses, courses.getStudents());
		}	
	}

}
