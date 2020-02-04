package com.advancedjpa.advancedjpa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.advancedjpa.advancedjpa.entity.Course;
import com.advancedjpa.advancedjpa.entity.Review;
import com.advancedjpa.advancedjpa.repository.CourseRepository;
import com.advancedjpa.advancedjpa.repository.StudentRepository;


@SpringBootApplication
public class AdvancedjpaApplication implements CommandLineRunner {
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	StudentRepository studrepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(AdvancedjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("Course with id 6225 -> {}", repository.findById(6225));
		// repository.deleteById(6225);
//		repository.save(new Course("Web Design and User Expeience"));
//		repository.save(new Course((long) 1, "BA"));
//		repository.entityManagerFunctions();
		
//		studrepository.saveStudentWithPassword();
		
//		repository.addHardCodedReviewsForCourse();
		List<Review> review = new ArrayList<>();
		review.add(new Review("Practical work", "4"));
		review.add(new Review("Great Teaching", "5"));
		
		repository.addReviewsForCourse(5100L, review);
	}

}
