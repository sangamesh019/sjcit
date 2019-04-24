package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Vehicle;
import com.college.dto.VehicleLog;

@Repository
public interface TransVehicleLogRepository extends JpaRepository<VehicleLog, Long> {

}
