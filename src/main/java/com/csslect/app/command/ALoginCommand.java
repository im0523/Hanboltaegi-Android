package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.ANDao;
import com.csslect.app.dto.AnMemberDto;


public class ALoginCommand implements ACommand{

	@Override
	public void execute(Model model) {		
		
		String id = (String)model.asMap().get("id");
		String pw = (String)model.asMap().get("pw");	
		
		ANDao adao = new ANDao();
		ArrayList<AnMemberDto> adtos = adao.anLogin(id, pw);
		
		model.addAttribute("anLogin", adtos); 
		
	}
	
}
