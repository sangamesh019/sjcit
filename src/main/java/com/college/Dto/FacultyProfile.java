package com.college.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="FacultyProfile")
public class FacultyProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String designation;
//	private String anIncome;
	private String pfatherName;
	private Address taddress;
	private Address paddress;
	private String maritalStatus;

	@Column(unique = true)
	private String mNumber;
	@Column(unique = true)
	private String email;

	private String bloodGroup;
	// Education
	private EducationDetails[] educationDetails;

	// emp details
//	private EmpDetails empDetails;

	private String exWorkshop;

	
	public String getPfatherName() {
		return pfatherName;
	}

	public void setPfatherName(String pfatherName) {
		this.pfatherName = pfatherName;
	}

	public Address getTaddress() {
		return taddress;
	}

	public void setTaddress(Address taddress) {
		this.taddress = taddress;
	}

	public Address getPaddress() {
		return paddress;
	}

	public void setPaddress(Address paddress) {
		this.paddress = paddress;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public EducationDetails[] getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(EducationDetails[] educationDetails) {
		this.educationDetails = educationDetails;
	}

	public String getExWorkshop() {
		return exWorkshop;
	}

	public void setExWorkshop(String exWorkshop) {
		this.exWorkshop = exWorkshop;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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
