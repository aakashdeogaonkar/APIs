package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository repository;

	@Test
	void findByIdTest() {
		Course course = repository.findById(6225);
		assertEquals("Cloud Computing", course.getName());		
	}
	
	@Test
	@DirtiesContext
	void deleteByIdTest() {
		repository.deleteById(5100);
		assertNull(repository.findById(5100));		
	}
	
	@Test
	@DirtiesContext
	void updateByIdTest() {
		Course course = repository.findById(1);
		assertEquals("BA", course.getName());
		
		course.setName("BA&I");
		repository.save(course);
		
		Course course1 = repository.findById(1);
		assertEquals("BA&I", course1.getName());
	}

}
