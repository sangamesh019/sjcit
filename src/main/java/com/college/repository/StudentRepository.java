package com.college.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.college.dto.Student;
import java.lang.String;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByEmail(String name);
	Student findByUsn(String usn);
	List<Student> findByMNumber(String mnumber);
	List<Student> findByBranch(String branch);
	
	@Override
	List<Student> findAll();
	
	Optional<List<Student>> findByEmailAndMNumber(String email, String nbr);
	Student findByUsnAndPassword(String usn, String password);
	
//	@Modifying
//    @Query("UPDATE student c SET c.active = :status WHERE c.usn = :usn")
//    int updateStatus(@Param("usn") String usn, @Param("status") String status);
}