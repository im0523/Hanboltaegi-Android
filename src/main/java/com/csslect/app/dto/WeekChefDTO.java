package com.csslect.app.dto;

public class WeekChefDTO {
	private String id, nickname;
	private int no, good;
	
	public WeekChefDTO(String id, String nickname, int no, int good) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.no = no;
		this.good = good;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}

}
