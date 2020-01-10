package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.RecipeDAO;

public class MaterialInsertCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		
		String material_id, material_group,recipe_id;
	    String material_name0, material_name1, material_name2, material_name3, material_name4, material_name5, material_name6, material_name7, material_name8, material_name9;
	    String material_unit0, material_unit1, material_unit2, material_unit3, material_unit4, material_unit5, material_unit6, material_unit7, material_unit8, material_unit9;
	    
	    material_id = (String)model.asMap().get("material_id");
	    material_group = (String)model.asMap().get("material_group");
	    recipe_id = (String)model.asMap().get("recipe_id");
	    material_name0 = (String)model.asMap().get("material_name0");
	    material_unit0 = (String)model.asMap().get("material_unit0");
	    material_name1 = (String)model.asMap().get("material_name1");
	    material_unit1 = (String)model.asMap().get("material_unit1");
	    material_name2 = (String)model.asMap().get("material_name2");
	    material_unit2 = (String)model.asMap().get("material_unit2");
	    material_name3 = (String)model.asMap().get("material_name3");
	    material_unit3 = (String)model.asMap().get("material_unit3");
	    material_name4 = (String)model.asMap().get("material_name4");
	    material_unit4 = (String)model.asMap().get("material_unit4");
	    material_name5 = (String)model.asMap().get("material_name5");
	    material_unit5 = (String)model.asMap().get("material_unit5");
	    material_name6 = (String)model.asMap().get("material_name6");
	    material_unit6 = (String)model.asMap().get("material_unit6");
	    material_name7 = (String)model.asMap().get("material_name7");
	    material_unit7 = (String)model.asMap().get("material_unit7");
	    material_name8 = (String)model.asMap().get("material_name8");
	    material_unit8 = (String)model.asMap().get("material_unit8");
	    material_name9 = (String)model.asMap().get("material_name9");
	    material_unit9 = (String)model.asMap().get("material_unit9");
		
		RecipeDAO adao = new RecipeDAO();
		adao.recInsert(material_id,material_group,recipe_id,
				material_name0,material_unit0,
				material_name1,material_unit1,
				material_name2,material_unit2,
				material_name3,material_unit3,
				material_name4,material_unit4,
				material_name5,material_unit5,
				material_name6,material_unit6,
				material_name7,material_unit7,
				material_name8,material_unit8,
				material_name9,material_unit9
				);
			
	}	 

}
