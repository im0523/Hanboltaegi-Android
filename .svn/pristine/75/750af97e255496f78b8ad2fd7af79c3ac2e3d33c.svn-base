package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dao.SearchDAO;

public class searchCommand implements ACommand {

	@Override
	public void execute(Model model) {
	
			String content = (String)model.asMap().get("content");
	
			
			SearchDAO dao = new SearchDAO();
			dao.search(content);

	}

}
