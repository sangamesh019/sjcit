package com.college.dto;

import java.io.Serializable;

public class Address implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String houseNbr;
	private String street;
	private String locality;
	private String city;
	private String state;
	private String country;
	private String pincode;
	public String getHouseNbr() {
		return houseNbr;
	}
	public void setHouseNbr(String houseNbr) {
		this.houseNbr = houseNbr;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
