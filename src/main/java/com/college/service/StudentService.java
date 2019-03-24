package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.dto.Student;
import com.college.exeption.StudentException;
import com.college.repository.StudentRepository;

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student signUpStudent(Student student) {
		if(!studentRepository.findByEmail(student.getEmail()).isEmpty()){
			throw new StudentException("Emil id already exists "+ student.getEmail());
		}
		
		Student save = studentRepository.save(student);
		return save;
	}
	
	public List<Student> getStudent(String name) {
		List<Student> save = studentRepository.findByEmail(name);
		return save;
	}
	
	public List<Student> getAllStudent(String name) {
		List<Student> save = studentRepository.findAll();
		return save;
	}
}
