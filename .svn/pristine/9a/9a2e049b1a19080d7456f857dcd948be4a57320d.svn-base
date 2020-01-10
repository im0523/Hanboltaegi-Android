package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;

public class gradeCommand implements ACommand {

	@Override
	public void execute(Model model) {

		String id= (String)model.asMap().get("id");		
		
		MemberDAO adao = new MemberDAO();
		adao.gradeUpdate(id);

	}

}
