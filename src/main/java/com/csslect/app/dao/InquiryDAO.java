package com.csslect.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.csslect.app.dto.InquiryDTO;

public class InquiryDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	DataSource dataSource;

	public InquiryDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team2");
//			dataSource = (DataSource) context.lookup("java:/comp/env/smart");
//			dataSource = (DataSource) context.lookup("java:/comp/env/team01");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}

	}

	// 공지글 목록 조회
		public ArrayList<InquiryDTO> anInquiry(String id) {
			ArrayList<InquiryDTO> list = new ArrayList<InquiryDTO>();

			try {
				conn = dataSource.getConnection();
				sql = "select rownum num, n.* "
					+ "from (select title, content, to_char(writedate, 'yyyy-mm-dd hh24:mi:ss') writedate, nickname, no from inquiry order by writedate asc) n " 
					+ "order by no desc";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					int no = rs.getInt("no");
					int num = rs.getInt("num");
					String title = rs.getString("title");
					String date = rs.getString("writedate");
					String content = rs.getString("content");
					String nickname = rs.getString("nickname");
					InquiryDTO dto = new InquiryDTO(no, num, title, date, content, id, nickname);
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
		
	// 공지글 신규저장처리
	public int InquiryInsert(String title, String nickname, String content, String id) {
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "insert into inquiry(title, nickname, content, id) " + "values(?, ?, ?, (select id from member where id = ?) )";

			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, nickname);
			ps.setString(3, content);
			ps.setString(4, id);
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

	// 공지글 수정저장처리
	public int InquiryUpdate( int no, String title, String writedate, String content, String id, String nickname) {
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update inquiry set title=?, content=? where no=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, no);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println(state + "수정성공");
			} else {
				System.out.println(state + "수정실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		return state;
	}

	// 공지글 삭제처리
	public int InquiryDelete(int no) {
			int state = -1;
	
			try {
				conn = dataSource.getConnection();
				sql = "delete from inquiry where no=?";
				
				System.out.println(no+"dao");
	
				ps = conn.prepareStatement(sql);
				ps.setInt(1, no);
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
}
