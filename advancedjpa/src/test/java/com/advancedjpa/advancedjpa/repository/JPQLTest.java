package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void jpqlTest() {
		Query query = em.createNamedQuery("query_getAllCourses");
		List resultList = query.getResultList();
		logger.info("Select c from Course c -> {}", resultList);		
	}
	
	@Test
	void jpqlTyped_Test() {
		TypedQuery<Course> query = em.createNamedQuery("query_getAllCourses", Course.class);
		List resultList = query.getResultList();
		logger.info("(Typed)Select c from Course c -> {}", resultList);		
	}
	
	@Test
	void jpqlWhere_Test() {
		TypedQuery<Course> query = em.createNamedQuery("query_getnamelike%JS", Course.class);
		List resultList = query.getResultList();
		logger.info("Select c from Course c WHERE name like '%JS' -> {}", resultList);		
	}
	
	@Test
	void courses_without_students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Courses without Students -> {}", resultList);
	}
	
	@Test
	void courses_withatleasttwo_students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Courses with at least 2 Students -> {}", resultList);
	}
	
	@Test
	void courses_ordered_by_students() {
		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Courses ordered by students -> {}", resultList);
	}
	
	@Test
	void students_with_passport_certain_order() {
		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%1234%'", Student.class);
		List<Student> resultList = query.getResultList();
		logger.info("Students with passport 1234 -> {}", resultList);
	}
	
	@Test
	void join_coursewithstudent() {
		Query query = em.createQuery("select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result size -> {}",resultList.size());
		
		for(Object[] result: resultList) {
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}
	
	@Test
	void left_join_coursewithstudent() {
		Query query = em.createQuery("select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result size -> {}",resultList.size());
		
		for(Object[] result: resultList) {
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}
	
	@Test
	void cross_join_coursewithstudent() {
		Query query = em.createQuery("select c,s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result size -> {}",resultList.size());
		
		for(Object[] result: resultList) {
			logger.info("Course{} Student{}", result[0], result[1]);
		}
	}

}
