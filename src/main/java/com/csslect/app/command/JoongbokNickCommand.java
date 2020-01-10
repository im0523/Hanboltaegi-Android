package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;
import com.csslect.app.dto.JoongbokDTO;

public class JoongbokNickCommand implements ACommand {

	@Override
	public void execute(Model model) {
		
		String id = null;
		String nickname = (String)model.asMap().get("nickname");
		
		MemberDAO adao = new MemberDAO();
		ArrayList<JoongbokDTO> adtos = adao.JoongbokNick(id, nickname);
		
		model.addAttribute("JoongbokNick", adtos);
	}

}
