package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;


public class recDeleteCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		int id = Integer.parseInt((String)model.asMap().get("recipe_id"));
		
		RecipeDAO adao = new RecipeDAO();
		adao.recDelete(id);		
			
	}	 

}
