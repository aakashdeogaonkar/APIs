package com.springboot.demo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.Person;

@Repository
public class PersonDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> getAll() {
		return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from Person where id=?", new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findByName(String name) {
		return jdbcTemplate.queryForObject("select * from Person where name=?", new Object[] {name},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("Delete from Person where id=?", new Object[] {id});
	}
}

