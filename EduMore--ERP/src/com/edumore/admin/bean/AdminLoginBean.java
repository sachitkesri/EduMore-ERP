package com.edumore.admin.bean;

public class AdminLoginBean {
	private int adminLoginId;
	private String username = "";
	private String password = "";

	public int getAdminLoginId() {
		return adminLoginId;
	}

	public void setAdminLoginId(int i) {
		this.adminLoginId = i;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
