package com.college.exeption;

public class StudentAlreadyExist {

	private String errorCode;
	private String message;

	public StudentAlreadyExist(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
}
