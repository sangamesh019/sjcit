package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.StudentResults;

@Repository
public interface StudentResultRepo extends JpaRepository<StudentResults, Long>{

//	List<StudentResults> find
	List<StudentResults> findByusn(String usn);
}
