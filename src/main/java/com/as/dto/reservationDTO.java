package com.as.dto;

import java.sql.Date;

public class reservationDTO {
	private String asitem;
	private Date res_date;
	private String res_time;
	private String res_name;
	private String res_id;
	private String phone;
	private String email;
	
	public String getAsitem() {
		return asitem;
	}
	public void setAsitem(String asitem) {
		this.asitem = asitem;
	}
	public Date getRes_date() {
		return res_date;
	}
	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "reservationDTO [asitem=" + asitem + ", res_date=" + res_date + ", res_time=" + res_time + ", res_name="
				+ res_name + ", res_id=" + res_id + ", phone=" + phone + ", email=" + email + "]";
	}
}
