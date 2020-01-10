package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.MyRecipeDTO;

public class SearchRecipeCommand implements ACommand {

	@Override
	public void execute(Model model) {
		
		RecipeDAO dao = new RecipeDAO();
		ArrayList<MyRecipeDTO> list = dao.SearchRecipe();
		
		model.addAttribute("SearchRecipe", list); 
	}

}
