package com.college.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.college.dto.Events;
import com.college.dto.Faculty;
import com.college.dto.FacultyProfile;
import com.college.dto.FacultySubject;
import com.college.dto.StuAssignment;
import com.college.dto.Student;
import com.college.dto.StudentResults;
import com.college.exeption.StudentException;
import com.college.repository.AssignmentRepository;
import com.college.repository.EventRepository;
import com.college.repository.FacEditprofile;
import com.college.repository.FacultyRepository;
import com.college.repository.FacultySubjectRepository;
import com.college.repository.StudentRepository;
import com.college.repository.StudentResultRepo;

@Component
public class StudentService {


	EntityManager em;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	FacultySubjectRepository facultySubjectRepository;
	
	@Autowired
	FacEditprofile facEditprofile;
	
	@Autowired
	StudentResultRepo studentResultRepo;
	
	@Autowired
	EventRepository uploadEventRepo;
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
		
		FacultyProfile facultyProfile = new FacultyProfile();
		facultyProfile.setEmail(faculty.getEmail());
		facultyProfile.setDesignation(faculty.getDesignation());
		facultyProfile.setmNumber(faculty.getmNumber());
		
		facEditprofile.save(facultyProfile);
		return save;
	}
	
	public StudentResults uploadResults(StudentResults res){
		StudentResults re = studentResultRepo.save(res);
		return re;
	}

	public FacultyProfile editFaculty(FacultyProfile faculty) {
		
		FacultyProfile editFacultyProfile = facEditprofile.findByEmail(faculty.getEmail());
		
		editFacultyProfile.setBloodGroup(faculty.getBloodGroup());
		editFacultyProfile.setDesignation(faculty.getDesignation());
		editFacultyProfile.setMaritalStatus(faculty.getMaritalStatus());
		editFacultyProfile.setmNumber(faculty.getmNumber());
		editFacultyProfile.setPaddress(faculty.getPaddress());
		editFacultyProfile.setTaddress(faculty.getTaddress());
		
		editFacultyProfile.setEducationDetailsX(faculty.getEducationDetailsX());
		editFacultyProfile.setEducationDetailsXII(faculty.getEducationDetailsXII());
		editFacultyProfile.setEducationDetailsDiploma(faculty.getEducationDetailsDiploma());
		editFacultyProfile.setEducationDetailsUG(faculty.getEducationDetailsUG());
		editFacultyProfile.setEducationDetailsPG(faculty.getEducationDetailsPG());
		editFacultyProfile.setEducationDetailsPHD(faculty.getEducationDetailsPHD());
		editFacultyProfile.setEducationDetailsOther1(faculty.getEducationDetailsOther1());
		editFacultyProfile.setEducationDetailsOther2(faculty.getEducationDetailsOther2());
		
		
		editFacultyProfile.setEmpDetails(faculty.getEmpDetails());
		
		editFacultyProfile.setExWorkshop(faculty.getExWorkshop());
		
		FacultyProfile save = facEditprofile.save(editFacultyProfile);
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
	public List<Student> getStudentByBranch(String branch) {
		List<Student> save = studentRepository.findByBranch(branch);
		return save;
	}
	
	public List<StudentResults> getStudentResults(String usn){
		List<StudentResults> res = studentResultRepo.findByusn(usn);
		return res;
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
	 * @param usn
	 * @return
	 */
	public List<Faculty> getFacultyList(String branch) {
		List<Faculty> save = facultyRepository.findByBranch(branch);
		return save;
	}
	
	/**
	 * 
	 * @param usn
	 * @return
	 */
	public List<Faculty> getAllFacultyList() {
		List<Faculty> save = facultyRepository.findAll();
		return save;
	}
	/**
	 * 
	 * @param usn
	 * @return
	 */
	public FacultySubject assignSubject(FacultySubject facultySubject) {
		FacultySubject save = facultySubjectRepository.save(facultySubject);
		return save;
	}
	
	public Events uploadEvents(Events event){
		return uploadEventRepo.save(event);
	}
	
	public List<Events> getAllEvents(){
		return uploadEventRepo.findAll();
	}
	
	public Events updateEvents(Events ev){
		Optional<Events> up = uploadEventRepo.findById(ev.getId());
		Events s = up.get();
		s.setAllowed(ev.getAllowed());
		return  uploadEventRepo.save(s);
	}
	

	/**
	 * 
	 * @param usn
	 * @return
	 */
	public List<FacultySubject> getSubjectAssigned(String branch, String facEmail) {
		List<FacultySubject> save = facultySubjectRepository.findByBranchAndFacEmail(branch,facEmail);
		return save;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Student> getAllStudent() {
		List<Student> save = studentRepository.findAll();
		return save;
	}

	public StuAssignment uploadAssignment(MultipartFile file, StuAssignment stuAssignment) throws StudentException, IOException {
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
	
	public List<StuAssignment> listAllAssignment(String branch, String sem) {
		List<StuAssignment> listOfAssignResp = assignmentRepository.findAll();

		StuAssignment find = new StuAssignment();
		find.setBranch(branch);
		find.setSem(sem);
		
		List<StuAssignment> listOfAssign = listOfAssignResp.stream()
							.filter(assignmentFilter -> (assignmentFilter.getBranch().equals(branch) && assignmentFilter.getSem().equals(sem)))
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
