package com.college.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.dto.Events;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/college")
public class EventController {
	
	@PostMapping(value = "/events")
	public String setEvents(@RequestBody Events faculty) {
		return "faculty";
	}
	
	@GetMapping(value = "/events")
	public String getAllEvents() {
		return "faculty";
	}
	
	@GetMapping(value = "/event")
	public String getEvent() {
		return "faculty";
	}
	
	@PutMapping(value = "/eventUpdate")
	public String updateEvent(@RequestBody Events faculty) {
		return "faculty";
	}
}
