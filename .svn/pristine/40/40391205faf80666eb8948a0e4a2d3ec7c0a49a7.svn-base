package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.MyRecipeDTO;

public class MyRecipeCommand implements ACommand {

	@Override
	public void execute(Model model) {
//		String title = (String)model.asMap().get("title");
//		Date writedate = (Date)model.asMap().get("writedate");
		String userid = (String)model.asMap().get("userid");
//		String nickname = (String)model.asMap().get("nickname");
		
		RecipeDAO dao = new RecipeDAO();
		ArrayList<MyRecipeDTO> list = dao.MyRecipe(userid);
		
		model.addAttribute("MyRecipe", list); 
	}

}
