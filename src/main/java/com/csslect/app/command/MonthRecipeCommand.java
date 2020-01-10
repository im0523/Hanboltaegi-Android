package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.TodayRecipeDTO;

public class MonthRecipeCommand implements ACommand {

	@Override
	public void execute(Model model) {

		RecipeDAO adao = new RecipeDAO();
		ArrayList<TodayRecipeDTO> adtos = adao.monthRecipe();
		model.addAttribute("monthRecipe", adtos);

	}

}
