package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.InquiryDAO;

public class InquiryInsertCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String title = (String)model.asMap().get("title");
		String content= (String)model.asMap().get("content");			
		String nickname = (String)model.asMap().get("nickname");
		String id= (String)model.asMap().get("id");			
		
		InquiryDAO dao = new InquiryDAO();
		dao.InquiryInsert(title, nickname, content, id);

	}

}
