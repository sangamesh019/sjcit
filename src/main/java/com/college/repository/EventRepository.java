package com.college.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Events;

@Repository
public interface EventRepository  extends JpaRepository<Events, Long>{
	Optional<Events> findById(Long id);
}
