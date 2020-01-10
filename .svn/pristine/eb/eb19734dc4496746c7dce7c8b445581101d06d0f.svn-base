package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.ANDao;
import com.csslect.app.dao.CommunityDAO;

public class CoUpdateCommand implements ACommand{	
	
	
	
	@Override
	public void execute(Model model) {
		String content = (String)model.asMap().get("content");
		String no = (String)model.asMap().get("no");
		
		CommunityDAO dao = new CommunityDAO();
		dao.CoUpdate(content, no);
	}
	
	
	
	
	
	
	
	
	
	/*@Override
	public void execute(Model model) {
		int id = Integer.parseInt((String)model.asMap().get("id"));
		String name = (String)model.asMap().get("name");
		String date = (String)model.asMap().get("date");
		String dbImgPath= (String)model.asMap().get("dbImgPath");
		
		ANDao adao = new ANDao();
		
		adao.anUpdateMulti(id, name, date, dbImgPath);
		
		
	}*/	 

}
