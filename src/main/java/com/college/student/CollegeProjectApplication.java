package com.college.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.college.controller.SContoller;

@SpringBootApplication
//@ComponentScan(basePackageClasses = SContoller.class)
@ComponentScan({"com.college.controller", "com.college.service"})
@EnableAutoConfiguration
//@Ac
public class CollegeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeProjectApplication.class, args);
	}

}
