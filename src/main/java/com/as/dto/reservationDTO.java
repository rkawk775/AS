package com.as.dto;

import java.sql.Date;

public class reservationDTO {
	private String asitem;
	private String email;
	private String res_date;
	private String res_time;
	private String name;
	private Integer res_id;
	private membershipDTO membership; // 추가된 회원 정보
	
	public String getAsitem() {
		return asitem;
	}
	public void setAsitem(String asitem) {
		this.asitem = asitem;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRes_id() {
		return res_id;
	}
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
	public membershipDTO getMembership() {
        return membership;
    }

    public void setMembership(membershipDTO membership) {
        this.membership = membership;
    }
	
    @Override
    public String toString() {
        return "ReservationDTO [asitem=" + asitem + "email=" + email + ", res_date=" + res_date + ", res_time=" + res_time + ", name="
                + name + ", res_id=" + res_id + ", membership=" + membership + "]";
    }
}
