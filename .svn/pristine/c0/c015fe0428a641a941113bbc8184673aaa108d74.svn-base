package com.csslect.app.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csslect.app.command.ACommand;
import com.csslect.app.command.BbangRecipeCommand;
import com.csslect.app.command.BobRecipeCommand;
import com.csslect.app.command.ChefRankCommand;
import com.csslect.app.command.CoUpdateCommand;
import com.csslect.app.command.DessertRecipeCommand;
import com.csslect.app.command.GitaRecipeCommand;
import com.csslect.app.command.GoodCommand;
import com.csslect.app.command.MonthRecipeCommand;
import com.csslect.app.command.NoodleRecipeCommand;
import com.csslect.app.command.SaladRecipeCommand;
import com.csslect.app.command.ScrapDeleteCommand;
import com.csslect.app.command.ScrapInsertCommand;
import com.csslect.app.command.ScrapRecipeCommand;
import com.csslect.app.command.SideRecipeCommand;
import com.csslect.app.command.SoupRecipeCommand;
import com.csslect.app.command.SourceRecipeCommand;
import com.csslect.app.command.TodayRecipeCommand;
import com.csslect.app.command.WeekChefCommand;
import com.csslect.app.command.allRecipeCommand;
import com.csslect.app.command.grade1Command;
import com.csslect.app.command.grade2Command;
import com.csslect.app.command.gradeCommand;
import com.csslect.app.command.maincat2s1RecipeCommand;
import com.csslect.app.command.maincat2s2RecipeCommand;
import com.csslect.app.command.maincat2s3RecipeCommand;
import com.csslect.app.command.maincat2s4RecipeCommand;
import com.csslect.app.command.maincat2s5RecipeCommand;
import com.csslect.app.command.maincat3s1RecipeCommand;
import com.csslect.app.command.maincat3s2RecipeCommand;
import com.csslect.app.command.maincat3s3RecipeCommand;
import com.csslect.app.command.maincat4s1RecipeCommand;
import com.csslect.app.command.maincat4s2RecipeCommand;
import com.csslect.app.command.maincat4s3RecipeCommand;
import com.csslect.app.command.maincat4s4RecipeCommand;
import com.csslect.app.command.recipeCommentCommand;
import com.csslect.app.command.recipeCommentDeleteCommand;
import com.csslect.app.command.recipeCommentInsertCommand;
import com.csslect.app.command.searchAllListCommand;
import com.csslect.app.command.searchCommand;
import com.csslect.app.command.searchUpdateCommand;
import com.csslect.app.command.searchWeekCommand;
import com.csslect.app.command.weekRecipeCommand;

@Controller
public class HanController {

	ACommand command;

	
	
	//전문요리사 등급되기
			@RequestMapping(value="/grade2", method = {RequestMethod.GET, RequestMethod.POST})
			public void grade2(HttpServletRequest req, Model model){
				System.out.println("grade2()");	
				
				try {
					req.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
				String id = (String) req.getParameter("id");
				model.addAttribute("id", id);
				
				command = new grade2Command();
				command.execute(model);		
				
			}
	//숙련요리사 등급되기
			@RequestMapping(value="/grade1", method = {RequestMethod.GET, RequestMethod.POST})
			public void grade1(HttpServletRequest req, Model model){
				System.out.println("grade1()");	
				
				try {
					req.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
				String id = (String) req.getParameter("id");
				model.addAttribute("id", id);
				
				command = new grade1Command();
				command.execute(model);		
				
			}
	//초보요리사 등급되기
		@RequestMapping(value="/grade", method = {RequestMethod.GET, RequestMethod.POST})
		public void grade(HttpServletRequest req, Model model){
			System.out.println("grade()");	
			
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			String id = (String) req.getParameter("id");
			model.addAttribute("id", id);
			
			command = new gradeCommand();
			command.execute(model);		
			
		}
	
	
	// �넫�뿭釉섓옙�뒄
	@RequestMapping(value = "/searchUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public void searchUpdate(HttpServletRequest req, Model model) {
		System.out.println("Good()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String count = (String) req.getParameter("count");
		String no = (String) req.getParameter("no");

		model.addAttribute("count", count);
		model.addAttribute("no", no);
		System.out.println("Hancontroller:" + count + no);
		command = new searchUpdateCommand();
		command.execute(model);

	}

	// �뚣끇占썬끇�빍占쎈뼒 疫뀐옙 筌뤴뫖以�
	@RequestMapping(value = "/searchAllList", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchAllList(HttpServletRequest req, Model model) {
		System.out.println("searchAllList()");

		command = new searchAllListCommand();
		command.execute(model);

		return "searchAllList";
	}

	// 검색한 내용 저장처리
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public void search(HttpServletRequest req, Model model) {
		System.out.println("search()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String content = (String) req.getParameter("content");

		model.addAttribute("content", content);

		command = new searchCommand();
		command.execute(model);

	}

	// �뚣끇占썬끇�빍占쎈뼒 疫뀐옙 筌뤴뫖以�
	@RequestMapping(value = "/searchWeek", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchWeek(HttpServletRequest req, Model model) {
		System.out.println("searchWeek()");

		command = new searchWeekCommand();
		command.execute(model);

		return "searchWeek";
	}

	// 占쎄맒占쎄쉭占쎌쟿占쎈뻻占쎈돗 �굜遺얠컲占쎈뱜 占쎄텣占쎌젫
	@RequestMapping(value = "/recipeCommentDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public void InquiryDelete(HttpServletRequest req, Model model) {
		System.out.println("recipeCommentDelete()");

		model.addAttribute("no", req.getParameter("no"));

		System.out.println((String) req.getParameter("no"));

		command = new recipeCommentDeleteCommand();
		command.execute(model);

	}

	// 占쎄맒占쎄쉭占쎌쟿占쎈뻻占쎈돗 �굜遺얠컲占쎈뱜占쎌삂占쎄쉐
	@RequestMapping(value = "/recipeCommentInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String recipeCommentInsert(HttpServletRequest req, Model model) {
		System.out.println("recipeCommentInsert()");

		String rc_id = (String) req.getParameter("rc_id");
		String member_id = (String) req.getParameter("member_id");
		String content = (String) req.getParameter("content");

		System.out.println(rc_id);
		System.out.println(member_id);
		System.out.println(content);

		model.addAttribute("rc_id", rc_id);
		model.addAttribute("member_id", member_id);
		model.addAttribute("content", content);

		command = new recipeCommentInsertCommand();
		command.execute(model);

		return "CommunityInsert";
	}

	// 占쎌쟿占쎈뻻占쎈돗 �굜遺얇렎占쎈뱜
	@RequestMapping(value = "/recipeComment", method = { RequestMethod.GET, RequestMethod.POST })
	public String recipeComment(HttpServletRequest req, Model model) {
		System.out.println("recipeComment()");
		String rc_id = (String) req.getParameter("rc_id");
		model.addAttribute("rc_id", rc_id);

		command = new recipeCommentCommand();
		command.execute(model);

		return "recipeComment";
	}

	// �넫�뿭釉섓옙�뒄
	@RequestMapping(value = "/Good", method = { RequestMethod.GET, RequestMethod.POST })
	public void Good(HttpServletRequest req, Model model) {
		System.out.println("Good()");

		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String good = (String) req.getParameter("good");
		String recipe_id = (String) req.getParameter("recipe_id");

		model.addAttribute("good", good);
		model.addAttribute("recipe_id", recipe_id);

		command = new GoodCommand();
		command.execute(model);

	}

	// 占쎈뮞占쎄쾿占쎌삫 筌욑옙占쎌뒭疫뀐옙
	@RequestMapping(value = "/ScrapDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public void ScrapDelete(HttpServletRequest req, Model model) {
		System.out.println("ScrapDelete()");

		model.addAttribute("scr_id", req.getParameter("scr_id"));

		System.out.println(req.getParameter("scr_id"));

		command = new ScrapDeleteCommand();
		command.execute(model);

	}

	// 占쎈뮞占쎄쾿占쎌삫 筌ｌ꼶�봺
	@RequestMapping(value = "/ScrapInsert", method = { RequestMethod.GET, RequestMethod.POST })
	public String ScrapInsert(HttpServletRequest req, Model model) {
		System.out.println("ScrapInsert()");

		String scr_userid = (String) req.getParameter("scr_userid");
		String scr_recipeid = (String) req.getParameter("scr_recipeid");
		String target_userid = (String) req.getParameter("target_userid");

		System.out.println(scr_userid);
		System.out.println(scr_recipeid);
		System.out.println(target_userid);

		model.addAttribute("scr_userid", scr_userid);
		model.addAttribute("scr_recipeid", scr_recipeid);
		model.addAttribute("target_userid", target_userid);

		command = new ScrapInsertCommand();
		command.execute(model);

		return "ScrapInsert";
	}

	// 占쎈뮞占쎄쾿占쎌삫占쎈립 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/ScrapRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String ScrapRecipe(HttpServletRequest req, Model model) {
		System.out.println("ScrapRecipe()");

//		int scr_id = Integer.parseInt(req.getParameter("scr_id"));
		model.addAttribute("scr_userid", req.getParameter("scr_userid"));

		System.out.println(req.getParameter("scr_userid"));

		command = new ScrapRecipeCommand();
		command.execute(model);

		return "ScrapRecipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat4s4Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat4s4Recipe(HttpServletRequest req, Model model) {

		command = new maincat4s4RecipeCommand();
		command.execute(model);

		return "maincat4s4Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat4s3Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat4s3Recipe(HttpServletRequest req, Model model) {

		command = new maincat4s3RecipeCommand();
		command.execute(model);

		return "maincat4s3Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat4s2Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat4s2Recipe(HttpServletRequest req, Model model) {

		command = new maincat4s2RecipeCommand();
		command.execute(model);

		return "maincat4s2Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat4s1Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat4s1Recipe(HttpServletRequest req, Model model) {

		command = new maincat4s1RecipeCommand();
		command.execute(model);

		return "maincat4s1Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat3s3Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat3s3Recipe(HttpServletRequest req, Model model) {

		command = new maincat3s3RecipeCommand();
		command.execute(model);

		return "maincat3s3Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat3s2Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat3s2Recipe(HttpServletRequest req, Model model) {

		command = new maincat3s2RecipeCommand();
		command.execute(model);

		return "maincat3s2Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat3s1Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat3s1Recipe(HttpServletRequest req, Model model) {

		command = new maincat3s1RecipeCommand();
		command.execute(model);

		return "maincat3s1Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat2s5Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat2s5Recipe(HttpServletRequest req, Model model) {

		command = new maincat2s5RecipeCommand();
		command.execute(model);

		return "maincat2s5Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat2s4Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat2s4Recipe(HttpServletRequest req, Model model) {

		command = new maincat2s4RecipeCommand();
		command.execute(model);

		return "maincat2s4Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat2s3Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat2s3Recipe(HttpServletRequest req, Model model) {

		command = new maincat2s3RecipeCommand();
		command.execute(model);

		return "maincat2s3Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat2s2Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat2s2Recipe(HttpServletRequest req, Model model) {

		command = new maincat2s2RecipeCommand();
		command.execute(model);

		return "maincat2s2Recipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/maincat2s1Recipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String maincat2s1Recipe(HttpServletRequest req, Model model) {
		System.out.println("maincat2s1Recipe()");

		command = new maincat2s1RecipeCommand();
		command.execute(model);

		return "maincat2s1Recipe";
	}

	// 占쎌읈筌ｏ옙 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/allRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String allRecipe(HttpServletRequest req, Model model) {

		command = new allRecipeCommand();
		command.execute(model);

		return "allRecipe";
	}

	// 占쎌뵠 占쎈뼎占쎌벥 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/monthRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String monthRecipe(HttpServletRequest req, Model model) {
		System.out.println("monthRecipe()");

		command = new MonthRecipeCommand();
		command.execute(model);

		return "monthRecipe";
	}

	// 占쎌뵠 雅뚯눘�벥 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/weekRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String weekRecipe(HttpServletRequest req, Model model) {
		System.out.println("weekRecipe()");

		command = new weekRecipeCommand();
		command.execute(model);

		return "weekRecipe";
	}

	// 疫꿸퀬占� 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/GitaRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String GitaRecipe(HttpServletRequest req, Model model) {
		System.out.println("GitaRecipe()");

		command = new GitaRecipeCommand();
		command.execute(model);

		return "GitaRecipe";
	}

	// �뜮占� 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/BbangRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String BbangRecipe(HttpServletRequest req, Model model) {
		System.out.println("BbangRecipe()");

		command = new BbangRecipeCommand();
		command.execute(model);

		return "BbangRecipe";
	}

	// 占쎄튂占쎌쑎占쎈굡 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/SaladRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String SaladRecipe(HttpServletRequest req, Model model) {
		System.out.println("SaladRecipe()");

		command = new SaladRecipeCommand();
		command.execute(model);

		return "SaladRecipe";
	}

	// 獄쎧쇽폓占쎈폔 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/BobRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String BobRecipe(HttpServletRequest req, Model model) {
		System.out.println("BobRecipe()");

		command = new BobRecipeCommand();
		command.execute(model);

		return "BobRecipe";
	}

	// 占쎈펶占쎈�쀯옙�꺖占쎈뮞 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/SourceRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String SourceRecipe(HttpServletRequest req, Model model) {
		System.out.println("SourceRecipe()");

		command = new SourceRecipeCommand();
		command.execute(model);

		return "SourceRecipe";
	}

	// 筌롫�履� 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/NoodleRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String NoodleRecipe(HttpServletRequest req, Model model) {
		System.out.println("NoodleRecipe()");

		command = new NoodleRecipeCommand();
		command.execute(model);

		return "NoodleRecipe";
	}

	// 占쎈탵占쏙옙占쎈뱜 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/DessertRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String DessertRecipe(HttpServletRequest req, Model model) {
		System.out.println("DessertRecipe()");

		command = new DessertRecipeCommand();
		command.execute(model);

		return "DessertRecipe";
	}

	// �뤃占썹몴占� 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/SoupRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String SoupRecipe(HttpServletRequest req, Model model) {
		System.out.println("SoupRecipe()");

		command = new SoupRecipeCommand();
		command.execute(model);

		return "SoupRecipe";
	}

	// 獄쏆꼷媛붻퉪占� 占쎌쟿占쎈뻻占쎈돗
	@RequestMapping(value = "/SideRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String SideRecipe(HttpServletRequest req, Model model) {
		System.out.println("SideRecipe()");

		command = new SideRecipeCommand();
		command.execute(model);

		return "SideRecipe";
	}

	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 DB�뜝�럩�젧�솻洹⑥삕 �뜝�럩諭썲뜝�럩�뮡�뼨�먯삕
	// 嶺뚮∥�뾼占쎈데�뜝�럩�꼨嶺뚮〕�삕 �뜝�럩逾η뼨�먯삕 �뜝�럩�읉�뜝�럥六삣뜝�럥�룛 �뜝�럩�꼨嶺뚮〕�삕
	@RequestMapping(value = "/todayRecipe", method = { RequestMethod.GET, RequestMethod.POST })
	public String mainRecipe(HttpServletRequest req, Model model) {
		System.out.println("todayRecipe()");

		command = new TodayRecipeCommand();
		command.execute(model);

		return "todayRecipe";
	}

	// 占쎌뵠占쎈뼎占쎌벥 占쎈렰占쎈늄占쎌삻占쎄때 筌뤴뫖以�
	@RequestMapping(value = "/chefRank", method = { RequestMethod.GET, RequestMethod.POST })
	public String chefRank(HttpServletRequest req, Model model) {
		System.out.println("chefRank()");

		command = new ChefRankCommand();
		command.execute(model);

		return "chefRank";
	}

	// 占쎌뵠占쎈뼎占쎌벥 占쎈렰占쎈늄占쎌삻占쎄때 TOP3
	@RequestMapping(value = "/weekChef", method = { RequestMethod.GET, RequestMethod.POST })
	public String weekChef(HttpServletRequest req, Model model) {
		System.out.println("weekChef()");

		command = new WeekChefCommand();
		command.execute(model);

		return "weekChef";
	}

}
