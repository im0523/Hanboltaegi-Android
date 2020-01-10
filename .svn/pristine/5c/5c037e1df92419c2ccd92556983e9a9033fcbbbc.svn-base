package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;

public class searchUpdateCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String count = (String)model.asMap().get("count");
		String no = (String)model.asMap().get("no");
		
		System.out.println("command:" + count+no);
		
		RecipeDAO dao = new RecipeDAO();
		dao.searchUpdate(count, no);

	}

}
