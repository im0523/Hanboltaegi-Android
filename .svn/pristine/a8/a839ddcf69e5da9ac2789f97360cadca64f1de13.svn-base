package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;
import com.csslect.app.dto.ChefRankDTO;


public class ChefRankCommand implements ACommand {

	@Override
	public void execute(Model model) {
		MemberDAO dao = new MemberDAO();
		ArrayList<ChefRankDTO> list = dao.chefRank();
		
		model.addAttribute("chefRank", list);

	}

}
