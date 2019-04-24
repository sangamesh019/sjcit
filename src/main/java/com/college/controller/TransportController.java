package com.college.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.dto.Vehicle;
import com.college.dto.VehicleLog;
import com.college.dto.VehicleReport;
import com.college.service.TransService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/college")
public class TransportController {

	@Autowired
	TransService service;

	@PostMapping(value = "/updateVehicleDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> updateVehicleDetails(@Valid @RequestBody Vehicle vehicle) {
		Vehicle status = service.updateVehicleDetails(vehicle);
		return new ResponseEntity<Vehicle>(status, HttpStatus.OK);
	}

	@PostMapping(value = "/updateVehicleReport", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleReport> updateVehicleReport(@Valid @RequestBody VehicleReport vehicleReport) {
		VehicleReport status = service.updateVehicleReport(vehicleReport);
		return new ResponseEntity<VehicleReport>(status, HttpStatus.OK);
	}

	@PostMapping(value = "/updateVehicleLog", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleLog> updateVehicleLog(@Valid @RequestBody VehicleLog vehicleLog) {
		VehicleLog status = service.updateVehicleLog(vehicleLog);
		return new ResponseEntity<VehicleLog>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getVehicleDetails/{vnbr}")
	public ResponseEntity<Vehicle> getVehicleDetails(@PathVariable String vnbr) {
		Vehicle status = service.getVehicleDetails(vnbr);
		return new ResponseEntity<Vehicle>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getVehicleLogDetails")
	public ResponseEntity<List<VehicleLog>> getVehicleLogDetails() {
		List<VehicleLog> status = service.getVehicleLogDetails();
		return new ResponseEntity<List<VehicleLog>>(status, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listVehicleDetails")
	public ResponseEntity<Integer> listVehicleDetails() {
		int status = service.listVehicleDetails();
		return new ResponseEntity<Integer>(status, HttpStatus.OK);
	}
}
