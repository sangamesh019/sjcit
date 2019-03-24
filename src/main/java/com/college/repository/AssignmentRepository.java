package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.StuAssignment;
import java.lang.String;
import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<StuAssignment, Long> {
	
	List<StuAssignment> findByFileName(String filename);
	List<StuAssignment> findByBranch(String branch);
	
	@Override
	List<StuAssignment> findAll();
}
