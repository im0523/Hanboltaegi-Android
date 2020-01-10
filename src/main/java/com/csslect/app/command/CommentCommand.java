package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.CommunityDAO;
import com.csslect.app.dto.CommunityDTO;

public class CommentCommand implements ACommand {

	@Override
	public void execute(Model model) {
		/*String title = (String)model.asMap().get("title");
		Date writedate = (Date)model.asMap().get("writedate");*/
		
		CommunityDAO adao = new CommunityDAO();
		ArrayList<CommunityDTO> adtos = adao.Comment();
		
//		InquiryDAO adao = new InquiryDAO();
//		ArrayList<AnInquiryDTO> adtos = adao.anInquiry();
//		
		model.addAttribute("Comment", adtos); 
	}

}
