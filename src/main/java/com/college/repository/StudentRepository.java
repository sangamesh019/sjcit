package com.college.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Student;
import java.lang.String;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByEmail(String name);
	List<Student> findByMNumber(String mnumber);
	
	@Override
	List<Student> findAll();
}