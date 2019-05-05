package com.college.dto;

import java.io.Serializable;

public class EducationDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eqLevel;
//	private String eqName;
	private String eqDegree;
	private String eqYear;
//	private String eqTime;
	private String eqSpecialization;
	private String eqGPA;
	
	public String getEqLevel() {
		return eqLevel;
	}
	public void setEqLevel(String eqLevel) {
		this.eqLevel = eqLevel;
	}
//	public String getEqName() {
//		return eqName;
//	}
//	public void setEqName(String eqName) {
//		this.eqName = eqName;
//	}
	public String getEqDegree() {
		return eqDegree;
	}
	public void setEqDegree(String eqDegree) {
		this.eqDegree = eqDegree;
	}
	public String getEqYear() {
		return eqYear;
	}
	public void setEqYear(String eqYear) {
		this.eqYear = eqYear;
	}

	public String getEqSpecialization() {
		return eqSpecialization;
	}
	public void setEqSpecialization(String eqSpecialization) {
		this.eqSpecialization = eqSpecialization;
	}
	public String getEqGPA() {
		return eqGPA;
	}
	public void setEqGPA(String eqGPA) {
		this.eqGPA = eqGPA;
	}

	
}
