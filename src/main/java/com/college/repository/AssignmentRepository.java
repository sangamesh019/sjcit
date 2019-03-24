package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.dto.StuAssignment;


public interface AssignmentRepository  extends JpaRepository<StuAssignment, Long> {

}
