package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.ANDao;
import com.csslect.app.dao.CommunityDAO;


public class CoDeleteCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		
		String no = (String) model.asMap().get("no");
		
		CommunityDAO adao = new CommunityDAO();
		adao.CoDelete(no);
		
		/*int id = Integer.parseInt((String)model.asMap().get("id"));
		
		ANDao adao = new ANDao();
		adao.anDeleteMulti(id);		
		*/	
	}	 

}
