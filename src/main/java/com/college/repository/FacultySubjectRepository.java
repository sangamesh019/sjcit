package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.FacultySubject;

@Repository
public interface FacultySubjectRepository extends JpaRepository<FacultySubject, Long>{

}
