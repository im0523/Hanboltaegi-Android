package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.CommunityDAO;
import com.csslect.app.dao.RecipeDAO;

public class recipeCommentInsertCommand implements ACommand {

	@Override
	public void execute(Model model) {
		String rc_id = (String) model.asMap().get("rc_id");
		String member_id = (String) model.asMap().get("member_id");
		String content = (String) model.asMap().get("content");
		
		RecipeDAO adao = new RecipeDAO();
		adao.recipeCommentInsert(rc_id, member_id, content);
	}

}
