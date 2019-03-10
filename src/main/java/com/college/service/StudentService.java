package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.Dto.Student;
import com.college.repository.StudentRepository;

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student signUpStudent(Student student) {
		Student save = studentRepository.save(student);
		return save;
	}
}
