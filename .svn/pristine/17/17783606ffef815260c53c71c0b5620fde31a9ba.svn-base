package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;
import com.csslect.app.dto.HanMemberDTO;

public class HanLoginCommand implements ACommand {

	@Override
	public void execute(Model model) {

		String id = (String) model.asMap().get("id");
		String pwd = (String) model.asMap().get("pwd");
		
		MemberDAO adao = new MemberDAO();
		ArrayList<HanMemberDTO> adtos = adao.HanLogin(id,pwd);
		
		model.addAttribute("HanLogin", adtos);

	}

}
