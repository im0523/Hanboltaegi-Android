package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;

public class RecepeInsertCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		
		String recipe_id = (String)model.asMap().get("recipe_id");
		String userid = (String)model.asMap().get("userid");
		String title = (String)model.asMap().get("title");
		String subtitle = (String)model.asMap().get("subtitle");			
		String cat1,cat2,cat3,cat4,portion,time,degree;
		cat1 = (String)model.asMap().get("cat1");
		cat2 = (String)model.asMap().get("cat2");
		cat3 = (String)model.asMap().get("cat3");
		cat4 = (String)model.asMap().get("cat4");
		portion = (String)model.asMap().get("portion");
		time = (String)model.asMap().get("time");
		degree = (String)model.asMap().get("degree");
		String writedate = (String)model.asMap().get("writedate");
		String material_id = (String)model.asMap().get("material_id");
		String material_group = (String)model.asMap().get("material_group");
		String imagepath = (String)model.asMap().get("imagepath");
		String imagepath1 = (String)model.asMap().get("imagepath1");
		String imagepath2 = (String)model.asMap().get("imagepath2");
		String imagepath3 = (String)model.asMap().get("imagepath3");
		String imagepath4 = (String)model.asMap().get("imagepath4");
		String cnt = (String)model.asMap().get("cnt");
		
		RecipeDAO adao = new RecipeDAO();
		adao.recInsert(recipe_id,title,subtitle,cat1,cat2,cat3,cat4,portion,time,degree,
				writedate,material_id,material_group,
				imagepath,imagepath1,imagepath2,imagepath3,imagepath4,userid,cnt);
			
	}	 

}
