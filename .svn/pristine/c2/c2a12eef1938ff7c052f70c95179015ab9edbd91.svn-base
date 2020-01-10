package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.command.ACommand;
import com.csslect.app.dao.RecipeDAO;

public class ProUpdateCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;

		String recipe_id = (String) model.asMap().get("recipe_id");
		text1 = (String) model.asMap().get("text1");
		text2 = (String) model.asMap().get("text2");
		text3 = (String) model.asMap().get("text3");
		text4 = (String) model.asMap().get("text4");
		text5 = (String) model.asMap().get("text5");
		text6 = (String) model.asMap().get("text6");
		text7 = (String) model.asMap().get("text7");
		text8 = (String) model.asMap().get("text8");
		text9 = (String) model.asMap().get("text9");
		text10 = (String) model.asMap().get("text10");

		RecipeDAO adao = new RecipeDAO();

		adao.recUpdate(recipe_id,text1, text2 ,text3 ,text4,text5,text6,text7,text8,text9,text10);

	}

}
