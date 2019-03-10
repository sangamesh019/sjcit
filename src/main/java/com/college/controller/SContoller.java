package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.college.Dto.Faculty;
import com.college.Dto.Student;
import com.college.service.StudentService;

@RestController
public class SContoller {

	@Autowired
	StudentService service;
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String getName(){
		return "Sangamesh";
	}
	
	@GetMapping(value = "/error")
	public String getError(){
		return "Sangamesh";
	}
	
	@PostMapping(value = "/signUpStudent")
	public String setStudent(@RequestBody Student student){
		System.out.println(student.getParentsDetails().getFatherName());
		String status = service.signUpStudent(student);
		return status;
	}
	
	@PostMapping(value = "/signUpFaculty")
	public String setFaculty(@RequestBody Faculty faculty){
		System.out.println(faculty.getfName());
//		String status = service.signUpStudent(student);
		return "faculty";
	}
}
