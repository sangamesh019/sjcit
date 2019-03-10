package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.Dto.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}