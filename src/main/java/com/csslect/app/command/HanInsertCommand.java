package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;

public class HanInsertCommand implements ACommand{	
	
	@Override
	public void execute(Model model) {
		
		String id = (String)model.asMap().get("id");
		String pwd = (String)model.asMap().get("pwd"); 
		String nickname = (String)model.asMap().get("nickname"); 
		String email = (String)model.asMap().get("email");
		
		MemberDAO adao = new MemberDAO();
		adao.HanInsert(id, pwd, nickname, email);
		
		
		/*int id = Integer.parseInt((String)model.asMap().get("id"));
		String name = (String)model.asMap().get("name");
		String date = (String)model.asMap().get("date");			
		String dbImgPath = (String)model.asMap().get("dbImgPath");
		
		ANDao adao = new ANDao();
		adao.anInsertMulti(id, name, date, dbImgPath);*/
			
	}	 

}
