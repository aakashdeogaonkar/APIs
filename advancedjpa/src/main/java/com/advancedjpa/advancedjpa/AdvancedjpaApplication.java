package com.advancedjpa.advancedjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.repository.CourseRepository;


@SpringBootApplication
public class AdvancedjpaApplication implements CommandLineRunner {
	
	@Autowired
	CourseRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(AdvancedjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Course with id 6225 -> {}", repository.findById(6225));
		// repository.deleteById(6225);
		repository.save(new Course("Web Design and User Expeience"));
		repository.save(new Course((long) 1, "BA"));
		repository.entityManagerFunctions();
	}

}
