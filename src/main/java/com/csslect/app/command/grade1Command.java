package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;

public class grade1Command implements ACommand {

	@Override
	public void execute(Model model) {

		String id= (String)model.asMap().get("id");		
		
		MemberDAO adao = new MemberDAO();
		adao.grade1Update(id);

	}

}
