package com.college.Dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String fName;
	private String mName;
	@NotNull
	private String lName;
	private String gender;
//	@NotNull
	private Calendar DOB;
	private String cAddress;
	@NotNull
	private String pAddress;
	private String categaroy;
	private String branch;
	private String sem;
	private String adhNumber;
	@NotNull
	private String mNumber;
	@NotNull
	private String email;
	
	private ParentsDetails parentsDetails;
	
	public ParentsDetails getParentsDetails() {
		return parentsDetails;
	}
	public void setParentsDetails(ParentsDetails parentsDetails) {
		this.parentsDetails = parentsDetails;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Calendar getDOB() {
		return DOB;
	}
	public void setDOB(Calendar dOB) {
		DOB = dOB;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}
	public String getCategaroy() {
		return categaroy;
	}
	public void setCategaroy(String categaroy) {
		this.categaroy = categaroy;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getAdhNumber() {
		return adhNumber;
	}
	public void setAdhNumber(String adhNumber) {
		this.adhNumber = adhNumber;
	}
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
