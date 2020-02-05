package com.advancedjpa.advancedjpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Passport;
import com.advancedjpa.advancedjpa.entity.Student;

@Transactional
@Repository
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Student findById(long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public Student save(Student student) {
		if(student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}
	
	public void saveStudentWithPassword() {
		Passport passport = new Passport("D123456");
		em.persist(passport);
		
		Student student = new Student("Sam");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void insertStudentAndCourseHardCodedValue() {
		Student s1 = new Student("Sansa");
		Course c1 = new Course("Agile Software Development");
		
		em.persist(s1);
		em.persist(c1);
		
		s1.addCourses(c1);
		c1.addStudents(s1);
		
		em.persist(s1);
	}
	
	public void insertStudentandCourse(Student student, Course course) {
		student.addCourses(course);
		course.addStudents(student);
		
		em.persist(student);
		em.persist(course);
	}

}
