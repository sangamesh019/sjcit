package com.college.service;

import org.springframework.stereotype.Component;

import com.college.Dto.Student;

@Component
public class StudentService {

	public String signUpStudent(Student student) {
		return student.getlName();
	}
}
