package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.dto.FacultyProfile;

public interface FacEditprofile  extends JpaRepository<FacultyProfile, Long> {

	FacultyProfile findByEmail(String email);
	List<FacultyProfile> findAll();
}
