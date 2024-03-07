package com.as.dto;

public class membershipDTO {
	private String email;
	private String pw;
	private String name;
	private String phone;
	private int admin;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "membershipDTO [email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", admin=" + admin + "]";
	}
	
	
	
	
}
