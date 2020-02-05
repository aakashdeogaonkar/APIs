package com.advancedjpa.advancedjpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
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
import com.advancedjpa.advancedjpa.entity.Passport;
import com.advancedjpa.advancedjpa.entity.Student;

@SpringBootTest(classes=AdvancedjpaApplication.class)
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentrepository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void findByStudentandPassportTest() {
		Student student = studentrepository.findById(20001);
		logger.info("Student with ID 20001 -> {}", student);
		logger.info("Passport Details of Student with ID 20001 -> {}",student.getPassport());
	}
	
	@Test
	@Transactional
	void updateStudentAndPassword() {
		Student student = studentrepository.findById(20002);
		
		Passport passport = student.getPassport();
		
		student.setName("Mike - Updated");
		
		passport.setNumber("B123456 - Updated");
		
		logger.info("Student's name with id 20002 -> {}", student);
		logger.info("Student's passport details with id 20002 -> {}", passport);
	}
	
	@Test
	@Transactional
	void retrievePassportDetailsAndStudentAssociatedTest() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("Passport with ID 40001 -> {}", passport);
		logger.info("Student Details of Passport with ID 40001 -> {}",passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndAssociatedCourse() {
		Student s1 = em.find(Student.class, 20001L);
		logger.info("Student with ID 20001 -> {}",s1);
		logger.info("Courses of Student with ID 20001 -> {}",s1.getCourses());
	}
	
	@Test
	@Transactional
	public void retrieveCourseAndAssociatedStudent() {
		Course c1 = em.find(Course.class, 6225L);
		logger.info("Course with id 6225 -> {}", c1);
		logger.info("Students of Course with ID 6225 -> {}", c1.getStudents());
	}
}
