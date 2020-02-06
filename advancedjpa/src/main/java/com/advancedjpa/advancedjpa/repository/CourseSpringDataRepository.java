package com.advancedjpa.advancedjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advancedjpa.advancedjpa.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

}
