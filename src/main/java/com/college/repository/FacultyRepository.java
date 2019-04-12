package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

	List<Faculty> findByEmail(String email);
	List<Faculty> findByMNumber(String mobileNumber);
	Faculty findByEmailAndPassword(String email, String pass);
	
}