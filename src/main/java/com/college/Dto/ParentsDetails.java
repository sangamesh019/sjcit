package com.college.dto;

import java.io.Serializable;


public class ParentsDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fatherName;
	private String fOccupation;
	private String motherName;
	private String mOccupation;
	private String aIncome;
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getfOccupation() {
		return fOccupation;
	}
	public void setfOccupation(String fOccupation) {
		this.fOccupation = fOccupation;
	}
	public String getmOccupation() {
		return mOccupation;
	}
	public void setmOccupation(String mOccupation) {
		this.mOccupation = mOccupation;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getaIncome() {
		return aIncome;
	}
	public void setaIncome(String aIncome) {
		this.aIncome = aIncome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
