package com.college.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.dto.Student;
import com.college.service.StudentService;

@RestController
@RequestMapping(value = "/college")
public class StudentContoller {

	@Autowired
	StudentService service;

	@PostMapping(value = "/signUpStudent")
	public ResponseEntity<Student> setStudent(@Valid @RequestBody Student student) {
		Student status = service.signUpStudent(student);
		return new ResponseEntity<Student>(status, HttpStatus.ACCEPTED);
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

	
}
