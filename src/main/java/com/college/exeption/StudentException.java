package com.college.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentException(String exception) {
		super(exception);
	}
}
