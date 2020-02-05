package com.advancedjpa.advancedjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Employee;
import com.advancedjpa.advancedjpa.entity.FullTimeEmployee;
import com.advancedjpa.advancedjpa.entity.PartTimeEmployee;
import com.advancedjpa.advancedjpa.entity.Review;

@Transactional
@Repository
public class EmployeeRepository {
	
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<PartTimeEmployee> getAllPartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> getAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	
	public void insertEmployees(Employee employee) {
		em.persist(employee);
	}
}
