package com.college.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class StudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentException(String exception) {
		super(exception);
	}
	
	public StudentException(String exception, Throwable status) {
		super(exception, status);
	}
}
