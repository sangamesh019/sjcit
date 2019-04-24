package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.FacultySubject;

@Repository
public interface FacultySubjectRepository extends JpaRepository<FacultySubject, Long>{

	List<FacultySubject> findByBranchAndFacEmail(String branch, String email);
}
