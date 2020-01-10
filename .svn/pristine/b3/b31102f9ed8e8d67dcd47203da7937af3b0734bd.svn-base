package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.command.ACommand;
import com.csslect.app.dao.RecipeDAO;

public class recUpdateCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String recipe_id = (String)model.asMap().get("recipe_id");
		String title = (String)model.asMap().get("title");
		String subtitle = (String)model.asMap().get("subtitle");		
		String material_id = (String)model.asMap().get("material_id");
		String material_group = (String)model.asMap().get("material_group");
		String cat1 = (String)model.asMap().get("cat1");
		String cat2 = (String)model.asMap().get("cat2");
		String cat3 = (String)model.asMap().get("cat3");
		String cat4 = (String)model.asMap().get("cat4");
		String portion = (String)model.asMap().get("portion");
		String time = (String)model.asMap().get("time");
		String degree = (String)model.asMap().get("degree");
		String writedate = (String)model.asMap().get("writedate");
		String imagepath = (String)model.asMap().get("imagepath");
		String imagepath1 = (String)model.asMap().get("imagepath1");
		String imagepath2 = (String)model.asMap().get("imagepath2");
		String imagepath3 = (String)model.asMap().get("imagepath3");
		String imagepath4 = (String)model.asMap().get("imagepath4");
		
		RecipeDAO adao = new RecipeDAO();
		
		adao.recUpdate(recipe_id,title,subtitle,cat1,cat2,cat3,cat4,portion,time,degree,
				writedate,material_id,material_group,
				imagepath,imagepath1,imagepath2,imagepath3,imagepath4);
		
		
	}	 

}
