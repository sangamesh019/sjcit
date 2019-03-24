package com.college.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.college.dto.Faculty;
import com.college.dto.StuAssignment;
import com.college.dto.Student;
import com.college.service.StudentService;

@RestController
@RequestMapping(value = "/college")
public class SContoller {

	@Autowired
	StudentService service;

	/*
	 * @Autowired StudentRepository studentRepository;
	 */

	@PostMapping(value = "/signUpStudent")
	public Student setStudent(@Valid @RequestBody Student student) {
		Student status = service.signUpStudent(student);
		return status;
	}

	@PostMapping(value = "/signUpFaculty")
	public String setFaculty(@RequestBody Faculty faculty) {
		System.out.println(faculty.getfName());
		return "faculty";
	}

	@GetMapping(value = "/student/{id}")
	public List<Student> getStudent(@PathVariable(value = "id") String email) {
		List<Student> studs = service.getStudent(email);
		return studs;
	}

	@PostMapping(value = "/uploadAssignment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public String fileUpload(StuAssignment assignment, @RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(assignment.getBranch());
		File convertFile = new File("g:/testFileupload/" + assignment.getBranch() +"_"+ assignment.getSem() +"_"+ assignment.getSubject());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "File is upload successfully";
	}
}
