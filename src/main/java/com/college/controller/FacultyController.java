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

import com.college.dto.Faculty;
import com.college.dto.StuAssignment;
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
	
	@PostMapping(value = "/signUpFacultyPhoto", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
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
	
	@PostMapping(value = "/uploadAssignment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<StuAssignment> uploadAssignment(@RequestParam("file") MultipartFile file, 
			@RequestParam("type") String type,
			@RequestParam("branch") String branch,
			@RequestParam("sem") String sem,
			@RequestParam("subject") String subject,
			@RequestParam("section") String section) throws IOException {
		StuAssignment assignment = new StuAssignment();
		assignment.setBranch(branch);
		assignment.setSem(sem);
		assignment.setSubject(subject);
		assignment.setSection(section);
		assignment.setType(type);
		
		StuAssignment assignment1 = service.uploadAssignment(file, assignment);
		return new ResponseEntity<StuAssignment>(assignment1, HttpStatus.OK);
	}
	
	@GetMapping(value = "/downloadAssignment/{file}")
	public ResponseEntity<ByteArrayResource> DownloadAssignment(@PathVariable("file") String file) throws IOException {
		StuAssignment assignment  = service.downloadAssignment(file).get(0);
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(assignment.getDocumentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + assignment.getFileName() + "\"")
                .body(new ByteArrayResource(assignment.getData()));
	}
	
	@GetMapping(value = "/listAllAssignments")
	public List<StuAssignment> listAllAssignment() throws IOException {
		List<StuAssignment> assignment  = service.listAllAssignment();
		return assignment;
	}
	
	@PostMapping(value = "/uploadResults", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadResults( @RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("g:/testFileupload/" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "File is upload successfully";
	}
}
