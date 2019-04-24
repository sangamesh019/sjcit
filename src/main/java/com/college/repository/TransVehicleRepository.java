package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Vehicle;

@Repository
public interface TransVehicleRepository extends JpaRepository<Vehicle, Long> {

	public Vehicle findByregNbr(String regNbr);
}
