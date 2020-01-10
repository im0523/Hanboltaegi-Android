package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.SearchDAO;
import com.csslect.app.dto.SearchWeekDTO;

public class searchAllListCommand implements ACommand {
	@Override
	public void execute(Model model) {
		SearchDAO adao = new SearchDAO();
		ArrayList<SearchWeekDTO> adtos = adao.searchAllList();
		model.addAttribute("searchAllList", adtos);

	}
}
