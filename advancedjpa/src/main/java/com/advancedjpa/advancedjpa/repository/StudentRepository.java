package com.advancedjpa.advancedjpa.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancedjpa.advancedjpa.entity.Passport;
import com.advancedjpa.advancedjpa.entity.Student;

@Transactional
@Repository
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
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

}
