package com.college.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.college.dto.Faculty;
import com.college.dto.StuAssignment;
import com.college.dto.Student;
import com.college.exeption.StudentException;
import com.college.repository.AssignmentRepository;
import com.college.repository.FacultyRepository;
import com.college.repository.StudentRepository;

@Component
public class StudentService {


	EntityManager em;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	/**
	 * 
	 * @param student
	 * @return
	 */
	public Student signUpStudent(Student student) {
		if (!studentRepository.findByEmail(student.getEmail()).isEmpty()
				|| !studentRepository.findByMNumber(student.getmNumber()).isEmpty()) {
			throw new StudentException(
					"Email or mobile # id already exists " + student.getEmail() + "/ " + student.getmNumber());
		}
		Student save = studentRepository.save(student);
		return save;
	}
	
	/**
	 * 
	 * @param photo
	 * @param phNumber
	 * @return
	 * @throws IOException
	 */
	public Student signUpStudentPhoto(MultipartFile photo, String phNumber) throws IOException {
		List<Student> stuList = studentRepository.findByMNumber(phNumber);
		stuList.get(0).setPhoto(photo.getBytes());
		Student saveUpdate = studentRepository.save(stuList.get(0));
		return saveUpdate;
	}
	
	/**
	 * 
	 * @param faculty
	 * @return
	 */
	public Faculty signUpFaculty(Faculty faculty) {
		if (!facultyRepository.findByEmail(faculty.getEmail()).isEmpty()
				|| !facultyRepository.findByMNumber(faculty.getmNumber()).isEmpty()) {
			throw new StudentException(
					"Email or mobile # id already exists " + faculty.getEmail() + "/ " + faculty.getmNumber());
		}
		Faculty save = facultyRepository.save(faculty);
		return save;
	}
	
	/**
	 * 
	 * @param photo
	 * @param email
	 * @return
	 * @throws IOException
	 */
	public Faculty signUpFacPhoto(MultipartFile photo, String email) throws IOException {
		List<Faculty> stuList = facultyRepository.findByEmail(email);
		stuList.get(0).setPhoto(photo.getBytes());
		Faculty saveUpdate = facultyRepository.save(stuList.get(0));
		return saveUpdate;
	}

	/**
	 * 
	 * @param usn
	 * @return
	 */
	public Student getStudent(String usn) {
		Student save = studentRepository.findByUsn(usn);
		return save;
	}
	
	/**
	 * 
	 * @param usn
	 * @return
	 */
	public Faculty getFaculty(String email) {
		List<Faculty> save = facultyRepository.findByEmail(email);
		return save.get(0);
	}
	

	/**
	 * 
	 * @return
	 */
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
	
	public boolean loginUser(String usn, String pass){
		Student stu = studentRepository.findByUsnAndPassword(usn, pass);
		boolean result = (stu != null ? true : false);
		return result;
	}
	
	public boolean loginFaculty(String usn, String pass){
		Faculty stu = facultyRepository.findByEmailAndPassword(usn, pass);
		boolean result = (stu != null ? true : false);
		return result;
	}
	
	
	public boolean updateStudents(){
		em.createQuery("update Student set name = :name")
		.setParameter("active", true)
		.executeUpdate();
		return false;
	}
	
	/*public boolean updateStudent(String usn, String status){
		studentRepository.updateStatus(usn, status);
		return false;
	}*/
}
