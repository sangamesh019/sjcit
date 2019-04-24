package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.college.dto.Vehicle;
import com.college.dto.VehicleLog;
import com.college.dto.VehicleReport;
import com.college.repository.TransVehicleReportRepository;
import com.college.repository.TransVehicleRepository;

@Component
public class TransService {

	@Autowired
	com.college.repository.TransVehicleLogRepository transVehicleLogRepository;

	@Autowired
	TransVehicleReportRepository transVehicleReportRepository;

	@Autowired
	TransVehicleRepository transVehicleRepository;

	public Vehicle updateVehicleDetails(Vehicle v) {
		Vehicle response = transVehicleRepository.save(v);
		return  response;
	}

	public VehicleReport updateVehicleReport(VehicleReport vr) {
		VehicleReport response = transVehicleReportRepository.save(vr);
		return  response;
	}

	public VehicleLog updateVehicleLog(VehicleLog vl) {
//		transVehicleLogRepository.findOne(vl.get)
		VehicleLog response = transVehicleLogRepository.save(vl);
		return  response;
	}
	
	public List<VehicleLog> getVehicleLogDetails() {
//		transVehicleLogRepository.findOne(vl.get)
		List<VehicleLog> response = transVehicleLogRepository.findAll();
		return  response;
	}
	
	
	public Vehicle getVehicleDetails(String v) {
		Vehicle response = transVehicleRepository.findByregNbr(v);
		return  response;
	}
	
	public int listVehicleDetails() {
		List<Vehicle> response = transVehicleRepository.findAll();
		return  response.size();
	}
}
