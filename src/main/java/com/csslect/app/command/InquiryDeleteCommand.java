package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.InquiryDAO;


public class InquiryDeleteCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		int no = Integer.parseInt((String)model.asMap().get("no"));
		
		InquiryDAO dao = new InquiryDAO();
		dao.InquiryDelete(no);		
			
	}	 

}
