package com.college.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.dto.Student;
import com.college.service.StudentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/college")
public class StudentContoller {

	@Autowired
	StudentService service;

	@PostMapping(value = "/signUpStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> setStudent(@Valid @RequestBody Student student) {
		Student status = service.signUpStudent(student);
		return new ResponseEntity<Student>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/myDetailsStudent")
	public String getStudent() {
		return "";
	}

	@GetMapping(value = "/student/{email}")
	public List<Student> getStudent(@PathVariable String email) {
		List<Student> studs = service.getStudent(email);
		return studs;
	}
	
	@GetMapping(value = "/students")
	public List<Student> getAllStudent() {
		List<Student> studs = service.getAllStudent();
		return studs;
	}

	
}
