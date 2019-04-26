package com.college.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "stuResults")
public class StudentResults implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	private String internals;
	private String sub;
	private String sem;
	private String usn;
	private String internalMark;
	private String assignMarks;
	
	public String getInternals() {
		return internals;
	}
	public String getUsn() {
		return usn;
	}


	public void setUsn(String usn) {
		this.usn = usn;
	}


	public void setInternals(String internals) {
		this.internals = internals;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getInternalMark() {
		return internalMark;
	}
	public void setInternalMark(String internalMark) {
		this.internalMark = internalMark;
	}
	public String getAssignMarks() {
		return assignMarks;
	}
	public void setAssignMarks(String assignMarks) {
		this.assignMarks = assignMarks;
	}
	
	
	
}
