package com.csslect.app.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;

import com.csslect.app.command.ACommand;
import com.csslect.app.command.CoDeleteCommand;
import com.csslect.app.command.CoInsertCommand;
import com.csslect.app.command.CoUpdateCommand;
import com.csslect.app.command.CommentCommand;
import com.csslect.app.command.HanInsertCommand;
import com.csslect.app.command.HanLoginCommand;
import com.csslect.app.command.HanUpdateCommand;
import com.csslect.app.command.JoongbokIdCommand;
import com.csslect.app.command.JoongbokNickCommand;

@Controller
public class AController {

	ACommand command;

	// 커뮤니티, 스크랩한레시피, 회원정보, 로그인
	
	
	//커뮤니티 글 수정
	@RequestMapping(value="/CommunityUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public void CommunityUpdate(HttpServletRequest req, Model model){
		System.out.println("CommunityUpdate()");	
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		String content = (String) req.getParameter("content");
		String no = (String) req.getParameter("no");
		
		model.addAttribute("content", content);
		model.addAttribute("no", no);
		
		command = new CoUpdateCommand();
		command.execute(model);		
		
	}
	
	
	
	
	
	// 커뮤니티 글 삭제
	@RequestMapping(value="/CommunityDelete", method = {RequestMethod.GET, RequestMethod.POST})
	public void CommunityDelete(HttpServletRequest req, Model model){
		System.out.println("CommunityDelete()");		
		
		
		model.addAttribute("no", req.getParameter("no"));		
				
		System.out.println(req.getParameter("no"));
			
		
		command = new CoDeleteCommand();
		command.execute(model);	
		
	}
	
	
	
	
	// 커뮤니티 글쓰기
	@RequestMapping(value = "/CommunityInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String CommunityInsert(HttpServletRequest req, Model model) {
		System.out.println("CommunityInsert()");

		/*try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/

		String nickname = (String) req.getParameter("nickname");
		String content = (String) req.getParameter("content");
//		String dbImgPath = (String) req.getParameter("dbImgPath");
		String userid = (String) req.getParameter("userid");
			
		System.out.println(nickname);
		System.out.println(content);
//		System.out.println(dbImgPath);
		System.out.println(userid);

		model.addAttribute("nickname", nickname);
		model.addAttribute("content", content);
//		model.addAttribute("dbImgPath", dbImgPath);
		model.addAttribute("userid", userid);

//		MultipartRequest multi = (MultipartRequest) req;
//		MultipartFile file = multi.getFile("image");
//		
//		if(file != null) {
//			String fileName = file.getOriginalFilename();
//			System.out.println(fileName);
//			
//			// 디렉토리 존재하지 않으면 생성
//			makeDir(req);	
//				
//			if(file.getSize() > 0){			
//				String realImgPath = req.getSession().getServletContext()
//						.getRealPath("/resources/");
//				
//				System.out.println( fileName + " : " + realImgPath);
//				System.out.println( "fileSize : " + file.getSize());					
//												
//			 	try {
//			 		// 이미지파일 저장
//					file.transferTo(new File(realImgPath, fileName));										
//				} catch (Exception e) {
//					e.printStackTrace();
//				} 
//									
//			}else{
//				// 이미지파일 실패시
//				fileName = "FileFail.jpg";
//				String realImgPath = req.getSession().getServletContext()
//						.getRealPath("/resources/" + fileName);
//				System.out.println(fileName + " : " + realImgPath);
//						
//			}			
//			
//		}

		command = new CoInsertCommand();
		command.execute(model);

		return "CommunityInsert";
	}
	
	
	public void makeDir(HttpServletRequest req){
		File f = new File(req.getSession().getServletContext()
				.getRealPath("/resources"));
		if(!f.isDirectory()){
		f.mkdir();
		}	
	}
	
	
	
	// 커뮤니티 글 목록
	@RequestMapping(value = "/Comment", method = { RequestMethod.GET, RequestMethod.POST })
	public String Comment(HttpServletRequest req, Model model) {
		System.out.println("Comment()");

		command = new CommentCommand();
		command.execute(model);

		return "Comment";
	}
	
	
	
	
	//회원정보 수정
		@RequestMapping(value="/HanUpdate", method = {RequestMethod.GET, RequestMethod.POST})
		public void HanUpdate(HttpServletRequest req, Model model){
			System.out.println("HanUpdate()");	
			
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			String nickname = (String) req.getParameter("nickname");
			String pwd = (String) req.getParameter("pwd");
			String email = (String) req.getParameter("email");
			String id = (String) req.getParameter("id");
			
			model.addAttribute("nickname", nickname);
			model.addAttribute("pwd", pwd);
			model.addAttribute("email", email);
			model.addAttribute("id", id);
			
			command = new HanUpdateCommand();
			command.execute(model);		
			
		}
	
	
	
	
	
	
	
	//닉네임 중복확인
	@RequestMapping(value="/JoongbokNick", method = {RequestMethod.GET, RequestMethod.POST})
	public String JoongbokNick(HttpServletRequest req, Model model) {
		System.out.println("JoongbokNick()");
		
//		String id = (String)req.getParameter("id");
		String nickname = (String)req.getParameter("nickname");
		
		model.addAttribute("nickname", nickname);
		
		System.out.println("컨트롤러 닉네임 체크 : " + nickname);
		
		command = new JoongbokNickCommand();
		command.execute(model);
		
		return "JoongbokNick";
	}
	
	
	//아이디 중복확인
	@RequestMapping(value="/JoongbokId", method = {RequestMethod.GET, RequestMethod.POST})
	public String JoongbokId(HttpServletRequest req, Model model) {
		System.out.println("JoongbokId()");
		
		String id = (String)req.getParameter("id");
		
		model.addAttribute("id", id);
		
		System.out.println("컨트롤러 아이디 체크 : " + id);
		
		command = new JoongbokIdCommand();
		command.execute(model);
		
		return "JoongbokId";
	}
	
	
	
	

	// 한볼테기 회원가입하기
	@RequestMapping(value = "/HanInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String HanInsert(HttpServletRequest req, Model model) {
		System.out.println("HanInsert()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String id = (String) req.getParameter("id");
		String pwd = (String) req.getParameter("pwd");
		String nickname = (String) req.getParameter("nickname");
		String email = (String) req.getParameter("email");

		System.out.println(id);
		System.out.println(pwd);
		System.out.println(nickname);
		System.out.println(email);

		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		model.addAttribute("nickname", nickname);
		model.addAttribute("email", email);

		MultipartRequest multi = (MultipartRequest) req;

		command = new HanInsertCommand();
		command.execute(model);

		return "HanInsert";
	}

	// 로그인
	@RequestMapping(value = "/HanLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String HanLogin(HttpServletRequest req, Model model) {
		System.out.println("HanLogin()");

		String id = (String) req.getParameter("id");
		String pwd = (String) req.getParameter("pwd");

		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);

		System.out.println(id);
		System.out.println(pwd);

		command = new HanLoginCommand();
		command.execute(model);

		return "HanLogin";
	}
}
