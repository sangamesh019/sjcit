package com.college.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicleLog")
public class VehicleLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private String logDate;
	private String vehicleRegNbr;
	private String vehicleNbr;
	private String driverName;
	private String certStartdate;
	private String pickPoint;
	private String destinationPoint;
	private String kms;
	private String initReading;
	private String finalReading;
	private String repairs;
	private String complain;
	private String dateComplain;
	private String amount;
	private String desiel;
	private String desielFilledLoc;
	private String desielFilledLocInfo;
	private String driSign;
	
	private String inchargeSign;
	private String insBill;
	private String insRenDate;
	private String insExpdate;
	private String inNameOfComp;
	private String insPolNbr;
	
	private String rtaxBill;
	private String rtaxRenDate;
	private String rtaxExpDate;
	private String rtaxNameRTO;
	private String rtaxChalanNbr;
	
	private String fitBill;
	private String fitRenNbr;
	private String fitExpNbr;
	private String fitnameRTO;
	private String fitCertnbr;
	
	private String fuelBill;
	private String fuelPro;
	private String fuelCertNbr;
	private String fuelFilldate;
	private String fuelHSD;
	private String fuelBillNbr;
	
	

	public String getInsBill() {
		return insBill;
	}

	public void setInsBill(String insBill) {
		this.insBill = insBill;
	}

	public String getInsRenDate() {
		return insRenDate;
	}

	public void setInsRenDate(String insRenDate) {
		this.insRenDate = insRenDate;
	}

	public String getInsExpdate() {
		return insExpdate;
	}

	public void setInsExpdate(String insExpdate) {
		this.insExpdate = insExpdate;
	}

	public String getInNameOfComp() {
		return inNameOfComp;
	}

	public void setInNameOfComp(String inNameOfComp) {
		this.inNameOfComp = inNameOfComp;
	}

	public String getInsPolNbr() {
		return insPolNbr;
	}

	public void setInsPolNbr(String insPolNbr) {
		this.insPolNbr = insPolNbr;
	}

	public String getRtaxBill() {
		return rtaxBill;
	}

	public void setRtaxBill(String rtaxBill) {
		this.rtaxBill = rtaxBill;
	}

	public String getRtaxRenDate() {
		return rtaxRenDate;
	}

	public void setRtaxRenDate(String rtaxRenDate) {
		this.rtaxRenDate = rtaxRenDate;
	}

	public String getRtaxExpDate() {
		return rtaxExpDate;
	}

	public void setRtaxExpDate(String rtaxExpDate) {
		this.rtaxExpDate = rtaxExpDate;
	}

	public String getRtaxNameRTO() {
		return rtaxNameRTO;
	}

	public void setRtaxNameRTO(String rtaxNameRTO) {
		this.rtaxNameRTO = rtaxNameRTO;
	}

	public String getRtaxChalanNbr() {
		return rtaxChalanNbr;
	}

	public void setRtaxChalanNbr(String rtaxChalanNbr) {
		this.rtaxChalanNbr = rtaxChalanNbr;
	}

	public String getFitBill() {
		return fitBill;
	}

	public void setFitBill(String fitBill) {
		this.fitBill = fitBill;
	}

	public String getFitRenNbr() {
		return fitRenNbr;
	}

	public void setFitRenNbr(String fitRenNbr) {
		this.fitRenNbr = fitRenNbr;
	}

	public String getFitExpNbr() {
		return fitExpNbr;
	}

	public void setFitExpNbr(String fitExpNbr) {
		this.fitExpNbr = fitExpNbr;
	}

	public String getFitnameRTO() {
		return fitnameRTO;
	}

	public void setFitnameRTO(String fitnameRTO) {
		this.fitnameRTO = fitnameRTO;
	}

	public String getFitCertnbr() {
		return fitCertnbr;
	}

	public void setFitCertnbr(String fitCertnbr) {
		this.fitCertnbr = fitCertnbr;
	}

	public String getFuelBill() {
		return fuelBill;
	}

	public void setFuelBill(String fuelBill) {
		this.fuelBill = fuelBill;
	}

	public String getFuelPro() {
		return fuelPro;
	}

	public void setFuelPro(String fuelPro) {
		this.fuelPro = fuelPro;
	}

	public String getFuelCertNbr() {
		return fuelCertNbr;
	}

	public void setFuelCertNbr(String fuelCertNbr) {
		this.fuelCertNbr = fuelCertNbr;
	}

	public String getFuelFilldate() {
		return fuelFilldate;
	}

	public void setFuelFilldate(String fuelFilldate) {
		this.fuelFilldate = fuelFilldate;
	}

	public String getFuelHSD() {
		return fuelHSD;
	}

	public void setFuelHSD(String fuelHSD) {
		this.fuelHSD = fuelHSD;
	}

	public String getFuelBillNbr() {
		return fuelBillNbr;
	}

	public void setFuelBillNbr(String fuelBillNbr) {
		this.fuelBillNbr = fuelBillNbr;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getVehicleRegNbr() {
		return vehicleRegNbr;
	}

	public void setVehicleRegNbr(String vehicleRegNbr) {
		this.vehicleRegNbr = vehicleRegNbr;
	}

	public String getVehicleNbr() {
		return vehicleNbr;
	}

	public void setVehicleNbr(String vehicleNbr) {
		this.vehicleNbr = vehicleNbr;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCertStartdate() {
		return certStartdate;
	}

	public void setCertStartdate(String certStartdate) {
		this.certStartdate = certStartdate;
	}

	public String getPickPoint() {
		return pickPoint;
	}

	public void setPickPoint(String pickPoint) {
		this.pickPoint = pickPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public String getKms() {
		return kms;
	}

	public void setKms(String kms) {
		this.kms = kms;
	}

	public String getInitReading() {
		return initReading;
	}

	public void setInitReading(String initReading) {
		this.initReading = initReading;
	}

	public String getFinalReading() {
		return finalReading;
	}

	public void setFinalReading(String finalReading) {
		this.finalReading = finalReading;
	}

	public String getRepairs() {
		return repairs;
	}

	public void setRepairs(String repairs) {
		this.repairs = repairs;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public String getDateComplain() {
		return dateComplain;
	}

	public void setDateComplain(String dateComplain) {
		this.dateComplain = dateComplain;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDesiel() {
		return desiel;
	}

	public void setDesiel(String desiel) {
		this.desiel = desiel;
	}

	public String getDesielFilledLoc() {
		return desielFilledLoc;
	}

	public void setDesielFilledLoc(String desielFilledLoc) {
		this.desielFilledLoc = desielFilledLoc;
	}

	public String getDesielFilledLocInfo() {
		return desielFilledLocInfo;
	}

	public void setDesielFilledLocInfo(String desielFilledLocInfo) {
		this.desielFilledLocInfo = desielFilledLocInfo;
	}

	public String getDriSign() {
		return driSign;
	}

	public void setDriSign(String driSign) {
		this.driSign = driSign;
	}

	public String getInchargeSign() {
		return inchargeSign;
	}

	public void setInchargeSign(String inchargeSign) {
		this.inchargeSign = inchargeSign;
	}

}
