package com.csslect.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.csslect.app.dto.ChefRankDTO;
import com.csslect.app.dto.HanMemberDTO;
import com.csslect.app.dto.JoongbokDTO;
import com.csslect.app.dto.WeekChefDTO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	DataSource dataSource;

	public MemberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/team2");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}

	}

	// 회원정보 수정
	public void MemberModify(String pwd, String nickname, String email, String id) {

		conn = null;
		ps = null;
		rs = null;
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update member set nickname = ?, pwd = ?, email = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nickname);
			ps.setString(2, pwd);
			ps.setString(3, email);
			ps.setString(4, id);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconn();
		}

	}

	// 닉네임 중복확인
	public ArrayList<JoongbokDTO> JoongbokNick(String id, String nickname) {

		ArrayList<JoongbokDTO> adtos = new ArrayList<JoongbokDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select nickname from member where nickname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nickname);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = null;
				nickname = rs.getString("nickname");

				JoongbokDTO adto = new JoongbokDTO(id, nickname);
				adtos.add(adto);
			}
			System.out.println("중복 닉네임 dtos 크기 : " + adtos.size());

		} catch (Exception e) {
			System.out.println("닉네임 중복확인 DAO 문제 있나봐");
		} finally {
			disconn();
		}

		return adtos;
	}

	// 아이디 중복확인
	public ArrayList<JoongbokDTO> JoongbokId(String id, String nickname) {

		ArrayList<JoongbokDTO> adtos = new ArrayList<JoongbokDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			sql = "select id from member where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
				nickname = null;

				JoongbokDTO adto = new JoongbokDTO(id, nickname);
				adtos.add(adto);
			}
			System.out.println("아이디 중복 dtos 크기 : " + adtos.size());

		} catch (Exception e) {
			System.out.println("아이디 중복확인 DAO 문제 있나봐");
		} finally {
			disconn();
		}

		return adtos;
	}

	// 회원가입하기
	public int HanInsert(String id, String pwd, String nickname, String email) {

		conn = null;
		ps = null;
		rs = null;

		int state = -1;

		try {
			//
			conn = dataSource.getConnection();
			sql = "insert into member(id, pwd, nickname, email) " + "values(?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, nickname);
			ps.setString(4, email);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println(state + "�궫�엯�꽦怨�");
			} else {
				System.out.println(state + "�궫�엯�떎�뙣");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

		return state;

	}

	// 로그인
	public ArrayList<HanMemberDTO> HanLogin(String id, String pwd) {

		ArrayList<HanMemberDTO> adtos = new ArrayList<HanMemberDTO>();
		conn = null;
		ps = null;
		rs = null;

		try {
			conn = dataSource.getConnection();
			/* String sql = "select * from member where id=? and pwd=?"; */
			String sql = "select(select count(*) from recipe, member where userid=id and id=m.id) cnt, m.* from member m where id=? and pwd=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				String nickname = rs.getString("nickname");
				String email = rs.getString("email");
				String user_pic = rs.getString("user_pic");
				int grade_id = rs.getInt("grade_id");
				int follower = rs.getInt("follower");
				int following = rs.getInt("following");
				int cnt = rs.getInt("cnt");
				HanMemberDTO adto = new HanMemberDTO(id, pwd, nickname, email, user_pic, grade_id,
						follower, following, cnt);
				adtos.add(adto);
			}

			System.out.println("HanMemberDTO" + adtos.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		return adtos;

	}

	// 이달의 쉐프랭킹 TOP3
	public ArrayList<WeekChefDTO> weekChef() {
		ArrayList<WeekChefDTO> list = new ArrayList<WeekChefDTO>();
		try {
			conn = dataSource.getConnection();
			String sql = "select rownum no, e.* " + "from (select sum(good) good, id, nickname "
					+ "from recipe r, member m " + "where m.id = r.userid(+) "
					+ "and to_date(writedate) between sysdate-30 and sysdate-1 "
					+ "group by id, nickname order by 1 desc) e " + "where rownum < 4";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nickname = rs.getString("nickname");
				int no = rs.getInt("no");
				int good = rs.getInt("good");

				WeekChefDTO dto = new WeekChefDTO(id, nickname, no, good);
				list.add(dto);
			}

			System.out.println("chefRankDTO" + list.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		return list;
	}

	// 이달의 쉐프랭킹
	public ArrayList<ChefRankDTO> chefRank() {
		ArrayList<ChefRankDTO> list = new ArrayList<ChefRankDTO>();
		try {
			conn = dataSource.getConnection();
			String sql = "select rownum no, e.* " + "from (select sum(good) good, id, nickname "
					+ "from recipe r, member m " + "where m.id = r.userid(+) "
					+ "and to_date(writedate) between sysdate-30 and sysdate-1 "
					+ "group by id, nickname order by 1 desc) e ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				int good = rs.getInt("good");
				String id = rs.getString("id");
				String nickname = rs.getString("nickname");

				ChefRankDTO dto = new ChefRankDTO(no, good, id, nickname);
				list.add(dto);
			}

			System.out.println("chefRankDTO" + list.size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		return list;
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

	public void gradeUpdate(String id) {
		conn = null;
		ps = null;
		rs = null;
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update member set grade_id=2 where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			disconn();
		}
		
	}

	public void grade1Update(String id) {
		conn = null;
		ps = null;
		rs = null;
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update member set grade_id=3 where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			disconn();
		}
		
	}
	public void grade2Update(String id) {
		conn = null;
		ps = null;
		rs = null;
		int state = -1;

		try {
			conn = dataSource.getConnection();
			sql = "update member set grade_id=4 where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			state = ps.executeUpdate();

			if (state > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			disconn();
		}
		
	}




}
