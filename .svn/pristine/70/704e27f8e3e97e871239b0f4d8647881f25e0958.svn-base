package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.TodayRecipeDTO;

public class maincat2s5RecipeCommand implements ACommand {

	@Override
	public void execute(Model model) {
		RecipeDAO adao = new RecipeDAO();
		ArrayList<TodayRecipeDTO> adtos = adao.maincat2s5Recipe();
		
		model.addAttribute("maincat2s5Recipe", adtos);

	}

}
