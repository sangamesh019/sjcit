package com.college.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "vehicle")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String mChassis;
	private String mType;
	private String wheelBase;
	private String regNbr;
	private String stUnitNbr;
	private String chassisNbr;
	private String engNbr;
	private String engMType;
	private String typeBody;
	private String fuelTankCap;
	private String unloadCap;
	private String regloadCap;
	private String chassisWeight;
	private String sizeFrontTire;
	private String sizeRearTire;
	private String commDate;
	private String certNbr;
	private String certExpdate;
	private String certRenDate;
	private String amount;
	private String route;
	
	

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getCertNbr() {
		return certNbr;
	}

	public void setCertNbr(String certNbr) {
		this.certNbr = certNbr;
	}

	public String getCertExpdate() {
		return certExpdate;
	}

	public void setCertExpdate(String certExpdate) {
		this.certExpdate = certExpdate;
	}

	public String getCertRenDate() {
		return certRenDate;
	}

	public void setCertRenDate(String certRenDate) {
		this.certRenDate = certRenDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getmChassis() {
		return mChassis;
	}

	public void setmChassis(String mChassis) {
		this.mChassis = mChassis;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getWheelBase() {
		return wheelBase;
	}

	public void setWheelBase(String wheelBase) {
		this.wheelBase = wheelBase;
	}

	public String getRegNbr() {
		return regNbr;
	}

	public void setRegNbr(String regNbr) {
		this.regNbr = regNbr;
	}

	public String getStUnitNbr() {
		return stUnitNbr;
	}

	public void setStUnitNbr(String stUnitNbr) {
		this.stUnitNbr = stUnitNbr;
	}

	public String getChassisNbr() {
		return chassisNbr;
	}

	public void setChassisNbr(String chassisNbr) {
		this.chassisNbr = chassisNbr;
	}

	public String getEngNbr() {
		return engNbr;
	}

	public void setEngNbr(String engNbr) {
		this.engNbr = engNbr;
	}

	public String getEngMType() {
		return engMType;
	}

	public void setEngMType(String engMType) {
		this.engMType = engMType;
	}

	public String getTypeBody() {
		return typeBody;
	}

	public void setTypeBody(String typeBody) {
		this.typeBody = typeBody;
	}

	public String getFuelTankCap() {
		return fuelTankCap;
	}

	public void setFuelTankCap(String fuelTankCap) {
		this.fuelTankCap = fuelTankCap;
	}

	public String getUnloadCap() {
		return unloadCap;
	}

	public void setUnloadCap(String unloadCap) {
		this.unloadCap = unloadCap;
	}

	public String getRegloadCap() {
		return regloadCap;
	}

	public void setRegloadCap(String regloadCap) {
		this.regloadCap = regloadCap;
	}

	public String getChassisWeight() {
		return chassisWeight;
	}

	public void setChassisWeight(String chassisWeight) {
		this.chassisWeight = chassisWeight;
	}

	public String getSizeFrontTire() {
		return sizeFrontTire;
	}

	public void setSizeFrontTire(String sizeFrontTire) {
		this.sizeFrontTire = sizeFrontTire;
	}

	public String getSizeRearTire() {
		return sizeRearTire;
	}

	public void setSizeRearTire(String sizeRearTire) {
		this.sizeRearTire = sizeRearTire;
	}

	public String getCommDate() {
		return commDate;
	}

	public void setCommDate(String commDate) {
		this.commDate = commDate;
	}

}
