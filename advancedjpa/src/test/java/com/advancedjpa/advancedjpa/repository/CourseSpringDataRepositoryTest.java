package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.advancedjpa.advancedjpa.AdvancedjpaApplication;
import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Review;

@SpringBootTest(classes=AdvancedjpaApplication.class)
class CourseSpringDataRepositoryTest {
	
	@Autowired
	CourseSpringDataRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void coursePresent() {
		Optional<Course> findById = repository.findById(6225L);
	}
	
	@Test
	public void insertAndUpdateCourse() {
		Course course = new Course("SpringBoot");
		repository.save(course);
		
		course.setName("SpringBoot - Updated");
		repository.save(course);
		logger.info("Course -> {}", course.getName());
		
		logger.info("All Courses -> {}", repository.findAll());
	}
	
	@Test
	public void pagination() {
		PageRequest pageOne = PageRequest.of(0, 9);
		Page<Course> firstPage = repository.findAll(pageOne);
		logger.info("Page 1 -> {}",firstPage.getContent());
		
		Pageable pageTwo = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(pageTwo);
		logger.info("Page 2 -> {}",secondPage.getContent());
	}

}
