package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;
import com.csslect.app.dto.MaterialDTO;
import com.csslect.app.dto.RecipeDTO;


public class MaterialSelectCommand implements ACommand{

	@Override
	public void execute(Model model) {			
		RecipeDAO adao = new RecipeDAO();
		ArrayList<MaterialDTO> adtos = adao.matSelect();
		
		model.addAttribute("matSelect", adtos); 
		
	}
	
}
