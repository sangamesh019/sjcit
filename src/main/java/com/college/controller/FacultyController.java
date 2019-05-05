package com.college.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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

import com.college.dto.Events;
import com.college.dto.Faculty;
import com.college.dto.FacultyProfile;
import com.college.dto.FacultySubject;
import com.college.dto.StuAssignment;
import com.college.dto.StudentResults;
import com.college.exeption.StudentException;
import com.college.service.StudentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/college")
public class FacultyController {

	@Autowired
	StudentService service;

	@PostMapping(value = "/signUpFaculty", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Faculty> setStudent(@Valid @RequestBody Faculty faculty) {
		Faculty status = service.signUpFaculty(faculty);
		return new ResponseEntity<Faculty>(status, HttpStatus.OK);
	}

	@PostMapping(value = "/editFaculty", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacultyProfile> editFaculty(@Valid @RequestBody FacultyProfile faculty) {
		FacultyProfile status = service.editFaculty(faculty);
		return new ResponseEntity<FacultyProfile>(status, HttpStatus.OK);
	}
		
	@PostMapping(value = "/uploadResults", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResults> uploadResults(@Valid @RequestBody StudentResults results) {
		StudentResults status = service.uploadResults(results);
		return new ResponseEntity<StudentResults>(status, HttpStatus.OK);
	}

	@PostMapping(value = "/signUpFacultyPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Faculty> setStudentPhoto(@RequestParam("file") MultipartFile facPhoto,
			@RequestParam("email") String facEmail) throws IOException {
		Faculty status = service.signUpFacPhoto(facPhoto, facEmail);
		return new ResponseEntity<Faculty>(status, HttpStatus.OK);
	}

	@GetMapping(value = "/faculty/{email}")
	public Faculty getStudent(@PathVariable String email) {
		Faculty studs = service.getFaculty(email);
		return studs;
	}
	
	@GetMapping(value = "/facultyEdit/{email}")
	public FacultyProfile getFacProfile(@PathVariable String email) {
		FacultyProfile studs = service.getFacultyProfile(email);
		return studs;
	}

	@GetMapping(value = "/facultList/{branch}")
	public List<Faculty> getfacultyList(@PathVariable String branch) {
		List<Faculty> facList = service.getFacultyList(branch);
		return facList;
	}

	@GetMapping(value = "/facultList")
	public List<Faculty> getAllfacultyList() {
		List<Faculty> facList = service.getAllFacultyList();
		return facList;
	}

	@PostMapping(value = "/assignFacultySubject", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacultySubject> assignFacultySubject(@RequestBody FacultySubject sub) {
		FacultySubject subj = service.assignSubject(sub);
		return new ResponseEntity<FacultySubject>(subj, HttpStatus.OK);
	}
	
	@PostMapping(value = "/uploadEvents", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Events> uploadEvents(@RequestBody Events event) {
		Events subj = service.uploadEvents(event);
		return new ResponseEntity<Events>(subj, HttpStatus.OK);
	}
	

	@PostMapping(value = "/updateEvents", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Events> updateEvents(@RequestBody Events event) {
		Events subj = service.updateEvents(event);
		return new ResponseEntity<Events>(subj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllEvents")
	public ResponseEntity<List<Events>> getAllEvents() {
		List<Events> subj = service.getAllEvents();
		return new ResponseEntity<List<Events>>(subj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSubjectAssigned/{branch}/{email}")
	public ResponseEntity<List<FacultySubject>> getSubjectAssigned(@PathVariable String branch,
			@PathVariable String email) {
		List<FacultySubject> subj = service.getSubjectAssigned(branch, email);
		return new ResponseEntity<List<FacultySubject>>(subj, HttpStatus.OK);
	}

	@PostMapping(value = "/uploadAssignment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<StuAssignment> uploadAssignment(@RequestParam("file") MultipartFile file,
			@RequestParam("type") String type, @RequestParam("branch") String branch, @RequestParam("sem") String sem,
			@RequestParam("subject") String subject, @RequestParam("section") String section)
			throws StudentException, IOException {
		StuAssignment assignment = new StuAssignment();
		assignment.setBranch(branch);
		assignment.setSem(sem);
		assignment.setSubject(subject);
		assignment.setSection(section);
		assignment.setType(type);

		String mimeType = file.getContentType();
		if (!mimeType.contains("pdf")) {
			throw new StudentException("file format exception");
		}

		StuAssignment assignment1 = service.uploadAssignment(file, assignment);
		return new ResponseEntity<StuAssignment>(assignment1, HttpStatus.OK);
	}

	@GetMapping(value = "/downloadAssignment/{file}")
	public ResponseEntity<ByteArrayResource> DownloadAssignment(@PathVariable("file") String file) throws IOException {
		StuAssignment assignment = service.downloadAssignment(file).get(0);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(assignment.getDocumentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + assignment.getFileName() + "\"")
				.body(new ByteArrayResource(assignment.getData()));
	}

	@GetMapping(value = "/listAllAssignments/{branch}/{sem}")
	public List<StuAssignment> listAllAssignment(@PathVariable("branch") String branch, @PathVariable("sem") String sem)
			throws IOException {
		List<StuAssignment> assignment = service.listAllAssignment(branch, sem);
		return assignment;
	}

	@PostMapping(value = "/uploadResults", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadResults(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("g:/testFileupload/" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "File is upload successfully";
	}
	
	
}
