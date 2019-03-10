package com.college.Dto;

import java.io.Serializable;


public class ParentsDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fatherName;
	private String fOccuption;
	private String motherName;
	private String mOccuption;
	private String aIncome;
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getfOccuption() {
		return fOccuption;
	}
	public void setfOccuption(String fOccuption) {
		this.fOccuption = fOccuption;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getmOccuption() {
		return mOccuption;
	}
	public void setmOccuption(String mOccuption) {
		this.mOccuption = mOccuption;
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
