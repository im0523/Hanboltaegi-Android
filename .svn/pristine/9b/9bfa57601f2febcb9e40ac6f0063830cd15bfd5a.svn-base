package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.TodayRecipeDTO;

public class maincat3s3RecipeCommand implements ACommand {

	@Override
	public void execute(Model model) {
		RecipeDAO adao = new RecipeDAO();
		ArrayList<TodayRecipeDTO> adtos = adao.maincat3s3Recipe();
		
		model.addAttribute("maincat3s3Recipe", adtos);

	}

}
