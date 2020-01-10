package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;
import com.csslect.app.dto.JoongbokDTO;

public class JoongbokIdCommand implements ACommand {

	@Override
	public void execute(Model model) {
		
		String id = (String)model.asMap().get("id");
		String nickname = null;
		
		MemberDAO adao = new MemberDAO();
		ArrayList<JoongbokDTO> adtos = adao.JoongbokId(id, nickname);
		
		model.addAttribute("JoongbokId", adtos);
	}

}
