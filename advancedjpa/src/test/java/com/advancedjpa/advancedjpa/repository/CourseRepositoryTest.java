package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.advancedjpa.advancedjpa.AdvancedjpaApplication;
import com.advancedjpa.advancedjpa.entity.Course;

@SpringBootTest(classes=AdvancedjpaApplication.class)
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void findByIdTest() {
		Course course = repository.findById(6225);
		assertEquals("Cloud Computing", course.getName());		
	}

}
