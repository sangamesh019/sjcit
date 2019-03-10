package com.college.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.Dto.Faculty;
import com.college.Dto.Student;
import com.college.repository.StudentRepository;
import com.college.service.StudentService;

@RestController
public class SContoller {

	@Autowired
	StudentService service;
	
	/*@Autowired
	StudentRepository studentRepository;*/

	@PostMapping(value = "/signUpStudent")
	public Student setStudent(@Valid @RequestBody Student student) {
		Student status = service.signUpStudent(student);
		return status;
	}

	@PostMapping(value = "/signUpFaculty")
	public String setFaculty(@RequestBody Faculty faculty) {
		System.out.println(faculty.getfName());
		return "faculty";
	}
}
