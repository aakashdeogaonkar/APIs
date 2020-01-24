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

@SpringBootTest(classes=AdvancedjpaApplication.class)
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void jpqlTest() {
		Query query = em.createQuery("Select c from Course c");
		List resultList = query.getResultList();
		logger.info("Select c from Course c -> {}", resultList);		
	}
	
	@Test
	void jpqlTyped_Test() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		List resultList = query.getResultList();
		logger.info("(Typed)Select c from Course c -> {}", resultList);		
	}
	
	@Test
	void jpqlWhere_Test() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c WHERE name like '% JS'", Course.class);
		List resultList = query.getResultList();
		logger.info("Select c from Course c WHERE name like '%JS' -> {}", resultList);		
	}

}
