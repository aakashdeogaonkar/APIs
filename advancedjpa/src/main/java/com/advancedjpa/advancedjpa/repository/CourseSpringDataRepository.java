package com.advancedjpa.advancedjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.advancedjpa.advancedjpa.entity.Course;
import java.lang.String;
import java.util.List;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

	List<Course> findByName(String name);
	
	List<Course> deleteByName(String name);
	
	List<Course> findByNameAndId(String name, Long id);
}
