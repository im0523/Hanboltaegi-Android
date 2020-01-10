package com.csslect.app.dto;


public class AnMemberDto {
	String id, pw, phone, address;
	
	

	public AnMemberDto(String id, String pw, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.address = address;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
