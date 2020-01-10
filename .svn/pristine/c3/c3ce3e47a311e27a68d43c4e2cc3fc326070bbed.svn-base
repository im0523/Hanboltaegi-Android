package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.RecipeDTO;

public class RecepeCommand implements ACommand{
	@Override
	public void execute(Model model) {
		
		String id = (String)model.asMap().get("recipe_id");
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
		
		System.out.println(id);
		System.out.println(title);
		System.out.println(subtitle);
		
		RecipeDAO adao = new RecipeDAO();
		ArrayList<RecipeDTO> adtos = adao.recipe(id, title,subtitle,cat1,cat2,cat3,cat4,portion,time,degree,writedate,material_id,material_group);
		
		model.addAttribute("recipe", adtos); 
		
	}
}
