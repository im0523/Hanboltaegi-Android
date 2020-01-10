package com.csslect.app.command;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.InquiryDAO;
import com.csslect.app.dto.InquiryDTO;

public class AnInquiryCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String title = (String)model.asMap().get("title");
		Date writedate = (Date)model.asMap().get("writedate");
		String id = (String)model.asMap().get("id");
		String nickname = (String)model.asMap().get("nickname");
		
		InquiryDAO dao = new InquiryDAO();
		ArrayList<InquiryDTO> list = dao.anInquiry(id);
		
		model.addAttribute("anInquiry", list); 
	}

}
