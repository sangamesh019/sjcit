package com.college.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.dto.Faculty;
import com.college.dto.StuAssignment;

@RestController
@RequestMapping(value = "/college")
public class FacultyController {

	@PostMapping(value = "/signUpFaculty")
	public String setFaculty(@RequestBody Faculty faculty) {
		System.out.println(faculty.getfName());
		return "faculty";
	}
	
	@PostMapping(value = "/uploadAssignment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadAssignment(StuAssignment assignment, @RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(assignment.getBranch());
		File convertFile = new File("g:/testFileupload/" + assignment.getBranch() +"_"+ assignment.getSem() +"_"+ assignment.getSubject());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "File is upload successfully";
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
