package com.csslect.app.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.csslect.app.dao.MemberDAO;
import com.csslect.app.dto.WeekChefDTO;

public class WeekChefCommand implements ACommand{

	@Override
	public void execute(Model model) {
		MemberDAO dao = new MemberDAO();
		ArrayList<WeekChefDTO> list = dao.weekChef();
		
		model.addAttribute("weekChef", list);
		
	}

}
