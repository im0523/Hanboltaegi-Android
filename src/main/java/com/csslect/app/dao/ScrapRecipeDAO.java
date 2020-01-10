package com.csslect.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.csslect.app.dto.MyRecipeDTO;
import com.csslect.app.dto.TodayRecipeDTO;

public class ScrapRecipeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	DataSource dataSource;

	public ScrapRecipeDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team2");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}
	}
	
	//스크랩 지우기
	public int ScrapDelete(int scr_id) {
		conn = null;
		ps = null;
		rs = null;

		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "delete from scrap where scr_id = ?";

			System.out.println(scr_id);

			ps = conn.prepareStatement(sql);
			ps.setInt(1, scr_id);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return state;

	}
	
	
	
	//스크랩하기 
	public int ScrapInsert(String scr_userid, String scr_recipeid, String target_userid) {
		conn = null;
		ps = null;
		rs = null;
		
		int state = -1;
		
		try {
			conn = dataSource.getConnection();
			sql = "insert into scrap(scr_userid, scr_recipeid, target_userid) "
					+ "values( (select id from member where id = ?), "
					+ "(select recipe_id from recipe where recipe_id = ?), "
					+ "(select userid from recipe where userid = ?) )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, scr_userid);
			ps.setString(2, scr_recipeid);
			ps.setString(3, target_userid);
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
	
	
	
	
	
	
	// 스크랩한 레시피 목록
	public ArrayList<TodayRecipeDTO> ScrapRecipe(String scr_userid) {
		ArrayList<TodayRecipeDTO> adtos = new ArrayList<TodayRecipeDTO>();
		
		try {
			conn = dataSource.getConnection();
			sql = "select nickname, r.*, ri.*, rt.*, mm.* "
					+ "from recipe r, recipeimage ri, recipetext rt, member m, materials mm, scrap s "
					+ "where r.recipe_id = ri.recipe_id(+) " 
					+ "and r.recipe_id = rt.recipe_id(+) "
					+ "and r.userid= m.id(+) " 
					+ "and r.recipe_id = mm.recipe_id(+) "
					+ "and r.recipe_id = s.scr_recipeid "
					+ "and scr_userid = ? " 
					+ "order by writedate desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, scr_userid);
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

			System.out.println("ScrapDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}

	
	
	

	private void disconn() {
		if( rs!=null ) { try{ rs.close(); }catch(Exception e) {} }
		if( ps!=null ) { try{ ps.close(); }catch(Exception e) {} }
		if( conn!=null ) { try{ conn.close(); }catch(Exception e) {} }
	}
}
