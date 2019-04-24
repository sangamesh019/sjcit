package com.college.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicleReport")
public class VehicleReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String totalFuel;
	private String amountSpare;
	private String lab;
	private String taxPaid;
	private String insurance;
	private String tyreCost;
	private String batterCost;
	private String grandTotal;
	private String year;

	public String getTotalFuel() {
		return totalFuel;
	}

	public void setTotalFuel(String totalFuel) {
		this.totalFuel = totalFuel;
	}

	public String getAmountSpare() {
		return amountSpare;
	}

	public void setAmountSpare(String amountSpare) {
		this.amountSpare = amountSpare;
	}

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String getTaxPaid() {
		return taxPaid;
	}

	public void setTaxPaid(String taxPaid) {
		this.taxPaid = taxPaid;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getTyreCost() {
		return tyreCost;
	}

	public void setTyreCost(String tyreCost) {
		this.tyreCost = tyreCost;
	}

	public String getBatterCost() {
		return batterCost;
	}

	public void setBatterCost(String batterCost) {
		this.batterCost = batterCost;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
