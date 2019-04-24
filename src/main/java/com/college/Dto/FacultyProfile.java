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
	private String anIncome;

	private Address taddress;
	private Address paddress;
	private String maritalStatus;

	@Column(unique = true)
	private String mNumber;
	@Column(unique = true)
	private String email;

	private String bloodGroup;
	// Education
	private EducationDetails educationDetailsX;
	private EducationDetails educationDetailsXII;
	private EducationDetails educationDetailsDiploma;
	private EducationDetails educationDetailsUG;
	private EducationDetails educationDetailsPG;
	private EducationDetails educationDetailsPHD;
	private EducationDetails educationDetailsOther1;
	private EducationDetails educationDetailsOther2;
	// emp details
	private EmpDetails empDetails;

	private String exWorkshop;

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

	public String getAnIncome() {
		return anIncome;
	}

	public void setAnIncome(String anIncome) {
		this.anIncome = anIncome;
	}

	public EducationDetails getEducationDetailsX() {
		return educationDetailsX;
	}

	public void setEducationDetailsX(EducationDetails educationDetailsX) {
		this.educationDetailsX = educationDetailsX;
	}

	public EducationDetails getEducationDetailsXII() {
		return educationDetailsXII;
	}

	public void setEducationDetailsXII(EducationDetails educationDetailsXII) {
		this.educationDetailsXII = educationDetailsXII;
	}

	public EducationDetails getEducationDetailsDiploma() {
		return educationDetailsDiploma;
	}

	public void setEducationDetailsDiploma(EducationDetails educationDetailsDiploma) {
		this.educationDetailsDiploma = educationDetailsDiploma;
	}

	public EducationDetails getEducationDetailsUG() {
		return educationDetailsUG;
	}

	public void setEducationDetailsUG(EducationDetails educationDetailsUG) {
		this.educationDetailsUG = educationDetailsUG;
	}

	public EducationDetails getEducationDetailsPG() {
		return educationDetailsPG;
	}

	public void setEducationDetailsPG(EducationDetails educationDetailsPG) {
		this.educationDetailsPG = educationDetailsPG;
	}

	public EducationDetails getEducationDetailsPHD() {
		return educationDetailsPHD;
	}

	public void setEducationDetailsPHD(EducationDetails educationDetailsPHD) {
		this.educationDetailsPHD = educationDetailsPHD;
	}

	public EducationDetails getEducationDetailsOther1() {
		return educationDetailsOther1;
	}

	public void setEducationDetailsOther1(EducationDetails educationDetailsOther1) {
		this.educationDetailsOther1 = educationDetailsOther1;
	}

	public EducationDetails getEducationDetailsOther2() {
		return educationDetailsOther2;
	}

	public void setEducationDetailsOther2(EducationDetails educationDetailsOther2) {
		this.educationDetailsOther2 = educationDetailsOther2;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
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
