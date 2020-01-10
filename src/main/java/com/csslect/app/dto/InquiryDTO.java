package com.csslect.app.dto;

public class InquiryDTO {

	private int no, num;
	private String title, writedate, content, id, nickname;

	
	public InquiryDTO(int no, int num, String title, String writedate, String content, String id, String nickname) {
		super();
		this.no = no;
		this.num = num;
		this.title = title;
		this.writedate = writedate;
		this.content = content;
		this.id = id;
		this.nickname = nickname;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
}