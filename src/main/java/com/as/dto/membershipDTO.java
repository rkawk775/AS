package com.as.dto;

public class membershipDTO {
	private String email;
	private String pw;
	private String name;
	private String phone;
	private Integer res_id;
	
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
	public Integer getRes_id() {
		return res_id;
	}
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
	@Override
	public String toString() {
		return "membershipDTO [email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", res_id="
				+ res_id + "]";
	}
	
	
}
