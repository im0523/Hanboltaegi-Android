package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.InquiryDAO;
import com.csslect.app.dao.RecipeDAO;

public class recipeCommentDeleteCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String no = (String) model.asMap().get("no");
		
		RecipeDAO dao = new RecipeDAO();
		dao.recipeCommentDelete(no);		

	}

}
