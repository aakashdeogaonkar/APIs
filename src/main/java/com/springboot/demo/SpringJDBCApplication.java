package com.springboot.demo;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.demo.entity.Person;
import com.springboot.demo.jdbc.PersonDAO;
import com.springboot.demo.jpa.PersonJPARepository;

// @SpringBootApplication
public class SpringJDBCApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.getAll());	
		logger.info("User with id 101 -> {}", dao.findById(101));
		logger.info("User with name Ta -> {}", dao.findByName("Ta"));
		logger.info("User with name Diksha -> {}", dao.findByName("Diksha"));
		logger.info("Deleting 101 -> Rows Affected - {}", dao.deleteById(101));
		logger.info("Inserting 104 -> {}", dao.insert(new Person(104, "Raj", "LA", new Date(1) )));
		logger.info("Update where id = 102", dao.update(new Person(102, "Ta", "St Louis", new Date(1))));
	}

}