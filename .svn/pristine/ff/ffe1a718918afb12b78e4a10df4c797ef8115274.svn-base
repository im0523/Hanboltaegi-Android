package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.ANDao;
import com.csslect.app.dao.CommunityDAO;
import com.csslect.app.dao.ScrapRecipeDAO;


public class ScrapDeleteCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		
		int scr_id = Integer.parseInt((String)model.asMap().get("scr_id"));
		
		ScrapRecipeDAO dao = new ScrapRecipeDAO();
		dao.ScrapDelete(scr_id);
		
	}	 

}
