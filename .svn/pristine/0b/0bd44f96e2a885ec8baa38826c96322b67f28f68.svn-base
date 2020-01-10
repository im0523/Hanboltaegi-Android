package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.InquiryDAO;

public class InquiryUpdateCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String title = (String)model.asMap().get("title");
		String nickname = (String)model.asMap().get("nickname");
		String writedate = (String)model.asMap().get("writedate");
		String content= (String)model.asMap().get("content");	
		String id= (String)model.asMap().get("id");
		int no = Integer.parseInt((String) model.asMap().get("no"));			
//		int num = Integer.parseInt((String) model.asMap().get("num"));			
		
		InquiryDAO adao = new InquiryDAO();
		adao.InquiryUpdate( no,  title ,writedate,  content,  id,  nickname);
	}

}
