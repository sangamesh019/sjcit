package com.college.dto;

import java.io.Serializable;

public class EmpDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String edName;
	private String edDesig;
	private String edPeriod;
	public String getEdName() {
		return edName;
	}
	public void setEdName(String edName) {
		this.edName = edName;
	}
	public String getEdDesig() {
		return edDesig;
	}
	public void setEdDesig(String edDesig) {
		this.edDesig = edDesig;
	}
	public String getEdPeriod() {
		return edPeriod;
	}
	public void setEdPeriod(String edPeriod) {
		this.edPeriod = edPeriod;
	}
	
	
}
