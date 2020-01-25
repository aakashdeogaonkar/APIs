package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

@SpringBootTest(classes=AdvancedjpaApplication.class)
class NativeTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	void nativeTest() {
		Query query = em.createNativeQuery("Select * from Course", Course.class);
		List resultList = query.getResultList();
		logger.info("Select * from Course -> {}", resultList);		
	}
	
	@Test
	void positionalNative_Test() {
		Query query = em.createNativeQuery("Select * from Course where id = ?", Course.class);
		query.setParameter(1, 6225);
		List resultList = query.getResultList();
		logger.info("Select * from Course where id = ?  -> {}", resultList);		
	}
	
	@Test
	void namedNative_Test() {
		Query query = em.createNativeQuery("Select * from Course where id = :id", Course.class);
		query.setParameter("id", 3);
		List resultList = query.getResultList();
		logger.info("Select * from Course where id = :id  -> {}", resultList);		
	}

	@Test
	@Transactional
	void updateNative_Test() {
		Query query = em.createNativeQuery("Update Course set last_updated_date=sysdate()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("Update Course set last_updated_date=sysdate()  -> {}", noOfRowsUpdated);		
	}
}
