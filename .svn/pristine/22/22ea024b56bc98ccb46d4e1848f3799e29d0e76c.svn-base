package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.RecipeCommentDTO;

public class recipeCommentCommand implements ACommand {

	@Override
	public void execute(Model model) {
		
		String rc_id = (String)model.asMap().get("rc_id");
		
		RecipeDAO adao = new RecipeDAO();
		ArrayList<RecipeCommentDTO> adtos = adao.recipeComment(rc_id);
		
		model.addAttribute("recipeComment", adtos);
		

	}

}
