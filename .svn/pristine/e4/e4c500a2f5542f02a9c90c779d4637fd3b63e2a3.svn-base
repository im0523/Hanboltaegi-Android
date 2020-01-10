package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.ANDao;
import com.csslect.app.dao.CommunityDAO;
import com.csslect.app.dao.MemberDAO;

public class HanUpdateCommand implements ACommand{	
	
	
	
	@Override
	public void execute(Model model) {
		String nickname = (String)model.asMap().get("nickname");
		String pwd = (String)model.asMap().get("pwd");
		String email = (String)model.asMap().get("email");
		String id = (String)model.asMap().get("id");
		
		MemberDAO adao = new MemberDAO();
		adao.MemberModify(pwd, nickname, email, id);
		
		
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
