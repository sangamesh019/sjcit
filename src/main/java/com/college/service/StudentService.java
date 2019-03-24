package com.college.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.dto.StuAssignment;
import com.college.dto.Student;
import com.college.exeption.StudentException;
import com.college.repository.AssignmentRepository;
import com.college.repository.StudentRepository;

@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AssignmentRepository assignmentRepository;

	public Student signUpStudent(Student student) {
		if (!studentRepository.findByEmail(student.getEmail()).isEmpty()
				|| studentRepository.findByMNumber(student.getmNumber()).isEmpty()) {
			throw new StudentException(
					"Email or mobile # id already exists " + student.getEmail() + "/ " + student.getmNumber());
		}

		Student save = studentRepository.save(student);
		return save;
	}

	public List<Student> getStudent(String name) {
		List<Student> save = studentRepository.findByEmail(name);
		return save;
	}

	public List<Student> getAllStudent() {
		List<Student> save = studentRepository.findAll();
		return save;
	}

	public String uploadAssignment(StuAssignment stuAssignment) {
		StuAssignment s = assignmentRepository.saveAndFlush(stuAssignment);
		return "";
	}

	public List<StuAssignment> downloadAssignment(String fileName) {
		List<StuAssignment> s = assignmentRepository.findByFileName(fileName);
		System.out.println(s);
		return s;
	}
	
	public List<StuAssignment> listAllAssignment() {
		List<StuAssignment> listOfAssignResp = assignmentRepository.findAll();
		
		List<StuAssignment> listOfAssign = new ArrayList<StuAssignment>();
		listOfAssignResp.stream().forEach(assignment -> {
			StuAssignment stuAssignment = new StuAssignment();
			stuAssignment.setBranch(assignment.getBranch());
			stuAssignment.setFileName(assignment.getFileName());
			stuAssignment.setSem(assignment.getSem());
			stuAssignment.setSubject(assignment.getSubject());
			listOfAssign.add(stuAssignment);
		});
		
		return listOfAssign;
	}
}
