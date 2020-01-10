package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;

public class RecepeImageInsertCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		
		String imagepathA1 = (String)model.asMap().get("imagepathA1");
		System.out.println("RecipeImageInsertCommand()");
		String imagepathA5,imagepathA6,imagepathA7,imagepathA8,imagepathA9,imagepathA0;
		imagepathA0 = (String)model.asMap().get("imagepathA0");
		System.out.println("imagepathA0 - " +imagepathA0);
		System.out.println(imagepathA1);
		String imagepathA2 = (String)model.asMap().get("imagepathA2");
		String imagepathA3 = (String)model.asMap().get("imagepathA3");
		String imagepathA4 = (String)model.asMap().get("imagepathA4");			
		imagepathA5 = (String)model.asMap().get("imagepathA5");
		imagepathA6 = (String)model.asMap().get("imagepathA6");
		imagepathA7 = (String)model.asMap().get("imagepathA7");
		imagepathA8 = (String)model.asMap().get("imagepathA8");
		imagepathA9 = (String)model.asMap().get("imagepathA9");
		String recipe_id = (String)model.asMap().get("recipe_id");
		String pnt = (String)model.asMap().get("pnt");
		
		RecipeDAO adao = new RecipeDAO();
		adao.recInsert(recipe_id,imagepathA0,imagepathA1,imagepathA2,imagepathA3,imagepathA4,imagepathA5,imagepathA6,imagepathA7,imagepathA8,imagepathA9,pnt);
			
	}	 

}
