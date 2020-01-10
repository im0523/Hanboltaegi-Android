package com.csslect.app.command;

import org.springframework.ui.Model;

import com.csslect.app.dao.CommunityDAO;
import com.csslect.app.dao.MemberDAO;
import com.csslect.app.dao.ScrapRecipeDAO;
import com.csslect.app.dto.CommunityDTO;
import com.csslect.app.dto.HanMemberDTO;

public class ScrapInsertCommand implements ACommand {

	@Override
	public void execute(Model model) {

		String scr_userid = (String) model.asMap().get("scr_userid");
		String scr_recipeid = (String) model.asMap().get("scr_recipeid");
		String target_userid = (String) model.asMap().get("target_userid");
		
		ScrapRecipeDAO dao = new ScrapRecipeDAO();
		dao.ScrapInsert(scr_userid, scr_recipeid, target_userid);
		
//		CommunityDAO adao = new CommunityDAO();
//		adao.CoInsert(content, nickname, userid);

		/*
		 * String id = (String)model.asMap().get("id"); String pwd =
		 * (String)model.asMap().get("pwd"); String nickname =
		 * (String)model.asMap().get("nickname"); String email =
		 * (String)model.asMap().get("email");
		 * 
		 * HanDAO adao = new HanDAO(); adao.HanInsert(id, pwd, nickname, email);
		 */

		/*
		 * int id = Integer.parseInt((String)model.asMap().get("id")); String name =
		 * (String)model.asMap().get("name"); String date =
		 * (String)model.asMap().get("date"); String dbImgPath =
		 * (String)model.asMap().get("dbImgPath");
		 * 
		 * ANDao adao = new ANDao(); adao.anInsertMulti(id, name, date, dbImgPath);
		 */

	}

}
