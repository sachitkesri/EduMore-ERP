package com.edumore.counsellor.bean;

import java.sql.Date;

public class FollowupBean {
	
	private int followupId;
	private Date date;
	private String remarks;
	private String enquiryId;
	
	public int getFollowupId() {
		return followupId;
	}
	public void setFollowupId(int followupId) {
		this.followupId = followupId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}
	
	

}
