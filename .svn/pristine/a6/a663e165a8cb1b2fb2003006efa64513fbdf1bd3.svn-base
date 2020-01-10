package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.ANDao;
import com.csslect.app.dao.CommunityDAO;
import com.csslect.app.dao.RecipeDAO;

public class GoodCommand implements ACommand{	
	
	
	
	@Override
	public void execute(Model model) {
		String good = (String)model.asMap().get("good");
		String recipe_id = (String)model.asMap().get("recipe_id");
		
		RecipeDAO dao = new RecipeDAO();
		dao.Good(good, recipe_id);
	}
	
	
	
	
	
	
	
	
	
	/*@Override
	public void execute(Model model) {
		int id = Integer.parseInt((String)model.asMap().get("id"));
		String name = (String)model.asMap().get("name");
		String date = (String)model.asMap().get("date");
		String dbImgPath= (String)model.asMap().get("dbImgPath");
		
		ANDao adao = new ANDao();
		
		adao.anUpdateMulti(id, name, date, dbImgPath);
		
		
	}*/	 

}
