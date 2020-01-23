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

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	// PersonDAO dao;
	PersonJPARepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		logger.info("User with id 101 -> {}", repository.findById(101));
		logger.info("Inserting -> {}", repository.insert(new Person("Raj", "LA", new Date(1) )));
		logger.info("Update where id = 102", repository.update(new Person(102, "Ta", "St Louis", new Date(1))));
		logger.info("All users -> {}", repository.getAll());
		repository.deleteById(100);
	}

}