package com.college.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
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
	
	@PostMapping(value = "/signUpFaculty")
	public String setFaculty(@RequestBody Faculty faculty) {
		System.out.println(faculty.getfName());
		return "faculty";
	}
	
	/*@PostMapping(value = "/uploadAssignment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadAssignment(StuAssignment assignment, @RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(assignment.getBranch());
		File convertFile = new File("g:/testFileupload/" + assignment.getBranch() +"_"+ assignment.getSem() +"_"+ assignment.getSubject());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		assignment.setFileName(assignment.getBranch() +"_"+ assignment.getSem() +"_"+ assignment.getSubject());
		assignment.setDocument(convertFile);
		service.uploadAssignment(assignment);
		return "File is upload successfully";
	}*/
	
	@PostMapping(value = "/uploadAssignment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean uploadAssignment(@RequestParam("file") MultipartFile file) throws IOException {
		service.uploadAssignment(file);
		return true;
	}
	
	@PostMapping(value = "/uploadAssignmentDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StuAssignment test(@RequestBody StuAssignment assignment) throws IOException {
		service.uploadAssignmentDetails(assignment);
		return assignment;
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
