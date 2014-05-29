package com.edumore.counsellor.bean;

import java.sql.Date;

public class RegistrationBean {
	
	private String enquiryNumber;
	private float registrationFee;
	private Date registrationDate;
	
	public String getEnquiryNumber() {
		return enquiryNumber;
	}
	public void setEnquiryNumber(String enquiry_number) {
		this.enquiryNumber = enquiry_number;
	}
	public float getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(float registrationFee) {
		this.registrationFee = registrationFee;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	

}
