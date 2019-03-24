package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.dto.Events;

@Repository
public interface EventRepository  extends JpaRepository<Events, Long>{

}
