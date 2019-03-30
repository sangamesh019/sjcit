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
	
	public Student signUpStudent(Student student) {
		if (!studentRepository.findByEmail(student.getEmail()).isEmpty()
				|| !studentRepository.findByMNumber(student.getmNumber()).isEmpty()) {
			throw new StudentException(
					"Email or mobile # id already exists " + student.getEmail() + "/ " + student.getmNumber());
		}
		Student save = studentRepository.save(student);
		return save;
	}
	
	public Student signUpStudentPhoto(MultipartFile photo, String phNumber) throws IOException {
		List<Student> stuList = studentRepository.findByMNumber(phNumber);
		stuList.get(0).setPhoto(photo.getBytes());
		Student saveUpdate = studentRepository.save(stuList.get(0));
		return saveUpdate;
	}

	public List<Student> getStudent(String name) {
		List<Student> save = studentRepository.findByEmail(name);
		return save;
	}

	public List<Student> getAllStudent() {
		List<Student> save = studentRepository.findAll();
		return save;
	}

	public StuAssignment uploadAssignment(MultipartFile file, StuAssignment stuAssignment) throws IOException {
		stuAssignment.setFileName(stuAssignment.getBranch() +"_"+ stuAssignment.getSem() +"_"+ stuAssignment.getSubject());
		stuAssignment.setData(file.getBytes());
		stuAssignment.setDocumentType(file.getContentType());
		StuAssignment s = assignmentRepository.saveAndFlush(stuAssignment);
		
		return s;
	}

	public List<StuAssignment> downloadAssignment(String fileName) {
		List<StuAssignment> s = assignmentRepository.findByFileName(fileName);
		return s;
	}
	
	public List<StuAssignment> listAllAssignment() {
		List<StuAssignment> listOfAssignResp = assignmentRepository.findAll();

		StuAssignment find = new StuAssignment();
		find.setBranch("EEE");
		find.setSem("1");
		
		List<StuAssignment> listOfAssign = listOfAssignResp.stream()
							.filter(assignmentFilter -> (assignmentFilter.getBranch().equals("EEE") && assignmentFilter.getSem().equals("1")))
							.collect(Collectors.toList());		
		return listOfAssign;
	}
}
