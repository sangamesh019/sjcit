package com.college.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import com.college.repository.AssignmentRepository;
import com.college.repository.FacultyRepository;
import com.college.repository.FacultySubjectRepository;
import com.college.repository.StudentRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.college.controller", "com.college.service"})
@EnableAutoConfiguration
@EntityScan("com.college.dto")
@EnableJpaRepositories(basePackageClasses = {StudentRepository.class, FacultyRepository.class, FacultySubjectRepository.class})
@EnableSwagger2
public class CollegeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeProjectApplication.class, args);
	}
	
	 @SuppressWarnings("deprecation")
	@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE","GET");
	            }
	        };
	    }

}
