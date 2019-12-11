package com.myweb.user.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

//	create table users (
//		user_id varchar2(30) constraint user_id_pk primary key,
//		user_pw varchar2(30) not null,
//		user_name varchar2(30) not null,
//		user_email varchar2(30),
//		user_address varchar2(50),
//		user_regdate date default sysdate
//
//	);

public class MemberDAO {

	// 싱글톤으로 생성, 필요한 변수 선언

	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
		try {
			InitialContext ct = new InitialContext(); // 초기 설정 정보가 저장되는 객체
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/oracle"); // 이니셜 컨텍스트 객체에서 이름으로 커넥션 풀 찾음

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		return dao;
	}

	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 아이디 중복확인 메서드
	public int confirmId(String id) {
		int result = 0;
		String sql = "select * from users where user_id = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 결과가 있다는 것은
				result = 1; // 중복된 값이 있다는 것
			} else {
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return result;
	}

	// 회원가입 메서드
	public int insert(MemberVO vo) {
		int result = 0;
		String sql = "insert into users(user_id, user_pw, user_name, user_email, user_address) values" + "(?,?,?,?,?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());

			result = pstmt.executeUpdate(); // 성공하면 1,실패하면 0

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public int userCheck(String id, String pw) {
		int result = 0;
		String sql = "select * from users where user_id = ? and user_pw = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public MemberVO getMemberInfo(String uid) {
		
		MemberVO vo = new MemberVO();
		String sql = "select * from users where user_id = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("user_id");
				String pw = rs.getString("user_pw");
				String name = rs.getString("user_name");
				String email = rs.getString("user_email");
				String address = rs.getString("user_address");
				Timestamp regdate = rs.getTimestamp("USER_REGDATE");
				vo = new MemberVO(id, pw, name, email, address, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
		
	}
	
	public int updateUser(MemberVO vo) {
		int result = 0;
		String sql = "update users set user_name = ?, user_email = ?, user_address = ?, user_pw = ? where user_id = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPw());
			pstmt.setString(5, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
		
	}
	
	public int deleteUser(String id) {
		int result = 0;
		String sql = "delete from users where user_id = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return result;
		
	}
	
	public int changePassword(String id, String nPw) {
		int result = 0;
		String sql = "update users set user_pw = ? where user_id = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nPw);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate(); // 성공시 1, 실패시 0 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
		
	}
}
