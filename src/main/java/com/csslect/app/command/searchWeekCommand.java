package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dao.SearchDAO;
import com.csslect.app.dto.SearchWeekDTO;
import com.csslect.app.dto.TodayRecipeDTO;

public class searchWeekCommand implements ACommand {

	@Override
	public void execute(Model model) {
		SearchDAO adao = new SearchDAO();
		ArrayList<SearchWeekDTO> adtos = adao.searchWeek();
		model.addAttribute("searchWeek", adtos);

	}

}
