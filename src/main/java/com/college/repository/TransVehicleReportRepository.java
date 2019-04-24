package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Vehicle;
import com.college.dto.VehicleReport;

@Repository
public interface TransVehicleReportRepository extends JpaRepository<VehicleReport, Long> {

}
