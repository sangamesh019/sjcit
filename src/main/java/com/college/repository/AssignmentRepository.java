package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.StuAssignment;

@Repository
public interface AssignmentRepository  extends JpaRepository<StuAssignment, Long> {

}
