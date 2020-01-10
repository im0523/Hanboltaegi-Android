package com.csslect.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.csslect.app.dto.MyListRecipeDTO;
import com.csslect.app.dto.MyRecipeDTO;
import com.csslect.app.dto.RecipeCommentDTO;
import com.csslect.app.dto.SearchWeekDTO;
import com.csslect.app.dto.TodayRecipeDTO;
import com.csslect.app.dto.WeekChefDTO;

public class SearchDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	DataSource dataSource;

	public SearchDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team2");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}
	}

	
	//검색어 저장처리
		public int search(String content) {
			conn = null;
			ps = null;
			rs = null;
			
			int state = -1;
			
			try {
				conn = dataSource.getConnection();
				sql = "insert into search(content, count) "
						+ "values( ?, 1)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, content);
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

		//메인화면 주간검색어순위
		public ArrayList<SearchWeekDTO> searchWeek() {
			ArrayList<SearchWeekDTO> adtos = new ArrayList<SearchWeekDTO>();
			conn = null;
			ps = null;
			rs = null;

			try {
				conn = dataSource.getConnection();
				sql = "select * from search \r\n" + 
						"where rownum < 4\r\n" + 
						"and writedate between sysdate-7 and sysdate-1\r\n" + 
						"order by count";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					String no = rs.getString("no");
					String content = rs.getString("content");
					String count = rs.getString("count");
					String writedate = rs.getString("writedate");
				
					SearchWeekDTO adto = new SearchWeekDTO(no, content, count, writedate);
					adtos.add(adto);
				}

				System.out.println("searchWeek" + adtos.size());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			} finally {
				disconn();
			}

			return adtos;
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


	public ArrayList<SearchWeekDTO> searchAllList() {
		ArrayList<SearchWeekDTO> adtos = new ArrayList<SearchWeekDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select * from search \r\n" + 
					"order by count";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String no = rs.getString("no");
				String content = rs.getString("content");
				String count = rs.getString("count");
				String writedate = rs.getString("writedate");
			
				SearchWeekDTO adto = new SearchWeekDTO(no, content, count, writedate);
				adtos.add(adto);
			}

			System.out.println("searchAllList" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return adtos;
	}


	
	

}
