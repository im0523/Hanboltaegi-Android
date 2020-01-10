package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.RecipeDTO;


public class RecepeSelectCommand implements ACommand{

	@Override
	public void execute(Model model) {			
		RecipeDAO adao = new RecipeDAO();
		ArrayList<RecipeDTO> adtos = adao.recSelect();
		
		model.addAttribute("recSelect", adtos); 
		
	}
	
}
