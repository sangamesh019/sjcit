package com.college.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.dto.Student;
import com.college.dto.StudentResults;
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
	
	@PostMapping(value = "/signUpStudentPhoto", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Student> setStudentPhoto(@RequestParam("file") MultipartFile studentPhoto,
			@RequestParam("number") String studentNumber) throws IOException {
		Student status = service.signUpStudentPhoto(studentPhoto, studentNumber);
		return new ResponseEntity<Student>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/myDetailsStudent")
	public String getStudent() {
		return "";
	}

	@GetMapping(value = "/student/{usn}")
	public Student getStudent(@PathVariable String usn) {
		Student studs = service.getStudent(usn);
		return studs;
	}
	
	@GetMapping(value = "/studentBranch/{branch}")
	public List<Student> getStudentByBranch(@PathVariable String branch) {
		List<Student> studs = service.getStudentByBranch(branch);
		return studs;
	}
	
	@GetMapping(value = "/studentResults/{usn}")
	public List<StudentResults> studentResults(@PathVariable String usn) {
		List<StudentResults> studs = service.getStudentResults(usn);
		return studs;
	}
	
	@GetMapping(value = "/students")
	public List<Student> getAllStudent() {
		List<Student> studs = service.getAllStudent();
		return studs;
	}
	
	@PostMapping(value = "/loginUser")
	public boolean loginUser(@RequestParam("usn") String userName, @RequestParam("password") String password, @RequestParam("role") String role ){
		boolean response = false;
		if(role.equals("Student")){
			response = service.loginUser(userName, password);
		} else {
			response = service.loginFaculty(userName, password);
		}
		return response;
	}
}
