package com.csslect.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.csslect.app.dto.MaterialDTO;
import com.csslect.app.dto.MyRecipeDTO;
import com.csslect.app.dto.RecipeCommentDTO;
import com.csslect.app.dto.RecipeDTO;
import com.csslect.app.dto.TodayRecipeDTO;

public class RecipeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	DataSource dataSource;

	public RecipeDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team2");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}
	}

	//
	private void disconn() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	// 좋아요 처리
	public int Good(String good, String recipe_id) {
		conn = null;
		ps = null;
		rs = null;

		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update recipe set good = ? + 1 where recipe_id = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, good);
			ps.setString(2, recipe_id);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

		} catch (Exception e) {

		} finally {
			disconn();
		}

		return state;
	}

	// 검색한 레시피 목록
	public ArrayList<MyRecipeDTO> SearchRecipe() {
		ArrayList<MyRecipeDTO> list = new ArrayList<MyRecipeDTO>();
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String titl = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
				
				MyRecipeDTO dto = new MyRecipeDTO(nickname, titl, recipe_id, subtitle, portion, time, cat1, cat2, cat3,
						cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3, image4, image5,
						image6, image7, image8, image9, image10, text1, text2, text3, text4, text5, text6, text7, text8,
						text9, text10, material_name0, material_unit0, material_name1, material_unit1, material_name2,
						material_unit2, material_name3, material_unit3, material_name4, material_unit4, material_name5,
						material_unit5, material_name6, material_unit6, material_name7, material_unit7, material_name8,
						material_unit8, material_name9, material_unit9, material_name10, material_unit10,
						material_name11, material_unit11, material_name12, material_unit12);
				list.add(dto);
			}

			System.out.println("list크기" + list.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		return list;
	}

	// 내가 올린 레시피 목록 조회(네비)
	public ArrayList<TodayRecipeDTO> myListRecipe(String userid) {
		ArrayList<TodayRecipeDTO> list = new ArrayList<TodayRecipeDTO>();
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, userid, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and r.userid = '" + userid
					+ "' " + "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			
				TodayRecipeDTO dto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1, cat2,
						cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3, image4,
						image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5, text6,
						text7, text8, text9, text10, material_name0, material_unit0, material_name1, material_unit1,
						material_name2, material_unit2, material_name3, material_unit3, material_name4, material_unit4,
						material_name5, material_unit5, material_name6, material_unit6, material_name7, material_unit7,
						material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12
						);
				list.add(dto);
			}

			System.out.println("myListRecipelist크기" + list.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return list;
	}

	// 내가 올린 레시피 목록 조회(검색)
	public ArrayList<MyRecipeDTO> MyRecipe(String userid) {
		ArrayList<MyRecipeDTO> list = new ArrayList<MyRecipeDTO>();
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and userid = ? "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			
				MyRecipeDTO dto = new MyRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1, cat2, cat3,
						cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3, image4, image5,
						image6, image7, image8, image9, image10, text1, text2, text3, text4, text5, text6, text7, text8,
						text9, text10, material_name0, material_unit0, material_name1, material_unit1, material_name2,
						material_unit2, material_name3, material_unit3, material_name4, material_unit4, material_name5,
						material_unit5, material_name6, material_unit6, material_name7, material_unit7, material_name8,
						material_unit8, material_name9, material_unit9, material_name10, material_unit10,
						material_name11, material_unit11, material_name12, material_unit12);
				list.add(dto);
			}

			System.out.println("list크기" + list.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return list;
	}

	public ArrayList<TodayRecipeDTO> monthRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n"
					+ "and to_date(writedate) between sysdate-30 and sysdate-1 \r\n" + "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12
					);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 이주의 레시피
	public ArrayList<TodayRecipeDTO> weekRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n"
					+ "and to_date(writedate) between sysdate-7 and sysdate-1 \r\n" + "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 메인화면 인기레시피(주간3위)
	public ArrayList<TodayRecipeDTO> todayRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n"
					+ "and to_date(writedate) between sysdate-7 and sysdate-1 \r\n" + "and rownum<4 order by good desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
				

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("todayRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat2s1Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat2='초스피드' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;

	}

	public ArrayList<TodayRecipeDTO> allRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat2s2Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat2='일상' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat2s4Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat2='술안주' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
	
				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat2s5Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat2='간식' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
	

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat2s3Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat2='손님접대' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		
				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("weekRecipeDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat3s1Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat3='육류' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
	

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat3s2Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat3='해산물' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
	

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat3s3Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat3='가공식품' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat4s1Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat4='봄' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat4s2Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat4='여름' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat4s3Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat4='가을' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<TodayRecipeDTO> maincat4s4Recipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.*\r\n"
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm\r\n"
					+ "where r.recipe_id = ri.recipe_id(+)\r\n" + "and r.recipe_id = rt.recipe_id(+)\r\n"
					+ "and r.userid= m.id(+)\r\n" + "and r.recipe_id = mm.recipe_id(+)\r\n" + "and cat4='겨울' \r\n"
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 장주
	// 기타 레시피
	public ArrayList<TodayRecipeDTO> GitaRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '기타' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("GitaRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 빵 레시피
	public ArrayList<TodayRecipeDTO> BbangRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '빵' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("BbangRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 샐러드 레시피
	public ArrayList<TodayRecipeDTO> SaladRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '샐러드' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("SaladRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 밥죽떡 레시피
	public ArrayList<TodayRecipeDTO> BobRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '밥/죽/떡' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("BobRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 양념/소스 레시피
	public ArrayList<TodayRecipeDTO> SourceRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '양념/소스' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		
				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("SourceRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 국류 레시피
	public ArrayList<TodayRecipeDTO> NoodleRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '면류' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("NoodleRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 디저트 레시피
	public ArrayList<TodayRecipeDTO> DessertRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '디저트' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			
				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("DessertRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 국류 레시피
	public ArrayList<TodayRecipeDTO> SoupRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '국류' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
		

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("SideRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	// 반찬 레시피
	public ArrayList<TodayRecipeDTO> SideRecipe() {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		conn = null;
		ps = null;
		rs = null;
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " + "and r.recipe_id = mm.recipe_id(+) " + "and cat1 = '반찬' "
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String title = rs.getString("title");
				String recipe_id = rs.getString("recipe_id");
				String subtitle = rs.getString("subtitle");
				String portion = rs.getString("portion");
				String time = rs.getString("time");
				String cat1 = rs.getString("cat1");
				String cat2 = rs.getString("cat2");
				String cat3 = rs.getString("cat3");
				String cat4 = rs.getString("cat4");
				String degree = rs.getString("degree");
				String writedate = rs.getString("writedate");
				String pid = rs.getString("pid");
				String good = rs.getString("good");
				String scrap = rs.getString("scrap");
				String imagepath = rs.getString("imagepath");
				String image1 = rs.getString("image1");
				String image2 = rs.getString("image2");
				String image3 = rs.getString("image3");
				String image4 = rs.getString("image4");
				String image5 = rs.getString("image5");
				String image6 = rs.getString("image6");
				String image7 = rs.getString("image7");
				String image8 = rs.getString("image8");
				String image9 = rs.getString("image9");
				String image10 = rs.getString("image10");
				String text1 = rs.getString("text1");
				String text2 = rs.getString("text2");
				String text3 = rs.getString("text3");
				String text4 = rs.getString("text4");
				String text5 = rs.getString("text5");
				String text6 = rs.getString("text6");
				String text7 = rs.getString("text7");
				String text8 = rs.getString("text8");
				String text9 = rs.getString("text9");
				String text10 = rs.getString("text10");
				String material_name0 = rs.getString("material_name0");
				String material_unit0 = rs.getString("material_unit0");
				String material_name1 = rs.getString("material_name1");
				String material_unit1 = rs.getString("material_unit1");
				String material_name2 = rs.getString("material_name2");
				String material_unit2 = rs.getString("material_unit2");
				String material_name3 = rs.getString("material_name3");
				String material_unit3 = rs.getString("material_unit3");
				String material_name4 = rs.getString("material_name4");
				String material_unit4 = rs.getString("material_unit4");
				String material_name5 = rs.getString("material_name5");
				String material_unit5 = rs.getString("material_unit5");
				String material_name6 = rs.getString("material_name6");
				String material_unit6 = rs.getString("material_unit6");
				String material_name7 = rs.getString("material_name7");
				String material_unit7 = rs.getString("material_unit7");
				String material_name8 = rs.getString("material_name8");
				String material_unit8 = rs.getString("material_unit8");
				String material_name9 = rs.getString("material_name9");
				String material_unit9 = rs.getString("material_unit9");
				String material_name10 = rs.getString("material_name10");
				String material_unit10 = rs.getString("material_unit10");
				String material_name11 = rs.getString("material_name11");
				String material_unit11 = rs.getString("material_unit11");
				String material_name12 = rs.getString("material_name12");
				String material_unit12 = rs.getString("material_unit12");
			

				TodayRecipeDTO adto = new TodayRecipeDTO(nickname, title, recipe_id, subtitle, portion, time, cat1,
						cat2, cat3, cat4, degree, writedate, pid, good, scrap, imagepath, image1, image2, image3,
						image4, image5, image6, image7, image8, image9, image10, text1, text2, text3, text4, text5,
						text6, text7, text8, text9, text10, material_name0, material_unit0, material_name1,
						material_unit1, material_name2, material_unit2, material_name3, material_unit3, material_name4,
						material_unit4, material_name5, material_unit5, material_name6, material_unit6, material_name7,
						material_unit7, material_name8, material_unit8, material_name9, material_unit9, material_name10,
						material_unit10, material_name11, material_unit11, material_name12, material_unit12);
				adtos.add(adto);
			}

			System.out.println("SideRecipeDTO : " + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public ArrayList<RecipeCommentDTO> recipeComment(String rc_id) {
		ArrayList<RecipeCommentDTO> adtos = new ArrayList<RecipeCommentDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select m.nickname, rc.* \r\n " + "from recipecomment rc, member m\r\n "
					+ "where rc.member_id = m.id(+)\r\n " + "and rc_id = '" + rc_id + "' " + "order by writedate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String nickname = rs.getString("nickname");
				String rc_id1 = rs.getString("rc_id");
				String member_id = rs.getString("member_id");
				String content = rs.getString("content");
				String writedate = rs.getString("writedate");
				String no = rs.getString("no");

				RecipeCommentDTO adto = new RecipeCommentDTO(nickname, rc_id1, member_id, content, writedate, no);
				adtos.add(adto);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	public int recipeCommentInsert(String rc_id, String member_id, String content) {
		conn = null;
		ps = null;
		rs = null;

		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "insert into recipecomment(rc_id, member_id, content) " + "values( ?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, rc_id);
			ps.setString(2, member_id);
			ps.setString(3, content);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		return state;

	}

	public int recipeCommentDelete(String no) {
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "delete from recipecomment where no=?";

			System.out.println(no + "dao");

			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return state;

	}

	public int recInsert(String material_id, String material_group, String recipe_id, String material_name0,
			String material_unit0, String material_name1, String material_unit1, String material_name2,
			String material_unit2, String material_name3, String material_unit3, String material_name4,
			String material_unit4, String material_name5, String material_unit5, String material_name6,
			String material_unit6, String material_name7, String material_unit7, String material_name8,
			String material_unit8, String material_name9, String material_unit9) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			//
			connection = dataSource.getConnection();
			String query = "insert into materials(material_group,recipe_id," + "material_name0,material_unit0,"
					+ "material_name1,material_unit1," + "material_name2,material_unit2,"
					+ "material_name3,material_unit3," + "material_name4,material_unit4,"
					+ "material_name5,material_unit5," + "material_name6,material_unit6,"
					+ "material_name7,material_unit7," + "material_name8,material_unit8,"
					+ "material_name9,material_unit9)" + " values('재료'," + "seq_recipe.currval,'" + material_name0
					+ "','" + material_unit0 + "','" + material_name1 + "','" + material_unit1 + "','" + material_name2
					+ "','" + material_unit2 + "','" + material_name3 + "','" + material_unit3 + "','" + material_name4
					+ "','" + material_unit4 + "','" + material_name5 + "','" + material_unit5 + "','" + material_name6
					+ "','" + material_unit6 + "','" + material_name7 + "','" + material_unit7 + "','" + material_name8
					+ "','" + material_unit8 + "','" + material_name9 + "','" + material_unit9 + "')";

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return state;
	}

	public ArrayList<MaterialDTO> matSelect() {
		ArrayList<MaterialDTO> adtos = new ArrayList<MaterialDTO>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * " + " from materials" + " order by material_id desc";
			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String material_id = resultSet.getString("material_id");
				String material_group = resultSet.getString("material_group");
				String recipe_id = resultSet.getString("recipe_id");
				String material_name0 = resultSet.getString("material_name0");
				String material_unit0 = resultSet.getString("material_unit0");
				String material_name1 = resultSet.getString("material_name1");
				String material_unit1 = resultSet.getString("material_unit1");
				String material_name2 = resultSet.getString("material_name2");
				String material_unit2 = resultSet.getString("material_unit2");
				String material_name3 = resultSet.getString("material_name3");
				String material_unit3 = resultSet.getString("material_unit3");
				String material_name4 = resultSet.getString("material_name4");
				String material_unit4 = resultSet.getString("material_unit4");
				String material_name5 = resultSet.getString("material_name5");
				String material_unit5 = resultSet.getString("material_unit5");
				String material_name6 = resultSet.getString("material_name6");
				String material_unit6 = resultSet.getString("material_unit6");
				String material_name7 = resultSet.getString("material_name7");
				String material_unit7 = resultSet.getString("material_unit7");
				String material_name8 = resultSet.getString("material_name8");
				String material_unit8 = resultSet.getString("material_unit8");
				String material_name9 = resultSet.getString("material_name9");
				String material_unit9 = resultSet.getString("material_unit9");
				MaterialDTO adto = new MaterialDTO(material_id, material_group, recipe_id, material_name0,
						material_unit0, material_name1, material_unit1, material_name2, material_unit2, material_name3,
						material_unit3, material_name4, material_unit4, material_name5, material_unit5, material_name6,
						material_unit6, material_name7, material_unit7, material_name8, material_unit8, material_name9,
						material_unit9);
				adtos.add(adto);
			}

			System.out.println("adtos크기" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adtos;
	}

	public ArrayList<RecipeDTO> recipe(String recipe_id, String title, String subtitle, String cat1, String cat2,
			String cat3, String cat4, String portion, String time, String degree, String writedate, String material_id,
			String material_group) {

		ArrayList<RecipeDTO> adtos = new ArrayList<RecipeDTO>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select recipe_id,title,subtitle from test where recipe_id = '" + recipe_id
					+ "' and title = '" + title + "' and subtitle = '" + subtitle + "'";
			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(recipe_id);
				System.out.println(title);
				System.out.println(subtitle);

				recipe_id = resultSet.getString("recipe_id");
				title = resultSet.getString("title");
				subtitle = resultSet.getString("subtitle");
				cat1 = resultSet.getString("cat1");
				cat2 = resultSet.getString("cat2");
				cat3 = resultSet.getString("cat3");
				cat4 = resultSet.getString("cat4");
				portion = resultSet.getString("portion");
				time = resultSet.getString("time");
				degree = resultSet.getString("degree");
				writedate = resultSet.getString("writedate");
				material_id = resultSet.getString("material_id");
				material_group = resultSet.getString("material_group");

				RecipeDTO adto = new RecipeDTO(recipe_id, title, subtitle, cat1, cat2, cat3, cat4, portion, time,
						degree, writedate, material_id, material_group);
				adtos.add(adto);
			}

			System.out.println("adtos크기" + adtos.size());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adtos;
	}

	public int recUpdate(String material_id, String material_group, String recipe_id, String material_name0,
			String material_unit0, String material_name1, String material_unit1, String material_name2,
			String material_unit2, String material_name3, String material_unit3, String material_name4,
			String material_unit4, String material_name5, String material_unit5, String material_name6,
			String material_unit6, String material_name7, String material_unit7, String material_name8,
			String material_unit8, String material_name9, String material_unit9) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			// 아이디는 수정할수 없음
			connection = dataSource.getConnection();
			String query = "update materials set " + " material_name0 = '" + material_name0 + "' "
					+ ", material_unit0 = '" + material_unit0 + "', material_name1 = '" + material_name1
					+ "', material_unit1 = '" + material_unit1 + "', material_name2 = '" + material_name2 + "', "
					+ " material_unit2 = '" + material_unit2 + "', material_name3 = '" + material_name3
					+ "', material_unit3 = '" + material_unit3 + "', material_name4 = '" + material_name4
					+ "', material_unit4 = '" + material_unit4 + "', material_name5 = '" + material_name5
					+ "', material_unit5 = '" + material_unit5 + "', material_name6 = '" + material_name6
					+ "', material_unit6 = '" + material_unit6 + "', material_name7 = '" + material_name7 + "', "
					+ "material_unit7 = '" + material_unit7 + "', material_name8 = '" + material_name8
					+ "', material_unit8 = '" + material_unit8 + "', " + " material_name9 = '" + material_name9
					+ "', material_unit9 = '" + material_unit9 + "' " + " where recipe_id = " + recipe_id;

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println("수정2성공");

			} else {
				System.out.println("수정2실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return state;
	}

	public int recUpdate(String recipe_id, String text1, String text2, String text3, String text4, String text5,
			String text6, String text7, String text8, String text9, String text10) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			// 아이디는 수정할수 없음
			connection = dataSource.getConnection();
			String query = "update recipetext set text1 = '" + text1 + "', text2 = '" + text2 + "' " + ", text3 = '"
					+ text3 + "', text4 = '" + text4 + "', text5 = '" + text5 + "', text6 = '" + text6 + "', "
					+ " text7 = '" + text7 + "', text8 = '" + text8 + "', text9 = '" + text9 + "', text10 = '" + text10
					+ "'" + " where recipe_id = " + recipe_id;

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println("수정2성공");

			} else {
				System.out.println("수정2실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return state;
	}

	public int recUpdate(String recipe_id, String title, String subtitle, String cat1, String cat2, String cat3,
			String cat4, String portion, String time, String degree, String writedate, String material_id,
			String material_group, String imagepath, String imagepath1, String imagepath2, String imagepath3,
			String imagepath4) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			// 아이디는 수정할수 없음
			connection = dataSource.getConnection();
			String query = "update recipe set title = '" + title + "' " + ", subtitle = '" + subtitle + "' "
					+ ", cat1 = '" + cat1 + "', cat2 = '" + cat2 + "', cat3 = '" + cat3 + "', cat4 = '" + cat4 + "', "
					+ " portion = '" + portion + "', time = '" + time + "', degree = '" + degree
					+ "', material_group = '재료', " + "imagepath = '" + imagepath + "', imagepath1 = '" + imagepath1
					+ "', imagepath2 = '" + imagepath2 + "', imagepath3 = '" + imagepath3 + "', " + "imagepath4 = '"
					+ imagepath4 + "' " + "where recipe_id = " + recipe_id;

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println("수정2성공");

			} else {
				System.out.println("수정2실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return state;
	}

	public int recDelete(int id) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			connection = dataSource.getConnection();
			String query = "delete from recipe where recipe_id=" + id;

			System.out.println(id);

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return state;

	}

	public int recInsert(String recipe_id, String text1, String text2, String text3, String text4, String text5,
			String text6, String text7, String text8, String text9, String text10) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			//
			connection = dataSource.getConnection();
			String query = "insert into RECIPETEXT(recipe_id,text1, text2, text3 ,text4 ,text5,text6,text7,text8,text9,text10)"
					+ " values(seq_recipe.currval,'" + text1 + "', " + "'" + text2 + "', '" + text3 + "', '" + text4
					+ "', '" + text5 + "'," + "'" + text6 + "', '" + text7 + "', '" + text8 + "', '" + text9 + "', '"
					+ text10 + "')";

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}
			state = -1;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return state;

	}

	public int recInsert(String id, String title, String subtitle, String cat1, String cat2, String cat3, String cat4,
			String portion, String time, String degree, String writedate, String material_id, String material_group,
			String imagepath, String imagepath1, String imagepath2, String imagepath3, String imagepath4, String userid,
			String cnt) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		int state = -1;

		try {
			//
			connection = dataSource.getConnection();
			String query = "insert into recipe(title,subtitle,cat1,cat2,cat3,cat4,portion,time,degree,material_id,material_group,"
					+ "imagepath,imagepath1,imagepath2,imagepath3,imagepath4,userid)" + " values('" + title + "','"
					+ subtitle + "','" + cat1 + "','" + cat2 + "','" + cat3 + "','" + cat4 + "','" + portion + "','"
					+ time + "','" + degree + "'" + ",seq_mat_id.nextval, '재료', '" + imagepath + "','" + imagepath1
					+ "','" + imagepath2 + "', '" + imagepath3 + "', '" + imagepath4 + "', '" + userid + "')";

			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();

			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}
			state = -1;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return state;
	}
	public int recInsert(String recipe_id, String image1, String image2, String image3, String image4, String image5, String image6,
			String image7, String image8, String image9, String image10, String pnt) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		int state = -1;
		
		try {
			//
			connection = dataSource.getConnection();
			String query = "insert into recipeimage(recipe_id,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10)"
					+ " values(seq_recipe.currval,'" + image1 + "','" + image2 + "','" + image3 + "','" + image4 + "','" + image5 + "','" + image6 + "','"
					+ image7 + "','" + image8 + "','" + image9 + "','" + image10 + "')";
			
			prepareStatement = connection.prepareStatement(query);
			state = prepareStatement.executeUpdate();
			
			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}
			state = -1;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return state;
	}

	public ArrayList<RecipeDTO> recSelect() {
		ArrayList<RecipeDTO> adtos = new ArrayList<RecipeDTO>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select m.*,r.*,mm.*,rt.*,ri.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm "
					+ "where r.recipe_id = ri.recipe_id(+) " + "and r.recipe_id = rt.recipe_id(+)	"
					+ "and r.userid= m.id(+)	" + "and r.recipe_id = mm.recipe_id(+)	"
					+ "order by to_number(r.recipe_id) desc";

			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String recipe_id = resultSet.getString("recipe_id");
				String title = resultSet.getString("title");
				String subtitle = resultSet.getString("subtitle");
				String cat1 = resultSet.getString("cat1");
				String cat2 = resultSet.getString("cat2");
				String cat3 = resultSet.getString("cat3");
				String cat4 = resultSet.getString("cat4");
				String portion = resultSet.getString("portion");
				String time = resultSet.getString("time");
				String degree = resultSet.getString("degree");
				String writedate = resultSet.getString("writedate");
				String material_id = resultSet.getString("material_id");
				String material_group = resultSet.getString("material_group");
				String material_name0 = resultSet.getString("material_name0");
				String material_name1 = resultSet.getString("material_name1");
				String material_name2 = resultSet.getString("material_name2");
				String material_name3 = resultSet.getString("material_name3");
				String material_name4 = resultSet.getString("material_name4");
				String material_name5 = resultSet.getString("material_name5");
				String material_name6 = resultSet.getString("material_name6");
				String material_name7 = resultSet.getString("material_name7");
				String material_name8 = resultSet.getString("material_name8");
				String material_name9 = resultSet.getString("material_name9");
				String material_unit0 = resultSet.getString("material_unit0");
				String material_unit1 = resultSet.getString("material_unit1");
				String material_unit2 = resultSet.getString("material_unit2");
				String material_unit3 = resultSet.getString("material_unit3");
				String material_unit4 = resultSet.getString("material_unit4");
				String material_unit5 = resultSet.getString("material_unit5");
				String material_unit6 = resultSet.getString("material_unit6");
				String material_unit7 = resultSet.getString("material_unit7");
				String material_unit8 = resultSet.getString("material_unit8");
				String material_unit9 = resultSet.getString("material_unit9");
				String text1 = resultSet.getString("text1");
				String text2 = resultSet.getString("text2");
				String text3 = resultSet.getString("text3");
				String text4 = resultSet.getString("text4");
				String text5 = resultSet.getString("text5");
				String text6 = resultSet.getString("text6");
				String text7 = resultSet.getString("text7");
				String text8 = resultSet.getString("text8");
				String text9 = resultSet.getString("text9");
				String text10 = resultSet.getString("text10");
				String imagepath = resultSet.getString("imagepath");
				String imagepath1 = resultSet.getString("imagepath1");
				String imagepath2 = resultSet.getString("imagepath2");
				String imagepath3 = resultSet.getString("imagepath3");
				String imagepath4 = resultSet.getString("imagepath4");
				String image1 = resultSet.getString("image1");
				String image2 = resultSet.getString("image2");
				String image3 = resultSet.getString("image3");
				String image4 = resultSet.getString("image4");
				String image5 = resultSet.getString("image5");
				String image6 = resultSet.getString("image6");
				String image7 = resultSet.getString("image7");
				String image8 = resultSet.getString("image8");
				String image9 = resultSet.getString("image9");
				String image10 = resultSet.getString("image10");
				String userid = resultSet.getString("userid");
				RecipeDTO adto = new RecipeDTO(recipe_id, title, subtitle, cat1, cat2, cat3, cat4, portion, time,
						degree, imagepath, imagepath1, imagepath2, imagepath3, imagepath4, writedate, material_id,
						material_group, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10,
						material_name0, material_name1, material_name2, material_name3, material_name4, material_name5,
						material_name6, material_name7, material_name8, material_name9, material_unit0, material_unit1,
						material_unit2, material_unit3, material_unit4, material_unit5, material_unit6, material_unit7,
						material_unit8, material_unit9, image1, image2, image3, image4, image5, image6, image7, image8,
						image9, image10, userid);
				adtos.add(adto);
			}

			System.out.println("adtos크기" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			try {

				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adtos;
	}

	public int searchUpdate(String count, String no) {
		conn = null;
		ps = null;
		rs = null;

		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update search set count = ? + 1 where no = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, count);
			ps.setString(2, no);
			state = ps.executeUpdate();
			System.out.println(count + "<서치업데이트>" + no);
			if (state > 0) {
				System.out.println("검색어 카운트 수정 성공!");
			} else {
				System.out.println("검색어 카운트 수정 실패!");
			}

		} catch (Exception e) {

		} finally {
			disconn();
		}

		return state;

	}

}
