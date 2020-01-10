package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.ScrapRecipeDAO;
import com.csslect.app.dto.TodayRecipeDTO;

public class ScrapRecipeCommand implements ACommand {

	@Override
	public void execute(Model model) {

		String scr_userid = (String)model.asMap().get("scr_userid");
		
		ScrapRecipeDAO adao = new ScrapRecipeDAO();
		ArrayList<TodayRecipeDTO> adtos = adao.ScrapRecipe(scr_userid);
		
		model.addAttribute("ScrapRecipe", adtos);

	}

}
