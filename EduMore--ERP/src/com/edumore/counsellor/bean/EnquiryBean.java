package com.edumore.counsellor.bean;

import java.util.ArrayList;

public class EnquiryBean {
	
	private int enquiry_id;
	private long enquiryNumber;
	private String firstName;
	private String middleName = "";
	private String lastName = "";
	private String dateOfBirth = "";
	private String gender;
	private String emailId;
	private String residenceNumber;
	private String mobileNumber;
	
	private String fatherFirstName;
	private String fatherMiddleName;
	private String fatherLastName;
	private String fatherResidenceNumber;
	private String fatherMobileNumber;
	
	private Address currentAddress;
	private Address permanentAddress;
	
	private ArrayList<EducationalQualification> educationalQualifications = new ArrayList<EducationalQualification>();
	
	private int counsellorId;
	
	private String enquiry_status;
	private String admission_status;
	
	public int getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(int enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	public long getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(long enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getResidenceNumber() {
		return residenceNumber;
	}

	public void setResidenceNumber(String residenceNumber) {
		this.residenceNumber = residenceNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherMiddleName() {
		return fatherMiddleName;
	}

	public void setFatherMiddleName(String fatherMiddleName) {
		this.fatherMiddleName = fatherMiddleName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getFatherResidenceNumber() {
		return fatherResidenceNumber;
	}

	public void setFatherResidenceNumber(String fatherResidenceNumber) {
		this.fatherResidenceNumber = fatherResidenceNumber;
	}

	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public ArrayList<EducationalQualification> getEducationalQualifications() {
		return educationalQualifications;
	}

	public void setEducationalQualifications(
			ArrayList<EducationalQualification> educationalQualifications) {
		this.educationalQualifications = educationalQualifications;
	}

	public int getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(int counsellorId) {
		this.counsellorId = counsellorId;
	}

	public String getEnquiry_status() {
		return enquiry_status;
	}

	public void setEnquiry_status(String enquiry_status) {
		this.enquiry_status = enquiry_status;
	}

	public String getAdmission_status() {
		return admission_status;
	}

	public void setAdmission_status(String admission_status) {
		this.admission_status = admission_status;
	}
	
	
	
}
