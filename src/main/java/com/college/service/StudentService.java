package com.college.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
	
	StuAssignment stuAssignment; 

	public Student signUpStudent(Student student) {
		if (!studentRepository.findByEmail(student.getEmail()).isEmpty()
				|| !studentRepository.findByMNumber(student.getmNumber()).isEmpty()) {
			throw new StudentException(
					"Email or mobile # id already exists " + student.getEmail() + "/ " + student.getmNumber());
		}
		Student save = studentRepository.save(student);
//		ResponseEntity<save>
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

	public String uploadAssignment(MultipartFile file) throws IOException {
		this.stuAssignment.setFileName(this.stuAssignment.getBranch() +"_"+ this.stuAssignment.getSem() +"_"+ this.stuAssignment.getSubject());
		this.stuAssignment.setData(file.getBytes());
		this.stuAssignment.setDocumentType(file.getContentType());
		StuAssignment s = assignmentRepository.saveAndFlush(this.stuAssignment);
		return "success";
	}
	
	public void uploadAssignmentDetails(StuAssignment stuAssignment) {
		this.stuAssignment = stuAssignment;
	}

	public List<StuAssignment> downloadAssignment(String fileName) {
		List<StuAssignment> s = assignmentRepository.findByFileName(fileName);
		return s;
	}
	
	public List<StuAssignment> listAllAssignment() {
		List<StuAssignment> listOfAssignResp = assignmentRepository.findAll();
		
//		List<StuAssignment> listOfAssign = new ArrayList<StuAssignment>();
		StuAssignment find = new StuAssignment();
		find.setBranch("EEE");
		find.setSem("1");
		
		List<StuAssignment> listOfAssign = listOfAssignResp.stream()
							.filter(assignmentFilter -> (assignmentFilter.getBranch().equals("EEE") && assignmentFilter.getSem().equals("1")))
							.collect(Collectors.toList());
		
//		listOfAssignResp.stream().forEach(assignment -> {
//			StuAssignment stuAssignment = new StuAssignment();
//			stuAssignment.setBranch(assignment.getBranch());
//			stuAssignment.setFileName(assignment.getFileName());
//			stuAssignment.setSem(assignment.getSem());
//			stuAssignment.setSubject(assignment.getSubject());
//			listOfAssign.add(stuAssignment);
//		});
		
		return listOfAssign;
	}
}
