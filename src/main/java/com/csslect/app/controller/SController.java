package com.csslect.app.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csslect.app.command.ACommand;
import com.csslect.app.command.AnInquiryCommand;
import com.csslect.app.command.InquiryDeleteCommand;
import com.csslect.app.command.InquiryInsertCommand;
import com.csslect.app.command.InquiryUpdateCommand;
import com.csslect.app.command.MyRecipeCommand;
import com.csslect.app.command.SearchRecipeCommand;
@Controller
public class SController {
	
	ACommand command;
	
	// 공지글 목록조회
	@RequestMapping(value = "/anInquiry", method = { RequestMethod.GET, RequestMethod.POST })
	public String anInquiry(HttpServletRequest req, Model model) {
		System.out.println("anInquiry()");
		
		command = new AnInquiryCommand();
		command.execute(model);

		return "anInquiry";
	}
	
	// 공지글 신규저장 처리
	@RequestMapping(value = "/InquiryInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String InquiryInsert(HttpServletRequest req, Model model) {
		System.out.println("InquiryInsert()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String title = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		String nickname = (String) req.getParameter("nickname");
		String id = (String) req.getParameter("id");

		System.out.println(title);
		System.out.println(nickname);
		System.out.println(content);
		System.out.println(id);

		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("nickname", nickname);
		model.addAttribute("id", id);


		command = new InquiryInsertCommand();
		command.execute(model);

		return "InquiryInsert";
	}

	// 공지글 수정저장 처리
	@RequestMapping(value = "/InquiryUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String InquiryUpdate(HttpServletRequest req, Model model) {
		System.out.println("InquiryUpdate()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String title = (String) req.getParameter("title");
		String nickname = (String) req.getParameter("nickname");
		String content = (String) req.getParameter("content");
		String id = (String) req.getParameter("id");
		String no= req.getParameter("no");

		System.out.println(title);
		System.out.println(content);

		model.addAttribute("title", title);
		model.addAttribute("nickname", nickname);
		model.addAttribute("content", content);
		model.addAttribute("id", id);
		model.addAttribute("no", no);


		command = new InquiryUpdateCommand();
		command.execute(model);

		return "InquiryUpdate";
	}
	
	// 공지글 삭제처리
	@RequestMapping(value="/InquiryDelete", method = {RequestMethod.GET, RequestMethod.POST})
	public void InquiryDelete(HttpServletRequest req, Model model){
		System.out.println("InquiryDelete()");		
		
		model.addAttribute("no", req.getParameter("no"));		
				
		System.out.println((String)req.getParameter("no"));
		
		command = new InquiryDeleteCommand();
		command.execute(model);	
		
	}
	
	// 내가 올린 레시피 목록 조회
	@RequestMapping(value = "/MyRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String MyRecipe(HttpServletRequest req, Model model) {
		System.out.println("MyRecipe()");
		model.addAttribute("userid", req.getParameter("userid"));
		command = new MyRecipeCommand();
		command.execute(model);

		return "MyRecipe";
	}
	
	//검색한 레시피 목록 조회
		@RequestMapping(value = "/SearchRecipe", method = { RequestMethod.GET, RequestMethod.POST })
		public String SearchRecipe(HttpServletRequest req, Model model) {
			System.out.println("SearchRecipe()");
			
			//model.addAttribute("userid", req.getParameter("userid"));
			
			command = new SearchRecipeCommand();
			command.execute(model);

			return "SearchRecipe";
		}
}
