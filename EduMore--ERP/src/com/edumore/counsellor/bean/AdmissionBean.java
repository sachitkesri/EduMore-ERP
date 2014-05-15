package com.edumore.counsellor.bean;

public class AdmissionBean {

	private EnquiryBean bean;
	private int admission_id;
	private String admissionNumber;

	public EnquiryBean getBean() {
		return bean;
	}

	public void setBean(EnquiryBean bean) {
		this.bean = bean;
	}

	public int getAdmission_id() {
		return admission_id;
	}

	public void setAdmission_id(int admission_id) {
		this.admission_id = admission_id;
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

}
