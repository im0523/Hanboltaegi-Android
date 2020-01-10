package com.csslect.app.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.csslect.app.dto.CommunityDTO;
import com.csslect.app.dto.HanMemberDTO;



public class CommunityDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	DataSource dataSource;
	
	

	public CommunityDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team2");
//			dataSource = (DataSource) context.lookup("java:/comp/env/smart");
//			dataSource = (DataSource) context.lookup("java:/comp/env/team01");
			/*dataSource = (DataSource) context.lookup("java:/comp/env/CSS");*/
		} catch (NamingException e) {
			e.getMessage();
		}

	}
	
	
	//커뮤니티 글 수정
	public int CoUpdate(String content, String no) {
		conn = null;
		ps = null;
		rs = null;
		
		int state = -1;
		
		try {
			conn = dataSource.getConnection();
			sql = "update community set content = ? where no = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, no);
			state = ps.executeUpdate();
			
			if(state > 0) {
				System.out.println("수정 성공!");
			}else {
				System.out.println("수정 실패!");
			}
			
		}catch(Exception e){
			
		}finally {
			disconn();
		}
		
		return state;
	}
	
	
	
	
	
	
	//커뮤니티 글 삭제
	public int CoDelete(String no) {

		conn = null;
		ps = null;
		rs = null;

		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "delete from community where no= ?";

			System.out.println(no);

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
			disconn();
		}

		return state;

	}
	
	
	
	
	
	
		//커뮤니티 글 작성
		public int CoInsert(String content, String nickname, String userid) {
					conn = null;
					ps = null;
					rs = null;
					
					int state = -1;
					
					try {
						conn = dataSource.getConnection();
						sql = "insert into community(nickname, content, userid) "
								+ "values( (select nickname from member where nickname = ? ), "
								+ "?,"
								+ "(select id from member where id = ?) )";
						ps = conn.prepareStatement(sql);
						ps.setString(1, nickname);
						ps.setString(2, content);
						ps.setString(3, userid);
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
	
	
	
	//커뮤니티 글 목록 보여주기
	public ArrayList<CommunityDTO> Comment() {
		ArrayList<CommunityDTO> adtos = new ArrayList<CommunityDTO>();
		conn = null;
		ps = null;
		rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select no, nickname, content, to_char(writedate, 'yyyy-mm-dd hh24:mi:ss') writedate, co_file1, co_filename1, userid "
					+ "from community order by no desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String no = rs.getString("no");
				String nickname = rs.getString("nickname");
				String content = rs.getString("content");
				String writedate = rs.getString("writedate");
				String co_file1 = rs.getString("co_file1");
				String co_filename1 = rs.getString("co_filename1");
				String userid = rs.getString("userid");
				
				
				CommunityDTO adto = new CommunityDTO(no, content, nickname, co_file1, co_filename1, userid, writedate);
				adtos.add(adto);			
			}	
			
			System.out.println("adtos크기" + adtos.size());
			
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
