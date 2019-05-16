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

	private String fName;
	private String mName;
	private String lName;
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

	private String password;
	private String bloodGroup;
	private String aboutMe;
	// Education
	@Column(columnDefinition="BLOB")
	private EducationDetails[] educationDetails;
	private String lnbr;
	// emp details
//	private EmpDetails empDetails;

	
	private String exWorkshop;

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
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

	public String getLnbr() {
		return lnbr;
	}

	public void setLnbr(String lnbr) {
		this.lnbr = lnbr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
